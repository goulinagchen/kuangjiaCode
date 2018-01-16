package tx.service;

import org.springframework.beans.factory.annotation.Autowired;

import tx.dao.BookShopDao;

public class BookShopServiceImp implements BookShopService{

	@Autowired
	public BookShopDao dao;
	
	@Override
	public void buyBook(String username, String isbn) {
		double price = dao.findBookPriceByIsbn(isbn);
		dao.updateBookStock(isbn);
		dao.updateUserAccount(username, price);
	}

}
