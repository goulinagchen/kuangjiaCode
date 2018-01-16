package com.atguigu.spring.jdbc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.atguigu.spring.jdbc.beans.Employee;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestJdbcTemplate {
	private ApplicationContext ctx = null ;
	private JdbcTemplate jdbcTemplate  = null ;
	
	@Before   // 会在每个@Test方法执行之前执行.
	public void init() {
		 ctx = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
		 jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
	}
	
	@Test
	public void testDataSource() throws Exception{
		//1.
		ComboPooledDataSource ds = (ComboPooledDataSource)ctx.getBean("dataSource");
		System.out.println(ds.getConnection());
	}
	
	/**
	 * update:  insert delete update .
	 */
	@Test
	public void testUpdate() {
		String sql = "insert into tbl_emp values(?,?,?,?)";
		jdbcTemplate.update(sql, 1001,"Tom","tom@atguigu.com",1);
		//自己完成 delete  update 
	}
	
	/**
	 * batchUpdate: 批量增删改.
	 */
	@Test
	public void testBatchUpdate() {
		String sql = "insert into tbl_emp(last_name,email,dept_id) values(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] {"AA","aa@sina.com",1});
		batchArgs.add(new Object[] {"BB","bb@sina.com",2});
		batchArgs.add(new Object[] {"CC","cc@sina.com",3});
		batchArgs.add(new Object[] {"DD","dd@sina.com",1});
		batchArgs.add(new Object[] {"EE","ee@sina.com",2});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	/**
	 * queryForObject: 查询单行数据返回单个对象
	 */
	@Test
	public void testQueryForObjectReturnSingleObject() {
		String sql  = " select id,last_name lastName ,email,dept_id deptId from tbl_emp where id = ?";
		RowMapper<Employee> rowMapper = 
				new BeanPropertyRowMapper<Employee>(Employee.class) ;
		
		Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, 1001);
		System.out.println(emp);
	}
	
	/**
	 * queryForObject: 查询返回单个值
	 */
	@Test
	public void testQueryForObjectReturnSingleResult() {
		String sql = " select count(id) from tbl_emp " ;
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(result);
	}
	
	/**
	 * query: 查询多行
	 */
	@Test
	public void testQuery() {
		String sql = "select id ,last_name lastName,email,dept_id deptId from tbl_emp where id > ? ";
		RowMapper<Employee> rowMapper = 
				new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> emps = jdbcTemplate.query(sql, rowMapper, 1001);
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
}
