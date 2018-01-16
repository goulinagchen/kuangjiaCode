package com.atguigu.mybatis.dao;

import com.atguigu.mybaits.beans.Employee;

public interface EmployeeMapperCache {

	public Employee getEmpById(Integer id);

	public Employee getEmpByLastName(String lastName);

	public boolean deleteEmpById(Integer id);
}
