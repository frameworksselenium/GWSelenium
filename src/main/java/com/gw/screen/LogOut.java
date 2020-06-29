package com.gw.screen;

import com.gw.driver.LoggerClass;
import com.gw.utilities.Common;
import com.gw.utilities.CommonManager;
import com.gw.utilities.ThreadCache;

public class LogOut {

	public static String sheetname = "LogOut";
	Common common = CommonManager.getInstance().getCommon();
	private org.apache.log4j.Logger logger  = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),ThreadCache.getInstance().getProperty("TCID"));

	public Boolean SCRLogOut() throws Exception {

		Boolean status = true;
		status = common.ClassComponent(sheetname, Common.o);
		if (!status) {
			status = false;
		}
		// common.Terminate();
		return status;
	}
}