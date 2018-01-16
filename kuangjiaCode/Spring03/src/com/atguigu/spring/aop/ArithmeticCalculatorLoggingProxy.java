package com.atguigu.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	//要代理的对象   目标对象
	private ArithmeticCalculator target ;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target =target ;
	}
	
	//获取代理对象
	public ArithmeticCalculator getLoggingProxy() {
		//要返回的代理对象
		ArithmeticCalculator proxy ;
		//loader: 类加载器对象.
		ClassLoader loader  = target.getClass().getClassLoader();
		//interfaces:目标对象的所有接口
		Class [] interfaces = target.getClass().getInterfaces();
		//h: InvocationHandler: 完成代理过程
		InvocationHandler  h = new InvocationHandler() {
			/**
			 * invoke: 用于调用目标对象的方法，完成代理过程
			 * proxy: 代理对象
			 * method:正在被调用的方法`
			 * args: 方法的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("[Atguigu]***The method "+ methodName +" begin with "+Arrays.asList(args));
				//执行目标方法
				Object result = method.invoke(target, args);
				
				System.out.println("[Atguigu]***The method "+methodName + "end with " +result );
				return result;
			}
		};
		proxy = (ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy ;
	}
}
