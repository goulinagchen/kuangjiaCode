package bean;

import java.util.Map;

public class PersonMap {

	private String name;
	private Integer age;
	private Map<String, Car> cars;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Map<String, Car> getCars() {
		return cars;
	}
	public void setCars(Map<String, Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "PersonMap [name=" + name + ", age=" + age + ", cars=" + cars + "]";
	}
	
}
