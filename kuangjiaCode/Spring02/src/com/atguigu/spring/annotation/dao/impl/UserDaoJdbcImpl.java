package com.atguigu.spring.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.atguigu.spring.annotation.dao.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao {
	
	public void addUser() {
		System.out.println("UserDaoJdbcImpl  addUser()...");
	}
}
