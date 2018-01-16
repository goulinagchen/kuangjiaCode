package factory;

import java.util.Map;
import java.util.HashMap;

/**
 * 实例工厂
 * 
 * @author gouli
 *
 */
public class InstanceCarFactory {

	private Map<String, Car> cars = null;

	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("audi", new Car("audi", 400000));
		cars.put("bmw", new Car("bmw", 400000));
	}

	public Car getCar(String name) {
		System.out.println("invoke InstanceCarFactory.getCar...");
		return cars.get(name);
	}
}
