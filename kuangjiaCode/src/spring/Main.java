package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
		hw.sayHello();
		HelloWorld world = context.getBean("helloWorld1",HelloWorld.class);
		world.sayHello();
//		HelloWorld world2 = context.getBean(HelloWorld.class);
//		world2.sayHello();
		
		
	}
}
