package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tx.dao.BookShopDao;
import tx.service.BookShopService;

public class TxTest {

	ApplicationContext context = null;
	BookShopService service = null;
	BookShopDao dao = null;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("tx.xml");
		service = (BookShopService) context.getBean("bookShopServiceImp");
		dao = (BookShopDao) context.getBean("bookShopDaoImp");
	}

	@Test
	public void testBookShopDaoFindBookPriceByIsbn() {
		double price = dao.findBookPriceByIsbn("1001");
		System.out.println(price);
	}

	@Test
	public void testBookShopDaoUpdateBookStock() {
		dao.updateBookStock("1001");
	}

	@Test
	public void testBookShopDaoUpdateUserAccount() {
		dao.updateUserAccount("Tom", 50);
	}

	@Test
	public void testBookShopServiceBuyBook() {
		service.buyBook("Tom", "1001");
	}
}
