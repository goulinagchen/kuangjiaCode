package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybaits.beans.Employee;

public interface EmployeeMapper {
	
	public List<Employee> getEmps();
}