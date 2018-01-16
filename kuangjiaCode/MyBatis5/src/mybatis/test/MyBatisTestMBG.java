package mybatis.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import mybatis.bean.Employee;
import mybatis.bean.EmployeeExample;
import mybatis.bean.EmployeeExample.Criteria;
import mybatis.dao.EmployeeMapper;

public class MyBatisTestMBG {

	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	@Test
	public void testMBG() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}

	@Test
	public void testMyBatis() throws Exception {
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			EmployeeExample example = new EmployeeExample();
			Criteria criteria = example.createCriteria();
			criteria.andLastNameLike("%e%");
			criteria.andGenderEqualTo("1");
			Criteria criteria2 = example.createCriteria();
			criteria2.andEmailLike("%j%");
			example.or(criteria2);
			List<Employee> list = mapper.selectByExample(example);
			for (Employee employee : list) {
				System.out.println(employee);
			}
		} finally {
			session.close();
		}
	}
}
