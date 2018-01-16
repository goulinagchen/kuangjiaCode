package jdbc.dao;

import jdbc.beans.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee getEmployeeById(Integer id){
		String sql= "select id,last_name lastName,email,dept_id deptId from tab_emp where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,id);
		return employee;
	}
}
