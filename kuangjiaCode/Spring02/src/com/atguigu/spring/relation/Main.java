package com.atguigu.spring.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.实例化SpringIOC容器
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("relation.xml");
		//2.获取bean
		//Address address = (Address)ctx.getBean("address");
		Address address1 = (Address)ctx.getBean("address1");
		
		//System.out.println("address:"+address);
		System.out.println("address1:"+address1);
		
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
