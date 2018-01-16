package com.atguigu.spring.aop;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int a, int b) {
		System.out.println("[Atguigu]The method add begin with ["+a+","+b+"]");
		int result = a + b ; 
		System.out.println("[Atguigu]The method add end with " +result );
		return  result ;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("[Atguigu]The method sub begin with [ "+a+ ","+b+"] ");
		int result = a - b ; 
		System.out.println("[Atguigu]The method sub end with " +result );
		return result;
	}

	@Override
	public int mul(int a, int b) {
		System.out.println("[Atguigu]The method mul begin with [ "+a+ ","+b+"] ");
		int result = a * b ;
		System.out.println("[Atguigu]The method mul end with " +result );
		return  result ;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("[Atguigu]The method div begin with [ "+a+ ","+b+"] ");
		int result = a / b ; 
		System.out.println("[Atguigu]The method div end with " +result );
		return result ;
	}
	
}
