package bean;

import java.util.Properties;

public class MyDataSource {

	private Properties properties;

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
