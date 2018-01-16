package factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂
 * 
 * @author gouli
 *
 */
public class StaticCarFactory {

	private static Map<String, Car> cars = new HashMap<>();

	static {
		cars.put("audi", new Car("audi", 400000));
		cars.put("bmw", new Car("bmw", 400000));
	}

	// 静态方法
	public static Car getCar(String name) {
		System.out.println("invoke StaticCarFactory.getCar...");
		return cars.get(name);
	}

}
