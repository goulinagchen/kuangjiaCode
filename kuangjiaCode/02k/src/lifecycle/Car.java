package lifecycle;

public class Car {

	private String brand;
	private double price;

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("car's setBrand...");
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("car's setPrice...");
		this.price = price;
	}

	public Car(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	}

	public Car() {
		System.out.println("car's constructor...");
	}

	public void init() {
		System.out.println("car's init..." + this);
	}

	public void destroy() {
		System.out.println("car's destroy...");
	}

}
