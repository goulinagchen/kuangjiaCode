package mybatis.dao;

import java.util.List;

import mybatis.bean.Employee;

public interface EmployeeMapper {

	public List<Employee> getEmployees();
}
