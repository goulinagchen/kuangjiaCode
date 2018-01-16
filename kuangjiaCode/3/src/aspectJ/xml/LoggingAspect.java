package aspectJ.xml;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志切面：将日志记录的功能模块化到一个切面类中
 * 
 * @author gouli
 *
 */
public class LoggingAspect {

	/**
	 * 重用切点表达式
	 */
	public void declareJoinPointExpression() {
	}

	/**
	 * 前置对象
	 */
	public void beforeMethod(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("The Method " + name + " begin with " + Arrays.asList(args));
	}

	/**
	 * 后置通知
	 */
	public void afterMethod(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println("The name " + name + " ends. ");
	}

	/**
	 * 返回通知
	 */

	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String name = joinPoint.getSignature().getName();
		System.out.println("The method " + name + " end with " + result);
	}

	/**
	 * 异常通知
	 */
	public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
		String name = joinPoint.getSignature().getName();
		System.out.println("The method " + name + " occurs exception: " + e);
	}

	/**
	 * 环绕通知
	 */
	public Object arountMethod(ProceedingJoinPoint pjp) {
		Object result = null;
		String name = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		try {
			System.out.println("The method " + name + " begin with " + Arrays.asList(args));
			result = pjp.proceed();
			System.out.println("The method " + name + " end with " + result);
		} catch (Throwable e) {
			System.out.println("The method " + name + " occurs exception: " + e);
		} finally {
			System.out.println("The method " + name + " ends. ");
		}
		return result;
	}
}
