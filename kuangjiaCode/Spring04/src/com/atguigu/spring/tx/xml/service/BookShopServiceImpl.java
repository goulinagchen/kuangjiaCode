package com.atguigu.spring.tx.xml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.spring.tx.xml.dao.BookShopDao;

@Service
//@Transactional
public class BookShopServiceImpl  implements BookShopService{
	
	@Autowired
	private BookShopDao bookShopDao;
	
	
	public void buyBook(String username, String isbn) {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//1.根据书号查书的价格
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户的余额
		bookShopDao.updateUserAccount(username, price);
	} 
	
}
