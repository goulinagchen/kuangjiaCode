package ssm.mapper;

import java.util.List;

import ssm.bean.Department;

public interface DepartmentMapper {

	public List<Department> getDepartments();

	public Department getDepartment(Integer id);
}
