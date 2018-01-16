package com.atguigu.spring.factory;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean  implements FactoryBean<Car>{
	/**
	 * 具体返回的对象
	 */
	@Override
	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Car("Ford",350000);
	}
	/**
	 * 对象的类型
	 */
	@Override
	public Class<?> getObjectType() {
	
		return Car.class;
	}
	/**
	 *是否是单例
	 */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
