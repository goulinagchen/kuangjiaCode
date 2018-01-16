package com.atguigu.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂
 */
public class InstanceCarFactory {
	
	private Map<String,Car> cars = null ;
	
	public InstanceCarFactory() {
		cars = new HashMap<String,Car>();
		cars.put("audi", new Car("Audi",400000));
		cars.put("bmw", new Car("bmw",500000));
	}
	
	//实例工厂方法
	public Car getCar(String name ) {
		System.out.println("invoke InstanceCarFactory getCar ....");
		return cars.get(name);
	}
}
