package tx.xml.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CashierImp implements Cashier {

	@Autowired
	private BookShopService service;

	@Override
	public void checkOut(String username, List<String> isbns) {
		for (String isbn : isbns) {
			service.buyBook(username, isbn);
		}
	}

}
