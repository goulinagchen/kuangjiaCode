package com.atguigu.spring.tx.xml.dao;

public interface BookShopDao {
	
	//1.根据书号获取对应的价格
	public int findBookPriceByIsbn(String isbn);
	
	//2.根据书号更新库存   库存-1
	public void updateBookStock(String isbn);
	
	//3.根据书的价格更新用户的余额
	public void updateUserAccount(String username,int price);
}
