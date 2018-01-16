package com.atguigu.spring.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidatorAspect {

	@Before("LoggingAspect.declareJoinPointExpression()")
	public void beforeMethod() {
		System.out.println("ValidatorAspect beforeMethod ......");
	}
}
