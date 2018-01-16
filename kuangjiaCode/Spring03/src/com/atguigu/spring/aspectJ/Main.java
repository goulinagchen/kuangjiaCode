package com.atguigu.spring.aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectJ.xml");
		
		//
		ArithmeticCalculator ac =(ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");
		
		int result = ac.add(1, 1);
		System.out.println("AspectJ Result======>: " + result );
		System.out.println("-----------------------------------");
//		result = ac.div(4, 0);
//		System.out.println("AspectJ Result======>: " + result );
	}
	
}
