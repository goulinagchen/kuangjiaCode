package com.atguigu.spring.aop;

public class Main {
	public static void main(String[] args) {
		//ArithmeticCalculator ac = new ArithmeticCalculatorLoggingImpl();
		
		//获取代理对象
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		
		ArithmeticCalculator proxy  =
				new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		// + 
		int result = proxy.add(1, 1);
		System.out.println("result=====>:" +result );
		
		// / 
		result = proxy.div(4, 2);
		System.out.println("result=====>:"+ result );
	}
}
