package hebernate.test;

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

import hebernate.bean.Student;

public class HibernateTest {

	public SessionFactory testSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure();// 省略hibernate.cfg.xml

		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb.applySettings(cfg.getProperties());
		ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	@Test
	public void saveStudent() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = new Student("Jerry", 21, "jerry@sina.com");
			session.save(student);
			Student student2 = (Student) session.get(Student.class, 1);
			System.out.println(student2);

			// student.setStudentAge(22);
			// student.setStudentName("Tom");
			// session.save(student);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testSessionCache() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, 2);
			System.out.println(student);
			// session.clear();
			// session.evict(student);
			// session.close();
			System.out.println("----------------------");
			Student student2 = (Student) session.get(Student.class, 2);
			System.out.println(student2);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testLazy() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			// Student student = (Student) session.get(Student.class, 2);
			// get()直接查询，不能延迟加载

			Student student = (Student) session.load(Student.class, 2);// load()可以延迟加载
			System.out.println(student.getClass().getName());// hebernate.bean.Student_$$_javassist_0
																// 如果Student类为fianl类，则不能生成代理类，也不能使用延迟加载了，直接查询，类也变成java.bean
			// System.out.println(student);
			System.out.println(student.getStudentId());// 2 不查，上面有
			System.out.println("------------------------");
			// session.close(); 注：session关闭后不能再进行查询
			System.out.println(student.getStudentEmail());// 查询
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdate() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, 2);

			student.setStudentAge(20);
			student.setStudentEmail("roserose@sina.com");
			// session.update(student);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testDelete() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Student student = (Student) session.get(Student.class, 1);
			session.delete(student);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testDoWork() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();

		session.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				String sql = null;
				connection.prepareStatement(sql);
			}
		});
	}

	@Test
	public void testHQL() {

		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			String hql = "from Student where name like ? order by name";

			Query query = session.createQuery(hql);
			query.setString(0, "%e%");
			// 分页：
			query.setFirstResult(1);
			query.setMaxResults(9);
			List<Student> list = query.list();
			for (Student student : list) {
				System.out.println(student);
			}

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
}