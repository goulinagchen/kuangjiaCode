package test;

import org.junit.Test;
import aspect.ArithmeticCalulator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对aspectJ的测试
 * 
 * @author gouli
 *
 */
public class AspectTest {

	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
		ArithmeticCalulator aci = (ArithmeticCalulator) context.getBean("arithmeticCalculatorImp");
		int result = aci.add(1, 3);
		System.out.println("AspectJ Result ===> " + result);
		System.out.println("-----------------------------");
		result = aci.div(4, 0);
		System.out.println("AspectJ Result ===> " + result);
	}
}
