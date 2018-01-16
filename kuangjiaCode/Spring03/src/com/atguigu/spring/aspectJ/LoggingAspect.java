package com.atguigu.spring.aspectJ;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 日志切面:将日志记录的功能模块化到一个切面类中.
 */
@Component  //标识为一个组件
@Aspect  //标识为一个切面
@Order(3)
//通过@Order注解来配置切面的优先级. 值越小优先级越高.配置Order注解的切面比不配置Order注解的切面的优先级高.
public class LoggingAspect {
	/**
	 * 重用切入点表达式
	 */
	@Pointcut("execution(* com.atguigu.spring.aspectJ.*.*(..))")
	public void declareJoinPointExpression() {}
	
	
	/**
	 * 前置通知:在目标方法执行之前执行.
	 * joinPoint:连接点对象    可以获取连接相关的信息. 方法名,方法参数等..
	 */
	//@Before("execution(public int com.atguigu.spring.aspectJ.ArithmeticCalculatorImpl.*(int,int))")
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();
		System.out.println("The Method "+methodName + " begin with " + Arrays.asList(args));
	}
	
	/**
	 * 后置通知:在目标方法执行之后执行. 不能获取目标方法的返回值，不管方法有没有异常都会执行.
	 * 第一个*: 任意修饰符 任意返回值
	 * 第二个*: 包下任意类
	 * 第三个*: 类下任意方法
	 * ..: 任意参数
	 */
	//@After("execution(* com.atguigu.spring.aspectJ.*.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName +" ends .");
	}
	/**
	 * 返回通知: 在方法正常执行结束后执行.
	 * 		       返回通知可以获取到目标方法的返回值.
	 */
	//@AfterReturning(value="execution(* com.atguigu.spring.aspectJ.*.*(..))",returning="result")
	@AfterReturning(value="declareJoinPointExpression()",returning="result")
	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+methodName +" end with " +result  );
	}
	
	/**
	 * 异常通知: 在方法抛出异常以后执行.
	 * 		      可以指定在目标方法抛出指定异常的时候执行.
	 */
	//@AfterThrowing(value="execution(* com.atguigu.spring.aspectJ.*.*(..))",throwing="ex")
	public void afterThrowingMethod(JoinPoint joinPoint,ArithmeticException ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: "+ex);
	}
	
	/**
	 * 环绕通知:  环绕着整个方法执行. 类似于动态代理的整个过程.
	 *          可以简单理解为:  环绕通知是 前置  后置  返回  异常四个通知的结合体.
	 */ 
	//@Around("execution(* com.atguigu.spring.aspectJ.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp)  {
		//定义返回值
		Object result = null ;
		String methodName = pjp.getSignature().getName();
		Object  [] args = pjp.getArgs();
		
		//调用目标方法
		try {
			//前置
			System.out.println("The method "+methodName +" begin with " +Arrays.asList(args));
			result = pjp.proceed();
			//返回
			System.out.println("The method "+methodName + "end with " +result  );
			return result ;
		} catch (Throwable e) {
			e.printStackTrace();
			//异常
			System.out.println("The method "+ methodName + " occurs exception:" + e );
		}finally {
			//后置
			System.out.println("The method "+ methodName + " ends .");
		}
		
		return null ;
		
	}
	
	
	
	
	
	
}
