package com.atguigu.mybaits.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybaits.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class MyBatisTest {

	@Test
	public void testSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
	}
	
	/**
	 *  HelloWorld简单版小结:
	 *  1.创建一个MyBatis的全局配置文件mybatis-config.xml,根据全局配置文件创建了SqlSessionFactory.	
	 *  2.创建一个Sql映射文件XXXXMapper.xml,该文件中定义sql语句以及封装规则等.
	 *  3.将Sql映射文件注册到全局配置文件中.
	 *  4.从SqlSessionFactory中获取SqlSession对象. 简单理解为是对Connection的封装.
	 *    一个SqlSession代表和数据库的一次会话。
	 *  5.调用sqlSession的方法，给定sql语句的唯一标识以及执行sql用到的参数。完成增删改查.
	 *  6.将sqlSession会话对象关闭。释放资源.
	 */
	
	@Test
	public void testHelloWord() throws Exception {
		//获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);
		
		//从SqlSessionFactory中获取SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		try {
			/**
			 * selectOne:
			 * 	 1.sql语句的唯一标识
			 *   2.执行sql要用的参数
			 */
		Employee employee = 
				 session.selectOne("com.atguigu.mybatis.dao.EmployeeMapper.selectEmployee", 1001);
		System.out.println(employee);
		} finally {
			session.close();
		}
	}
	/**
	 * HelloWorld Mapper接口版本小结:
	 * 	1.创建一个MyBatis的全局配置文件mybatis-config.xml,根据全局配置文件创建了SqlSessionFactory.	
	 *  2.创建一个Sql映射文件XXXXMapper.xml,该文件中定义sql语句以及封装规则等.
	 *  3.将Sql映射文件注册到全局配置文件中.
	 *  4.编写Mapper接口,在接口中定义好增删改查的方法.完成两个绑定.
	 *    a.将sql映射文件的namespace的值写成接口的全类名 . sql映射文件与接口的绑定.
	 *    b.sql映射文件中sql语句的id值与接口中的方法一致。    sql语句与接口的方法绑定.
	 *  5.从SqlSessionFactory中获取SqlSession对象.
	 *  6.获取Mapper接口的代理类对象.
	 *    EmployeeDao==>EmployeeDaoImpl==>new EmployeeDaoImpl().调用方法
	 *    EmployeeMapper==>Proxy==>代理类的对象.
	 *  7.使用代理类对象调用方法来完成增删改查
	 *  8.关闭资源.
	 */
	/**
	 * Mapper接口编程的好处:
	 *   1.接口规定的方法拥有更强的类型检查.
	 *   2.接口规定的方法有明确的返回值类型.
	 *   3.接口本身:
	 *   	接口本身就是抽象,抽出了规范. 将dao的规范与实现分离. 
	 *      EmployeeMapper接口
	 *      具体实现: MyBatis   Hibernate  JdbcTemplate  jdbc .....
	 */
	@Test
	public void testHelloWorldMapper()  throws Exception{
		//获取SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			//获取接口的实现类对象.  MyBaits会为Mapper接口生成代理类，获取的是代理类的对象.
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			System.out.println(mapper.getClass().getName());  //com.sun.proxy.$Proxy4
			
			Employee employee = mapper.getEmployeeById(1001);
			System.out.println(employee);
		}finally {
			session.close();
		}
		
	}
}
