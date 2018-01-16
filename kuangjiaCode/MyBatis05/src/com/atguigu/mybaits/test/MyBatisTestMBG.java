package com.atguigu.mybaits.test;

import java.io.File;
import java.io.InputStream;
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

import com.atguigu.mybaits.beans.Employee;
import com.atguigu.mybaits.beans.EmployeeExample;
import com.atguigu.mybaits.beans.EmployeeExample.Criteria;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class MyBatisTestMBG {
	
	public SqlSessionFactory getSqlSessionFactory()  throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	
	@Test
	public void testMBG()  throws Exception{
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
	public void testMyBatis() throws Exception{
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession session = ssf.openSession();
		
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			
			//查询员工名字中带有"e"字母 和员工性别是1的   或者email中带有j字母的
			EmployeeExample example = new EmployeeExample();
			//获取Criteria对象
			Criteria criteria = example.createCriteria();
			
			criteria.andLastNameLike("%e%");
			
			criteria.andGenderEqualTo("1");
			
			//对于或的条件，需要用新的Criteria来封装
			Criteria criteriaOr = example.createCriteria();
			criteriaOr.andEmailLike("%j%");
			
			example.or(criteriaOr);
			
			List<Employee> emps = mapper.selectByExample(example);
			
			for (Employee employee : emps) {
				System.out.println(employee);
			}
			
		}finally {
			session.close();
		}
	}
}
