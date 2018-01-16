package mybatis.bean;

import java.util.List;

public class Department {

	private Integer id;
	private String departmentName;
	private List<Employee> employees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department(Integer id) {
		super();
		this.id = id;
	}

	public Department() {
		super();
	}

	public Department(Integer id, String departmentName, List<Employee> employees) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", employees=" + employees + "]";
	}
}
