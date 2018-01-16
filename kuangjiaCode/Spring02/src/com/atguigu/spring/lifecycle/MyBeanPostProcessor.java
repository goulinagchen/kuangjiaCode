package com.atguigu.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//Bean的后置处理器
public class MyBeanPostProcessor  implements BeanPostProcessor{
	
	/**
	 * 在调用init初始化方法之前执行
	 * 
	 * Object bean: 正在创建bean对象
	 * String beanName:bean对象的id值
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization...");
		Car currentCar = (Car)bean;  //如果在实际开发中，需要进行类型的判断再转换.
		currentCar.setPrice(28888);
		return currentCar;
	}
	
	/**
	 * 在调用destroy销毁方法之前执行
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization");
		Car car = new Car();
		car.setBrand("Audi");
		car.setPrice(400000);
		return car;
	}


}
