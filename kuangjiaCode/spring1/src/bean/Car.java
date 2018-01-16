package bean;

public class Car {

	private String brand;
	private String crop;
	private double price;
	private int maxSpeed;
	public Car() {
		System.out.println("Car's no param Constructor....");
	}
	public Car(String brand, String crop, double price, int maxSpeed) {
		System.out.println("Car's Constructor has param....");
		this.brand = brand;
		this.crop = crop;
		this.price = price;
		this.maxSpeed = maxSpeed;
	}
	
	public Car(String brand, String crop, double price) {
		System.out.println("Car's Constructor has param....no maxSpeed");
		this.brand = brand;
		this.crop = crop;
		this.price = price;
	}
	public Car(String brand, String crop, int maxSpeed) {
		System.out.println("Car's Constructor has param....no price");
		this.brand = brand;
		this.crop = crop;
		this.maxSpeed = maxSpeed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		System.out.println("setBrand invoke....");
		this.brand = brand;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		System.out.println("setCrop invoke....");
		this.crop = crop;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		System.out.println("setPrice invoke....");
		this.price = price;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", crop=" + crop + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}
	
}
