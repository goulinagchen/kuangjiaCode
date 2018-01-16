package com.atguigu.hibernate.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.atguigu.hibernate.beans.Student;

public class HibernateTest {
	
	//@Test
	public SessionFactory testSessionFactory() {
		//1.加载配置文件
		Configuration cfg = new Configuration();
		cfg.configure();//省略参数，默认文件名称：hibernate.cfg.xml		
		
		//2.创建SessionFactory对象
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder() ;
		srb.applySettings(cfg.getProperties());
		ServiceRegistry serviceRegistry = srb.buildServiceRegistry() ;
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		System.out.println(sessionFactory);
		return sessionFactory;
	}
	
	//保存
	@Test
	public void saveStudent() {
		SessionFactory sessionFactory = testSessionFactory();
		
		//获取Session对象
		Session session  = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			//开启事务
		    tx = session.beginTransaction();
			
		    //
		    Student stu = new Student();
		    stu.setStudentName("Tom");
		    stu.setAge(22);
		    stu.setEmail("tom@sina.com");
		    
		    session.save(stu);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testObjectState() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			//临时状态   没有OID  session缓存中没有  数据库没有
			Student stu = new Student("Jerry", 22, "jerry@sina.com");
			
			//持久化状态
			// 1. session.save(stu);  //stu:  有OID  session缓存有  数据库有
			
			//2. 
			 stu = (Student)session.get(Student.class,3);
			
			//游离状态  托管状态
//			session.clear();  // 清空session缓存
//			session.evict(stu);
//			session.close();
			
			 
			//删除状态
			session.delete(stu);    //stu: oid没有  session中没有  数据库没有
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testSessionCache() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		//Session session1 = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			Student student = (Student)session.get(Student.class, 2);
			System.out.println(student);
			
			//session.clear();
			//session.evict(student);
			//session.close();
			System.out.println("------------------------");
			
			Student stu = (Student)session.get(Student.class,2);
			System.out.println(stu);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//session1.close();
		}	
	}
	
	@Test
	public void testLazy() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			//get: 直接发送sql语句到数据库查询对应的数据.
			//Student student = (Student)session.get(Student.class, 2);
			Student student = (Student)session.load(Student.class, 2);
			//System.out.println(student.getClass().getName());
			System.out.println(student.getStudentId());
			System.out.println("--------------------");
			//session.close();
			
			System.out.println(student.getStudentName());  //发送sql
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			//session.close();
		}	
	}
	
	@Test
	public void testUpdate() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			Student stu = (Student)session.get(Student.class, 2);
			
			stu.setStudentName("RoseAA");
//			stu.setEmail("rose@sina.com");
//			stu.setAge(25);
			
			//session.update(stu);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}	
	}
	
	@Test
	public void testUpdate2() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			Student stu = new Student("Jack", 30, "jack@sina.com");  //临时
			stu.setStudentId(1);
			
			session.update(stu);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}	
	}
	
	@Test
	public void testDelete() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			
			//Student stu = (Student)session.get(Student.class, 2);
			
			//stu.setStudentId(null);
			
			Student stu = new Student();
			stu.setStudentId(2);
			
			session.delete(stu);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}	
	}
	
	@Test
	public void testDoWork() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.doWork(new Work() {
			@Override
			public void execute(Connection conn) throws SQLException {
				// jdbc
				//conn.prepareStatement(sql);
			}
		});
	}
	
	@Test
	public void testHQL() {
		
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			//sql: select * from tbl_student where  student_name like ?  limit ?,?  order by studentName
			String hql = "from Student where studentName like ? order by studentName";
			
			Query query = session.createQuery(hql);
			query.setString(0, "%e%");
			//分页：
			query.setFirstResult(0);
//			
			query.setMaxResults(2);
			
			List<Student> list = query.list();
			for (Student student : list) {
				System.out.println(student);
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}	
		
	
	}
	
}
