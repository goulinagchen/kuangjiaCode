package tx.service;

import tx.dao.BookShopDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopServiceImp implements BookShopService {

	@Autowired
	private BookShopDao dao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false, timeout = 3)
	@Override
	public void buyBook(String username, String isbn) {
		double price = dao.findBookPriceByIsbn(isbn);
		dao.updateBookStock(isbn);
		dao.updateUserAccount(username, price);
	}

}
