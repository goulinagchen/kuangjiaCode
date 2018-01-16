package com.atguigu.spring.tx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.tx.dao.BookShopDao;
import com.atguigu.spring.tx.service.BookShopService;
import com.atguigu.spring.tx.service.Cashier;

public class TestSpringTransaction {

	ApplicationContext ctx = null ;
	BookShopService bookShopService = null ;
	BookShopDao bookShopDao = null ;
	Cashier cashier = null ;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("tx.xml");
		bookShopService = (BookShopService)ctx.getBean("bookShopServiceImpl");
		bookShopDao  = (BookShopDao) ctx.getBean("bookShopDaoImpl");
		cashier = (Cashier)ctx.getBean("cashierImpl");
		//System.out.println(cashier.getClass().getName());
	}
	
	@Test
	public void testBookShopDaoFindBookPriceByIsbn() {
		int price = bookShopDao.findBookPriceByIsbn("1001");
		System.out.println(price );
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testBookShopDaoUpdateUserAccount() {
		bookShopDao.updateUserAccount("Tom", 50);
	}
	
	@Test
	public void testBookShopServiceBuyBook() {
		bookShopService.buyBook("Tom", "1001");
	}
	
	
	@Test
	public void testCashierCheckOut() {
		List<String> isbns = new ArrayList<String>();
		isbns.add("1001");
		isbns.add("1002");
		cashier.checkOut("Tom", isbns);
	}
}
