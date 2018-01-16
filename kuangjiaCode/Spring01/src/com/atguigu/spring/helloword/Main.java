package com.atguigu.spring.helloword;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		//1.创建HelloWorld对象
//		HelloWorld  helloWorld = new HelloWorld();
//		
//		//2.给对象的属性赋值
//		helloWorld.setUserName("Atguigu");
		
		/**
		 * 使用spring来完成1  2  
		 */
		//1.实例化IOC容器
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	
		//2.从IOC容器中获取bean
		//HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
		//HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		HelloWorld helloWorld = ctx.getBean("helloWorld1",HelloWorld.class);
		
		//3.调用方法
		helloWorld.sayHello();
		
		//ctx.refresh();
	}
}
