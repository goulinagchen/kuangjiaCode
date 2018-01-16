package com.atguigu.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.实例化IOC容器
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("scope.xml");
		
		//2.获取bean
		
		Address address = (Address)ctx.getBean("address");
//		
//		Address address1 = (Address) ctx.getBean("address");
//		
//		System.out.println(address == address1);
	}
}
