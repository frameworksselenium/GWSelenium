package com.gw.utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gw.constants.PCConstants;
import com.gw.driver.LoggerClass;

public class LocalDriverFactory {

	//static Logger log = Logger.getLogger(LocalDriverFactory.class);
	private static org.apache.log4j.Logger loggers;
	//private org.apache.log4j.Logger log  = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),ThreadCache.getInstance().getProperty("TCID"));

	private static LocalDriverFactory instance = new LocalDriverFactory();

	public static LocalDriverFactory getInstance() {
		//System.out.println("gng to return:::");
		//System.out.println("instance is:::");
		return instance;
	}

	public WebDriver createNewDriver() {
		WebDriver driver = null;
		File directory = new File(".");
		String driverPath = null;
		try {
			driverPath = directory.getCanonicalPath() + "\\src\\main\\resources\\drivers";
		} catch (IOException e) {
			e.printStackTrace();
		}
		//String driverPath = HTML.properties.getProperty("driverPath");
		String execution = HTML.properties.getProperty("TypeOfAutomation");
		String browser = HTML.properties.getProperty("Browser");
		DesiredCapabilities cap = null;
		if (execution.toUpperCase().equalsIgnoreCase("HEADLESS")) {
			//log.info("Webdriver Headless Automation started");
			/*
			 * final String phantomJsFilePath = driverPath + "\\phantomjs.exe"; service =
			 * new PhantomJSDriverService.Builder().usingPhantomJSExecutable(new
			 * File(phantomJsFilePath)).usingAnyFreePort() .build(); try { service.start();
			 * } catch (IOException e1) { e1.printStackTrace(); }
			 * log.info("Headless phantomjs service started");
			 */
			if (browser.toUpperCase().contains("CH")) {
				cap = DesiredCapabilities.chrome();
			}
			if (browser.toUpperCase().contains("FF")) {
				cap = DesiredCapabilities.firefox();
			}
			if (browser.toUpperCase().contains("IE")) {
				cap = DesiredCapabilities.internetExplorer();
			}
			//try {
				//driver = new RemoteWebDriver(new URL(ManagerPhantomJS.getInstance().getPhantomJSDriverService().getUrl().toString()), cap);
			//} catch (MalformedURLException e) {
			//	e.printStackTrace();
			//}
			//log.info("Headless '" + browser.toUpperCase() + "' DesiredCapabilities initiated");
			//log.info("Headless '" + browser.toUpperCase() + "' driver started");
		}
		if (execution.toUpperCase().equalsIgnoreCase("HEAD")) {
			//log.info("Webdriver with Head Automation started");
			if (browser.toUpperCase().contains("CH")) {
				System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("useAutomationExtension", false);
				options.addArguments("no-sandbox");
				options.addArguments("start-maximized");
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				// HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				if (HTML.properties.getProperty("Forms").equalsIgnoreCase("YES") || HTML.properties.getProperty("XmlLogFileDownload").equalsIgnoreCase("YES")) {
					createFormDirectory();
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					chromePrefs.put("download.default_directory", ThreadCache.getInstance().getProperty(PCConstants.FormsFolderPath));
					options.setExperimentalOption("prefs", chromePrefs);
				}

				driver = new ChromeDriver(options);
			}
			if (browser.toUpperCase().contains("FF")) {
				driver = new FirefoxDriver();
				//log.info("firefox  DesiredCapabilities initiated");
			}
			if (browser.toUpperCase().contains("IE")) {
				System.setProperty("webdriver.ie.driver", driverPath + "\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			//log.info("'" + browser.toUpperCase() + "' driver started");

		}
		return driver;
	}

	public static Boolean createFormDirectory() {
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		String date = dateFormat.format(d);
		String dirAddress = HTML.properties.getProperty("FormsDownloadPath") + "\\" + date + "_" + d.getHours() + d.getMinutes() + d.getSeconds() + Thread.currentThread().getId();
		ThreadCache.getInstance().setProperty(PCConstants.FormsFolderPath, dirAddress);
		File dir = new File(dirAddress);
		if (!dir.exists()) {
			dir.mkdir();
		}
		return true;
	}
}
