package mybatis.dao;

import mybatis.beans.Employee;

public interface EmployeeMapper {

	public Employee getEmployeeById(Integer id);
}
