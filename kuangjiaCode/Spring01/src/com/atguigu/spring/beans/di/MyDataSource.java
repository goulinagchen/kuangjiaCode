package com.atguigu.spring.beans.di;

import java.util.Properties;

public class MyDataSource {
	
	private Properties properties ;  // 描述数据库连接信息 driverClass url  username  password

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "MyDataSource [properties=" + properties + "]";
	}
	
	
	
}
