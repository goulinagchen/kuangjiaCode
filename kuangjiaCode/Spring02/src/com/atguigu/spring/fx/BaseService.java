package com.atguigu.spring.fx;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	@Autowired
	private BaseRepository<T> baseRepository;
	
	public void suibian() {
		System.out.println(baseRepository);
	}
}
