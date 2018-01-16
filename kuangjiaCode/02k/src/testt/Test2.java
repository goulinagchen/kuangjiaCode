package testt;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import relation.Address;
import relation.Person;

public class Test2 {

	@Test
	//relation2.xml
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("relation2.xml");
	/*	Address address0 = (Address) context.getBean("address0");
		System.out.println(address0);*/
		
		Address address1 = (Address) context.getBean("address1");
		System.out.println(address1);
		
		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}
	
	@Test
	//scope2.xml
	public void test2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("scope2.xml");
		Address address1 = (Address) context.getBean("address");
		Address address2 = (Address) context.getBean("address");
		System.out.println(address1);
		System.out.println(address2);
	}
	
	@Test
	//sple2.xml
	public void test3(){
		new ClassPathXmlApplicationContext("");
	}
}
