package com.gw.screen;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.gw.constants.PCConstants;
import com.gw.driver.LoggerClass;
import com.gw.utilities.Common;
import com.gw.utilities.CommonManager;
import com.gw.utilities.HTML;
import com.gw.utilities.PCThreadCache;

public class Login {

	public static String sheetname = "Login";
	private static org.apache.log4j.Logger loggers;
	private org.apache.log4j.Logger logger  = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),PCThreadCache.getInstance().getProperty("TCID"));
	Common common = CommonManager.getInstance().getCommon();

	public Boolean SCRLogin() throws Exception {
		Boolean s = common.OpenApp();
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		String date = dateFormat.format(d);
		if (!s) {
			logger.info("Thread ID = " + Thread.currentThread().getId() + "Application not Loggedin Successfully");
			HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Application should login successfully", "Application not loggedin successfully", "PASS");
			return false;
		}
		Boolean status = true;
		if (HTML.properties.getProperty("TestCaseScreenShot").contains("YES")) {
			File dir = new File(HTML.properties.getProperty("ResultsFolderPath") + "\\" + PCThreadCache.getInstance().getProperty("testcasename") + "_" + date + "_" + d.getHours() + d.getMinutes() + d.getSeconds() + Thread.currentThread().getId());
			PCThreadCache.getInstance().setProperty(PCConstants.ZipFolderPath, HTML.properties.getProperty("ResultsFolderPath") + "\\" + PCThreadCache.getInstance().getProperty("testcasename") + "_" + date + "_" + d.getHours() + d.getMinutes() + d.getSeconds() + Thread.currentThread().getId());
			if (!dir.exists()) {
				dir.mkdir();
			}
		}
		if (HTML.properties.getProperty("EXECUTIONAPP").contains("ODS")) {
			status = common.CSVFile();
		}
		status = common.ClassComponent(sheetname, Common.o);
		if (!status) {
			return status;
		}
		if (common.WaitUntilClickable(Common.o.getObject("eleDeskTopAction"), Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT")))) {
			logger.info("Thread ID = " + Thread.currentThread().getId() + " Application Loggedin Successfully");
			HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Application should login successfully", "Application loggedin successfully", "PASS");
			//status = SCRCommon.funGetUserLoggedName();
			status = true;
		} else {
			logger.info("Thread ID = " + Thread.currentThread().getId() + " Application not Loggedin Successfully");
			HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Application should login successfully", "Application not loggedin successfully", "FAIL");
			status = false;
		}
		return status;
	}

	public boolean SelectActivity(String sFuncValue) throws Exception {
		boolean status = false;
		String[] sValue = sFuncValue.split(":::");
		status = common.ActionOnTable(Common.o.getObject("eleActivityTable"), 2, 2, sValue[1], sValue[1], "a");
		return status;
	}

}