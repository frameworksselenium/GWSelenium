/**
 * @ClassPurpose This Class is to run the phantomdriver
 * @Scriptor Sojan David
 * @ReviewedBy
 * @ModifiedBy 
 * @LastDateModified 3/17/2017
 */

package com.gw.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

public class PhantomJSDriverFactory {

	static Logger log = Logger.getLogger(PhantomJSDriverFactory.class);

	private static PhantomJSDriverFactory instance = new PhantomJSDriverFactory();

	public static PhantomJSDriverFactory getInstance() {
		return instance;
	}

	public PhantomJSDriverService createPhantomJSDriver() {
		String driverPath = HTML.properties.getProperty("driverPath");
		String execution = HTML.properties.getProperty("TypeOfAutomation");
		PhantomJSDriverService service = null;
		if (execution.toUpperCase().equalsIgnoreCase("HEADLESS")) {
			log.info("Webdriver Headless Automation started");
			final String phantomJsFilePath = driverPath + "\\phantomjs.exe";
			service = new PhantomJSDriverService.Builder().usingPhantomJSExecutable(new File(phantomJsFilePath)).usingAnyFreePort().build();
			try {
				service.start();
				log.info("Headless phantomjs service started");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return service;
	}

}
