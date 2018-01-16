package hibernate.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.xml.soap.Text;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {

	// @Test
	public SessionFactory testSessionFactory() {

		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
		SessionFactory buildSessionFactory = configuration.buildSessionFactory(serviceRegistry);
		System.out.println(buildSessionFactory);
		return buildSessionFactory;
	}

	@Test
	public void testStudent() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Student student = new Student();
			student.setName("Orwen");
			student.setAge(19);
			student.setEmail("ow@sina.com");
			session.save(student);

			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testObjectState() {
		SessionFactory sessionFactory = testSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();

			Student student = new Student("Orwen", 19, "ow@sina.com");// 临时状态
																		// 没有oid
																		// session缓存没有
																		// 数据库没有
			session.save(student);// 持久化状态 有oid session缓存有 数据库有
			Student student2 = (Student) session.get(Student.class, 5);// 持久化状态
			// 游离状态 托管状态（下面三种）
			session.clear();// 清空session缓存
			session.evict(student);// 清空key为student的session缓存
			session.close();// 关闭session，不能再使用session查询等操作

			session.delete(student2);// 删除状态 oid没有 session中没有 数据库没有

			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testSessionCache() {
		Session session = testSessionFactory().openSession();
		Transaction tc = null;
		try {
			tc = session.beginTransaction();
			Student student = (Student) session.get(Student.class, 7);
			System.out.println(student);

			// session.clear();
			session.evict(student);
			// session.close();
			System.out.println("-----------------------");

			Student student2 = (Student) session.get(Student.class, 7);
			System.out.println(student2);
			System.out.println(student == student2);

			tc.commit();
		} catch (Exception e) {
			tc.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testLazy() {
		Session session = testSessionFactory().openSession();
		Transaction ts = null;

		try {
			Student student = (Student) session.load(Student.class, 2);
			System.out.println(student.getClass().getName());
			System.out.println(student.getId());
			System.out.println("----------------------------");
			System.out.println(student.getName());
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdate() {
		Session session = testSessionFactory().openSession();
		Transaction ts = null;

		try {
			ts = session.beginTransaction();
			Student student = (Student) session.get(Student.class, 4);
			System.out.println(student);
			student.setEmail("roseu@sina.com");
			session.update(student);

			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testUpdate2() {
		Session session = testSessionFactory().openSession();
		Transaction ts = null;

		try {
			ts = session.beginTransaction();
			Student student = new Student("Jack", 27, "jack@sina.com");
			student.setId(2);
			System.out.println(student);
			session.update(student);

			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testDelete() {
		Session session = testSessionFactory().openSession();
		Transaction ts = null;

		try {
			ts = session.beginTransaction();
			Student student = (Student) session.get(Student.class, 4);
			System.out.println(student);
			student.setId(null);
			System.out.println(student);

			session.delete(student);

			ts.commit();
		} catch (Exception e) {
			System.out.println("-----------------");
			ts.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testDoWork() {
		Session session = testSessionFactory().openSession();
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
		Session session = testSessionFactory().openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			String sql = "from Student where name like ? order by name";
			Query query = session.createQuery(sql);
			query.setString(0, "%e%");
			query.setFirstResult(0);
			query.setMaxResults(6);
			List<Student> list = query.list();
			for (Student student : list) {
				System.out.println(student);
			}

			ts.commit();
		} catch (Exception e) {
			ts.rollback();
		} finally {
			session.close();
		}
	}
}
