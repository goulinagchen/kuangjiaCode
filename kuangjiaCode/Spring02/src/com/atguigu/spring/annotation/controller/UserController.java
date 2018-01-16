package com.atguigu.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.atguigu.spring.annotation.service.UserService;

/**
 * @Controller的配置相当于在xml中配置如下内容:
 * 	<bean id="userController" class="com.atguigu.spring.annotation.controller.UserController">
 * 		<property name="userSerivce" ref="userService" />
 *  </bean>
 * 
 * @author weiyh
 *
 */
@Controller 
public class UserController {
	
	@Autowired(required=false)
	private UserService userService ;
	
	public void addUser() {
		System.out.println("UserController addUser()....");
		userService.addUser();
	}
}
