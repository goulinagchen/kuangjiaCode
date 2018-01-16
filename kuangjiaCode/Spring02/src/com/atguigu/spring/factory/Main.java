package com.atguigu.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("factory.xml");
		
		//2. 获取bean
		
		Car car = (Car)ctx.getBean("car");
		
		System.out.println(car);
		
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car)ctx.getBean("car2");
		System.out.println(car2);
	}
}
