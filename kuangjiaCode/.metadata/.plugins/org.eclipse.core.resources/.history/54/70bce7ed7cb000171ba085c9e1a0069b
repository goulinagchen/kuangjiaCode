package com.atguigu.mybaits.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybaits.beans.Department;
import com.atguigu.mybaits.beans.Employee;
import com.atguigu.mybatis.dao.DepartmentMapperResultMap;
import com.atguigu.mybatis.dao.EmployeeMapperResultMap;

public class MyBatisTestResultMap {
	
	public SqlSessionFactory getSqlSessionFactory()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	
	@Test
	public void testResultMap()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperResultMap mapper = 
						session.getMapper(EmployeeMapperResultMap.class);
			Employee employee = mapper.getEmpById(1001);
			System.out.println(employee);
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testGetEmpAndDept()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperResultMap mapper = 
						session.getMapper(EmployeeMapperResultMap.class);
			Employee employee = mapper.getEmpAndDept(1001);
			System.out.println(employee);
			System.out.println(employee.getDept());
			session.commit();
		}finally {
			session.close();
		}
	}
	@Test
	public void testGetEmpAndDeptStep()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperResultMap mapper = 
						session.getMapper(EmployeeMapperResultMap.class);
			Employee employee = mapper.getEmpAndDeptStep(1001);
			System.out.println(employee.getLastName());
			System.out.println("-----------------------------");
			//System.out.println(employee.getDept());
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testGetDeptAndEmps()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			DepartmentMapperResultMap mapper = 
					session.getMapper(DepartmentMapperResultMap.class);
			Department dept = mapper.getDeptAndEmps(1);
			System.out.println(dept);
			
			System.out.println(dept.getEmps());
			
			session.commit();
		}finally {
			session.close();
		}
	}

	
	@Test
	public void testGetDeptAndEmpsStep()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			DepartmentMapperResultMap mapper = 
					session.getMapper(DepartmentMapperResultMap.class);
			Department dept = mapper.getDeptAndEmpsStep(1);
			System.out.println(dept.getDepartmentName());
			System.out.println("---------------------");
			System.out.println(dept.getEmps());
			
			session.commit();
		}finally {
			session.close();
		}
	}

}
