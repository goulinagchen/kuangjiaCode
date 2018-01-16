package mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.beans.Employee;
import mybatis.dao.EmployeeMapper;

public class MyBatisTest {

	@Test
	public void testHelloWorld() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(session);
		try {
			Employee employee = session.selectOne("suibian.selectEmployee", 1001);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void testHelloWorldMapper() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			System.out.println(mapper.getClass().getName());
			Employee employee = mapper.getEmployeeById(1001);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}
}
