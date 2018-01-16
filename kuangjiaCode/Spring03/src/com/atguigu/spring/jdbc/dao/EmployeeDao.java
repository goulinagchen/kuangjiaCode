package com.atguigu.spring.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.atguigu.spring.jdbc.beans.Employee;

@Repository
public class EmployeeDao  extends JdbcDaoSupport {
	
//	@Autowired
//	public void setDataSource2(DataSource dataSource) {
//		setDataSource(dataSource);
//	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee getEmployeeById(Integer id ) {
		String sql  = " select id,last_name lastName ,email,dept_id deptId from tbl_emp where id = ?";
		RowMapper<Employee> rowMapper = 
				new BeanPropertyRowMapper<Employee>(Employee.class) ;
		
		Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, id);
		
		//getJdbcTemplate().queryForObject(sql, requiredType)
		return emp ;
	}
}
