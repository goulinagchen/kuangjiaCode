package tx.xml.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tx.xml.dao.BookShopDao;
import tx.xml.service.BookShopService;
import tx.xml.service.Cashier;

public class TxTest {

	ApplicationContext context = null;
	BookShopService service = null;
	BookShopDao dao = null;
	Cashier cashier = null;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("tx-xml.xml");
		service = (BookShopService) context.getBean("bookShopServiceImp");
		dao = (BookShopDao) context.getBean("bookShopDaoImp");
		cashier = (Cashier) context.getBean("cashierImp");
	}

	@Test
	public void testBookShopDaoFindBookPriceByIsbn() {
		double price = dao.findBookPriceByIsbn("1003");
		System.out.println(price);
	}

	@Test
	public void testBookShopDaoUpdateBookStock() {
		dao.updateBookStock("1002");
	}

	@Test
	public void testBookShopServiceUserAccount() {
		dao.updateUserAccount("Tom", 20);
	}

	@Test
	public void testBookShopServiceBuyBook() {
		service.buyBook("Tom", "1002");
	}

	@Test
	public void testCashierCheckOut() {
		List<String> isbns = new ArrayList<String>();
		isbns.add("1002");
		isbns.add("1003");
		cashier.checkOut("Tom", isbns);
	}
}
