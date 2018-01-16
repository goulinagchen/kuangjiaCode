package com.atguigu.spring.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.annotation.controller.UserController;
import com.atguigu.spring.annotation.dao.UserDao;
import com.atguigu.spring.annotation.service.UserService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("annotation.xml");
		//UserController
		UserController userController = (UserController)ctx.getBean("userController");
	//	System.out.println("userController:"+ userController);
//		
		//UserService
//		UserService userService= (UserService)ctx.getBean("userService");
//		System.out.println("userService:"+userService);
//		//UserDao
//		UserDao userDao = (UserDao)ctx.getBean("userDaoJdbcImpl");
//		System.out.println("userDao:"+ userDao);
		
		userController.addUser();
	}
}
