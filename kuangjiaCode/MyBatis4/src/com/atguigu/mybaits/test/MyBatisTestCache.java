package com.atguigu.mybaits.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybaits.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperCache;

public class MyBatisTestCache {

	public SqlSessionFactory getSqlSessionFactory() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	/**
	 * MyBatis的二级缓存 
	 * 一级缓存：SqlSession级别的(不同的SqlSession不共享数据)
	 * 		与数据库的一次会话期间查到的数据放到SqlSession对应的一级缓存中，以后需要获取相同的数据，直接从缓存中读取
	 * 一级缓存失效：
	 * 	1.SqlSession不同
	 * 	2.SqlSession相同，查询条件不同
	 * 	3.SqlSession相同，但两次查询中间有增删改操作的执行
	 * 	4.SqlSession相同，但手动的清除了缓存
	 * 
	 * 二级缓存：
	 * 	1.二级缓存又叫全局缓存
	 * 	2.二级缓存默认是关闭的，必须要手动配置开启
	 * 	3.二级缓存是namespace级别的缓存，的多个sqlSession可以共享同一个namespace级别的二级缓存
	 * 工作机制：
	 * 	a.一个会话（sqlSession），从数据库查询一条数据，这个数据会刚到当前会话的一级缓存中
	 * 	b.当绘画关闭或是提交，当前会话的一级缓存中的数据会被保存到对应的namespace的二级缓存中
	 * 	c.当新的会话查询相同的数据，就能从二级缓存中获取数据，而不再从数据库中查询
	 * 使用步骤：
	 * 	1.在全局配置文件中开启二级缓存：
	 *		<setting name="cacheEnabled" value="true"/>
	 *	2.在sql映射文件中，配置使用二级缓存
	 *		<cache></cache>
	 *	3.POJO需要实现序列化接口
	 *
	 *缓存相关的设置
	 *	1.cacheEnable:true/false,改为false后，二级缓存关闭，一级缓存依旧可以使用
	 *	2.每个select标签都有useCache=true的属性，改为false后，二级缓存不能使用，一级依然可以使用
	 *	3.每个增删改标签都有flushCache=true的属性
	 *		增删改指定完成后，会清除一二级缓存
	 *		select标签中也有flushCache=false属性
	 *	4.sqlSession.clearCache():只会清空一级缓存
	 *	5.localCacheScope:本地缓存作用域，影响一级缓存的。
	 *		session：当前会话
	 *		statement：一次执行期间，可以禁用一级缓存
	 *	流程：二一库 
	 *
	 *	整合第三方缓存
	 *		
	 */

	@Test
	public void test() {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			EmployeeMapperCache mapper = session.getMapper(EmployeeMapperCache.class);
			Employee employee = mapper.getEmpById(1001);
			System.out.println("第一次查询：" + employee);
			System.out.println("----------------------");
			Employee employee2 = mapper.getEmpById(1001);
			System.out.println("第二次查询：" + employee2);
			System.out.println("----------------------");
			System.out.println("两次查询对象是否为一个对象：" + (employee == employee2));

		} finally {
			session.close();
		}
	}
}
