package com.gw.utilities;

import org.openqa.selenium.phantomjs.PhantomJSDriverService;

public class ManagerPhantomJS {
	
	private static ManagerPhantomJS instance = new ManagerPhantomJS();

	public static ManagerPhantomJS getInstance() {
		return instance;
	}

	ThreadLocal<PhantomJSDriverService> service = new ThreadLocal<PhantomJSDriverService>();

	public PhantomJSDriverService getPhantomJSDriverService() {
		return service.get();
	}

	public void setPhantomJSDriverService(PhantomJSDriverService phantomJSDriverService) {
		service.set(phantomJSDriverService);
	}
}
