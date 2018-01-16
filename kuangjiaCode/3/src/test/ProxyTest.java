package test;

import org.junit.Test;
import aop.ArithmeticCalulator;
import aop.ArithmeticCalculatorImp;
import aop.ArithmeticCalculatorLoggingPoxy;

/**
 * 对代理模式的测试
 * 
 * @author gouli
 *
 */
public class ProxyTest {

	@Test
	public void test1() {
		
		ArithmeticCalulator target = new ArithmeticCalculatorImp();

		ArithmeticCalulator proxy = new ArithmeticCalculatorLoggingPoxy(target).getLoggingProxy();

		int result = proxy.add(1, 2);

		System.out.println("result ===> " + result);

		result = proxy.div(4, 2);
		
		System.out.println("result ===> " + result);
	}
}
