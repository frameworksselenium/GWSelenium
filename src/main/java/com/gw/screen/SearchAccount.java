package com.gw.screen;

import com.gw.driver.LoggerClass;
import com.gw.utilities.Common;
import com.gw.utilities.CommonManager;
import com.gw.utilities.PCThreadCache;

public class SearchAccount {

	public static String sheetname = "SearchAccount";
	Common common = CommonManager.getInstance().getCommon();
	private org.apache.log4j.Logger logger  = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),PCThreadCache.getInstance().getProperty("TCID"));

	public Boolean SCRSearchAccount() throws Exception {
		Boolean status = true;
		status = common.ClassComponent(sheetname, Common.o);
		if (!status) {
			return false;
		}
		return status;
	}

}
