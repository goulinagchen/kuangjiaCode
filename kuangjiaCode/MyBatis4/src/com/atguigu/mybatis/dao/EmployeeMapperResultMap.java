package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybaits.beans.Employee;

public interface EmployeeMapperResultMap {
	//查询单个对象
	public Employee getEmpById(Integer id );
	
	//查询员工的同时查询部门信息
	public Employee getEmpAndDept(Integer id );
	
	//查询员工的同时查询部门信息  分步
	public Employee getEmpAndDeptStep(Integer id );
	
	//根据部门id查询所有的员工信息
	public List<Employee> getEmpsByD_ID(Integer did );
	

}