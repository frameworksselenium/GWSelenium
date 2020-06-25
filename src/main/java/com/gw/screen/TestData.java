package com.gw.screen;

import com.gw.driver.LoggerClass;
import com.gw.utilities.Common;
import com.gw.utilities.CommonManager;
import com.gw.utilities.HTML;
import com.gw.utilities.PCThreadCache;

public class TestData {

	public static String sheetname = "TestData";
	private org.apache.log4j.Logger logger  = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),PCThreadCache.getInstance().getProperty("TCID"));
	Common common = CommonManager.getInstance().getCommon();

	public Boolean SCRTestData() throws Exception {

		Boolean status = true;
		status = common.ClassComponent(sheetname, Common.o);
		if (!status) {
			logger.info("Test Data update was UnSuccessful");
			HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Test Data update should be Successful", "Test Data update was UnSuccessful", "FAIL");
			status = false;
		} else {
			logger.info("Test Data update was Successful");
			HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Test Data update should be Successful", "Test Data update was Successful", "PASS");
			status = true;
		}
		return status;
	}
}