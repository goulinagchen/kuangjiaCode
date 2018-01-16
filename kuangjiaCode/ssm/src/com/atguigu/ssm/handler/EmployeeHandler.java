package com.atguigu.ssm.handler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atguigu.ssm.beans.Employee;
import com.atguigu.ssm.service.EmployeeService;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService ;
	
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String getAllEmps(Map<String,Object> map) {
		List<Employee> emps = employeeService.getAllEmps();
		map.put("emps", emps);
		return "list";
	}
}
