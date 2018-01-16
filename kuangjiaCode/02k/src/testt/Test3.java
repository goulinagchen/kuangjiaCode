package testt;

import lifecycle.Car;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

	@Test
	public void test1() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");

		Car car = (Car) context.getBean("car");
		System.out.println(car);

		context.close();
	}
}
