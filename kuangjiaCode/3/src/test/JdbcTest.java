package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import jdbc.beans.Employee;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTest {

	private ApplicationContext context = null;
	private JdbcTemplate jdbcTemplate = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");
	}

	@Test
	public void testDataSource() {
		ComboPooledDataSource cp = (ComboPooledDataSource) context.getBean("dataSource");
		try {
			System.out.println(cp.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAdd() {
		String sql = "insert into tab_emp values(?,?,?,?)";
		jdbcTemplate.update(sql, 1001, "Tom", "tom@163.com", 1);
	}

	@Test
	public void testDelete() {
		String sql = "delete from tab_emp where id = ?";
		jdbcTemplate.update(sql, 2);
	}

	@Test
	public void testUpdate() {
		String sql = "update tab_emp set id = ?,last_name = ?,email = ?,dept_id = ? where id = ?";
		jdbcTemplate.update(sql, 2, "Jerry", "jerry@163.com", 3, 1001);
	}

	@Test
	public void testBatchUpdate(){
		String sql = "insert into tab_emp(last_name,email,dept_id) values(?,?,?)";
		ArrayList<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"AA","aa@sina.com",1});
		batchArgs.add(new Object[]{"BB","bb@sina.com",2});
		batchArgs.add(new Object[]{"VV","vv@sina.com",3});
		batchArgs.add(new Object[]{"CC","cc@sina.com",2});
		batchArgs.add(new Object[]{"DD","dd@sina.com",1});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	@Test
	public void testQueryForObjectReturnSingleObject(){
		String sql = "select id,last_name lastName,email,dept_id deptId from tab_emp where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1002);
		System.out.println(employee);
	}
	@Test
	public void testQueryForObjectReturnSingResult(){
		String sql = "select count(id) from tab_emp";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(result);
	}
	@Test
	public void testQuery(){
		String sql = "select id,last_name lastName,email,dept_id deptId from tab_emp where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> list = jdbcTemplate.query(sql, rowMapper,1002);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	/**
	 * 具名参数的jdbc模板测试
	 */
	@Test
	public void testNamedParamterJdbcTemplate(){
		
		String sql = "insert into tab_emp(last_name,email,dept_id) values(:ln,:email,:di)";
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("ln", "Jerry");
		paramMap.put("email", "jerry@22.com");
		paramMap.put("di", 2);
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testNamedParamterJdbcTemplate2(){
		
		String sql = "insert into tab_emp(last_name,email,dept_id) values(:lastName,:email,:deptId)";
		Employee employee = new Employee(null, "Rose", "rose@126.com", 2);
		
		SqlParameterSource SqlParameterSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql, SqlParameterSource);
	}
	
}
