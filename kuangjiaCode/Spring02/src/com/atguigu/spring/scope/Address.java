package com.atguigu.spring.scope;

public class Address {
	private String city ;
	private String street ;
	
	public Address() {
		System.out.println("Address 's no param Contructor ....");
	}
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	} 
		
}


