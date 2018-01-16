package factory;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Car>{

	@Override
	public Car getObject() throws Exception {
		
		return new Car("Ford",350000);
	}

	@Override
	public Class<?> getObjectType() {
		
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		
		return true;
	}
 
}
