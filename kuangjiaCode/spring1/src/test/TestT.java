package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import bean.Book;
import bean.Car;
import bean.HelloWorld;
import bean.MyDataSource;
import bean.Person;
import bean.PersonList;
import bean.PersonMap;

public class TestT {

	@Test
	// 测试applicationContext.xml
	public void test1() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld h1 = (HelloWorld) context.getBean("helloWorld");
		h1.sayHello();

		HelloWorld h2 = (HelloWorld) context.getBean("helloWorld1");
		h2.sayHello();
	}

	@Test
	// 测试di.xml
	public void test2() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("di.xml");

		Car car1 = (Car) context.getBean("car1");
		System.out.println(car1);

		Car car2 = (Car) context.getBean("car2");
		System.out.println(car2);

		Car car0 = (Car) context.getBean("car0");
		System.out.println(car0);

		Book book = (Book) context.getBean("book");
		System.out.println(book);

		Person person = (Person) context.getBean("person");
		System.out.println(person);

		Person personInnerBean = (Person) context.getBean("personInnerBean");
		System.out.println(personInnerBean);

		Person personNullAndCascade = (Person) context.getBean("personNullAndCascade");
		System.out.println(personNullAndCascade);

		PersonList personList = (PersonList) context.getBean("personList");
		System.out.println(personList);

		PersonMap personMap = (PersonMap) context.getBean("personMap");
		System.out.println(personMap);

		MyDataSource mdSource = (MyDataSource) context.getBean("myDataSource");
		System.out.println(mdSource);

		PersonList personList2 = (PersonList) context.getBean("personList2");
		System.out.println(personList2);
	}

	@Test
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");
		Person person = context.getBean("person", Person.class);
		System.out.println(person);
	}
}
