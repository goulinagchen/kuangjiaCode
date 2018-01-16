package com.atguigu.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.实例化IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("autowire.xml");
		//2.获取bean
		Person person = ctx.getBean("person",Person.class);
		//3.使用
		System.out.println(person);
	}
}
