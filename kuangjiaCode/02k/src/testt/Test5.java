package testt;

import org.junit.Test;
import annotation.service.UserService;
import annotation.dao.imp.UserDaoJdbcImp;
import annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {

	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
		UserController userConntroller = (UserController) context.getBean("userController");
		
		UserService userService = (UserService) context.getBean("userService");
		
		UserDaoJdbcImp userDaoJdbcImp = (UserDaoJdbcImp) context.getBean("userDaoJdbcImp");
		
		System.out.println(userConntroller);
		System.out.println(userService);
		System.out.println(userDaoJdbcImp);
	}
}
