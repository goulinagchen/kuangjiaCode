package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.bean.Department;
import ssm.mapper.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper mapper;

	public List<Department> getDepartments() {
		List<Department> list = mapper.getDepartments();
		return list;
	}

	public Department getDepartment(Integer id) {
		Department department = mapper.getDepartment(id);
		return department;
	}
}
