package mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQL {

	public List<Employee> getEmpsByConditionIf(Employee employee);

	public List<Employee> getEmpsByConditionTrim(Employee employee);

	public List<Employee> getEmpsByConditionChoose(Employee employee);

	public void updateEmpByConditionSet(Employee employee);

	public List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

	public void addEmpsBatch(@Param("emps") List<Employee> emps);

	public List<Employee> getEmpsTestInnerParameter(Employee employee);
}
