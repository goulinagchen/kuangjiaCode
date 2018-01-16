package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.bean.Employee;
import ssm.mapper.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper mapper;

	public Employee getEmp(Integer id) {
		return mapper.getEmp(id);
	}

	public List<Employee> getAllEmps() {
		return mapper.getAllEmps();
	}

	public void addEmp(Employee employee) {
		mapper.addEmp(employee);
	}

	public void updateEmp(Employee employee) {
		mapper.updateEmp(employee);
	}

	public void deleteEmp(Integer id) {
		mapper.deleteEmp(id);
	}
}
