package testt;

import factory.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("factory.xml");
		Car car1 = (Car) context.getBean("car1");
		System.out.println(car1);
		
		Car car2 = (Car) context.getBean("car2");
		System.out.println(car2);
		
		Car car3 = (Car) context.getBean("car3");
		System.out.println(car3);
		
		Car car4 = (Car) context.getBean("car4");
		System.out.println(car4);
		
		Car car5 = (Car) context.getBean("car5");
		System.out.println(car5);
	}
}
