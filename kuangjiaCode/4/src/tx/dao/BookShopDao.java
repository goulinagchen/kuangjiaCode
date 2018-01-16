package tx.dao;

public interface BookShopDao {

	public double findBookPriceByIsbn(String isbn);
	public void updateBookStock(String isbn);
	public void updateUserAccount(String username,double price);
}
