package com.atguigu.springmvc.beans;

public class Address {
	private String province ; //省份
	private String city ;  //城市
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + "]";
	}
	
	
}
