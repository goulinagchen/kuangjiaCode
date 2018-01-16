package tx.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierImp implements Cashier {

	@Autowired
	private BookShopService service;

	@Override
	@Transactional
	public void checkOut(String username, List<String> isbns) {
		for (String isbn : isbns) {
			service.buyBook(username, isbn);
		}
	}

}
