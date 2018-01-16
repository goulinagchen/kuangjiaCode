package com.atguigu.mybatis.dao;

import com.atguigu.mybaits.beans.Employee;

/**
 *  Mapper接口  等价于 JDBC中的Dao接口.
 *
 */
public interface EmployeeMapper {
	
	public Employee getEmployeeById(Integer id );
}


/*class EmployeeMapperImpl implements EmployeeMapper{

	@Override
	public Employee getEmployeeById(Integer id) {
		//jdbc
		return null;
	}
	
}*/