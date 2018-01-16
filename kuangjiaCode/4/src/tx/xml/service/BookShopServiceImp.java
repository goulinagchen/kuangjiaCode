package tx.xml.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tx.xml.dao.BookShopDao;

@Service
public class BookShopServiceImp implements BookShopService {

	@Autowired
	private BookShopDao dao;

	@Override
	public void buyBook(String username, String isbn) {
		double price = dao.findBookPriceByIsbn(isbn);
		dao.updateBookStock(isbn);
		dao.updateUserAccount(username, price);
	}

}
