package com.atguigu.spring.helloword;

public class HelloWorld {
	
	private String userName;

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public void sayHello() {
		System.out.println("Hello "+ userName);
		
	}
	
}
