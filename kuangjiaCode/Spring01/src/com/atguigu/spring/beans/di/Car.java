package com.atguigu.spring.beans.di;

public class Car {
	
	private String brand ;
	private String crop ;
	private double price ;
	
	private int maxSpeed;
	
	public Car() {
		System.out.println("Car 's no param Constructor .....");
	}
	
	
	
	public Car(String brand, String crop, double price) {
		System.out.println("Car's Constructor  has param.....");
		this.brand = brand;
		this.crop = crop;
		this.price = price;
	}
	
	

	
	public Car(String brand, String crop, int maxSpeed) {
		super();
		this.brand = brand;
		this.crop = crop;
		this.maxSpeed = maxSpeed;
	}



	public int getMaxSpeed() {
		return maxSpeed;
	}



	public void setMaxSpeed(int maxSpeed) {
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



	@Override
	public String toString() {
		return "Car [brand=" + brand + ", crop=" + crop + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}
	
}
