package com.atguigu.spring.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle.xml");
		
		Car car = (Car)ctx.getBean("car");
		
		System.out.println("使用:" + car);
		
		//关闭容器
		ctx.close();
	}
}
