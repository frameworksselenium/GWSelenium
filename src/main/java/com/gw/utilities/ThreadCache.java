
package com.gw.utilities;

import java.util.Properties;

public class ThreadCache {

	private static ThreadCache instance = new ThreadCache();

	public static ThreadCache getInstance() {
		return instance;
	}

	ThreadLocal<Properties> properties = new ThreadLocal<Properties>() {
		@Override
		protected Properties initialValue() {
			return new Properties();
		}
	};

	public String getProperty(String key) {

		return properties.get().getProperty(key);
	}

	public void setProperty(String key, String value) {

		properties.get().setProperty(key, value);
	}

	public void resetProperties() {
		Properties prop = properties.get();
		prop.clear();
		for (String key : prop.stringPropertyNames()) {
			prop.remove(key);
		}
	}
}
