package com.gw.screen;

import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.gw.constants.PCConstants;
import com.gw.driver.LoggerClass;
import com.gw.utilities.Common;
import com.gw.utilities.CommonManager;
import com.gw.utilities.FlatFile;
import com.gw.utilities.HTML;
import com.gw.utilities.PCThreadCache;
import com.gw.utilities.XlsxReader;

public class CreateAccount {

	public static String sheetname = "CreateAccount";
	private org.apache.log4j.Logger logger  = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),PCThreadCache.getInstance().getProperty("TCID"));
	public String accountNumber;
	public String accountName;
	private XSSFWorkbook workbook;
	Common common = CommonManager.getInstance().getCommon();

	public Boolean SCRCreateAccount() throws Exception {
		logger.info("It is in createaccount::");
		Boolean status = true;
		status = common.ClassComponent(sheetname, Common.o);
		if (!status) {
			status = false;
		}
		return status;
	}

	public Boolean UpdateAccountNumber() throws Exception {
		HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
		HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
		try {
			Boolean status = true;
			if (common.WaitUntilClickable(Common.o.getObject("eleCreateNewAccountNumber"), Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT")))) {
				XlsxReader sXL = XlsxReader.getInstance();
				accountNumber = common.ReadElement(Common.o.getObject("eleCreateNewAccountNumber"), 30);
				PCThreadCache.getInstance().setProperty(PCConstants.CACHE_ACCOUNT_NUMBER, accountNumber);
				PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
				PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
				logger.info("System displayed Account Summary Page with Account Number: " + accountNumber);
				HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display Account Summary Page with Account Number", "System displayed Account Summary Page with Account Number: '" + accountNumber + "'", "PASS");
				if (HTML.properties.getProperty("EXECUTIONAPP").contains("ODS")) {
					FlatFile sReadWrite = FlatFile.getInstance();
					SCRCommon scrCommon = new SCRCommon();
					String FlatFileName =  PCThreadCache.getInstance().getProperty("FlatFileName");
					status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), "AccountNumber", accountNumber, "OUTPUT", FlatFileName);
				}
				status = true;
			} else {
				logger.info("System not displayed Account Summary Page");
				HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display Account Summary Page with Account Number", "System not displayed Account Summary Page","FAIL");
				status = false;
			}
			return status;
		} finally {
			updateColumnNameValues = null;
			whereConstraint = null;
		}
	}

	public boolean update() {
		boolean status = false;
		int sElementSize = common.ElementSize(Common.o.getObject("eleUpdate"));
		if (sElementSize == 1) {
			try {
				status = common.SafeAction(Common.o.getObject("eleUpdate"), "eleUpdate", "eleUpdate");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				status = common.SafeAction(Common.o.getObject("eleOverRide"), "eleOverRide", "eleOverRide");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}
}