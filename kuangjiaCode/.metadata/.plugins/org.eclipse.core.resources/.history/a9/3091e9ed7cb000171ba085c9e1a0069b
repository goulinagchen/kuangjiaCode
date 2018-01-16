package com.atguigu.mybaits.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybaits.beans.Department;
import com.atguigu.mybaits.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;

public class MyBatisTestDynamicSQL {
	
	public SqlSessionFactory getSqlSessionFactory()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	
	@Test
	public void testIf()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = 
					session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee();
			//employee.setId(1001);
			employee.setLastName("Tom");
			employee.setEmail("tom@sina.com");
			//employee.setGender("1");
			List<Employee > emps    =mapper.getEmpsByConditonIf(employee);
			
			System.out.println(emps );
			
			session.commit();
		}finally {
			session.close();
		}
	}
	@Test
	public void testTrim()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = 
					session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee();
			employee.setId(1001);
			employee.setLastName("Tom");
			employee.setEmail("tom@sina.com");
			//employee.setGender("1");
			List<Employee > emps    =mapper.getEmpsByConditionTrim(employee);
			
			System.out.println(emps );
			
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testChoose()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = 
					session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee();
			//employee.setId(1001);
//			employee.setLastName("Tom");
//			employee.setEmail("tom@sina.com");
			employee.setGender("1");
			List<Employee > emps    =mapper.getEmpsByConditionChoose(employee);
			
			System.out.println(emps );
			
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testSet()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = 
					session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee();
			employee.setId(1001);
			employee.setLastName("TomAA");
			employee.setEmail("tomaa@sina.com");
			//employee.setGender("0");
			mapper.updateEmpByConditionSet(employee);
			
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testForeach()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = 
					session.getMapper(EmployeeMapperDynamicSQL.class);
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(1001);
			ids.add(1004);
			List<Employee > emps = mapper.getEmpsByConditionForeach(ids);
			System.out.println(emps);
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testMysqlBatch1()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = 
					session.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> emps = new ArrayList<Employee>();
			emps.add(new Employee("AA", "0", "aa@sina.com", new Department(1)));
			emps.add(new Employee("BB", "1", "bb@sina.com", new Department(2)));
			emps.add(new Employee("CC", "0", "cc@sina.com", new Department(3)));
			emps.add(new Employee("DD", "1", "dd@sina.com", new Department(2)));
			emps.add(new Employee("EE", "0", "ee@sina.com", new Department(1)));
			
			mapper.addEmpsBatch(emps);
			session.commit();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testInnerParameter()  throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		try {
			EmployeeMapperDynamicSQL mapper = 
					session.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee();
			employee.setId(1001);
			employee.setLastName("a");
			List<Employee> emps = mapper.getEmpsTestInnerParameter(employee);
			System.out.println(emps);
			session.commit();
		}finally {
			session.close();
		}
	}
	

}
