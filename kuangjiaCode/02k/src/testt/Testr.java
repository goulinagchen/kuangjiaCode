package testt;

import org.junit.Test;
import relation.Person;
import relation.Address;
import javax.sql.DataSource;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testr {

	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("relation.xml");
		Address address0 = (Address) context.getBean("address0");
		Address address1 = (Address) context.getBean("address1");
		System.out.println(address0);
		System.out.println(address1);

		Person person = (Person) context.getBean("person");
		System.out.println(person);
	}

	@Test
	public void test2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("scope.xml");
		Address address = (Address) context.getBean("address");
		System.out.println(address);
	}

	@Test
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test4() {
		ApplicationContext context = new ClassPathXmlApplicationContext("sple.xml");
		spel.Address address = (spel.Address) context.getBean("address");
		System.out.println(address);

		spel.Person person = (spel.Person) context.getBean("person");
		System.out.println(person);
	}
}
