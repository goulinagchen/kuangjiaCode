package ssm.mapper;

import java.util.List;

import ssm.bean.Employee;

public interface EmployeeMapper {

	public List<Employee> getAllEmps();

	public void addEmp(Employee employee);

	public void updateEmp(Employee employee);

	public void deleteEmp(Integer id);

	public Employee getEmp(Integer id);
}
