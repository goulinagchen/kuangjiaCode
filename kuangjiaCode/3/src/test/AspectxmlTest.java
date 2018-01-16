package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import aspectJ.xml.ArithmeticCalulator;

public class AspectxmlTest {

	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aspect-xml.xml");
		ArithmeticCalulator ac = (ArithmeticCalulator) context.getBean("arithmeticCalculatorImp");
		System.out.println(ac.getClass().getName());
		int result = ac.add(4, 2);
		System.out.println("AspectJ Result ===> " + result);
	}
}
