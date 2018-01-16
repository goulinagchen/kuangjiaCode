package mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.bean.Employee;
import mybatis.dao.EmployeeMapper;

public class MyBtisTest {

	public SqlSession getSqlSession() {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println(sqlSession);
		return sqlSession;
	}

	@Test
	public void testHelloWorld() throws Exception {
		SqlSession session = getSqlSession();
		try {
			Employee employee = session.selectOne("mybatis.dao.EmployeeMapper.selectEmployee", 1002);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void testAddEmp() throws Exception {
		SqlSession session = getSqlSession();
		try {
			Employee employee = new Employee("zsf", "1", "zsf@sina.com");
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			boolean addEmp = mapper.addEmp(employee);
			System.out.println(addEmp);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdateEmp() throws Exception {
		SqlSession session = getSqlSession();
		try {
			Employee employee = new Employee(1002, "Orwen", "1", "ow@sian.com");
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			boolean updateEmp = mapper.updateEmp(employee);
			System.out.println(updateEmp);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void testDeleteEmp() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			boolean deleteEmpById = mapper.deleteEmpById(1002);
			System.out.println(deleteEmpById);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void testParameter() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpByIdAndLastName(1003, "zsf");
			System.out.println(employee);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void testParameterMap() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Map<String, Object> map = new HashMap<>();
			map.put("id", 1001);
			map.put("lastName", "Tom");
			map.put("tableName", "tal_employee");
			Employee empByMap = mapper.getEmpByMap(map);
			System.out.println(empByMap);
		} finally {
			session.close();
		}
	}

	@Test
	public void testGetEmpByLastNameReturnList() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			List<Employee> list = mapper.getEmpsByLastName("%o%");
			System.out.println(list);
		} finally {
			session.close();
		}
	}

	@Test
	public void testGetEmpByIdReturnMap() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Map<String, Object> map = mapper.getEmpByIdReturnMap(1003);
			System.out.println(map);
		} finally {
			session.close();
		}
	}

	@Test
	public void testGetEmpByLastNameReturnMap() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Map<String, Employee> map = mapper.getEmpsByLastNameReturnMap("%o%");
			System.out.println(map);
		} finally {
			session.close();
		}
	}

	@Test
	public void testResultMap() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpByIdWithResultMap(1003);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void testGetEmpAndDept() throws Exception {
		SqlSession session = getSqlSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpAndDeptWithResultMap(1001);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}
}
