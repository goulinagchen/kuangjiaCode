package aop;

import java.util.Arrays;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

public class ArithmeticCalculatorLoggingPoxy {

	private ArithmeticCalulator target;
	
	public ArithmeticCalculatorLoggingPoxy(ArithmeticCalulator target){
		this.target = target;
	}
	
	public ArithmeticCalulator getLoggingProxy(){
		//要返回的代理对象
		ArithmeticCalulator proxy;
		//类加载器对象
		ClassLoader loader = target.getClass().getClassLoader();
		//目标对象的所有接口
		Class[] interfaces = target.getClass().getInterfaces();
		//完成代理过程
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				String name = method.getName();
				
				System.out.println("The method " + name+ " begin with "+Arrays.asList(args));
				
				Object result = method.invoke(target, args);
				
				System.out.println("The method "+name + "end with "+result);
				
				return result;
			}
		};
		proxy = (ArithmeticCalulator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
