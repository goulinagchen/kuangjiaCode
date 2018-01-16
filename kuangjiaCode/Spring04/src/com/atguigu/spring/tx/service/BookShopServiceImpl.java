package com.atguigu.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.spring.tx.dao.BookShopDao;
import com.atguigu.spring.tx.exception.UserAccountException;

@Service
//@Transactional
public class BookShopServiceImpl  implements BookShopService{
	@Autowired
	private BookShopDao bookShopDao;
	
	/**
	 * propagation:事务的传播行为.  
	 *             即当前的事务方法被另外一个事务方法调用时,当前的事务方法如何使用事务.
	 *             REQUIRED：使用调用者的事务   默认值.  
	 * 			   REQUIRES_NEW：将调用者的事务挂起,使用自己的事务.
	 * isolation:事务的隔离级别.  最常用的取值为READ_COMMITTED 读已提交.
	 * 
	 * rollbackFor
	 * rollbackForClassName
	 * noRollbackFor
	 * noRollbackForClassName
	 * Spring默认情况下对所有的运行时异常进行回滚.
	 * 
	 * readOnly:只读.  指定事务是否为只读事务.
	 *          如果是只读事务,表达这个事务只读取数据而不进行修改.
	 *          若一个事务真的只读取数据，就有必要设置readOnly=true,
	 *          可以帮助数据库引擎优化事务.
	 * timeout:设置超时时间.
	 * 		      指定强制回滚之前事务可以占用的时间.
	 *         避免一个事务对连接占用过长的时间.
	 * 
	 */
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,
					isolation=Isolation.READ_COMMITTED,
					noRollbackFor= {UserAccountException.class},
					readOnly=false,
					timeout=3)
	public void buyBook(String username, String isbn) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1.根据书号查书的价格
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户的余额
		bookShopDao.updateUserAccount(username, price);
	} 
	
}
