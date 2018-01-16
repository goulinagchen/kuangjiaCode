package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Component
@Aspect
@Order(1)
public class ValidatorAspect {

	@Before("LoggingAspect.declareJoinPointExpression()")
	public void beforeMethod() {
		System.out.println("VaildatorAspect beforeMethod ...");
	}
}
