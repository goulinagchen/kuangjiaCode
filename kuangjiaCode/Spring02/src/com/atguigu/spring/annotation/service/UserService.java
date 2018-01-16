package com.atguigu.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.spring.annotation.dao.UserDao;

@Service
public class UserService {
	/**
	 * @Autowired 会优先是有byType的方式去匹配兼容的组件来进行注入.
	 *            如果匹配到多个兼容的组件，则尝试根据byName的方式进行匹配,
	 *            匹配成功则注入，匹配失败则抛出异常.
	 * 
	 * required=true/false:默认情况下，@Autowired标注的属性必须被注入值.           
	 */
	@Autowired(required=true)
	@Qualifier("userDaoJdbcImpl")  //具体指定要求注入的组件的id值.
	private UserDao userDao ; 
	
	public void  addUser() {
		System.out.println("UserService addUser()....");
		userDao.addUser();
	}
}
