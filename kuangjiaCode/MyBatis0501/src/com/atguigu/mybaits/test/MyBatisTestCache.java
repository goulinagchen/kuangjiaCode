package com.atguigu.mybaits.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybaits.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class MyBatisTestCache {
	
	public SqlSessionFactory getSqlSessionFactory()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	@Test
	public void testPageHelper()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			
			//在查询之前设置分页信息
			Page<Object> page = PageHelper.startPage(9,1);
			List<Employee> emps = mapper.getEmps();
			
			//PageInfo   传入要连续显示多少页码,做分页逻辑
			PageInfo<Employee> info = new PageInfo<>(emps,5);
			
			for (Employee employee : emps) {
				System.out.println(employee);
			}
			
			System.out.println("-------------------------");
			System.out.println("从page对象中获取分页相关的信息:");
			System.out.println("当前页码:" + page.getPageNum());
			System.out.println("总记录数:" + page.getTotal());
			System.out.println("每页的记录数:" + page.getPageSize());
			System.out.println("总页码:" + page.getPages());
			System.out.println("----------------------------");
			System.out.println("从pageInfo对象中获取分页相关的信息:");
			System.out.println("当前页码:" + info.getPageNum());
			System.out.println("总记录数:" + info.getTotal());
			System.out.println("每页的记录数:" +info.getPageSize());
			System.out.println("总页码:" + info.getPages());
			System.out.println("是否第一页:"+ info.isIsFirstPage());
			System.out.println("是否是尾页:"+info.isIsLastPage());
			System.out.println("是否有上一页:"+ info.isHasPreviousPage());
			System.out.println("是否有下一页:" +info.isHasNextPage());
			
			System.out.println("连续显示的页码:");
			int [] nums = info.getNavigatepageNums();
			for(int i : nums ) {
				System.out.print(i +" ");
			}
			
			
		}finally {
			session.close();
		}
	}
	
	
	
}
