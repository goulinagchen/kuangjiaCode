package com.atguigu.spring.lifecycle;

public class Car {
	private String brand ; 
	private double price ;
	
	public Car() {
		System.out.println("Car 's  Constructor ...");
	}
	
	public void init() {
		System.out.println("Car 's init ...." + this);
	}
	
	public void destroy() {
		System.out.println("Car 's destroy ....");
	}
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		System.out.println("Car 's setBrand....");
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		System.out.println("Car 's setPrice....");
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	} 
	
}
