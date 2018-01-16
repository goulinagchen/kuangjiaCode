package com.atguigu.mybatis.dao;

import com.atguigu.mybaits.beans.Department;

public interface DepartmentMapperResultMap {
	
	//根据部门id查询部门
	public Department getDeptById(Integer id );
	
	//查询部门的同时将部门对应的所有员工也查询出来
	public Department getDeptAndEmps(Integer id );
	
	//查询部门的同时将部门对应的所有员工也查询出来  分步
	public Department getDeptAndEmpsStep(Integer id );
}
