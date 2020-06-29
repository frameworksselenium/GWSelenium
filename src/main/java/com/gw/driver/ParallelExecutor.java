package com.gw.driver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.gw.constants.PCConstants;
import com.gw.utilities.Common;
import com.gw.utilities.CommonManager;
import com.gw.utilities.HTML;
import com.gw.utilities.LocalDriverFactory;
import com.gw.utilities.ManagerDriver;
import com.gw.utilities.RemoteDriverFactory;
//import com.gw.utilities.ThreadCache;
//import com.gw.utilities.ThreadCacheManager;

public class ParallelExecutor implements Runnable {

	private String strRunMode = null;
	private String strTestCaseName = null;
	private String workbook = null;
	private String region = null;
	private org.apache.log4j.Logger log;

	public ParallelExecutor(String strRunMode, String strTestCaseName, String workbook, String region) {
		this.strRunMode = strRunMode;
		this.strTestCaseName = strTestCaseName;
		this.workbook = workbook;
		this.region = region;
	}

	//@Override
	public void run() {
		List<String> acList = new ArrayList<String>();
		File f= new File("C:/Selenium/WorkSpace/GWSelenium/Reports/Log/" + strTestCaseName+".log");
		if(f.exists()){
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),strTestCaseName);

		//below code commented for to stop e2e
		boolean isTestCasePass = false;
		WebDriver driver = null;
		String execMode = HTML.properties.getProperty("EXECUTIONMODE");
		if (execMode.equalsIgnoreCase(PCConstants.executionModeLocal)) {
			driver = LocalDriverFactory.getInstance().createNewDriver();
		} else {
			driver = RemoteDriverFactory.getInstance().createNewDriver();
		}
		Common common = new Common();
		CommonManager.getInstance().setCommon(common);
		ManagerDriver.getInstance().setWebDriver(driver);
		
		//ThreadCacheManager tm = new ThreadCacheManager();
        //ThreadCache.getInstance().setThreadCacheManager(tm);
		try {
			isTestCasePass = common.RunTest("RunModeNo", strTestCaseName, workbook, region);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error while executing test case = " + strTestCaseName, e);
		}
		common = null; // Mark for garbage collection
	}
}
