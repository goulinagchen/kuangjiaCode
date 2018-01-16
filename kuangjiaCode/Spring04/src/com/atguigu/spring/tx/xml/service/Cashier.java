package com.atguigu.spring.tx.xml.service;

import java.util.List;

public interface Cashier {
	/**
	 * 用户的结账行为  模拟一次性买多本书
	 */
	public void checkOut(String username, List<String> isbns);
}
