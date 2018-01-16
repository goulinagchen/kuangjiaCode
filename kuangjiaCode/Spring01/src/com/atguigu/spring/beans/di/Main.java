package com.atguigu.spring.beans.di;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.实例化IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di.xml");
		//2.从IOC容器中获取bean
		
		
		
		Car car1 = (Car) ctx.getBean("car1");
		
		Car car2 = (Car) ctx.getBean("car2");
		
		Book book = (Book) ctx.getBean("book");
		
		Person person = (Person)ctx.getBean("person");
		
		Person personInnerBean = (Person)ctx.getBean("personInnerBean");
		
		Person personNullAndCascade = (Person) ctx.getBean("personNullAndCascade");
		
		Car car0 = (Car)ctx.getBean("car0");
		
		PersonList personList = (PersonList)ctx.getBean("personList");
		
		PersonMap personMap = (PersonMap) ctx.getBean("personMap");
		
		MyDataSource mds = (MyDataSource) ctx.getBean("myDataSource");
		
		PersonList personList2 = (PersonList)ctx.getBean("personList2");
		//3.使用
		System.out.println(car0);
		
		System.out.println(car1);
		
		System.out.println(car2);
		
		System.out.println(book);
		
		System.out.println(person);
		
		System.out.println(personInnerBean);
		
		System.out.println(personNullAndCascade);
	
		System.out.println(personList);
		
		System.out.println(personMap);
		
		System.out.println(mds);
		
		System.out.println(personList2);
	}
	
}
