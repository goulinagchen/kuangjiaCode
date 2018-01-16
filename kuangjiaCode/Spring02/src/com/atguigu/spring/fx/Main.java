package com.atguigu.spring.fx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("fx.xml");
		
		UserService userService = (UserService)ctx.getBean("userService");
		
		userService.suibian();
		
//		RoleService roleService= (RoleService)ctx.getBean("roleService");
//		
//		roleService.suibian();
		
	}
}
