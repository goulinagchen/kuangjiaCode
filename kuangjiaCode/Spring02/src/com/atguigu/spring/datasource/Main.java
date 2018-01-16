package com.atguigu.spring.datasource;


import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("datasource.xml");
		DataSource ds = (DataSource)ctx.getBean("dataSource");
		
		System.out.println(ds);
		
		System.out.println(ds.getConnection());
	}
}
