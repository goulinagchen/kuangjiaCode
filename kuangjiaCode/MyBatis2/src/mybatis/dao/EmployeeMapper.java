package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import mybatis.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmployeeById(Integer id);

	public boolean addEmp(Employee employee);

	public boolean updateEmp(Employee employee);

	public boolean deleteEmpById(Integer id);

	public Employee getEmpByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

	public Employee getEmpByMap(Map<String, Object> map);

	public List<Employee> getEmpsByLastName(String lastName);

	public Map<String, Object> getEmpByIdReturnMap(Integer id);

	@MapKey("id")
	public Map<String, Employee> getEmpsByLastNameReturnMap(String lastName);

	public Employee getEmpByIdWithResultMap(Integer id);

	public Employee getEmpAndDeptWithResultMap(Integer id);
}
