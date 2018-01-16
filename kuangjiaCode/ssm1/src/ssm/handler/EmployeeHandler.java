package ssm.handler;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ssm.bean.Department;
import ssm.bean.Employee;
import ssm.service.DepartmentService;
import ssm.service.EmployeeService;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService eService;

	@Autowired
	private DepartmentService dService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getAllEmps(Map<String, Object> map) {
		List<Employee> employees = eService.getAllEmps();
		map.put("employees", employees);
		System.out.println("查询所有员工信息：" + employees);
		return "list";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String toAddPage(Map<String, Object> map) {
		Collection<Department> departments = dService.getDepartments();
		map.put("departments", departments);
		System.out.println("查询departments：" + departments);
		map.put("employee", new Employee());
		return "input";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String addEmp(Employee employee) {
		eService.addEmp(employee);
		System.out.println("addEmp employee:" + employee);
		return "redirect:/employees";
	}

	/**
	 * 修改前查询
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") Integer id, Map<String, Object> map) {
		System.out.println("updatePage id:" + id);
		Employee employee = eService.getEmp(id);
		System.out.println("update: " + employee);
		map.put("employee", employee);
		Collection<Department> departments = dService.getDepartments();
		map.put("departments", departments);
		return "input";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	public String updateEmp(Employee employee) {
		eService.updateEmp(employee);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id") Integer id) {
		eService.deleteEmp(id);
		return "redirect:/employees";
	}

	@ModelAttribute
	public void getEmployee(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			Employee employee = eService.getEmp(id);
			map.put("employee", employee);
		}
	}
}
