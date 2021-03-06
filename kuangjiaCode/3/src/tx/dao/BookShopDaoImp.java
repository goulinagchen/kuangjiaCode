package tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tx.exception.BookStockException;
import tx.exception.UserAccountExecption;

@Repository
public class BookShopDaoImp implements BookShopDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public double findBookPriceByIsbn(String isbn) {
		String sql = "select price from where isbn = ?";
		return jdbcTemplate.queryForObject(sql, Double.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		String sql = "select stock from book_stock where isbn = ?";
		Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		if (stock<=0) {
			throw new BookStockException("库存不足。。。");
		}
		sql = "update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql,isbn);
	}

	@Override
	public void updateUserAccount(String username, double price) {
		String sql = "select balance from account where username = ?";
		Double balance = jdbcTemplate.queryForObject(sql, Double.class, username);
		if (balance<price) {
			throw new UserAccountExecption("余额不足。。。");
		}
		sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price,username);
	}

	
}
