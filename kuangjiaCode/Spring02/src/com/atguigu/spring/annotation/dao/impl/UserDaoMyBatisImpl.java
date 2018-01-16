package com.atguigu.spring.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.atguigu.spring.annotation.dao.UserDao;

@Repository    
// 默认的id值是userDaoMyBatisImpl    @Repository("userDao")等价于@Repository(value="userDao")
public class UserDaoMyBatisImpl implements UserDao {
	
	@Override
	public void addUser() {
		System.out.println("UserDaoMyBatisImpl addUser()....");
	}
}
