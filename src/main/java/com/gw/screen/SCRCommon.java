package com.gw.screen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.InputSource;
import com.gw.constants.PCConstants;
import com.gw.driver.LoggerClass;
import com.gw.utilities.Common;
import com.gw.utilities.CommonManager;
import com.gw.utilities.FlatFile;
import com.gw.utilities.HTML;
import com.gw.utilities.IconReader;
import com.gw.utilities.ManagerDriver;
import com.gw.utilities.PCThreadCache;
import com.gw.utilities.XlsxReader;
import org.w3c.dom.Document;

public class SCRCommon {

    public static String sheetname = "SCRCommon";
    private static org.apache.log4j.Logger logger;
    private org.apache.log4j.Logger loggers = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
    public WebDriver driver = ManagerDriver.getInstance().getWebDriver();
    Common common = CommonManager.getInstance().getCommon();
    public static FlatFile E2EWrite;

    // public static String Path;

    public boolean Wait() throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        boolean status = common.WaitForElementExist(Common.o.getObject("eleAddSuccessMsg"), 20);
        return status;
    }

    public boolean CheckPopUpAlert() throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        boolean status = false;
        boolean popUpExist = common.ElementSize(Common.o.getObject("eleAlertPopUp")) != 0;
        if (popUpExist == true) {
            common.SafeAction(Common.o.getObject("eleAlertPopUp"), "eleAlertPopUp", "ele");
            status = true;
        }
        return status;
    }

    public static Boolean VerifyDropDownFalse(String eleObjID, String expValues) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));

        // TODO Auto-generated method stub
        boolean status = false;
        boolean blnMatchFound = false;
        String[] sActListValue = null;
        String[] sExpListValue = expValues.split("##");
        status = CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID), "ele", "eleDropdown");
        CommonManager.getInstance().getCommon().WaitForPageToBeReady();
        ManagerDriver.getInstance().getWebDriver().findElement(By.id(eleObjID)).sendKeys(Keys.ARROW_DOWN);
        CommonManager.getInstance().getCommon().WaitForPageToBeReady();
        List<WebElement> gwListBox = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("LI"));

        for (int j = 0; j < sExpListValue.length; j++) {
            for (int k = 0; k < gwListBox.size(); k++) {
                if (sExpListValue[j].equals(gwListBox.get(k).getText())) {
                    logger.info("Expected UI dropdown value - " + sExpListValue[j] + " is available in List");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are available in UI List", "Expected Dropdown Value - " + sExpListValue[j] + " available in UI list", "FAIL");
                    blnMatchFound = true;
                    break;
                }
            }
            status = CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID), "ele", "eleDropdown");
            if (!blnMatchFound) {
                logger.info("Expected UI dropdown value - " + sExpListValue[j] + " is not available in List");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are not available in UI List", "Expected Dropdown Value - " + sExpListValue[j] + " not available in UI list", "PASS");
                status = CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID), "ele", "eleDropdown");
            }
        }
        return !blnMatchFound;

    }

    public static boolean DataWebTable(By id, int sRow, int sCol, String strReadString, String ActionClick, String sTagName) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        boolean SearchString = false;
        boolean Status = false;
        Actions objActions = new Actions(ManagerDriver.getInstance().getWebDriver());
        WebElement mytable = common.returnObject(id);
        List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
        sRow--;
        List<WebElement> Columns_row = rows_table.get(sRow).findElements(By.tagName("td"));
        String celtext = Columns_row.get(sCol).getText();
        if (celtext.contains(strReadString)) {
            SearchString = true;
            List<WebElement> CellElements = Columns_row.get(sCol).findElements(By.tagName(sTagName));
            for (WebElement element : CellElements) {
                switch (ActionClick) {
                    case "single":
                        element.click();
                        Status = true;
                        break;
                    case "double":
                        objActions.doubleClick(element).build().perform();
                        Status = true;
                        break;
                }
                break;
            }
        }
        if (SearchString) {
            logger.info("Search String available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and search string is  '" + strReadString + "'", "PASS");
        } else {
            logger.info("Search String not available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System not searched string in table and search string is  '" + strReadString + "'", "FAIL");
            Status = false;
        }
        return Status;
    }

    public boolean TestDataFill(String sValue) throws Exception {
        System.out.println("SCRCommon.testDataFill log start = " + Runtime.getRuntime().totalMemory());
        CommonManager.getInstance().getCommon();
        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        String accountNumber = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_ACCOUNT_NUMBER);
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        String policyNumber = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_NUMBER);
        String policyNumberSearch = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_NUMBER_SEARCH);
        String submissionNumber = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_SUBMISSION_NUMBER);
        String PolicyeffDate = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_EFF_DATE);
        String PolicyexpDate = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_EXP_DATE);
        String strTCID = PCThreadCache.getInstance().getProperty("TCID");
        System.out.println(Runtime.getRuntime().freeMemory());
        boolean status = false;
        String[] sfunValue = sValue.split(":::");
        // int funValueSize = sfunValue.length;
        XlsxReader sXL = XlsxReader.getInstance();
        // int rowcount = sXL.getRowCount(sfunValue[1]);
        int rowcount = sXL.getRowCount(sfunValue[0]);
        for (int i = 1; i <= rowcount; i++) {
            // String value = sXL.getCellData(sfunValue[1], 0, i);
            String value = sXL.getCellData(sfunValue[0], 0, i);
            // String sheetName = sXL.getCellData("TestData", 1, i);
            if (!value.isEmpty()) {
                // if(PCThreadCache.getInstance().getProperty("TCID").equals(value))
                if (strTCID.equals(value)) {
                    switch (sfunValue[1].toUpperCase()) {
                        case "ACCOUNTNUMBER":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            status = true;
                            break;
                        case "POLICYNUMBER":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            status = true;
                            break;
                        case "SUBMISSIONNUMBER":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.SubmissionNumber, submissionNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("SubmissionNumber", submissionNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set SubmissionNumber =
                            // '"+Payment.SubmissionNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            status = true;
                            break;
                        case "POLICYNUMBERONLY":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            status = true;
                            break;
                        case "CLAPOLICYNUMBERONLY":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.CLAPolicyNumber, policyNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("CLAPolicyNumber", policyNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set CLAPolicyNumber = '"+Payment.PolicyNumber+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            status = true;
                            break;
                        case "ACCOUNTCLAPOLICYNUMBER":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.CLAPolicyNumber, policyNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("CLAPolicyNumber", policyNumber);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);

                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set CLAPolicyNumber = '"+Payment.PolicyNumber+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            status = true;
                            break;

                        case "POLICYEFFDATE":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.CLAPolicyEffDate, PolicyeffDate);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("CLAPolicyEffDate", PolicyeffDate);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.CLAPolicyExpDate, PolicyexpDate);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("CLAPolicyExpDate", PolicyexpDate);
                            //status = sXL.executeUpdateQuery(sfunValue[2], updateColumnNameValues, whereConstraint);

                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                            // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            // status =
                            // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                            // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                            // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                            status = true;
                            break;
                        case "POLICYMOVE":
                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_POLICYMOVE, updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_POLICYMOVE, updateColumnNameValues, whereConstraint);

                            updateColumnNameValues.clear();
                            whereConstraint.clear();
                            updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                            whereConstraint.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_ACCOUNTHISTORY, updateColumnNameValues, whereConstraint);
                            status = true;
                            break;
                    }
                }
            }
        }
        // System.out.println("SCRCommon.testDataFill log End = "
        // +Runtime.getRuntime().totalMemory());
        // System.out.println(Runtime.getRuntime().freeMemory());
        return status;
    }

    public static boolean testData(String sValue) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        System.out.println("SCRCommon.testDataFill log start = " + Runtime.getRuntime().totalMemory());
        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        String accountNumber = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_ACCOUNT_NUMBER);
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        String policyNumber = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_NUMBER);
        String policyNumberSearch = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_NUMBER_SEARCH);
        String submissionNumber = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_SUBMISSION_NUMBER);
        String PolicyeffDate = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_EFF_DATE);
        String PolicyexpDate = PCThreadCache.getInstance().getProperty(PCConstants.CACHE_POLICY_EXP_DATE);
        System.out.println(Runtime.getRuntime().freeMemory());
        boolean status = false;
        String[] sfunValue = sValue.split(":::");
        XlsxReader sXL = XlsxReader.getInstance();
        switch (sfunValue[0].toUpperCase()) {
            case "ACCOUNTNUMBER":
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                status = true;
                break;
            case "POLICYNUMBER":
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                status = true;
                break;

            case "SUBMISSIONNUMBER":
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.SubmissionNumber, submissionNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("SubmissionNumber", submissionNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set SubmissionNumber =
                // '"+Payment.SubmissionNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                status = true;
                break;
            case "POLICYNUMBERONLY":
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.PolicyNumber, policyNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("PolicyNumber", policyNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                status = true;
                break;
            case "CLAPOLICYNUMBERONLY":
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.CLAPolicyNumber, policyNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("CLAPolicyNumber", policyNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set CLAPolicyNumber = '"+Payment.PolicyNumber+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                status = true;
                break;
            case "ACCOUNTCLAPOLICYNUMBER":
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.AccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("AccountNumber", accountNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.CLAPolicyNumber, policyNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("CLAPolicyNumber", policyNumber);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtPolicyNumber, policyNumberSearch);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.edtaccountNumber, accountNumber);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("edtaccountNumber", accountNumber);
                //status = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);

                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set AccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set CLAPolicyNumber = '"+Payment.PolicyNumber+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchAccount Set edtaccountNumber = '"+accountNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                status = true;
                break;

            case "POLICYEFFDATE":
                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.CLAPolicyEffDate, PolicyeffDate);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("CLAPolicyEffDate", PolicyeffDate);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                whereConstraint.clear();
                updateColumnNameValues.put(PCConstants.CLAPolicyExpDate, PolicyexpDate);
                whereConstraint.put(PCConstants.ID, tcID);
                PCThreadCache.getInstance().setProperty("CLAPolicyExpDate", PolicyexpDate);
                //status = sXL.executeUpdateQuery(sfunValue[1], updateColumnNameValues, whereConstraint);

                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update "+sfunValue[2]+" Set PolicyNumber = '"+Payment.PolicyNumber+"' where
                // ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                // status =
                // common.UpdateQuery(HTML.properties.getProperty("DataSheetName"),
                // "Update SearchPolicy Set edtPolicyNumber = '"+Payment.PolicyNumberSearch+"'
                // where ID='"+PCThreadCache.getInstance().getProperty("TCID")+"'");
                status = true;
                break;
        }
        // System.out.println("SCRCommon.testDataFill log End = "
        // +Runtime.getRuntime().totalMemory());
        // System.out.println(Runtime.getRuntime().freeMemory());
        return status;
    }

    public static String ReturnCurrentDate() {

        String status = null;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = sdf.format(date);
            status = strDate;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }


    public static String ReturnThirtydaysAfterDate() {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        String status = null;
        try {
            Calendar Date = Calendar.getInstance();
            Date.add(Calendar.DATE, 45);
            String End_Date = (Date.get(Calendar.MONTH) + 1) + "/" + (Date.get(Calendar.DATE) + "/" + (Date.get(Calendar.YEAR)));
            System.out.println("End_Date is :::" + End_Date);
            status = End_Date;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }

    public static boolean ReturnCurrentDate(String sFuncValue) {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        boolean status = false;
        String edt = "edt" + sFuncValue;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = sdf.format(date);
            status = common.SafeAction(Common.o.getObject(edt), strDate, "edt");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }

    public static boolean ReturnOneYearFutureDate(String sFuncValue) {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        String edt = "edt" + sFuncValue;
        try {
            Calendar Date = Calendar.getInstance();
            Date.add(Calendar.YEAR, 1);
            String End_Date = (Date.get(Calendar.MONTH) + 1) + "/" + (Date.get(Calendar.DATE) + "/" + (Date.get(Calendar.YEAR)));
            status = common.SafeAction(Common.o.getObject(edt), End_Date, "edt");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }

    public static int TableRowCount(By locator) {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        WebElement table = common.returnObject(locator);
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int sRowCount = rows_table.size();
        return sRowCount;
    }

    public static String ReturnOneYearFromDate() {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        String status = null;
        try {
            Calendar Date = Calendar.getInstance();
            Date.add(Calendar.YEAR, 1);
            String End_Date = (Date.get(Calendar.MONTH) + 1) + "/" + (Date.get(Calendar.DATE) + "/" + (Date.get(Calendar.YEAR)));
            status = End_Date;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }

    public static boolean CommonWait(String sFuncValue) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean status = true;
        Common common = CommonManager.getInstance().getCommon();
        String[] sValue = sFuncValue.split(":::");
        common.WaitForPageToBeReady();
        status = common.WaitUntilClickable(Common.o.getObject("" + sValue[0] + ""), Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT")));
        if (status == false) {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Object " + sValue[0] + " is not ready to click", "Object " + sValue[0] + " should ready to click", "FAIL");
        }
        return status;
    }

    public static Boolean ODSWait(int odswait1) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Thread.sleep(odswait1);
        return true;
    }

    public static Boolean MDMWait() throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Thread.sleep(Integer.valueOf(HTML.properties.getProperty("MDMWAIT")));
        return true;
    }

    public static boolean VerifyBannerMsg(String strValue) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        String strObjName = "";
        String[] arrValue = strValue.split(":::");
        switch (arrValue[0].toUpperCase()) {
            case "SUBMISSIONMANAGER":
                strObjName = "eleASMBannerMessage";
                break;
            case "LOCATIONS":
                strObjName = "eleALBannerMessage";
                break;
            case "SEARCHACC":
                strObjName = "eleSearchErrorMessage";
                break;
            case "ACCOUNTRECEPIENT":
                strObjName = "eleARErrortext";
                break;

            case "ACCPOLICYTRANSACTION":
                strObjName = "eleAPTBannerMessage";
                break;

        }
        boolean status = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject(strObjName)).size() != 0;
        String strErrorMsg = common.ReadElement(Common.o.getObject(strObjName), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
        if (status == true) {

            if (strErrorMsg.toUpperCase().equalsIgnoreCase(arrValue[1])) {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether banner message is displayed as expected", "Expected banner message '" + arrValue[1] + "'  is matching with Actual : '" + strErrorMsg + "'", "PASS");
                status = true;
            } else {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether banner message is displayed as expected", "Expected banner message '" + arrValue[1] + "' is not matching with Actual : '" + strErrorMsg + "'", "FAIL");
                status = false;
            }
        } else {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether banner message is displayed or not", "Banner message is not displayed : '" + strErrorMsg + "'", "FAIL");
            status = false;
        }

        return status;
    }

    public static boolean VerifyErrorMessages(String sValue) throws IOException {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean Status = true;
        String expectedText = null;
        String[] sfunVal = sValue.split(":::::");
        String[] sfunValue = sfunVal[1].split(":::");
        String ele = "ele" + sfunVal[0];
        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject(ele));
        for (WebElement element : CellElements) {
            boolean matchStatus = false;
            String errorText = element.getText();
            for (String expText : sfunValue) {
                expectedText = expText.toString();
                if (errorText.contentEquals(expectedText)) {
                    matchStatus = true;
                    logger.info("Expected error text is matching with actual text '" + expectedText + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "Expected error text is matching with actual text '" + expectedText + "'", "PASS");
                    break;
                }
            }
            if (matchStatus == false) {
                logger.info("Expected error text is not matching with actual text '" + expectedText + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "Expected error text is not matching with actual text '" + expectedText + "'", "FAIL");
                // Status = false;
            }
        }
        return Status;
    }

    public static boolean verifyErrorMsgText(String sValue) throws IOException {
        int c = 0;
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        List<String> a = new ArrayList<String>();
        String[] expMsg = null;
        boolean matchStatus = false;
        // String expectedText=null;
        if (common.ElementSize(Common.o.getObject("eleValidationMsg")) == 0) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen", "PASS");
            // status=true;

        } else {
            WebElement eleErrtble = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleValidationMsg"));
            List<WebElement> eleDiv = eleErrtble.findElements(By.className("message")); // all div
            List<WebElement> eleErrIcon = eleErrtble.findElements(By.tagName("img")); // all div
            expMsg = sValue.split("::");

            for (String expectedText : expMsg) {
                logger.info("Expected Message - " + expectedText);
                String type = null;
                for (int i = 0; i < eleDiv.size(); i++) {
                    matchStatus = false;
                    String actWarningMsg = eleDiv.get(i).getText();
                    String TypeMsg = eleErrIcon.get(i).getAttribute("class");
                    String[] Msgtype = TypeMsg.split("_");
                    type = Msgtype[0];
                    if ((actWarningMsg.contains(expectedText) && Msgtype[0].equals("error")) || actWarningMsg.contains(expectedText) && TypeMsg.contains("error")) {
                        c++;
                        matchStatus = true;
                        // logger.info("Expected " + Msgtype[0]
                        // +" Message is matching with actual message '" +
                        // expectedText + "'");
                        break;
                    }

                }
                logger.info("Visibility of error message " + expectedText + " :" + matchStatus);
            }
            if (c == expMsg.length) {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected Error Messags should be displayed '" + "'", "Expected Error message(s) displayed", "PASS");
                status = true;
            } else
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected Error Messags should be displayed '" + "'", "Expected Error message(s) not displayed", "FAIL");
        }
        return true;
    }

    public static Boolean PageVerify(String strPageName) throws Exception {
        System.out.println("PCThreadCache.getInstance().getProperty() is :::" + PCThreadCache.getInstance().getProperty("TCID"));
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        String ele = "ele" + strPageName;
        Boolean status = false;
        if (common.WaitUntilClickable(Common.o.getObject(ele), Integer.valueOf(HTML.properties.getProperty("LONGESTWAIT")))) {
            logger.info("System displayed '" + strPageName + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strPageName + "'", "System displayed '" + strPageName + "'", "PASS");
            status = true;
        } else {
            logger.info("System not displayed '" + strPageName + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strPageName + "'", "System not displayed '" + strPageName + "'", "FAIL");
            status = false;
        }
        return status;
    }

    public static Boolean PageVerifyNotPresent(String strPageName) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        String ele = "ele" + strPageName;
        Boolean status = false;
        if (common.WaitUntilClickable(Common.o.getObject(ele), Integer.valueOf(HTML.properties.getProperty("LONGESTWAIT")))) {
            logger.info("System displayed '" + strPageName + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should not display '" + strPageName + "'", "System displayed '" + strPageName + "'", "FAIL");
            status = false;
        } else {
            logger.info("System not displayed '" + strPageName + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should not display '" + strPageName + "'", "System not displayed '" + strPageName + "'", "PASS");
            status = true;
        }
        return status;
    }

    public static Boolean VerifyElements(String strPageName) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        boolean Status = true;
        String[] sfunVal = strPageName.split(":::::");
        for (String element : sfunVal) {
            String[] sfunValue = element.split(":::");
            String ele = "ele" + sfunValue[1];
            switch (sfunValue[0].toUpperCase()) {
                case "VISIBLETRUE":
                    boolean popUpExist = common.ElementSize(Common.o.getObject(ele)) != 0;
                    if (popUpExist == true) {
                        // if(Common.WaitUntilClickable(Common.o.getObject(ele),
                        // Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT"))))
                        // {
                        logger.info("System displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strPageName + "'", "System displayed '" + strPageName + "'", "PASS");
                        // Status = true;
                    } else {
                        logger.info("System not displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strPageName + "'", "System not displayed '" + strPageName + "'", "FAIL");
                        // Status = false;
                    }
                    break;
                case "VISIBLEFALSE":
                    boolean popUpExist1 = common.ElementSize(Common.o.getObject(ele)) == 0;
                    if (popUpExist1 != true) {
                        logger.info("System not displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should not display '" + strPageName + "'", "System displayed '" + strPageName + "'", "FAIL");
                        // Status = true;
                    } else {
                        logger.info("System displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should not display '" + strPageName + "'", "System not displayed '" + strPageName + "'", "PASS");
                        // Status = false;
                    }
            }
        }
        return Status;
    }

    public static Boolean VerifyElement(String strPageName) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        boolean Status = true;
        String[] sfunVal = strPageName.split(":::::");
        for (String element : sfunVal) {
            String[] sfunValue = element.split(":::");
            // String ele = "ele" + sfunValue[1];
            switch (sfunValue[0].toUpperCase()) {
                case "VISIBLETRUE":
                    boolean popUpExist = common.ElementSize(Common.o.getObject(sfunValue[1])) != 0;
                    if (popUpExist == true) {
                        // if(Common.WaitUntilClickable(Common.o.getObject(ele),
                        // Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT"))))
                        // {
                        logger.info("System displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strPageName + "'", "System displayed '" + strPageName + "'", "PASS");
                        // Status = true;
                    } else {
                        logger.info("System not displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strPageName + "'", "System not displayed '" + strPageName + "'", "FAIL");
                        // Status = false;
                    }
                    break;
                case "VISIBLEFALSE":
                    boolean popUpExist1 = common.ElementSize(Common.o.getObject(sfunValue[1])) != 0;
                    if (popUpExist1 == true) {
                        logger.info("System not displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should not display '" + strPageName + "'", "System displayed '" + strPageName + "'", "FAIL");
                        // Status = true;
                    } else {
                        logger.info("System displayed '" + strPageName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should not display '" + strPageName + "'", "System not displayed '" + strPageName + "'", "PASS");
                        // Status = false;
                    }
            }
        }
        return Status;
    }

    public Boolean PageLeftPane1(String strPageName) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        String strReadString = "";
        String actionObjetName = "";
        String LeftPanelActionsLinksLevel = "";

        boolean SearchString = false;
        boolean ActionObject = false;

        String LeftPanelLinks = "";
        String LeftPanelActions = "";
        int readCol = 0;
        boolean Status = true;
        String[] sfunVal = strPageName.split("::");

        switch (sfunVal[0].toUpperCase()) {
            case "DESKTOP":
                LeftPanelLinks = "eleDeskTopLeftPanelLinks";
                LeftPanelActions = "eleDeskTopLeftPanelActions";
                break;
            case "ACCOUNT":
                LeftPanelLinks = "eleAccountLeftPanelLinks";
                LeftPanelActions = "eleAccountLeftPanelActions";
                break;
            case "POLICY":
                LeftPanelLinks = "elePolicyLeftPanelLinks";
                LeftPanelActions = "elePolicyLeftPanelActions";
                break;
        }

        String[] sLnkAct = sfunVal[1].split("--");
        switch (sLnkAct[0].toUpperCase()) {
            case "LINKS":
                WebElement mytable = common.returnObject(Common.o.getObject(LeftPanelLinks));
                List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
                for (int i = 0; i <= allrows.size() - 1; i++) {
                    List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
                    String readText = Cells.get(readCol).getText();
                    strReadString = sLnkAct[1];
                    actionObjetName = sLnkAct[1];
                    if (readText.contains(sLnkAct[1])) {
                        SearchString = true;
                        List<WebElement> CellElements = Cells.get(readCol).findElements(By.tagName("div"));
                        for (WebElement element : CellElements) {
                            String objName = element.getText();
                            if (objName.contains(sLnkAct[1])) {
                                Status = true;
                                ActionObject = true;
                                element.click();
                                break;
                            }
                        }
                    }
                    if (ActionObject == true) {
                        break;
                    }
                }
                if (SearchString) {
                    logger.info("Search String available in the table. '" + strReadString + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "PASS");
                    if (ActionObject) {
                        logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "PASS");
                        Status = true;
                    } else {
                        logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "FAIL");
                        Status = false;
                    }
                } else {
                    logger.info("Search String not available in the table. '" + strReadString + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "FAIL");
                    Status = false;
                }
                break;
            case "ACTIONS":
                Status = common.SafeAction(Common.o.getObject(LeftPanelActions), "", LeftPanelActions);
                String[] sActs = sLnkAct[1].split("&&");
                for (String str : sActs) {
                    LeftPanelActionsLinksLevel = "x-menu-item-text";
                    // String[] sLinkAction = str.split(":&");
                    List<WebElement> allrows1 = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("span"));
                    for (WebElement ele : allrows1) {
                        ActionObject = false;
                        Status = false;
                        String readAttri = ele.getAttribute("class");

                        strReadString = str;
                        actionObjetName = str;
                        if (readAttri.contains(LeftPanelActionsLinksLevel)) {
                            // logger.info(readAttri);
                            String readText = ele.getText();
                            if (readText.contains(str)) {
                                SearchString = true;
                                String readAttriID = ele.getAttribute("id");
                                WebElement elem = common.returnObject(By.id(readAttriID));
                                Status = true;
                                ActionObject = true;
                                common.highlightElement(By.id(readAttriID));
                                elem.click();
                                common.WaitForPageToBeReady();
                                break;
                            }
                        }
                        if (ActionObject == true) {
                            break;
                        }
                    }
                    if (SearchString) {
                        logger.info("Search String available in the table. '" + strReadString + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "PASS");
                        if (ActionObject) {
                            logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "PASS");
                            Status = true;
                        } else {
                            logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "FAIL");
                            Status = false;
                        }
                    } else {
                        logger.info("Search String not available in the table. '" + strReadString + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "FAIL");
                        Status = false;
                    }
                }
        }
        return Status;
    }

    public boolean SelectPolicyNumber(String sFuncValue) throws Exception {
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        String[] sValue = sFuncValue.split(":::");
        status = common.ActionOnTable(Common.o.getObject("eleAccountSummary_PolicyTermsTbl"), 1, 1, sValue[0], sValue[0], "a");
        return status;
    }

    public static boolean VerifyPolicyStatus(String sValue) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        // Thread.sleep(8000);
        String strPolicyStatus = common.ReadElement(Common.o.getObject("eleCLAPolicyStatus"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
        if (strPolicyStatus.equalsIgnoreCase(sValue)) {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify the policy status", "Application policy status is matching with expected status: '" + strPolicyStatus + "'", "PASS");
            status = true;
        } else {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify the policy status", "Application policy status is not matching with expected status: '" + strPolicyStatus + "'", "FAIL");
            status = false;
        }
        return status;
    }

    public boolean VerifyStandardizationMessages(String strFunValue) throws Exception {
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        String sApplnValue = "";
        String[] sValue = strFunValue.split(":::");
        try {
            switch (sValue[0]) {
                case "AccountLocation":
                    sApplnValue = common.ReadElement(Common.o.getObject("eleLocationInfoMsg"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
                    break;
                case "AccountContact":
                    sApplnValue = common.ReadElement(Common.o.getObject("eleAccount_Message"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
                    break;
                case "CreateAccount":
                    sApplnValue = common.ReadElement(Common.o.getObject("eleAddSuccessMsg"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
                    break;
            }
            if (sApplnValue.equals(sValue[1])) {
                status = true;
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display expected standardized message", "System displayed" + sApplnValue + "message as expected", "PASS");
            } else {
                status = false;
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display expected standardized message", "System did not display" + sApplnValue + "message as expected", "FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }

    public boolean CreateAccountOK() throws Exception {
        boolean status = true;
        Common common = CommonManager.getInstance().getCommon();
        // boolean popUpExist =
        // common.ElementSize(Common.o.getObject("eleCreateAccountOK"))!=0;
        int popUpExist = common.ElementSize(Common.o.getObject("eleCreateAccountOK"));
        if (popUpExist == 1) {
            common.SafeAction(Common.o.getObject("eleCreateAccountOK"), "eleCreateAccountOK", "eleCreateAccountOK");
            status = true;
        }
        return status;
    }

    public boolean CreateAccountCancel() throws Exception {
        boolean status = true;
        Common common = CommonManager.getInstance().getCommon();
        boolean popUpExist = common.ElementSize(Common.o.getObject("eleCreateAccountCancel")) != 0;
        if (popUpExist == true) {
            common.SafeAction(Common.o.getObject("eleCreateAccountCancel"), "eleCreateAccountCancel", "eleCreateAccountCancel");
            status = true;
        }
        return status;
    }

    public static Boolean VerifyElementText(String strPageName) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        logger.info("Verifying element text...");
        boolean Status = true;
        Common common = CommonManager.getInstance().getCommon();
        String[] sfunVal = strPageName.split(":::::");

        for (String element : sfunVal) {
            String[] sfunValue = element.split(":::");
            String ele = "ele" + sfunValue[0];

            // String txt = Common.ReadElement(Common.o.getObject(ele), 30);

            common.WaitUntilClickable(Common.o.getObject(ele), 30);
            WebElement element1 = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(ele));
            String txt = element1.getText();
            // String txt = element1.getAttribute("value");

            if (txt.contentEquals(sfunValue[1])) // R3 (txt.contentEquals(sfunValue[1]))

            {
                logger.info("System displayed '" + sfunValue[1] + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + sfunValue[1] + "'", "System displayed '" + txt + "'", "PASS");

                // Status = true;
            } else {
                logger.info("System not displayed '" + txt.toUpperCase() + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + sfunValue[1] + "'",

                        "System  displayed '" + txt + "'", "FAIL");

                // Status = false;
            }
        }
        return Status;
    }

    public static boolean VerifyText(String sValue) throws IOException {

        boolean Status = true;
        boolean matchStatus = false;
        String expectedText = null;
        String[] sfunVal = sValue.split(":::::");
        String[] sfunValue = sfunVal[1].split(":::");
        // String ele = "ele" + sfunVal[0];
        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject(sfunVal[0]));
        if (CellElements.size() > 0) {
            for (WebElement element : CellElements) {
                String errorText = element.getText();
                for (String expText : sfunValue) {
                    expectedText = expText.toString();
                    // if
                    // (errorText.toUpperCase().contentEquals(expectedText.toUpperCase()))
                    if (errorText.toUpperCase().contains(expectedText.toUpperCase()) || (expectedText.toUpperCase().contains(errorText.toUpperCase()))) {
                        matchStatus = true;
                        logger.info("Expected text '" + expectedText + "' is matching/ contains with actual text '" + errorText + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected text '" + expectedText + "' should matching with actual text '" + errorText + "'", "Expected text '" + expectedText + "' is matching with actual text '" + errorText + "'", "PASS");
                        break;
                    }
                }
                if (!matchStatus) {
                    logger.info("Expected text '" + expectedText + "' is not matching with actual text '" + errorText + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected text '" + expectedText + "' should matching with actual text '" + errorText + "'", "Expected text '" + expectedText + "' is not matching with actual text '" + errorText + "'", "FAIL");
                    // Status = false;
                }
            }
        } else {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + sfunVal[0] + " element should be found", "" + sfunVal[0] + " not found", "FAIL");
        }
        return Status;
    }

    public static Boolean VerifyEditBoxText(String strPageName) throws Exception {

        boolean Status = true;
        Common common = CommonManager.getInstance().getCommon();
        String[] sfunVal = strPageName.split(":::::");

        for (String element : sfunVal) {
            String[] sfunValue = element.split(":::");
            String ele = sfunValue[0];
            common.WaitUntilClickable(Common.o.getObject(ele), 30);
            WebElement element1 = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(ele));

            String txt = element1.getAttribute("value");
            if (sfunValue[1].equalsIgnoreCase("CURRDATE")) {
                sfunValue[1] = ReturnCurrentDate();
            }
            if (txt.equalsIgnoreCase(sfunValue[1])) {
                logger.info("System displayed '" + sfunValue[1] + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + sfunValue[1] + "'", "System displayed '" + sfunValue[1] + "'", "PASS");
                // Status = true;
            } else {
                logger.info("System not displayed '" + sfunValue[1] + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + sfunValue[1] + "'", "System not displayed '" + sfunValue[1] + "'", "FAIL");
                // Status = false;
            }
        }
        return Status;
    }

    public static Boolean verifyEditBoxTextValue(String strPageName) throws Exception {

        boolean Status = true;
        CommonManager.getInstance().getCommon();
        String[] sfunVal = strPageName.split(":::::");

        for (String element : sfunVal) {
            String[] sfunValue = element.split(":::");
            WebElement element1 = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(sfunValue[0]));
            // String txt = element1.getText();
            String txt = element1.getAttribute("value");
            if (sfunValue[1].equalsIgnoreCase("CURRDATE")) {
                sfunValue[1] = ReturnCurrentDate();
            }
            if (txt.equalsIgnoreCase(sfunValue[1])) {
                logger.info("System displayed '" + sfunValue[1] + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + sfunValue[1] + "'", "System displayed '" + sfunValue[1] + "'", "PASS");
                // Status = true;
            } else {
                logger.info("System not displayed '" + txt + "intsead of" + sfunValue[1] + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + sfunValue[1] + "'", "System not displayed '" + sfunValue[1] + "'", "FAIL");
                // Status = false;
            }
        }
        return Status;
    }

    public static Boolean verifyEditFieldNoBlank(String strField) throws Exception {

        boolean Status = true;
        CommonManager.getInstance().getCommon();
        WebElement element1 = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strField));
        // String txt = element1.getText();
        String txt = element1.getText();

        if (txt.trim().length() > 0) {
            logger.info("Field is displayed '" + strField + "' with value " + txt);
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strField + "' with pre polulated value ", "System displayed '" + strField + "' with pre polulated value", "PASS");
            // Status = true;
        } else {
            logger.info("Field is NOT displayed '" + strField + "' with value");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strField + "' with pre polulated value ", "System is NOT displayed '" + strField + "' with pre polulated value", "FAIL");
            // Status = false;
        }
        return Status;
    }

    public Boolean VerifyElementNotExistence(String strElement) throws Exception {

        String[] sfunVal = strElement.split(":::");
        for (String element : sfunVal) {
            boolean Status = true;
            List<WebElement> ele = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("a"));
            for (WebElement e : ele) {
                String txt = e.getText();
                if (txt.contains(element)) {
                    Status = false;
                }

            }
            if (Status) {
                logger.info("'" + element + "' " + "Element should not available");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Element should not available '" + element + "'", "'" + element + "' " + "Element not available", "PASS");
                // Status = true;
            } else {
                logger.info("Element should not available '" + element + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + element + "' " + "Element should not available", "'" + element + "' " + "Element available", "FAIL");
                // Status = false;
            }

        }
        return true;
    }

    public Boolean PageLeftPane(String strPageName) throws Exception {

        Common common = CommonManager.getInstance().getCommon();
        String strReadString = "";
        String actionObjetName = "";
        String LeftPanelActionsLinksLevel = "";
        boolean SearchString = false;
        boolean ActionObject = false;
        String LeftPanelLinks = "";
        String LeftPanelActions = "";
        int readCol = 0;
        boolean Status = true;
        String[] sfunVal = strPageName.split("::");
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        switch (sfunVal[0].toUpperCase()) {
            case "DESKTOP":
                LeftPanelLinks = "eleDeskTopLeftPanelLinks";
                LeftPanelActions = "eleDeskTopLeftPanelActions";
                LeftPanelActionsLinksLevel = "x-menu-item-text";
                break;
            case "ACCOUNT":
                LeftPanelLinks = "eleAccountLeftPanelLinks";
                LeftPanelActions = "eleAccountLeftPanelActions";
                LeftPanelActionsLinksLevel = "x-tree-node-text ";
                break;
            case "POLICY":
                LeftPanelLinks = "elePolicyLeftPanelLinks";
                LeftPanelActions = "elePolicyLeftPanelActions";
                LeftPanelActionsLinksLevel = "x-tree-node-text ";
                break;
            case "ADMIN":
                LeftPanelLinks = "eleAdminLeftPanelLinks";
                // LeftPanelActions = "elePolicyLeftPanelActions";
                LeftPanelActionsLinksLevel = "x-tree-node-text ";
                break;

        }

        String[] sLnkAct = sfunVal[1].split("--");
        switch (sLnkAct[0].toUpperCase()) {
            case "LINKS":

                WebElement mytable = common.returnObject(Common.o.getObject(LeftPanelLinks));
                List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
                for (int i = 0; i <= allrows.size() - 1; i++) {
                    List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
                    String readText = Cells.get(readCol).getText();
                    strReadString = sLnkAct[1];
                    actionObjetName = sLnkAct[1];
                    if (readText.contains(sLnkAct[1])) {
                        SearchString = true;
                        List<WebElement> CellElements = Cells.get(readCol).findElements(By.tagName("div"));
                        for (WebElement element : CellElements) {
                            String objName = element.getText();
                            if (objName.contains(sLnkAct[1])) {
                                element.click();
                                ActionObject = true;
                                Status = JavaScript(js);
                                break;
                            }
                        }
                    }
                    if (ActionObject == true) {
                        break;
                    }
                }
                if (SearchString) {
                    logger.info("Search String available in the table. '" + strReadString + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "PASS");
                    if (ActionObject) {
                        logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "PASS");
                        Status = true;
                    } else {
                        logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "FAIL");
                        Status = false;
                    }
                } else {
                    logger.info("Search String not available in the table. '" + strReadString + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "FAIL");
                    Status = false;
                }
                break;
            case "ACTIONS":
                Status = common.SafeAction(Common.o.getObject(LeftPanelActions), "", LeftPanelActions);
                String[] sActs = sLnkAct[1].split("&&");
                for (String str : sActs) {
                    LeftPanelActionsLinksLevel = "x-menu-item-text";
                    // String[] sLinkAction = str.split(":&");
                    List<WebElement> allrows1 = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("span"));
                    for (WebElement ele : allrows1) {
                        ActionObject = false;
                        Status = false;
                        String readAttri = ele.getAttribute("class");

                        strReadString = str;
                        actionObjetName = str;
                        if (readAttri.contains(LeftPanelActionsLinksLevel)) {
                            // logger.info(readAttri);
                            String readText = ele.getText();
                            if (readText.contains(str)) {
                                SearchString = true;
                                String readAttriID = ele.getAttribute("id");
                                WebElement elem = common.returnObject(By.id(readAttriID));
                                ActionObject = true;
                                common.highlightElement(By.id(readAttriID));
                                elem.click();
                                Status = JavaScript(js);
                                // common.WaitForPageToBeReady();
                                break;
                            }
                        }
                        if (ActionObject == true) {
                            break;
                        }
                    }
                    if (SearchString) {
                        logger.info("Search String available in the table. '" + strReadString + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "PASS");
                        if (ActionObject) {
                            logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "PASS");
                            Status = true;
                        } else {
                            logger.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "FAIL");
                            Status = false;
                        }
                    } else {
                        logger.info("Search String not available in the table. '" + strReadString + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "FAIL");
                        Status = false;
                    }
                }
        }
        return Status;
    }

    public boolean WaitToPageToReady() {
        Common common = CommonManager.getInstance().getCommon();
        boolean status = true;
        common.WaitForPageToBeReady();
        return status;
    }

    public static Boolean PageScreenShot(String strSSName) throws Exception {
        // File directory = new File (".");
        Boolean Status = true;
        if (HTML.properties.getProperty("TestCaseScreenShot").contains("YES")) {
            File reportFile;
            Date d = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
            String date = dateFormat.format(d);
            String ssFolder = HTML.properties.getProperty("ResultsFolderPath");
            // File dir = new
            // File("C:\\Selenium\\Workspace\\PC\\Reports\\HTMLReports\\"+PCThreadCache.getInstance().getProperty("testcasename")+"_"+
            // date);
            // File dir = new
            // File("C:\\Selenium\\WorkSpace\\PC\\Reports\\HTMLReports\\"+PCThreadCache.getInstance().getProperty("testcasename")+"_"+
            // date);
            /*
             * File dir = new File(
             * "C:\\Selenium\\WorkSpace\\PC\\Reports\\HTMLReports\\"+PCThreadCache.getInstance().getProperty("testcasename")+"_"+ date +"
             * _" + Thread.currentThread().getId()); if (!dir.exists()) { dir.mkdir(); }
             */

            do {
                reportFile = new File(PCThreadCache.getInstance().getProperty(PCConstants.ZipFolderPath) + "\\" + strSSName + "_" + date + "_" + d.getHours() + d.getMinutes() + d.getSeconds() + ".png");
                String Path = PCThreadCache.getInstance().getProperty(PCConstants.ZipFolderPath);
                PCThreadCache.getInstance().setProperty(PCConstants.ALMScreenshotPath, Path);
                Status = true;
            } while (reportFile.exists());
            File screenshot = ((TakesScreenshot) ManagerDriver.getInstance().getWebDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, reportFile);
            // Status = ZipFolder();
        }
        return Status;
    }

    public static Boolean PageScreenShot() throws Exception {
        // File directory = new File (".");
        Boolean Status = false;
        File reportFile;
        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
        String date = dateFormat.format(d);
        // File dir = new
        // File("C:\\Selenium\\WorkSpace\\PC\\Reports\\HTMLReports\\"+PCThreadCache.getInstance().getProperty("testcasename")+"_"+
        // date);
        File dir = new File("C:\\Selenium\\Workspace6\\PC_New\\Reports\\HTMLReports\\" + PCThreadCache.getInstance().getProperty("testcasename") + "_" + date + "_" + Thread.currentThread().getId());
        // String FolderName =
        // "C:\\Selenium\\WorkSpace\\PC\\Reports\\HTMLReports\\"+PCThreadCache.getInstance().getProperty("testcasename")+"_"+
        // date;
        if (!dir.exists()) {
            dir.mkdir();
        }
        do {
            // reportFile = new File(directory.getCanonicalPath()
            // +"\\Reports\\HTMLReports\\"+PCThreadCache.getInstance().getProperty("testcasename")+"_"+
            // date+"_"+ d.getHours() +d.getMinutes()+d.getSeconds()+ ".png");
            reportFile = new File(dir.getCanonicalPath() + "\\" + PCThreadCache.getInstance().getProperty("testcasename") + "_" + date + "_" + d.getHours() + d.getMinutes() + d.getSeconds() + ".png");
            String Path = dir.getCanonicalPath();
            PCThreadCache.getInstance().setProperty(PCConstants.ALMScreenshotPath, Path);
            Status = true;
        } while (reportFile.exists());
        File screenshot = ((TakesScreenshot) ManagerDriver.getInstance().getWebDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, reportFile);

        return Status;
    }

    public static boolean ZipFolder() throws Exception {

        // zipFolder(SCRCommon.Path, SCRCommon.Path+".zip");
        if (HTML.properties.getProperty("TestCaseScreenShot").contains("YES")) {
            zipFolder(PCThreadCache.getInstance().getProperty(PCConstants.ALMScreenshotPath), PCThreadCache.getInstance().getProperty(PCConstants.ALMScreenshotPath) + ".zip");
        }
        return true;

    }

    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;

        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);

        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
    }

    static private void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws Exception {

        File folder = new File(srcFile);
        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        } else {
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(srcFile);
            zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
        }
    }

    static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
            } else {
                addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
            }
        }
    }

    public Boolean WaitForObjectToBeReady(String sFuncValue) throws Exception, Exception {
        Boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        status = common.WaitUntilClickable(Common.o.getObject("ele" + sFuncValue + ""), Integer.valueOf(HTML.properties.getProperty("LONGESTWAIT")));
        return status;
    }

    public Boolean QPBOtherPremiumEdit(String strParam) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = true;
        String[] sHeader = strParam.split("###");
        String[] strParams = sHeader[1].split(":::::");
        for (int i = 0; i < (strParams.length); i++) {
            String strParams1[] = strParams[i].split(":::");
            String cla = "x-form-item-label x-unselectable x-form-item-label-top";
            List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
            for (WebElement element : CellElements) {
                String objName = element.getText();
                String clas = element.getAttribute("class");
                if (objName.contains(strParams1[0])) {
                    if (cla.contains(clas)) {
                        String readAttriID1 = element.getAttribute("id");
                        String[] sID = readAttriID1.split("DV:");
                        String[] sID1 = sID[1].split(":");
                        int value2 = Integer.parseInt(sID1[0]) + 1;
                        String SD3 = sID[0].concat("DV:") + value2 + ":QPBModalQuestion_ExtInputSet:IntegerFieldInput-inputEl";
                        WebElement elem = common.returnObject(By.id(SD3));
                        elem.click();
                        elem.sendKeys(strParams1[1]);
                        elem.sendKeys(Keys.TAB);
                        // Common.WaitForPageToBeReady();
                        Thread.sleep(4000);
                        break;
                    }
                }
            }
            if (status) {
                logger.info("" + strParams1[0] + " TestArea has been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " TestArea should filled", "" + strParams1[0] + " TestArea is filled", "PASS");
            } else {
                logger.info("" + strParams1[0] + " TestArea has not been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " TestArea should filled", "" + strParams1[0] + " TestArea is not filled", "FAIL");
                status = false;
            }
        }
        return status;
    }

    public Boolean QPBEdit(String strParam) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        String[] sHeader = strParam.split("###");
        String[] strParams = sHeader[1].split(":::::");
        // String[] strParams = strParam.split(":::::");
        for (int i = 0; i < (strParams.length); i++) {
            String strParams1[] = strParams[i].split(":::");
            // for(String str: strParams)
            // {
            String cla = "x-form-item-label x-unselectable x-form-item-label-top";
            List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
            for (WebElement element : CellElements) {
                String objName = element.getText();
                String clas = element.getAttribute("class");
                if (objName.contains(strParams1[0])) {
                    if (cla.contains(clas)) {
                        String readAttriID1 = element.getAttribute("id");
                        String[] sID = readAttriID1.split("-");
                        String sID1 = sID[0].concat("-inputEl");
                        WebElement elem = common.returnObject(By.id(sID1));
                        elem.click();
                        common.WaitForPageToBeReady();
                        elem.sendKeys(strParams1[1]);
                        status = false;
                        break;
                    }
                }

            }
            // }
            if (status) {
                logger.info("" + strParams1[0] + " TestArea has been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " TestArea should filled", "" + strParams1[0] + " TestArea is filled", "PASS");
            } else {
                logger.info("" + strParams1[0] + " TestArea has not been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " TestArea should filled", "" + strParams1[0] + " TestArea is not filled", "FAIL");
                status = false;
            }
        }
        return status;
    }

    public Boolean QPBEditWait(String strParam) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        String[] sHeader = strParam.split("###");
        String[] strParams = sHeader[1].split(":::::");
        // String[] strParams = strParam.split(":::::");
        for (int i = 0; i < (strParams.length); i++) {
            String strParams1[] = strParams[i].split(":::");
            // for(String str: strParams)
            // {
            String cla = "x-form-item-label x-unselectable x-form-item-label-left";
            List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
            for (WebElement element : CellElements) {
                String objName = element.getText();
                String clas = element.getAttribute("class");
                if (objName.contains(strParams1[0])) {
                    if (cla.contains(clas)) {
                        String readAttriID1 = element.getAttribute("id");
                        String[] sID = readAttriID1.split("-");
                        String sID1 = sID[0].concat("-inputEl");
                        WebElement elem = common.returnObject(By.id(sID1));
                        elem.click();
                        elem.sendKeys(strParams1[1]);
                        elem.sendKeys(Keys.TAB);
                        Thread.sleep(4000);
                        status = true;
                        break;
                    }
                }
            }
            // }
            if (status) {
                logger.info("" + strParams1[0] + " TestArea has been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " TestArea should filled", "" + strParams1[0] + " TestArea is filled", "PASS");
            } else {
                logger.info("" + strParams1[0] + " TestArea has not been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " TestArea should filled", "" + strParams1[0] + " TestArea is not filled", "FAIL");
                status = false;
            }
        }
        return status;
    }

    public Boolean QPBCoverageMarketingFlyers(String strParam) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        String[] sHeader = strParam.split("###");
        String[] strParams = sHeader[1].split(":::::");
        // String[] strParams = strParam.split(":::::");
        for (int i = 0; i < (strParams.length); i++) {
            String strParams1[] = strParams[i].split(":::");
            // for(String str: strParams1)
            // {
            List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("a"));
            for (WebElement element : CellElements) {
                String objName = element.getText();
                {
                    if (objName.contains(strParams1[0])) {
                        String readAttriID1 = element.getAttribute("id");
                        String[] sID = readAttriID1.split("_ExtInputSet");
                        String sID1 = sID[0].concat("_ExtInputSet:choicea:choicea_Arg-inputEl");
                        WebElement sElement = common.returnObject(By.id(sID1));
                        sElement.click();
                        sElement.clear();
                        sElement.sendKeys(strParams1[1]);
                        sElement.sendKeys(Keys.TAB);
                        common.WaitForPageToBeReady();
                        Thread.sleep(3000);
                        status = true;
                        break;
                    }
                }
            }
            // }
            if (status) {
                logger.info("" + strParams1[0] + " Flyer has been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " should filled", "" + strParams1[0] + " is filled", "PASS");
            } else {
                logger.info("" + strParams1[0] + " Flyer has not been Filled");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams1[0] + " should filled", "" + strParams1[0] + " is not filled", "FAIL");
                status = false;
            }
        }
        return status;
    }

    public Boolean QPBCheckBox(String strParam) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        String[] sHeader = strParam.split("###");
        String[] strParams = sHeader[1].split(":::");
        // String[] strParams = strParam.split(":::");
        for (String str : strParams) {
            String cla = "x-form-cb-label x-form-cb-label-after";
            List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
            for (WebElement element : CellElements) {
                String objName = element.getText();
                String clas = element.getAttribute("class");
                if (objName.contains(str)) {
                    if (cla.contains(clas)) {
                        String readAttriID1 = element.getAttribute("id");
                        WebElement elem = common.returnObject(By.id(readAttriID1));
                        elem.click();
                        // Common.WaitForPageToBeReady();
                        // waitForAjax();
                        // Common.getResponseCode();
                        // Common.checkHttpResponseCode();
                        // Common.getStatusCode();
                        // Common.linkExists();
                        // Common.getStatusCode();
                        status = true;
                        break;
                    }
                }
            }
            if (status) {
                logger.info("" + str + " Check Box has been Selected");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + str + " should filled", "" + str + " is Selected", "PASS");
            } else {
                logger.info("" + str + " Check Box has not been Selected");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + str + " should filled", "" + str + " is not Selected", "FAIL");
                status = false;
            }
        }
        return status;
    }

    public Boolean QPBVerifyElement(String strParam) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        Boolean sVerifyElementAssert = true;
        String[] sHeader = strParam.split("###");
        String[] strParams = sHeader[1].split(":::");
        // String[] strParams = strParam.split(":::");
        for (String str : strParams) {
            String cla = "x-form-cb-label x-form-cb-label-after";
            List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
            for (WebElement element : CellElements) {
                String objName = element.getText();
                String clas = element.getAttribute("class");
                if (objName.contains(str)) {
                    if (cla.contains(clas)) {
                        String readAttriID1 = element.getAttribute("id");
                        WebElement elem = common.returnObject(By.id(readAttriID1));
                        // Common.highlightElement(By.id(readAttriID1));
                        elem.click();
                        status = true;
                        sVerifyElementAssert = SCRCommon.PageVerify(strParams[1]);
                        break;
                        // Common.WaitForPageToBeReady();
                    }
                }
            }
            if (status) {
                logger.info("" + str + " Check Box has been Selected and Verified the Element");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + str + " should filled", "" + str + " is Selected", "PASS");
                if (sVerifyElementAssert) {
                    logger.info("" + strParams[1] + " Verified the Element");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams[1] + " should filled", "" + strParams[1] + " is Selected", "PASS");
                } else {
                    logger.info("" + str + " Element does not exist");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strParams[1] + " should filled", "" + strParams[1] + " is not Selected", "FAIL");
                    status = false;
                }
            } else {
                logger.info("" + str + " Check Box has not been Selected");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + str + " should filled", "" + str + " is not Selected", "FAIL");
                status = false;
            }
        }
        return status;
    }

    public static String ReturnSixtyDaysFromDate() {
        String status = null;
        try {
            Calendar Date = Calendar.getInstance();
            Date.add(Calendar.DATE, 60);
            String End_Date = (Date.get(Calendar.MONTH) + 1) + "/" + (Date.get(Calendar.DATE) + "/" + (Date.get(Calendar.YEAR)));
            status = End_Date;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }

    public static String ReturnDate(int dateValue) {
        String sDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, dateValue);
            sDate = sdf.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return sDate;
    }

    public static String ReturnDate(Calendar cal, int dateValue) {

        String strReturnDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(cal.getTime());
        cal.add(Calendar.DATE, dateValue);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println(formatter.format(cal.getTime()));
        System.out.println(cal.getTime());
        strReturnDate = formatter.format(cal.getTime());
        return strReturnDate;

    }

    public static String ReturnHundredAndEightyDaysFromDate() {
        String status = null;
        try {
            Calendar Date = Calendar.getInstance();
            Date.add(Calendar.DATE, 180);
            String End_Date = (Date.get(Calendar.MONTH) + 1) + "/" + (Date.get(Calendar.DATE) + "/" + (Date.get(Calendar.YEAR)));
            status = End_Date;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return status;
    }

    public boolean MouseOverActionMainAndSubMenu(String strValue) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        boolean status = false;
        String[] strOject = strValue.split(":::");
        status = common.MouseHoverAction(Common.o.getObject(strOject[0]), Common.o.getObject(strOject[1]));
        return status;
    }

    public boolean VerifySubMenu(String strObject) throws Exception {
        boolean status = false;
        boolean blnMenu = false;

        String strElement = strObject.split(":::")[0];
        String[] strMenu = strObject.split(":::")[1].split("::");
        String[] strActMenu = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strElement)).getText().split("\n");

        for (int i = 0; i <= strMenu.length - 1; i++) {
            for (int j = 0; j <= strActMenu.length - 1; j++) {
                if (strMenu[i].equalsIgnoreCase(strActMenu[j])) {
                    blnMenu = true;
                }
            }
            if (blnMenu) {
                loggers.info("Search String available in the Menu. '" + strMenu[i] + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in Menu and Search string is '" + strMenu[i] + "'", "System searched string in Menu and search string is  '" + strMenu[i] + "'", "PASS");
                blnMenu = false;
                status = true;
            } else {
                loggers.info("Search String not available in the Menu. '" + strMenu[i] + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in Menu and Search string is '" + strMenu[i] + "'", "System not searched string in Menu and search string is  '" + strMenu[i] + "'", "FAIL");
                status = false;
            }
        }
        // System.out.println(driver.findElement(By.cssSelector(".x-panel.x-layer.x-panel-default.x-menu.x-border-box:not([style*='hidden'])")).getText());
        return status;
    }

    public static Boolean QPBCommon(String strParam) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        String sClassName = null;
        List<WebElement> CellElements = null;
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        String[] sHeader = strParam.split("#####");
        logger.info("Starting the Additional Coverage" + sHeader[0]);
        for (int i = 1; i <= (sHeader.length) - 1; i++) {
            status = false;
            String[] sFields = sHeader[i].split("~~");
            String sSameLabelIdentity = sFields[1].substring(0, 3);
            switch (sFields[2].toUpperCase()) {
                case "CHK":
                    if (sFields[3].equals("YES")) {
                        sClassName = "x-form-cb-label x-form-cb-label-after";
                        // added log statement
                        logger.info("str 1 =" + sFields[1]);
                        CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
                        for (WebElement element : CellElements) {
                            String objName = element.getText();
                            String sFieldClass = element.getAttribute("class");
                            if (objName.contains(sFields[1])) {
                                // added log statement
                                logger.info("str 2 =" + sFields[1]);
                                if (sClassName.contains(sFieldClass)) {
                                    String readAttriID1 = element.getAttribute("id");
                                    WebElement sElement = common.returnObject(By.id(readAttriID1));
                                    sElement.click();
                                    status = common.SafeAction(By.id(readAttriID1), "ele", "ele");
                                    status = true;
                                    break;
                                }
                            }
                        }
                    } else {
                        status = true;
                    }
                    break;
                case "EDT":
                    if (sFields[3].equals("YES")) {
                        sClassName = "x-form-item-label x-unselectable x-form-item-label-left";
                        // added log statement
                        logger.info("str 1 =" + sFields[1]);
                        CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
                        for (WebElement element : CellElements) {
                            String objName = element.getText();
                            String sFieldClass = element.getAttribute("class");
                            if (objName.contains(sFields[1])) {
                                if (sClassName.contains(sFieldClass)) {
                                    String readAttriID1 = element.getAttribute("id");
                                    String[] sID = readAttriID1.split("-");
                                    String sID1 = sID[0].concat("-inputEl");
                                    WebElement sElement = common.returnObject(By.id(sID1));
                                    // sElement.click();
                                    sElement.clear();
                                    sElement.sendKeys(sFields[4]);
                                    sElement.sendKeys(Keys.TAB);
                                    // status = Common.JavaScriptWait(sElement, js);
                                    status = true;
                                    break;
                                }
                            }
                        }
                    } else {
                        status = true;
                    }
                    break;
                case "TXA":
                    if (sFields[3].equals("YES")) {
                        if (!sSameLabelIdentity.equals("OC1") && !sSameLabelIdentity.equals("OC2") && !sSameLabelIdentity.equals("OC3") && !sSameLabelIdentity.equals("ALD") && !sSameLabelIdentity.equals("GMS") && !sSameLabelIdentity.equals("NFP") && !sSameLabelIdentity.equals("APP") && !sSameLabelIdentity.equals("OC3")) {
                            sClassName = "x-form-item-label x-unselectable x-form-item-label-top";
                            // added log statement
                            logger.info("str 1 =" + sFields[1]);
                            CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
                            for (WebElement element : CellElements) {
                                String objName = element.getText();
                                String sFieldClass = element.getAttribute("class");
                                if (objName.contains(sFields[1])) {
                                    if (sClassName.contains(sFieldClass)) {
                                        String readAttriID1 = element.getAttribute("id");
                                        String[] sID = readAttriID1.split("-");
                                        String sID1 = sID[0].concat("-inputEl");
                                        WebElement sElement = common.returnObject(By.id(sID1));
                                        // sElement.click();
                                        // sElement.clear();
                                        // sElement.sendKeys(sFields[4]);
                                        status = common.SafeAction(By.id(sID1), sFields[4], "edt");
                                        sElement.sendKeys(Keys.TAB);
                                        // status = Common.JavaScriptWait(sElement,
                                        // js);
                                        status = true;
                                        break;
                                    }
                                }
                            }
                        } else {
                            String[] sEdtLabelValue = sFields[1].split("---");
                            String cla = null;
                            logger.info("str 1 =" + sFields[1]);
                            // This is to check whether the concatenate object is an
                            // edt label or txtarea label or chk label
                            if (sSameLabelIdentity.equals("ALD") || sSameLabelIdentity.equals("GMS")) {
                                cla = "x-form-item-label x-unselectable x-form-item-label-left";
                            } else if (sSameLabelIdentity.equals("OC1") || sSameLabelIdentity.equals("OC2") || sSameLabelIdentity.equals("OC3")) {
                                cla = "x-form-item-label x-unselectable x-form-item-label-top";
                            }
                            /*
                             * else if(sSameLabelIdentity.equals("CDS")) { cla =
                             * "x-component x-component-default"; }
                             */
                            else {
                                cla = "x-form-cb-label x-form-cb-label-after";
                            }
                            CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
                            for (WebElement element : CellElements) {
                                String objName = element.getText();
                                String clas = element.getAttribute("class");
                                if (objName.contains(sEdtLabelValue[1])) {
                                    if (cla.contains(clas)) {
                                        String readAttriID1 = element.getAttribute("id");
                                        String[] sID = readAttriID1.split("DV:");
                                        String[] sID1 = sID[1].split(":");
                                        int value = 0;
                                        if (sSameLabelIdentity.equals("APP") || sSameLabelIdentity.equals("NFP") || sSameLabelIdentity.equals("CDS")) {
                                            value = Integer.parseInt(sID1[0]) + 1;
                                        } else {
                                            value = Integer.parseInt(sID1[0]) + 2;
                                        }
                                        String SD3 = sID[0].concat("DV:") + value + ":QPBModalQuestion_ExtInputSet:Stringrtextarea1-inputEl";
                                        WebElement sElement = common.returnObject(By.id(SD3));
                                        // sElement.click();
                                        // sElement.sendKeys(sFields[4]);
                                        status = common.SafeAction(By.id(SD3), sFields[4], "edt");
                                        sElement.sendKeys(Keys.TAB);
                                        // status = Common.JavaScriptWait(sElement,
                                        // js);
                                        status = true;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        status = true;
                    }
                    break;
                case "CHKJ":
                    if (sFields[3].equals("YES")) {
                        if (!sFields[1].equals("ADSOther") && !sFields[1].equals("SUBOther") && !sFields[1].equals("OPFOther")) {
                            sClassName = "x-form-cb-label x-form-cb-label-after";
                            // added log statement
                            logger.info("str 1 =" + sFields[1]);
                            CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
                            for (WebElement element : CellElements) {
                                String objName = element.getText();
                                String sFieldClass = element.getAttribute("class");
                                if (objName.contains(sFields[1])) {
                                    // added log statement
                                    logger.info("str 2 =" + sFields[1]);
                                    if (sClassName.contains(sFieldClass)) {
                                        String readAttriID1 = element.getAttribute("id");
                                        // WebDriver driver = Common.dr();
                                        // JavascriptExecutor js1 =
                                        // (JavascriptExecutor) driver;
                                        WebElement sElement = common.returnObject(By.id(readAttriID1));
                                        // status =
                                        // Common.SafeAction(By.id(readAttriID1),
                                        // "scl", "scl");
                                        status = common.SafeAction(By.id(readAttriID1), "ele", "ele");
                                        // sElement.click(); //here we are clicking
                                        // the checkbox which is making the ajax
                                        // call
                                        status = SCRCommon.JavaScriptWait(sElement, js);
                                        status = true;
                                        break;
                                    }
                                }
                            }
                        } else {
                            String sObject = "eleQPB" + sFields[1] + "";
                            status = common.SafeAction(Common.o.getObject(sObject), "", sObject);
                            // /status = SCRCommon.JavaScriptWait(Common.ele, js);
                            // Krishna Commented this line
                        }
                    } else {
                        status = true;
                    }
                    break;
                case "EDTJ":
                    if (sFields[3].equals("YES")) {
                        if (!sSameLabelIdentity.equals("OC1") && !sSameLabelIdentity.equals("OC2") && !sSameLabelIdentity.equals("OC3")) {
                            sClassName = "x-form-item-label x-unselectable x-form-item-label-left";
                            // added log statement
                            logger.info("str 1 =" + sFields[1]);
                            CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
                            for (WebElement element : CellElements) {
                                String objName = element.getText();
                                String sFieldClass = element.getAttribute("class");
                                if (objName.contains(sFields[1])) {
                                    if (sClassName.contains(sFieldClass)) {
                                        String readAttriID1 = element.getAttribute("id");
                                        String[] sID = readAttriID1.split("-");
                                        String sID1 = sID[0].concat("-inputEl");
                                        WebElement sElement = common.returnObject(By.id(sID1));
                                        // sElement.click();
                                        // sElement.clear();
                                        // sElement.sendKeys(sFields[4]);
                                        status = common.SafeAction(By.id(sID1), sFields[4], "edt");
                                        sElement.sendKeys(Keys.TAB);
                                        status = SCRCommon.JavaScriptWait(sElement, js);
                                        status = true;
                                        break;
                                    }
                                }
                            }
                        } else {
                            logger.info("str 1 =" + sFields[1]);
                            String[] sEdtLabelValue = sFields[1].split("---");
                            String cla = "x-form-item-label x-unselectable x-form-item-label-top";
                            CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("label"));
                            for (WebElement element : CellElements) {
                                String objName = element.getText();
                                String clas = element.getAttribute("class");
                                if (objName.contains(sEdtLabelValue[1])) {
                                    if (cla.contains(clas)) {
                                        String readAttriID1 = element.getAttribute("id");
                                        String[] sID = readAttriID1.split("DV:");
                                        String[] sID1 = sID[1].split(":");
                                        int value2 = Integer.parseInt(sID1[0]) + 1;
                                        String SD3 = sID[0].concat("DV:") + value2 + ":QPBModalQuestion_ExtInputSet:IntegerFieldInput-inputEl";
                                        WebElement sElement = common.returnObject(By.id(SD3));
                                        // sElement.click();
                                        // sElement.sendKeys(sFields[4]);
                                        status = common.SafeAction(By.id(SD3), sFields[4], "edt");
                                        sElement.sendKeys(Keys.TAB);
                                        status = SCRCommon.JavaScriptWait(sElement, js);
                                        status = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "LSTJ":
                    if (sFields[3].equals("YES")) {
                        CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("a"));
                        for (WebElement element : CellElements) {
                            String objName = element.getText();
                            {
                                if (objName.contains(sFields[1])) {
                                    String readAttriID1 = element.getAttribute("id");
                                    String[] sID = readAttriID1.split("_ExtInputSet");
                                    String sID1 = sID[0].concat("_ExtInputSet:choicea:choicea_Arg-inputEl");
                                    WebElement sElement = common.returnObject(By.id(sID1));
                                    // sElement.click();
                                    // sElement.clear();
                                    // sElement.sendKeys(sFields[4]);
                                    // sElement.sendKeys(Keys.TAB);
                                    status = common.SafeAction(By.id(sID1), sFields[4], "lst");
                                    status = SCRCommon.JavaScriptWait(sElement, js);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "LSSJ":
                    if (sFields[3].equals("YES")) {
                        CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("span"));
                        for (WebElement element : CellElements) {
                            String objName = element.getText();
                            {
                                if (objName.contains(sFields[1])) {
                                    String readAttriID1 = element.getAttribute("id");
                                    String[] sID = readAttriID1.split("_ExtInputSet");
                                    String sID1 = sID[0].concat("_ExtInputSet:choicea:choicea_Arg-inputEl");
                                    WebElement sElement = common.returnObject(By.id(sID1));
                                    // sElement.click();
                                    // sElement.clear();
                                    // sElement.sendKeys(sFields[4]);
                                    // sElement.sendKeys(Keys.TAB);
                                    status = common.SafeAction(By.id(sID1), sFields[4], "lst");
                                    status = SCRCommon.JavaScriptWait(sElement, js);
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            if (status) {
                if (sFields[3].contains("YES")) {
                    if (sFields[2].contains("CHK") || sFields[2].contains("CHKJ")) {
                        logger.info("System clicked " + sFields[1] + " Check Box");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should click '" + sFields[1] + "' Check box", "System clicked '" + sFields[1] + "' check box", "PASS");
                    } else if (sFields[2].contains("EDT") || sFields[2].contains("EDTJ")) {
                        logger.info("System entered '" + sFields[4] + "' value for " + sFields[1] + " Edit box");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should enter value '" + sFields[4] + "' for '" + sFields[1] + "' Edit Box", "System entered value for '" + sFields[4] + "' '" + sFields[1] + "' Edit Box", "PASS");
                    } else if (sFields[2].contains("TXT")) {
                        logger.info("System entered '" + sFields[4] + "' value for " + sFields[1] + " TexArea Box");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should enter value '" + sFields[4] + "' for '" + sFields[1] + "' TextArea Box", "System entered value for '" + sFields[4] + "' '" + sFields[1] + "' TextArea Box", "PASS");
                    } else {
                        logger.info("System entered '" + sFields[4] + "' value for " + sFields[1] + " List Box");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should enter value '" + sFields[4] + "' for '" + sFields[1] + "' List Box", "System entered value for '" + sFields[4] + "' '" + sFields[1] + "' List Box", "PASS");
                    }

                } else {
                    status = true;
                }
            } else {
                if (sFields[3].contains("YES")) {
                    if (sFields[2].contains("CHK") || sFields[2].contains("CHKJ")) {
                        logger.info("" + sFields[1] + " check box is not clicked ");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should click '" + sFields[1] + "' check box", "System not clicked '" + sFields[1] + "' check box", "FAIL");
                        status = false;
                    } else if (sFields[2].contains("EDT") || sFields[2].contains("EDTJ")) {
                        logger.info("System not entered '" + sFields[4] + "' value for " + sFields[1] + " Edit box");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should enter value '" + sFields[4] + "' for '" + sFields[1] + "' Edit Box", "System not entered value for '" + sFields[4] + "' '" + sFields[1] + "' Edit Box", "FAIL");
                        status = false;
                    } else if (sFields[2].contains("TXA")) {
                        logger.info("System not entered '" + sFields[4] + "' value for " + sFields[1] + " TexArea Box");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should enter value '" + sFields[4] + "' for '" + sFields[1] + "' TextArea Box", "System not entered value for '" + sFields[4] + "' '" + sFields[1] + "' TextArea Box", "FAIL");
                        status = false;
                    } else {
                        logger.info("System not entered '" + sFields[4] + "' value for " + sFields[1] + " List Box");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should enter value '" + sFields[4] + "' for '" + sFields[1] + "' List Box", "System not entered value for '" + sFields[4] + "' '" + sFields[1] + "' List Box", "FAIL");
                        status = false;
                    }
                } else {
                    status = false;
                }
            }
        }

        return status;
    }

    public static boolean JavaScriptWait1(WebElement element, JavascriptExecutor js) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean status = false;
        for (int i = 1; i <= Integer.parseInt(HTML.properties.getProperty("VERYLONGWAIT")); i++) {
            logger.info("Document Ajax State = " + js.executeScript("return Ext.Ajax.isLoading();").toString());
            Boolean isAjaxRunning = Boolean.valueOf(js.executeScript("return Ext.Ajax.isLoading();") // returns true if
                    // ajax call
                    // is currently
                    // in progress
                    .toString());
            if (!isAjaxRunning.booleanValue()) {
                status = true;
                break;
            }
            Thread.sleep(1000);// wait for one secnod then check if ajax is
            // completed
        }
        // only remove this print statements after this has been tested
        logger.info("Entering Wait....");
        logger.info("Document window.getComputedStyle(document.body).cursor = " + js.executeScript("return window.getComputedStyle(document.body).cursor;").toString());
        // After ajax call is over, page is not displaying fields(elements) in
        // UI so we are calling below code to display fields in UI
        // status = Common.SafeAction(Common.o.getObject("eleAccountNumber"),
        // "","eleQPBAccountNo");
        // only remove this print statements after this has been tested
        logger.info("End Wait....1");
        // we are waiting to load the elements into page
        WebDriverWait wait = new WebDriverWait(ManagerDriver.getInstance().getWebDriver(), Integer.parseInt(HTML.properties.getProperty("VERYLONGWAIT")));
        wait.until(ExpectedConditions.stalenessOf(element));// (By.id(readAttriID1)));
        logger.info("End Wait....2");
        status = true;
        return status;
    }

    public static boolean JavaScriptWait(WebElement element, JavascriptExecutor js) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        // Actions clickTriangle= new Actions(driver);
        for (int i = 1; i <= Integer.parseInt(HTML.properties.getProperty("VERYLONGWAIT")); i++) {
            logger.info("Document Ajax State = " + js.executeScript("return Ext.Ajax.isLoading();").toString());
            Boolean isAjaxRunning = Boolean.valueOf(js.executeScript("return Ext.Ajax.isLoading();").toString()); // returns
            // true
            // if
            // ajax
            // call
            // is
            // currently
            // in
            // progress
            // Boolean isAjaxRun = Boolean
            // .valueOf(js.executeScript("return((window.jQuery != null) && (jQuery.active
            // === 0))").toString());
            if (!isAjaxRunning.booleanValue()) {
                status = true;
                break;
            }
            Thread.sleep(1000);// wait for one secnod then check if ajax is
            // completed
        }
        // only remove this print statements after this has been tested
        logger.info("Entering Wait....");
        logger.info("Document window.getComputedStyle(document.body).cursor = " + js.executeScript("return window.getComputedStyle(document.body).cursor;").toString());
        // After ajax call is over, page is not displaying fields(elements) in
        // UI so we are calling below code to display fields in UI
        status = common.SafeAction(Common.o.getObject("eleQPBAccountNo"), "eleQPBAccountNo", "eleQPBAccountNo");
        // only remove this print statements after this has been tested
        logger.info("End Wait....1");
        // //we are waiting to load the elements into page
        WebDriverWait wait = new WebDriverWait(ManagerDriver.getInstance().getWebDriver(), Integer.parseInt(HTML.properties.getProperty("VERYLONGWAIT")));
        wait.until(ExpectedConditions.stalenessOf(element));// (By.id(readAttriID1)));
        // js.executeScript("arguments[0].scrollIntoView();",element);
        // clickTriangle.moveToElement(element);
        logger.info("End Wait....2");
        return status;
    }

    public static boolean JavaScriptDynamicWait(WebElement sElement, JavascriptExecutor js) throws Exception {
        boolean status = false;
        for (int i = 1; i <= Integer.parseInt(HTML.properties.getProperty("VERYLONGWAIT")); i++) {
            logger.info("Document Ajax State = " + js.executeScript("return Ext.Ajax.isLoading();").toString());
            Boolean isAjaxRunning = Boolean.valueOf(js.executeScript("return Ext.Ajax.isLoading();") // returns true if
                    // ajax call
                    // is currently
                    // in progress
                    .toString());
            if (!isAjaxRunning.booleanValue()) {
                status = true;
                break;
            }
            Thread.sleep(1000);// wait for one secnod then check if ajax is
            // completed
        }
        WebDriverWait wait = new WebDriverWait(ManagerDriver.getInstance().getWebDriver(), Integer.parseInt(HTML.properties.getProperty("VERYLONGWAIT")));
        wait.until(ExpectedConditions.stalenessOf(sElement));// (By.id(readAttriID1)));
        // logger.info("End Wait....2");
        return status;
    }

    public static boolean JavaScript(JavascriptExecutor js) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean status = false;
        for (int i = 1; i <= Integer.parseInt(HTML.properties.getProperty("VERYLONGWAIT")); i++) {
            logger.info("Document Ajax State = " + js.executeScript("return Ext.Ajax.isLoading();").toString());
            Boolean isAjaxRunning = Boolean.valueOf(js.executeScript("return Ext.Ajax.isLoading();") // returns true if
                    // ajax call
                    // is currently
                    // in progress
                    .toString());
            if (!isAjaxRunning.booleanValue()) {
                status = true;
                break;
            }
            Thread.sleep(1000);// wait for one secnod then check if ajax is
            // completed
        }
        return status;
    }

    public static boolean waitForJQueryProcessing(int timeOutInSeconds) {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean jQcondition = false;
        try {
            new WebDriverWait(ManagerDriver.getInstance().getWebDriver(), timeOutInSeconds) {
            }.until(new ExpectedCondition<Boolean>() {

                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) ((JavascriptExecutor) driverObject).executeScript("return !!window.jQuery && window.jQuery.active == 0");
                }
            });
            jQcondition = (Boolean) ((JavascriptExecutor) ManagerDriver.getInstance().getWebDriver()).executeScript("return window.jQuery != undefined && jQuery.active === 0");
            return jQcondition;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return jQcondition;
    }


    public static Boolean VerifyCalendarControlExistence(String ObjDatepicker) throws Exception {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Common common = CommonManager.getInstance().getCommon();
        boolean status = false;
        String sObject = "ele" + ObjDatepicker + "";
        status = common.SafeAction(Common.o.getObject(sObject), "ele", "ele"); // eleMailDateDtepicker
        List<WebElement> sTable = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleDatepickrControl"));
        for (WebElement ele : sTable) {
            logger.info(sTable.size());
            String roleValue = ele.getAttribute("role");
            // String readText = ele.getText();
            String sLabelId = ele.getAttribute("id");
            if (sLabelId.contains("datepicker") && roleValue.contains("grid")) {
                logger.info(sLabelId);
                int i = common.ElementSize(By.id(sLabelId));
                status = common.ElementDisplayed(By.id(sLabelId));
                if (status && i == 1) {
                    logger.info("Calendar control is displayed in UI - " + sLabelId);
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Calendar Control should be displayed in UI", "Calendar control dispalyed", "PASS");
                    status = common.SafeAction(Common.o.getObject("eleTodayDtepickerBtn"), "ele", "ele");
                    // String
                    // ActValue=Common.ReadElementGetAttribute(Common.o.getObject("edtMailDate"),"value");
                    String ActValue = common.ReadElementFromListEditBox(Common.o.getObject("edtMailDate"), Integer.valueOf(HTML.properties.getProperty("NORMALWAIT")));
                    status = common.CompareStringResult("Mail Date  - Canadian Policy", SCRCommon.ReturnCurrentDate(), ActValue);
                } else {
                    logger.info("NO Calendar control is displayed in UI");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Calendar Control should be displayed in UI", "No calendar control dispalyed", "FAIL");

                }
            } else {
                logger.info("No element matches with Datepicker criteria in UI");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Calendar Control should be displayed in UI", "No elements foudn with Datepicker properties", "FAIL");
            }
        }
        return status;
    }

    public static Boolean VerifyCalendarControlExistence1(String ObjDatepicker) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        boolean status = false;
        // /following-sibling::td"
        String objCalendarxpath = "//td[@id='<ID>']//following-sibling::td";
        objCalendarxpath = objCalendarxpath.replace("<ID>", ObjDatepicker);
        objCalendarxpath = objCalendarxpath.replace("inputEl", "inputCell");

        status = common.SafeAction(By.xpath(objCalendarxpath), "ele", "ele"); // eleMailDateDtepicker
        List<WebElement> sTable = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleDatepickrControl"));
        for (WebElement ele : sTable) {
            logger.info(sTable.size());
            String roleValue = ele.getAttribute("role");
            // String readText = ele.getText();
            String sLabelId = ele.getAttribute("id");
            if (sLabelId.contains("datepicker") && roleValue.contains("grid")) {
                logger.info(sLabelId);
                int i = common.ElementSize(By.id(sLabelId));
                status = common.ElementDisplayed(By.id(sLabelId));
                if (status && i == 1) {
                    logger.info("Calendar control is displayed in UI - " + sLabelId);
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Calendar Control should be displayed in UI", "Calendar control dispalyed", "PASS");
                    // status=common.SafeAction(Common.o.getObject("eleTodayDtepickerBtn"),"ele","ele");
                    // String
                    // ActValue=Common.ReadElementGetAttribute(Common.o.getObject("edtMailDate"),"value");
                    // String
                    // ActValue=common.ReadElementFromListEditBox(Common.o.getObject("edtMailDate"),
                    // Integer.valueOf(HTML.properties.getProperty("NORMALWAIT")));
                    // status =
                    // common.CompareStringResult("Mail Date - Canadian Policy",
                    // SCRCommon.ReturnCurrentDate(), ActValue);
                } else {
                    logger.info("NO Calendar control is displayed in UI");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Calendar Control should be displayed in UI", "No calendar control dispalyed", "FAIL");
                }
            } else {
                logger.info("No element matches with Datepicker criteria in UI");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Calendar Control should be displayed in UI", "No elements foudn with Datepicker properties", "FAIL");
            }
        }
        return status;
    }

    public Boolean radioButtonClickAction(By obj, int readCol, int actionCol, String strReadString, String actionObjetName, String sTagName) throws Exception {
        boolean Status = false;
        boolean SearchString = false;
        boolean ActionObject = false;
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                SearchString = true;
                List<WebElement> CellElements = Cells.get(actionCol).findElements(By.tagName(sTagName));
                for (WebElement element : CellElements) {
                    String objName = element.getAttribute("inputvalue");
                    if (objName.contains(actionObjetName)) {
                        Status = true;
                        ActionObject = true;
                        element.click();
                        JavaScriptDynamicWait(element, js);
                        break;
                    }
                }
            }
            if (ActionObject == true) {
                break;
            }
        }
        if (SearchString) {
            loggers.info("Search String available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "PASS");
            if (ActionObject) {
                loggers.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "PASS");
                Status = true;
            } else {
                loggers.info("Search and click on object in the table cell and object name is '" + actionObjetName + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + actionObjetName + "'", "System searched object in the table and clicked on object. object name is '" + actionObjetName + "'", "FAIL");
                Status = false;
            }
        } else {
            loggers.info("Search String not available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + actionObjetName + "'", "FAIL");
            Status = false;
        }
        return Status;
    }

    public Boolean VerifyPendingTransTable(String funValue) {

        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        String value = null;
        String[] sValue = funValue.split(":::");
        loggers.info(sValue[0]);

        try {

            value = common.GetTextFromTable(Common.o.getObject(sValue[0]), 5, 5, sValue[1]);
            status = common.CompareStringResult("verify display of biling Number", sValue[1], value);
            if (sValue[2].toUpperCase().equalsIgnoreCase("SPAN") || sValue[2].toUpperCase().equalsIgnoreCase("DIV")) {
                status = common.ActionOnTable(Common.o.getObject(sValue[0]), 5, 5, sValue[1], sValue[2].toLowerCase());
                if (status) {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display without hyperlink", "'" + sValue[1] + "' displayed without hyperlink", "PASS");
                } else {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display without hyperlink", "'" + sValue[1] + "' NOT displayed without hyperlink", "FAIL");
                }
            } else if (sValue[2].toUpperCase().equalsIgnoreCase("LINK")) {
                status = common.ActionOnTable(Common.o.getObject(sValue[0]), 5, 5, sValue[1], "a");
                if (status) {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display with hyperlink", "'" + sValue[1] + "' displayed with hyperlink", "PASS");
                } else {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display with hyperlink", "'" + sValue[1] + "' NOT displayed with hyperlink", "FAIL");
                }
            } else {
                status = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;

    }

    public static String ReturnDate_frmDate(int dateValue, String strStartDate) {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        String sDate = null;
        try {
            Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(strStartDate);
            date1.setDate(date1.getDate() + dateValue);
            sDate = new SimpleDateFormat("MM/dd/yyyy").format(date1);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
        return sDate;
    }

    public static boolean VerifyWarning_ErrorMessages(String sValue) throws IOException {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        boolean status = true;
        String expectedText = null;
        String refClassName = null;
        String[] arrMessgage = sValue.split("::");
        String[] expWarnignMsg = arrMessgage[1].split(":::");
        List<String> a = new ArrayList<String>();
        // ArrayList actWarningMsg=new ArrayList();
        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleErrorMsgs"));
        if (arrMessgage[0].toUpperCase().contentEquals("ERROR")) {
            refClassName = "error_icon";

        } else if (arrMessgage[0].toUpperCase().contentEquals("WARNING")) {
            refClassName = "warning_icon";
        }
        if (CellElements.size() == 0) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "No Error/Warning messgae in the screen to validate", "FAIL");

        }
        for (int i = 0; i <= CellElements.size() - 1; i++) {

            List<WebElement> Cells = CellElements.get(i).findElements(By.className(refClassName));
            if (Cells.size() != 0) {

                String actWarningMsg = CellElements.get(i).getText();
                a.add(actWarningMsg);
                logger.info(actWarningMsg);

            }
        }
        // check for Warnging in UI list
        for (String expText : expWarnignMsg) {
            boolean matchStatus = false;
            expectedText = expText.toString();
            for (String actText : a) {
                if (actText.equals(expText)) {
                    matchStatus = true;
                    logger.info("Expected Warning Message  is matching with actual message '" + expectedText + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "Expected error text is matching with actual text '" + expectedText + "'", "PASS");
                    break;
                }
            }

            if (matchStatus == false) {
                logger.info("Expected Warning Message is not matching with actual message '" + expectedText + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "Expected error text is not matching with actual text '" + expectedText + "'", "FAIL");
                // Status = false;
            }
        }
        return status;
    }

    public Boolean VerifyBillMethodInPendingTransTable(String funValue) {

        Common common = CommonManager.getInstance().getCommon();
        Boolean status = false;
        String value = null;
        String[] sValue = funValue.split(":::");
        loggers.info(sValue[0]);

        try {

            value = common.GetTextFromTable(Common.o.getObject(sValue[0]), 5, 5, sValue[1]).trim();
            status = common.CompareStringResult("verify display of biling Number", sValue[1], value);
            if (sValue[2].toUpperCase().equalsIgnoreCase("SPAN") || sValue[2].toUpperCase().equalsIgnoreCase("DIV")) {
                status = common.ActionOnTable(Common.o.getObject(sValue[0]), 5, 5, sValue[1], sValue[2].toLowerCase());
                if (status) {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display without hyperlink", "'" + sValue[1] + "' displayed without hyperlink", "PASS");
                } else {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display without hyperlink", "'" + sValue[1] + "' NOT displayed without hyperlink", "FAIL");
                }
            } else if (sValue[2].toUpperCase().equalsIgnoreCase("LINK")) {
                status = common.ActionOnTable(Common.o.getObject(sValue[0]), 5, 5, sValue[1], "a");
                if (status) {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display with hyperlink", "'" + sValue[1] + "' displayed with hyperlink", "PASS");
                } else {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Billing method '" + sValue[1] + "' should display with hyperlink", "'" + sValue[1] + "' NOT displayed with hyperlink", "FAIL");
                }
            } else {
                status = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean IconValidation(String valEleName, String strExpected) throws NumberFormatException, Exception {
        boolean status = false;
        // boolean pageExist = false;
        int iElementCount;
        String strTxt;
        String vElement = valEleName.substring(3);
        String vType = vElement.substring(0, 3).toUpperCase();
        Common common = CommonManager.getInstance().getCommon();
        // pageExist = common.WaitUntilClickable(Common.o.getObject(vElement),
        // 30);
        iElementCount = common.ElementSize(Common.o.getObject(vElement));
        try {
            if (iElementCount == 1) {
                WebElement element1 = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(vElement));
                switch (vType) {
                    case "ELE":
                        switch (valEleName) {
                            case "valeleAccountSummary_Address":
                            case "valelePolicyInfo_Address":
                                strTxt = element1.getText();
                                status = common.CompareStringResult("Address value", strExpected, strTxt);
                                break;
                            case "valeleAccountSummary_Phone":
                            case "valeleAccountContacts_Phone":
                            case "valelePolicyInfo_PhoneNo":
                            case "valeleAccountContacts_PhoneAccountHolder":
                                String pattern = "(\\D)";
                                strExpected = strExpected.replaceAll(pattern, "");
                                strTxt = element1.getText().toUpperCase();
                                strTxt = strTxt.replaceAll(pattern, "");
                                status = verifyAndUpdateResults(strTxt, strExpected, vElement);
                                break;
                            case "valelePolicyInfo_BOR_EndDate":
                                strExpected = SCRCommon.returnDate(Integer.parseInt(strExpected));
                                break;
                            case "valelePolicyInfo_NPNNumber":
                                String[] number = strExpected.split(":");
                                String NPNNumber = number[1].trim();
                                String NpnValue = common.ReadElement(Common.o.getObject("elePolicyInfo_NPNNumber"), Integer.valueOf(HTML.properties.getProperty("NORMALWAIT")));
                                status = common.CompareStringResult("NPN Number", NpnValue, NPNNumber);
                                break;
                            case "valelePolicyInfo_NPNFirstName":
                                String[] CombinedValue = strExpected.split(":");
                                String[] FName = CombinedValue[0].split(",");
                                String FirstName = FName[1].trim();
                                String Fname = common.ReadElement(Common.o.getObject("elePolicyInfo_NPNFirstName"), Integer.valueOf(HTML.properties.getProperty("NORMALWAIT")));
                                status = common.CompareStringResult("First Name", Fname, FirstName);

                                break;
                            case "valelePolicyInfo_NPNLastName":
                                String[] CombinedValue1 = strExpected.split(":");
                                String[] LName = CombinedValue1[0].split(",");
                                String LastName = LName[0].trim();
                                String Lname = common.ReadElement(Common.o.getObject("elePolicyInfo_NPNLastName"), Integer.valueOf(HTML.properties.getProperty("NORMALWAIT")));
                                status = common.CompareStringResult("Last Name", Lname, LastName);
                                break;
                            case "valelePolicyInfo_NPNMiddleName":
                                String[] CombinedValue2 = strExpected.split(":");
                                String[] MName = CombinedValue2[0].split(",");
                                String MiddleName = MName[2].trim();
                                String Mname = common.ReadElement(Common.o.getObject("elePolicyInfo_NPNMiddleName"), Integer.valueOf(HTML.properties.getProperty("NORMALWAIT")));
                                status = common.CompareStringResult("Middle Name", Mname, MiddleName);
                                break;
                            default:
                                strTxt = element1.getText().toUpperCase();
                                status = verifyAndUpdateResults(strTxt, strExpected, vElement);
                                break;
                        }
                        break;
                    case "EDT":
                        strTxt = common.ReadElementGetAttribute(Common.o.getObject(vElement), "value", Integer.valueOf(HTML.properties.getProperty("NORMALWAIT")));
                        status = verifyAndUpdateResults(strTxt, strExpected, vElement);
                        break;
                }
            } else {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verifying Element '" + vElement + "'", "Element not displayed on the screen.", "FAIL");
            }
            if (!status) {
                status = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            status = true;
        }
        return status;
    }


    public boolean verifyAndUpdateResults(String strAct, String strExp, String ele) throws IOException {
        boolean status = false;
        ele = ele.substring(3);
        if (strAct.toUpperCase().contentEquals(strExp.toUpperCase())) {
            loggers.info("Value for the element '" + ele + "' matches with expected value '" + strExp);
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify value for element '" + ele + "'. Expected value (from ICON): '" + strExp + "'", "'" + ele + "' - Actual value in PC '" + strAct + "' matches with the expected value", "PASS");
            status = true;
        } else {
            loggers.info("Value for the element '" + ele + "' matches with expected value '" + strExp);
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify value for element '" + ele + "'. Expected value (from ICON): '" + strExp + "'", "'" + ele + "' - Actual value in PC '" + strAct + "' is not matching with expected value", "FAIL");
        }

        return status;
    }

    public Boolean importIconValue() {
        boolean status = false;
        XlsxReader sXL = XlsxReader.getInstance();
        IconReader iCN = IconReader.getInstance();
        HashMap<String, Object> whereConstraintSelect = new HashMap<String, Object>();
        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        ArrayList<HashMap<String, Object>> resultListRows1 = new ArrayList<HashMap<String, Object>>();
        ArrayList<HashMap<String, Object>> resultListRows2 = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> whereConstraintUpdate = new HashMap<String, Object>();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        String sValueToReadPCDB = null;
        String sPCMappingValue = null;
        String sPCIconValue = null;
        try {
            whereConstraintSelect.clear();
            whereConstraintSelect.put(PCConstants.ID, tcID);
            resultListRows = sXL.executeSelectQuery(PCConstants.SHEET_Read, whereConstraintSelect);
            for (HashMap<String, Object> processRow : resultListRows) {
                sValueToReadPCDB = (String) processRow.get(PCConstants.ValueToReadPCDB);
                // System.out.println("ValueToReadPCDB "+sValueToReadPCDB);
                whereConstraintSelect.clear();
                whereConstraintSelect.put(PCConstants.PC, sValueToReadPCDB);
                resultListRows1 = iCN.executeSelectQuery(PCConstants.SHEET_Name_Mapping, whereConstraintSelect);
                if (!(resultListRows.size() == 0)) {
                    for (HashMap<String, Object> processRow1 : resultListRows1) {
                        sPCMappingValue = (String) processRow1.get(PCConstants.E2E_Fields);
                        // System.out.println("E2E_Fields "+sPCMappingValue);
                        break;
                    }

                    whereConstraintSelect.clear();
                    whereConstraintSelect.put(PCConstants.E2E_Scenario_Name, tcID);
                    whereConstraintSelect.put(PCConstants.FieldName, sPCMappingValue);
                    resultListRows2 = iCN.executeSelectQuery(PCConstants.SHEET_E2E_Testdata, whereConstraintSelect);
                    if (!(resultListRows.size() == 0)) {
                        for (HashMap<String, Object> processRow2 : resultListRows2) {
                            sPCIconValue = (String) processRow2.get(PCConstants.FieldValues);
                            // System.out.println("FieldValues "+sPCIconValue);
                            String sColumnValue = "val" + sValueToReadPCDB + "";
                            updateColumnNameValues.clear();
                            whereConstraintUpdate.clear();
                            updateColumnNameValues.put(sColumnValue, sPCIconValue);
                            whereConstraintUpdate.put(PCConstants.ID, tcID);
                            PCThreadCache.getInstance().setProperty(sColumnValue, sPCIconValue);
                            //status = sXL.executeUpdateQuery(PCConstants.SHEET_ICONValidation, updateColumnNameValues, whereConstraintUpdate);
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + sPCIconValue + " Value should update in the ICONValidation Sheet", "" + sPCIconValue + " Value updated in the ICONValidation Sheet", "PASS");
                            if (!status) {
                                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + sPCIconValue + " Value should update in the ICONValidation Sheet", "" + sPCIconValue + " Value is not updated in the ICONValidation Sheet", "FAIL");
                            }
                            break;
                        }

                    } else {
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + sPCMappingValue + " Value should present in the E2E_Testdata Sheet", "" + sPCMappingValue + " is not present in the E2E_Testdata Sheet", "FAIL");
                    }
                } else {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + sValueToReadPCDB + " should present in the Name_Mapping Sheet", "" + sValueToReadPCDB + " is not present in the Name_Mapping Sheet", "FAIL");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public Boolean importICONODSValue() {
        Boolean status = true;
        if (HTML.properties.getProperty("EXECUTIONAPP").contains("ODS")) {
            loggers.info("Starting to import the ICON Values to Flat File");
            IconReader iCN = IconReader.getInstance();
            FlatFile write = FlatFile.getInstance();
            HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
            ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
            ArrayList<HashMap<String, Object>> resultListRows1 = new ArrayList<HashMap<String, Object>>();
            whereConstraint.clear();
            whereConstraint.put(PCConstants.ID, PCThreadCache.getInstance().getProperty("TCID"));
            resultListRows = iCN.executeSelectQuery(PCConstants.SHEET_Trans, whereConstraint);
            for (HashMap<String, Object> processRow : resultListRows) {
                String sFieldName = (String) processRow.get("Field_Name");
                String sFieldValue = (String) processRow.get("Field_Value");
                whereConstraint.clear();
                whereConstraint.put("Field_Name", sFieldName);
                resultListRows1 = iCN.executeSelectQuery("Mapping", whereConstraint);
                for (HashMap<String, Object> processRow1 : resultListRows1) {
                    String sODSFieldName = (String) processRow1.get("ODS");
                    status = write.write(PCThreadCache.getInstance().getProperty("TCID"), "IconValidation", sODSFieldName, sFieldValue, "Input", FlatFileName());
                }
            }
            loggers.info("Completed the ICON Values Import");
        }
        return status;
    }

    /**
     * function - to get the icon data from ICON mapping sheet for PC
     *
     * @return true/false
     */
    public Boolean importICONPCValue() {
        loggers.info("Starting to import the ICON Values to Flat File");
        boolean status = true;
        XlsxReader sXL = XlsxReader.getInstance();
        IconReader iCN = IconReader.getInstance();
        HashMap<String, Object> whereConstraintSelect = new HashMap<String, Object>();
        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        ArrayList<HashMap<String, Object>> resultListRows1 = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> whereConstraintUpdate = new HashMap<String, Object>();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        String transFieldName = null;
        String transFieldValue = null;
        String sPCMappingField = null;
        try {
            whereConstraintSelect.clear();
            whereConstraintSelect.put(PCConstants.ID, tcID);
            resultListRows = iCN.executeSelectQuery("Trans", whereConstraintSelect);
            if (resultListRows.size() > 0) {
                for (HashMap<String, Object> processRow : resultListRows) {
                    transFieldName = (String) processRow.get("Field_Name");
                    transFieldValue = (String) processRow.get("Field_Value");
                    whereConstraintSelect.clear();
                    whereConstraintSelect.put("Field_Name", transFieldName);
                    resultListRows1 = iCN.executeSelectQuery("Mapping", whereConstraintSelect);
                    if (resultListRows.size() > 0) {
                        for (HashMap<String, Object> processRow1 : resultListRows1) {
                            sPCMappingField = (String) processRow1.get("PC");
                            if (!sPCMappingField.equals("")) {
                                updateColumnNameValues.clear();
                                whereConstraintUpdate.clear();
                                whereConstraintUpdate.put(PCConstants.ID, tcID);
                                updateColumnNameValues.put("val" + sPCMappingField, transFieldValue);
                                PCThreadCache.getInstance().setProperty("val" + sPCMappingField, transFieldValue);
                                //status = sXL.executeUpdateQuery(PCConstants.SHEET_ICONValidation, updateColumnNameValues, whereConstraintUpdate);
                            }
                            if (transFieldName.equalsIgnoreCase("ACCOUNTNUMBER") || transFieldName.equalsIgnoreCase("POLICYNUMBER")) {
                                status = updateAccountPolicyNumberforIcon(transFieldName, transFieldValue);
                            }
                        }
                    } else {
                        loggers.info("Trans field ID " + transFieldName + " is not available in the Mapping Sheet");
                    }
                }
            } else {
                loggers.info("TestCase ID " + tcID + " is not available in the Trans Sheet");
                status = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * @param strField
     * @param strValue
     * @return true/false
     * @function this will update in the account & policy number in the excel sheet
     */
    public static Boolean updateAccountPolicyNumberforIcon(String strField, String strValue) {
        Boolean blnStatus = false;
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        XlsxReader sXL = XlsxReader.getInstance();
        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        HashMap<String, Object> whereConstraintUpdate = new HashMap<String, Object>();
        switch (strField.toUpperCase()) {
            case "ACCOUNTNUMBER":
                updateColumnNameValues.clear();
                whereConstraintUpdate.clear();
                whereConstraintUpdate.put(PCConstants.ID, tcID);
                updateColumnNameValues.put("edtaccountNumber", strValue);
                PCThreadCache.getInstance().setProperty("edtaccountNumber", strValue);
                //blnStatus = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraintUpdate);

                updateColumnNameValues.clear();
                whereConstraintUpdate.clear();
                whereConstraintUpdate.put(PCConstants.ID, tcID);
                updateColumnNameValues.put("AccountNumber", strValue);
                PCThreadCache.getInstance().setProperty("AccountNumber", strValue);
                //blnStatus = sXL.executeUpdateQuery(PCConstants.SHEET_ICONValidation, updateColumnNameValues, whereConstraintUpdate);
                break;
            case "POLICYNUMBER":
                String policyNumberSearch = strValue.substring(strValue.length() - 6);
                updateColumnNameValues.clear();
                whereConstraintUpdate.clear();
                whereConstraintUpdate.put(PCConstants.ID, tcID);
                updateColumnNameValues.put("edtPolicyNumber", policyNumberSearch);
                PCThreadCache.getInstance().setProperty("edtPolicyNumber", policyNumberSearch);
                //blnStatus = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHPOLICY, updateColumnNameValues, whereConstraintUpdate);

                updateColumnNameValues.clear();
                whereConstraintUpdate.clear();
                whereConstraintUpdate.put(PCConstants.ID, tcID);
                updateColumnNameValues.put("PolicyNumber", strValue);
                PCThreadCache.getInstance().setProperty("PolicyNumber", strValue);
                //blnStatus = sXL.executeUpdateQuery(PCConstants.SHEET_ICONValidation, updateColumnNameValues, whereConstraintUpdate);
                break;
        }
        return blnStatus;
    }

    public boolean OutputforODS(String colName) throws Exception {
        loggers.info("Started Output for ODS Function");
        Boolean Status = false;
        Boolean ElementExist = false;
        String sFileName = FlatFileName();
        String[] sSplitColValue = colName.split(":::");
        Common common = CommonManager.getInstance().getCommon();
        // FlatFileWriter write = FlatFileWriter.getInstance(sFileName);
        FlatFile sReadWrite = FlatFile.getInstance();
        String sGetPCValue = null;
        for (String element : sSplitColValue) {
            String elementType = element.substring(0, 3);
            String elementName = element.substring(3);
            switch (elementType.toUpperCase()) {
                case "EDT":
                    ElementExist = common.ElementExist(Common.o.getObject(element));
                    if (ElementExist) {
                        sGetPCValue = common.ReadElementGetAttribute(Common.o.getObject(element), "value", Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT")));
                        Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), elementName, sGetPCValue, "OUTPUT", sFileName);
                    }
                    break;
                case "ELE":
                    ElementExist = common.ElementExist(Common.o.getObject(element));
                    if (ElementExist) {
                        sGetPCValue = common.ReadElement(Common.o.getObject(element), Integer.valueOf(HTML.properties.getProperty("VERYLONGWAIT")));
                        /*
                         * if(elementName.toUpperCase().contains("ACCOUNTNUMBER")) {
                         */
                        Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), elementName, sGetPCValue, "OUTPUT", sFileName);
                        /*
                         * }else if(elementName.toUpperCase().contains("POLICYNUMBER")) { Status =
                         * sReadWrite.write(PCThreadCache.getInstance().getProperty ("TCID"
                         * ),PCThreadCache.getInstance().getProperty("methodName"), "PolicyNumber",
                         * sGetPCValue, "OUTPUT", sFileName); }else { Status =
                         * sReadWrite.write(PCThreadCache.getInstance().getProperty ("TCID"
                         * ),PCThreadCache.getInstance().getProperty("methodName"), elementName,
                         * sGetPCValue, "OUTPUT", sFileName); }
                         */
                    }
                    break;
                case "DAT":
                    sGetPCValue = ReturnCurrentDate();
                    Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), elementName, sGetPCValue, "OUTPUT", sFileName);
                    break;
            }
        }
        return Status;
    }

    public String FlatFileName() {
        XlsxReader xls = XlsxReader.getInstance();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        String[] splittcID = tcID.split("_");
        String sFileName = null;
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.clear();
        whereConstraint.put(PCConstants.ID, splittcID[0]);
        resultListRows = xls.executeSelectQuery(PCConstants.SHEET_FLATFILE, whereConstraint);
        for (HashMap<String, Object> processRow : resultListRows) {
            sFileName = (String) processRow.get("FlatFileName");
            break;
        }
        return sFileName;
    }

    /**
     * function use to get the data for ODS Queries
     *
     * @param SheetName
     * @return boolean
     * @throws Exception
     */
    public boolean InputforODS(String SheetName) throws Exception {
        boolean Status = true;
        if (HTML.properties.getProperty("EXECUTIONAPP").contains("ODS")) {
            loggers.info("Started Input for ODS Function");
            XlsxReader xls = XlsxReader.getInstance();
            String tcID = PCThreadCache.getInstance().getProperty("TCID");
            String sFileName = FlatFileName();
            // FlatFileWriter write = FlatFileWriter.getInstance(sFileName);
            FlatFile sReadWrite = FlatFile.getInstance();
            int rowcount = xls.getRowCount(SheetName);
            for (int i = 2; i <= rowcount; i++) {
                if (xls.getCellData(SheetName, "ID", i).equals(PCThreadCache.getInstance().getProperty("TCID"))) {
                    int colcount = xls.getColumnCount(SheetName);
                    for (int j = 2; j <= colcount; j++) {
                        String ColName = xls.getCellData(SheetName, j, 1);
                        String value = xls.getCellData(SheetName, j, i);
                        if (!ColName.isEmpty() && !value.isEmpty()) {
                            String element = ColName.substring(0, 3);
                            String elementName = ColName.substring(3);
                            if (!value.isEmpty()) {
                                if (element.toUpperCase().contains("ODS") || element.toUpperCase().contains("EDT") || element.toUpperCase().contains("EDJ") || element.toUpperCase().contains("LST") || element.toUpperCase().contains("LSJ")) {
                                    Status = sReadWrite.write(tcID, PCThreadCache.getInstance().getProperty("methodName"), elementName, value, "input", sFileName);
                                } else if (element.toUpperCase().contains("VAL")) {
                                    String strIconElement[] = elementName.split("_");
                                    Status = sReadWrite.write(tcID, PCThreadCache.getInstance().getProperty("methodName"), strIconElement[1], value, "input", sFileName);
                                }
                            }
                        }
                    }
                }
            }
        }
        return Status;
    }

    public boolean TableHandling(String sFuncValue) {
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = true;
        Boolean tcAvailable = false;
        String[] funcValue = sFuncValue.split(":::");
        int sRowCount = 0;
        XlsxReader sXL = XlsxReader.getInstance();// new XlsxReader(
        // PCThreadCache.getInstance().getProperty("DataSheetName)
        try {
            int rowcount = sXL.getRowCount(funcValue[0]);
            for (int i = 2; i <= rowcount; i++) {
                String TCID = PCThreadCache.getInstance().getProperty("TCID");
                String Iteration = PCThreadCache.getInstance().getProperty("Iteration");
                String TCIDAdd = sXL.getCellData(funcValue[0], "ID", i);
                String TCIDIteration = sXL.getCellData(funcValue[0], "Iteration", i);
                if (TCIDAdd.equals(TCID) && TCIDIteration.equals(Iteration))
                // if(sXL.getCellData(funcValue[0], "ID",
                // i).equals(PCThreadCache.getInstance().getProperty("TCID")) &&
                // sXL.getCellData(funcValue[0], "Iteration",
                // i).contains(PCConstants.Iteration))
                {
                    tcAvailable = true;
                    int colcount = sXL.getColumnCount(funcValue[0]);
                    for (int j = 2; j <= colcount; j++) {
                        String ColName = sXL.getCellData(funcValue[0], j, 1);
                        if (!ColName.isEmpty()) {
                            String value = sXL.getCellData(funcValue[0], j, i);
                            if (!value.equals("")) {
                                String[] valueSplit = value.split(":::");
                                String elementType = ColName.substring(0, 3);
                                String elementName = ColName.substring(3);
                                String concatName = null;
                                if (elementType.toUpperCase().equals("TED") || elementType.toUpperCase().equals("TBL")) {
                                    sRowCount = TableRowCount(Common.o.getObject(funcValue[1]));
                                }
                                switch (elementType.toUpperCase()) {
                                    case "TED":
                                        status = SCRCommon.TableCellValueClick(Common.o.getObject(funcValue[1]), sRowCount, Integer.parseInt(valueSplit[1]), "single", "div");
                                        concatName = "edt" + elementName;
                                        status = common.SafeAction(Common.o.getObject(concatName), valueSplit[0], concatName);
                                        break;
                                    case "TLS":
                                        status = SCRCommon.TableCellValueClick(Common.o.getObject(funcValue[1]), sRowCount, Integer.parseInt(valueSplit[1]), "single", "div");
                                        concatName = "lst" + elementName;
                                        status = common.SafeAction(Common.o.getObject(concatName), valueSplit[0], concatName);
                                        break;
                                    case "TLJ":
                                        status = SCRCommon.TableCellValueClick(Common.o.getObject(funcValue[1]), sRowCount, Integer.parseInt(valueSplit[1]), "single", "div");
                                        concatName = "lsj" + elementName;
                                        status = common.SafeAction(Common.o.getObject(concatName), valueSplit[0], concatName);
                                        break;
                                    case "TEJ":
                                        status = SCRCommon.TableCellValueClick(Common.o.getObject(funcValue[1]), sRowCount, Integer.parseInt(valueSplit[1]), "single", "div");
                                        concatName = "edj" + elementName;
                                        status = common.SafeAction(Common.o.getObject(concatName), valueSplit[0], concatName);
                                        break;
                                    case "TSJ":
                                        status = SCRCommon.TableCellValueClick(Common.o.getObject(funcValue[1]), sRowCount, Integer.parseInt(valueSplit[1]), "single", "div");
                                        concatName = "slj" + elementName;
                                        status = common.SafeAction(Common.o.getObject(concatName), valueSplit[0], concatName);
                                        break;
                                    case "TBL":
                                        status = SCRCommon.TableCellValueClick(Common.o.getObject(funcValue[1]), sRowCount, Integer.parseInt(valueSplit[1]), "single", "div");
                                        break;
                                    case "ELE":
                                        status = common.SafeAction(Common.o.getObject(ColName), "", ColName);
                                        break;
                                    case "ELJ":
                                        status = common.SafeAction(Common.o.getObject(ColName), "", ColName);
                                        break;
                                    case "EDT":
                                        status = common.SafeAction(Common.o.getObject(ColName), valueSplit[0], ColName);
                                        break;
                                    case "EDJ":
                                        status = common.SafeAction(Common.o.getObject(ColName), valueSplit[0], ColName);
                                        break;
                                    case "LSJ":
                                        status = common.SafeAction(Common.o.getObject(ColName), valueSplit[0], ColName);
                                        break;
                                    case "LST":
                                        status = common.SafeAction(Common.o.getObject(ColName), valueSplit[0], ColName);
                                        break;
                                }
                            }
                        }
                    }
                    if (!tcAvailable) {
                        logger.info("" + PCThreadCache.getInstance().getProperty("TCID") + " is not avilable in the " + funcValue[0] + "");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean FillCodeDetails(String sFuncValue) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        // Boolean Status = common.ClassComponent(Sheetname, o);
        Boolean status = true;
        Boolean tcAvailable = false;
        String[] funcValue = sFuncValue.split(":::");
        int sRowCount = 0;
        XlsxReader sXL = XlsxReader.getInstance();// new XlsxReader(
        // PCThreadCache.getInstance().getProperty("DataSheetName)

        int rowcount = sXL.getRowCount(funcValue[0]);
        for (int i = 2; i <= rowcount; i++) {
            String TCID = PCThreadCache.getInstance().getProperty("TCID");
            String Iteration = PCThreadCache.getInstance().getProperty("Iteration");
            String TCIDAdd = sXL.getCellData(funcValue[0], "ID", i);
            String TCIDIteration = sXL.getCellData(funcValue[0], "Iteration", i);
            if (TCIDAdd.equals(TCID) && TCIDIteration.equals(Iteration))
            // if(sXL.getCellData(funcValue[0], "ID",
            // i).equals(PCThreadCache.getInstance().getProperty("TCID")) &&
            // sXL.getCellData(funcValue[0], "Iteration",
            // i).contains(PCConstants.Iteration))
            {
                tcAvailable = true;
                int colcount = sXL.getColumnCount(funcValue[0]);
                for (int j = 2; j <= colcount; j++) {
                    String ColName = sXL.getCellData(funcValue[0], j, 1);

                    if (!ColName.isEmpty()) {
                        String elementType = ColName.substring(0, 3);
                        String value = sXL.getCellData(funcValue[0], j, i);
                        if (!(elementType.toUpperCase().contains("VAL")) && !value.equals("")) {
                            status = common.SafeAction(Common.o.getObject(ColName), value, ColName);
                        } else if (elementType.toUpperCase().contains("VAL")) {
                            String[] arrTbl = value.split(":::");
                            status = common.ElementExistOrNotTrue("Table existence", "Table should be displayed for Validating & selecting the Value", "Table is getting as expected to Select the Value", Common.o.getObject(arrTbl[0]));
                            status = common.ActionOnTable_JS(Common.o.getObject(arrTbl[0]), 1, 0, arrTbl[1], "a");
                        }
                    }
                }
            }
        }

        return status;
    }

    public static boolean TableCellValueClick(By id, int sRow, int sCol, String ActionClick, String sTagName) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        boolean Status = false;
        Actions objActions = new Actions(ManagerDriver.getInstance().getWebDriver());
        WebElement mytable = common.returnObject(id);
        List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
        sRow--;
        List<WebElement> Columns_row = rows_table.get(sRow).findElements(By.tagName("td"));
        Columns_row.get(sCol).getText();
        List<WebElement> CellElements = Columns_row.get(sCol).findElements(By.tagName(sTagName));
        for (WebElement element : CellElements) {
            switch (ActionClick) {
                case "single":
                    element.click();
                    Status = true;
                    break;
                case "double":
                    objActions.doubleClick(element).build().perform();
                    Status = true;
                    break;
            }
            break;
        }
        return Status;
    }

    public static Boolean coverageSheet(String strSheetName) {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        logger.info("Entering into coverage details function");
        Common common = CommonManager.getInstance().getCommon();
        Boolean status = true;
        Boolean checkBoxFound = false;
        String sChooseCoverage = null;
        String sCoverageName = null;
        String sFieldName = null;
        String sFieldValue = null;
        String strFieldType = null;
        String strTablePage = null;
        String strCoverageType = null;
        Boolean blnTableHeaderBody = false;
        String sRemoveCoverage = null;
        String currentCompoentName = PCThreadCache.getInstance().getProperty("methodName");

        int loop;
        XlsxReader xls = XlsxReader.getInstance();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.clear();
        whereConstraint.put(PCConstants.ID, tcID);
        whereConstraint.put(PCConstants.Iteration, PCThreadCache.getInstance().getProperty("Iteration"));
        whereConstraint.put("Component", currentCompoentName);
        resultListRows = xls.executeSelectQuery(strSheetName, whereConstraint);
        try {
            if (resultListRows.size() > 0) {
                Outer:
                for (HashMap<String, Object> processRow : resultListRows) {
                    loop = 0;
                    sChooseCoverage = (String) processRow.get("ChooseCoverage");
                    sRemoveCoverage = (String) processRow.get("RemoveCoverage");
                    sCoverageName = (String) processRow.get("Coverages");
                    strTablePage = (String) processRow.get("TablePage");
                    strCoverageType = (String) processRow.get("CoverageType");
                    if (!sCoverageName.equals("") && !(sCoverageName == null)) {
                        status = getCoverageNameID(sCoverageName);
                    }

                    if (!status) {
                        logger.info("" + sCoverageName + " is not present in the screen");
                        status = false;
                        break Outer;
                    }
                    if (sChooseCoverage.toUpperCase().equals("YES") && !sChooseCoverage.isEmpty()) {
                        checkBoxFound = selectCheckBoxUsingLabelName(sCoverageName);

                    }
                    if (sRemoveCoverage.toUpperCase().equals("YES")) {
                        status = RemoveCoverageSelected(sCoverageName);
                    }
                    for (int i = 1; i <= 10; i++) {
                        sFieldName = (String) processRow.get("Field" + i);
                        sFieldValue = (String) processRow.get("FieldValue" + i);
                        if (!(sFieldName == null) && !(sFieldValue == null) && !sFieldName.isEmpty() && !sFieldValue.isEmpty()) {
                            if (!(strCoverageType == null) && !(sCoverageName == null) && !strCoverageType.isEmpty() && !sCoverageName.isEmpty() && loop == 0) {
                                if (status) {
                                    blnTableHeaderBody = getCoverageTableHeader(sCoverageName, strCoverageType, PCThreadCache.getInstance().getProperty(PCConstants.CoverageID));
                                    loop = 1;
                                } else {
                                    logger.info("" + sCoverageName + " is not present in the screen for identifying the table");
                                    break Outer;
                                }
                            }
                            strFieldType = sFieldName.substring(sFieldName.length() - 3);
                            switch (strFieldType.toUpperCase()) {
                                case "TBL":
                                case "TBD":
                                case "TBA":
                                case "TBP":
                                case "RMV":
                                    if (blnTableHeaderBody) {
                                        status = coverageTableHandling(sFieldName, sFieldValue, sCoverageName, strTablePage);
                                    }
                                    break;
                                case "DEF":
                                    sFieldName = sFieldName.substring(0, sFieldName.length() - 3);
                                    status = common.SafeAction(Common.o.getObject(sFieldName), sFieldValue, sFieldName);
                                    break;
                                default:
                                    status = fillCoverage(sCoverageName, sFieldName, sFieldValue);
                                    break;
                            }
                            if (!status) {
                                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Coverage " + sCoverageName + " should be filled for the " + sFieldName + " field", "Error in the " + sCoverageName + " Coverage for the " + sFieldName + " field", "FAIL");
                                break Outer;
                            }
                        }
                    }
                }
            } else {
                logger.info("TestCaseID " + tcID + " or Iteration " + PCThreadCache.getInstance().getProperty("Iteration") + " is not available in the " + strSheetName + " Sheet");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "TestCaseID " + tcID + " and Iteration " + PCThreadCache.getInstance().getProperty("Iteration") + " should available in the " + strSheetName + " Sheet", "TestCaseID " + tcID + " or Iteration " + PCThreadCache.getInstance().getProperty("Iteration") + " is not available in the " + strSheetName + " Sheet", "FAIL");
                status = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * @param CoverageName
     * @param sFieldName
     * @param sFieldValue
     * @return true/false
     * @throws IOException
     * @function This will use to fill the fields of the particular coverage
     */
    public static Boolean fillCoverage(String CoverageName, String sFieldName, String sFieldValue) throws IOException {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        logger.info("Entering into fill the " + CoverageName + " fields");
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        Boolean status = false;
        Boolean sParenetLabel = false;
        Boolean sChildLabel = false;
        String sPCLabelValue = null;
        String sLabelID = null;
        String sLabelConcatListID = null;
        String sSplitFieldName = (String) sFieldName.substring(3);
        String sElementType = sFieldName.substring(0, 3);
        String sID = null;
        String[] sLabelIDSplit = null;
        String[] sSplit = null;
        String interanlID = null;
        try {
            List<WebElement> abcd = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
            Outer:
            for (WebElement sText : abcd) {
                String sElementText = sText.getText();
                System.out.println(sElementText);
                if (sElementText.equals(CoverageName)) {
                    sParenetLabel = true;
                    sID = sText.getAttribute("id");
                    sSplit = sID.split("-");
                    By sTargetID = By.id(sSplit[0]);
                    WebElement sTargetLegend = CommonManager.getInstance().getCommon().returnObject(sTargetID);
                    List<WebElement> sTargetLegendDiv = sTargetLegend.findElements(By.tagName("label"));
                    for (WebElement sLabel : sTargetLegendDiv) {
                        sPCLabelValue = (String) sLabel.getText();
                        // System.out.println("Excel Value is "+sSplitFieldName+" & length is
                        // "+sSplitFieldName.length());
                        // System.out.println("PC Value is "+sPCLabelValue+" & length is
                        // "+sPCLabelValue.length());
                        if (sSplitFieldName.toUpperCase().equals(sPCLabelValue.toUpperCase())) {
                            sChildLabel = true;
                            sLabelID = sLabel.getAttribute("id");
                            sLabelIDSplit = sLabelID.split("-");
                            sLabelConcatListID = sLabelIDSplit[0].concat("-inputEl");
                            try {
                                switch (sElementType.toUpperCase()) {
                                    case "LSJ":
                                        status = CommonManager.getInstance().getCommon().SafeAction(By.id(sLabelConcatListID), sFieldValue, sFieldName);
                                        status = SCRCommon.JavaScript(js);
                                        break;
                                    case "EDJ":
                                        status = CommonManager.getInstance().getCommon().SafeAction(By.id(sLabelConcatListID), sFieldValue, sFieldName);
                                        status = SCRCommon.JavaScript(js);
                                        break;
                                    case "LST":
                                        status = CommonManager.getInstance().getCommon().SafeAction(By.id(sLabelConcatListID), sFieldValue, sFieldName);
                                        status = SCRCommon.JavaScript(js);
                                        break;
                                    case "EDT":
                                        status = CommonManager.getInstance().getCommon().SafeAction(By.id(sLabelConcatListID), sFieldValue, sFieldName);
                                        break;
                                    case "CLR":
                                        status = CommonManager.getInstance().getCommon().SafeAction(By.id(sLabelConcatListID), sFieldValue, sFieldName);
                                        break;
                                    case "RDO":
                                        String getRdoID = getRadioButtonID(sLabelID, sFieldValue);
                                        status = CommonManager.getInstance().getCommon().SafeAction(By.id(getRdoID), sFieldValue, sFieldName);
                                        status = SCRCommon.JavaScript(js);
                                        break;
                                    case "BTN":
                                        interanlID = sSplit[0].concat(":CoverageSchedule:BP7ScheduleInputSet:BP7ScheduledItemsLV_tb:ToolbarButton-btnInnerEl");
                                        status = CommonManager.getInstance().getCommon().SafeAction(By.id(interanlID), sFieldValue, sFieldName);
                                        status = SCRCommon.JavaScript(js);
                                        break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (sChildLabel) {
                            break Outer;
                        }
                    }
                    if (!sChildLabel) {
                        logger.info("Unable to find the coverage field '" + sFieldName + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + sFieldName + "' Field should available in the '" + CoverageName + "' Coverage", "'" + sFieldName + "' Field is not available in the '" + CoverageName + "' Coverage", "FAIL");
                    }
                }
                /*
                 * if(sParenetLabel == true) { break; }
                 */
            }
            if (!sParenetLabel) {
                logger.info("Unable to find the coverage '" + sFieldName + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + CoverageName + "' Coverage should available in the system", "'" + CoverageName + "' Coverage is not available in the system", "FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sSplitFieldName = null;
            sLabelID = null;
            sLabelConcatListID = null;
            sElementType = null;
            sID = null;
            sLabelIDSplit = null;
            sSplit = null;
        }
        return status;
    }

    /**
     * @param sId
     * @param option
     * @return String
     * @function Convert the label id attribute into radio button id attribute
     */
    public static String getRadioButtonID(String sId, String option) {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        String radioID = null;
        String[] splitID = sId.split("-");
        switch (option.toUpperCase()) {
            case "YES":
                radioID = splitID[0].concat("_true-boxLabelEl");
                break;
            case "NO":
                radioID = splitID[0].concat("_false-boxLabelEl");
                break;
        }
        return radioID;
    }

    /**
     * @param sFuncValue
     * @return true/false
     * @throws IOException
     * @function This function will select the check box by using the label name
     */
    public static Boolean selectCheckBoxUsingLabelName(String sFuncValue) throws IOException {
        logger = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(), PCThreadCache.getInstance().getProperty("TCID"));
        Boolean status = false;
        Boolean sLabelFound = false;
        String getIDofLabel = null;
        String[] sSplitID = null;
        String actualID = null;
        String actualTblID = null;

        List<WebElement> abcd = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
        try {
            sLabelLoop:
            for (WebElement element : abcd) {
                String sElementText = element.getText();
                if (sElementText.equals(sFuncValue)) {
                    logger.info("" + sFuncValue + " label found in the Screen");
                    sLabelFound = true;
                    getIDofLabel = element.getAttribute("id");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageID, getIDofLabel);
                    sSplitID = getIDofLabel.split("-");
                    actualID = sSplitID[0].concat(":_checkbox");
                    actualTblID = sSplitID[0].concat("-legendChk");
                    try {
                        WebElement sCheckBox = CommonManager.getInstance().getCommon().returnObject(By.id(actualTblID));
                        String sClassName = sCheckBox.getAttribute("class");
                        if (sClassName.endsWith("x-form-cb-checked")) {
                            logger.info("Already Checkbox is selected." + sFuncValue + "");
                        } else {
                            status = CommonManager.getInstance().getCommon().SafeAction(By.id(actualID), "elj" + sFuncValue + "", "elj" + sFuncValue + "");
                            logger.info("Clicked the checkbox of " + sFuncValue + "");
                        }

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        logger.info("Unable to click the elj" + sFuncValue + " checkbox");
                        e.printStackTrace();
                    }
                }
                if (sLabelFound) {
                    break sLabelLoop;
                }
            }
            if (!sLabelFound) {
                logger.info("" + sFuncValue + " is not present in the Screen");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + sFuncValue + "' CheckBox should available in the system", "'" + sFuncValue + "' CheckBox is not available in the system", "FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getIDofLabel = null;
            sSplitID = null;
            actualID = null;
        }
        return status;
    }

    // code to iterate all the columns from the excelsheet using excel query
    /*
     * HashMap<String,Object> whereConstraint = new HashMap<String,Object>();
     * ArrayList<HashMap<String,Object>> resultListRows= new
     * ArrayList<HashMap<String,Object>>(); whereConstraint.put(PCConstants.ID,
     * PCThreadCache.getInstance().getProperty("TCID"));
     * whereConstraint.put("Coverage", sFuncValue); resultListRows =
     * sXL.executeSelectQuery("Coverages", whereConstraint);
     *
     * for (HashMap<String, Object> sProcessRow : resultListRows) { psProcessRow
     *
     * for (String key : sProcessRow.keySet()) { String getKeyValue =
     * (String)sProcessRow.get(key); System.out.println(key);
     * System.out.println(getKeyValue); } }
     */

    /**
     * @return boolean
     * @throws Exception
     * @function Function used to fill the Industry code or NAICS code details
     */
    public boolean FillIndustry_NAICSCodeDetails(String sFuncValue) throws Exception {
        Boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        String[] sValue = sFuncValue.split(":::");
        String[] sSetValue = sValue[1].split("@@");
        logger.info("Verifying the Results");
        String Value = null;
        switch (sValue[0].toUpperCase()) {
            case "INDUSTRY":
                status = common.SafeAction(Common.o.getObject("eleIndustryCodeSearch"), "elj", "elj");
                break;
            case "NAICS":
                status = common.SafeAction(Common.o.getObject("elePolicyInfo_NAICSSearch"), "elj", "elj");
                break;
            case "PREDOMINANT_CODE":
                status = common.SafeAction(Common.o.getObject("elePolicyInfo_PredominantClassCode"), "elj", "elj");
                break;
            /*
             * case "INSURED_INDUSTRY" : status=common.SafeAction(Common.o.getObject(
             * "eleSearchIndustryCodeInsured"), "elj", "elj"); break;
             */
        }
        // set values for code

        status = common.SafeAction(Common.o.getObject("edtIndustryCode"), sSetValue[0], "edtIndustryCode");
        if (!(sSetValue[1].equalsIgnoreCase("NULL"))) {
            status = common.SafeAction(Common.o.getObject("edtPolicyInfo_IndustryClassfication"), sSetValue[1], "edtPolicyInfo_IndustryClassfication");
        }
        // click on search
        status = common.SafeAction(Common.o.getObject("eljCommonSearch"), "elj", "elj");

        // Verify result table and set the code
        status = common.ElementExistOrNotTrue("Table existence", "Table should be displayed for Validating & selecting the Value", "Table is getting as expected to Select the Value", Common.o.getObject("eleIndustryCodeResultTbl"));
        if (!(sSetValue[0].isEmpty())) {
            status = common.ActionOnTable_JS(Common.o.getObject("eleIndustryCodeResultTbl"), 1, 0, sSetValue[0], "a");
        }

        return status;
    }

    /**
     * @return boolean
     * @throws Exception
     * @function Function used to fill the Industry code or NAICS code details
     */
    public boolean FillProducerCodeDetails(String sFuncValue) throws Exception {
        Boolean status = false;
        Common common = CommonManager.getInstance().getCommon();

        String[] sSetValue = sFuncValue.split(":::");
        logger.info("Verifying the Results");
        String Value = null;
        // set values for code
        status = common.SafeAction(Common.o.getObject("elePolicyInfo_ProducerCodeSearch"), "ele", "ele");
        status = common.SafeAction(Common.o.getObject("edtProducerCode"), sSetValue[0], "edtProducerCode");
        if (!(sSetValue[1].equalsIgnoreCase("NULL"))) {
            status = common.SafeAction(Common.o.getObject("edtPolicyInfo_AgencyNameProducerCode"), sSetValue[1], "edtPolicyInfo_AgencyNameProducerCode");
        }

        // click on search
        status = common.SafeAction(Common.o.getObject("eljCommonSearch"), "elj", "elj");

        // Verify result table and set the code
        status = common.ElementExistOrNotTrue("Table existence", "Table should be displayed for Validating & selecting the Value", "Producer Code search Result table dispalyed as expected", Common.o.getObject("elePCSearchResultsTable"));
        if (!(sSetValue[0].isEmpty())) {
            status = common.ActionOnTable_JS(Common.o.getObject("elePCSearchResultsTable"), 2, 0, sSetValue[0], "a");
        }

        return status;
    }

    /**
     * @return boolean
     * @throws Exception
     * @function Function used to fill the Industry code or NAICS code details
     */
    public boolean fillPredominatClasscode(String sFuncValue) throws Exception {
        Boolean status = false;
        Common common = CommonManager.getInstance().getCommon();

        String[] sSetValue = sFuncValue.split(":::");
        logger.info("Verifying the Results");
        String Value = null;
        // set values for code
        status = common.SafeAction(Common.o.getObject("elePolicyInfo_PredominantClassCode"), "ele", "ele");
        status = common.SafeAction(Common.o.getObject("edtPolicyInfo_PreClassCode_Popup"), sSetValue[0], "edtPolicyInfo_PreClassCode_Popup");

        // click on search
        /*
         * if(!(sSetValue[1].equalsIgnoreCase("NULL"))) { status=common.SafeAction
         * (Common.o.getObject("edtPolicyInfo_PreClassDesc_Popup"), sSetValue[1],
         * "edtPolicyInfo_PreClassDesc_Popup"); }
         */
        status = common.SafeAction(Common.o.getObject("eljCommonSearch"), "elj", "elj");

        // Verify result table and set the code
        status = common.ElementExistOrNotTrue("Table existence", "Table should be displayed for Validating & selecting the Value", "Predominant CLass code search Result table dispalyed as expected", Common.o.getObject("elePredominateSearchRes"));
        if (!(sSetValue[0].isEmpty())) {
            status = common.ActionOnTable_JS(Common.o.getObject("elePredominateSearchRes"), 1, 0, sSetValue[0], "a");
            if (status) {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether class code can be Added successfully", "As expected, class code had been selected", "PASS");
            } else {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether class code can be Added successfully", "Class code had not been selected", "FAIL");
            }
        }

        return status;
    }

    /**
     * @return
     * @throws Exception
     * @function it helps to handle the create account new button for dynamic
     */
    public boolean FillModifierDetails(String sFuncValue) throws Exception {
        Common common = CommonManager.getInstance().getCommon();
        // Boolean Status = common.ClassComponent(Sheetname, o);
        Boolean status = true;
        Boolean tcAvailable = false;
        JavascriptExecutor js = null;
        WebElement strCedit = null;
        String[] funcValue = sFuncValue.split(":::");
        int sRowCount = 0;
        XlsxReader sXL = XlsxReader.getInstance();// new XlsxReader(
        // PCThreadCache.getInstance().getProperty("DataSheetName)

        int rowcount = sXL.getRowCount("Modifiers");

        // hanlde modifer table find till row
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleModiferTable"));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int k = 0; k <= allrows.size() - 1; k++) {
            List<WebElement> Cells = allrows.get(k).findElements(By.tagName("td")); // get all tds

            WebElement strDivLabel = Cells.get(0).findElement(By.tagName("div")); // category - get all div
            // and loop & match with
            // label
            String readText = strDivLabel.getText(); // category
            // category
            breakXlRows:
            for (int i = 2; i <= rowcount; i++) // iterating to
            // find category
            // in excel
            {
                String TCID = PCThreadCache.getInstance().getProperty("TCID");
                String Iteration = PCThreadCache.getInstance().getProperty("Iteration");
                String TCIDAdd = sXL.getCellData(funcValue[0], "ID", i);
                String TCIDIteration = sXL.getCellData(funcValue[0], "Iteration", i);
                if (TCIDAdd.equals(TCID))
                // if(sXL.getCellData(funcValue[0], "ID",
                // i).equals(PCThreadCache.getInstance().getProperty("TCID")) &&
                // sXL.getCellData(funcValue[0], "Iteration",
                // i).contains(PCConstants.Iteration))
                {
                    tcAvailable = true;
                    int colcount = sXL.getColumnCount(funcValue[0]);
                    String strCategoryName = sXL.getCellData(funcValue[0], 2, i); // reading
                    // category name
                    if (readText.equalsIgnoreCase(strCategoryName)) {
                        Boolean CategryMatch = true;
                        System.out.println(strCategoryName);
                        for (int j = 3; j < colcount; j++) {
                            String xlValue = sXL.getCellData(funcValue[0], j, i);
                            String xlColName = sXL.getCellData(funcValue[0], j, 1); // column headers
                            if (!(xlValue.isEmpty())) {
                                // Thread.sleep(5000);
                                if (xlColName.equals("Justification")) {
                                    break;
                                } else if (xlColName.equals("CreditDebit")) {
                                    // strCedit =
                                    // Cells.get(3).findElement(By.tagName("div"));
                                    // status=DataWebTable(Common.o.getObject("eleModiferTable"),
                                    // k+1, 3, readText, "single", "div");
                                    status = common.ActionOnTable(Common.o.getObject("eleModiferTable"), 0, 3, readText, "div");

                                    // common.WaitForElementExist(By.tagName("div"),
                                    // Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
                                    // strCedit.click();
                                    // strCedit.clear();
                                    // strCedit.sendKeys(xlValue);
                                    //
                                }

                                // WebElement strCedit =
                                // Cells.get(4).findElement(By.tagName("div"));

                                // JavaScript(js);
                                // Boolean abc=new WebDriverWait(
                                // ManagerDriver.getInstance().getWebDriver(),
                                // 30).until(ExpectedConditions.stalenessOf(strCedit));

                                WebElement ele = ManagerDriver.getInstance().getWebDriver().findElement(By.name(xlColName));
                                ele.clear();
                                ele.sendKeys(xlValue);
                            }

                        }
                        if (CategryMatch) {
                            break breakXlRows;
                        }

                    }

                }
            }
        }
        return status;
    }

    /**
     * @return boolean
     * @throws Exception
     * @function Function used to fill the Industry code or NAICS code details
     */

    public static boolean addCoverages(String sFuncValue) throws Exception {
        logger.info("Entering into Add Coverages  Common function");
        Boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        String sCoverageComponentName = null;
        String sTabName = null;
        String[] arrSheetTabName = null;
        Boolean tcAvailable = false;
        String TCID = null;
        String TCIDAdd = null;
        int iPos = 0;
        String[] arrCoverageName = null;
        String currentCompoentName = PCThreadCache.getInstance().getProperty("methodName");
        arrSheetTabName = sFuncValue.split("_");
        int rowcount;
        String sCovAvailablity = null;

        XlsxReader sXL = XlsxReader.getInstance();
        rowcount = sXL.getRowCount(arrSheetTabName[0]);
        for (int i = 2; i <= rowcount; i++) {
            TCID = PCThreadCache.getInstance().getProperty("TCID");
            TCIDAdd = sXL.getCellData(arrSheetTabName[0], "ID", i);
            sCoverageComponentName = sXL.getCellData(arrSheetTabName[0], "Component", i);
            sTabName = sXL.getCellData(arrSheetTabName[0], "CoverageTab", i);

            String Iteration = PCThreadCache.getInstance().getProperty("Iteration");
            String TCIDIteration = sXL.getCellData(arrSheetTabName[0], "Iteration", i);
            // Checking for Testcases ID, Component Name , TabNaem and Iteration
            if (TCIDAdd.equals(TCID) && currentCompoentName.equals(sCoverageComponentName) && arrSheetTabName[1].equalsIgnoreCase(sTabName) && Iteration.equalsIgnoreCase(TCIDIteration)) {
                tcAvailable = true;
                int colcount = sXL.getColumnCount(arrSheetTabName[0]);
                for (int j = 3; j <= colcount; j++) {
                    String sCellValue = sXL.getCellData(arrSheetTabName[0], j, i);
                    if (!sCellValue.isEmpty()) {
                        String sColunmName = sXL.getCellData(arrSheetTabName[0], j, 1);
                        String sCategoryName = sXL.getCellData(arrSheetTabName[0], 5, i);
                        sCovAvailablity = sXL.getCellData(arrSheetTabName[0], "CoverageAvailablity", i);
                        String sElementType = sColunmName.substring(0, 3);
                        switch (sElementType.toUpperCase()) {
                            case "ELE":
                            case "LST":
                                status = common.SafeAction(Common.o.getObject(sColunmName), sCellValue, sColunmName);
                                break;
                            case "EDT":
                                if (sColunmName.equalsIgnoreCase("edtSearchCoverageName")) {
                                    iPos = sCellValue.indexOf(":::");
                                    if (iPos > 0) {
                                        arrCoverageName = sCellValue.split(":::");
                                    }
                                } else {
                                    status = common.SafeAction(Common.o.getObject(sColunmName), sCellValue, sColunmName);
                                }
                                break;
                            case "FUN":
                                if (sColunmName.equalsIgnoreCase("funSearchAndSelectCoverage")) {
                                    status = SearchAndSelectCoverage(sCellValue, sCovAvailablity);

                                } else if (sColunmName.equalsIgnoreCase("funValidateAddedCoverage")) {
                                    status = ValidateAddedCoverage(sCellValue, sCategoryName);
                                }
                                break;
                            case "RDO":
                                if (sCellValue.equalsIgnoreCase("CONDITION")) {
                                    status = common.SafeAction(Common.o.getObject("eleType_Condition"), "", "eleType_Condition");
                                } else if (sCellValue.equalsIgnoreCase("EXCLUSION")) {
                                    status = common.SafeAction(Common.o.getObject("eleType_Exclusion"), "", "eleType_Exclusion");

                                } else if (sCellValue.equalsIgnoreCase("EXLCUSION AND CONDITION")) {
                                    status = common.SafeAction(Common.o.getObject("eleType_Excl_Condition"), "", "eleType_Excl_Condition");

                                }
                                break;
                            default:
                                logger.info("none of case matches");
                        }
                    }
                }
            }
        }
        if (tcAvailable == false) {
            logger.info("TC ID not avaialble insheet");
        }
        return status;
    }

    /**
     * Function added to search and select the coverage
     *
     * @param sCellValue
     * @return boolean
     */
    private static Boolean SearchAndSelectCoverage(String sCellValue, String covAvail) {

        boolean status = false;
        boolean blnCoveragefound = false;
        String[] arrCoverageName = null;
        String sUICoverageName = null;
        String sCountObject = null;
        String intValue = null;
        int intRowCnt = 0;
        int Counter = 1;
        Common common = CommonManager.getInstance().getCommon();

        arrCoverageName = sCellValue.split(":::");
        try {
            if (arrCoverageName.length == 1) {
                status = common.SafeAction(Common.o.getObject("edtSearchCoverageName"), arrCoverageName[0], "edtSearchCoverageName");
                status = common.SafeAction(Common.o.getObject("eleTerritory_SearchBtn"), "ele", "eleSearchButton");
                intRowCnt = TableRowCount(Common.o.getObject("eleSearch_CovResultTbl"));
                if (intRowCnt > 0) {
                    arrCoverageName[0] = arrCoverageName[0].trim().replaceAll(" +", " ");
                    //status = common.ActionOnTable_Equals(Common.o.getObject("eleSearch_CovResultTbl"), 1, 0, arrCoverageName[0], "img");
                    status = common.ActionOnTable_Equals(Common.o.getObject("eleSearch_CovResultTbl"), 1, 0, arrCoverageName[0], "img");
                    status = common.SafeAction(Common.o.getObject("eleSearch_AddSelectedCovBtn"), "ele", "eleSearch_AddSelectedCovBtn");
                } else if (intRowCnt == 0 && covAvail.equalsIgnoreCase("NO")) {
                    logger.info("As expected coverage is not available to Add");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether Coverage can be Added successfully", "As expected,Coverage - " + arrCoverageName[0] + " is not available to add", "PASS");
                    status = common.SafeAction(Common.o.getObject("eleReturnToLink"), "ele", "eleReturnToLink");
                } else {
                    logger.info("No records found for the search result");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether Coverage can be Added successfully", "Coverage - " + arrCoverageName[0] + " is not available to add", "FAIL");
                    status = common.SafeAction(Common.o.getObject("eleReturnToLink"), "ele", "eleReturnToLink");
                }
            } else {
                for (String sCovName : arrCoverageName) {
                    blnCoveragefound = false;
                    // int
                    // size=common.ElementSize(Common.o.getObject("eljNextDisabled"));

                    sCountObject = common.ReadElement(Common.o.getObject("elePageNumber"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
                    // String sCount =
                    // sCountObject.substring(sCountObject.length()-2);

                    intValue = sCountObject.replaceAll("[^0-9]", "");
                    brkWhile:
                    while (Counter < Integer.parseInt(intValue)) // until
                    // next
                    // button
                    // is
                    // diabled
                    {
                        intRowCnt = SCRCommon.TableRowCount(Common.o.getObject("eleSearch_CovResultTbl"));
                        for (int i = 0; i < intRowCnt; i++) {
                            sUICoverageName = common.GetTextFromTable(Common.o.getObject("eleSearch_CovResultTbl"), i, 1);
                            if (sUICoverageName.equals(sCovName)) {
                                blnCoveragefound = true;
                                logger.info("Expected coverage is displayed on Screen " + sCovName);
                                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify the provided coverage is available in Search Results to select and Add. Coverage to be selected '" + sCovName + "'", "Expected Coverage is displayed on screen", "PASS");
                                status = common.ActionOnTable(Common.o.getObject("eleSearch_CovResultTbl"), 1, 0, sCovName, "img");
                            }
                            if (blnCoveragefound) {
                                break brkWhile; // while
                            }
                        }

                        status = common.SafeAction(Common.o.getObject("eljAddCovNext"), "elj", "elj");
                    }
                }
                // Click on add coverga
                status = common.SafeAction(Common.o.getObject("eleSearch_AddSelectedCovBtn"), "ele", "eleSearch_AddSelectedCovBtn");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return status;

    }

    /**
     * Function used to validate the added covergaes in main screen
     *
     * @param sFunValue
     * @param sCategoryName
     * @return boolean
     */

    private static boolean ValidateAddedCoverage(String sFunValue, String sCategoryName) {

        boolean status = false;
        boolean blnDefaultVal = false;
        WebElement abcd = null;
        List<WebElement> eleCov = null;
        String sElementText = null;
        try {

            switch (sCategoryName.toUpperCase()) {
                case "LINE EXCLUSIONS":
                case "LINE LIABILITY EXCLUSION":
                case "LINE PROPERTY EXCLUSION":
                    abcd = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleAddtnlExclusionSection"));
                    break;
                case "LINE CONDITIONS":
                case "LINE LIABILITY CONDITION":
                case "LINE PROPERTY CONDITION":
                    abcd = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleCoverages")); // dimmy
                    // code
                    break;
                case "LINE LIABILITY EXCLUSION - UMBRELLA":
                    abcd = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleCoverages")); // dummy
                    // code
                    break;
                case "LINE LIABILITY CONDITION - UMBRELLA":
                    abcd = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleCoverages"));
                    break;
                default:
                    eleCov = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
                    blnDefaultVal = true;
                    break;
            }
            if (!blnDefaultVal) {
                List<WebElement> sFieldSet = abcd.findElements(By.tagName("fieldset"));
                Outer:
                for (WebElement sField : sFieldSet) {
                    String fieldsetId = sField.getAttribute("id");
                    String sLabelConcatListID = fieldsetId.concat("-legendTitle");
                    WebElement sTargetFielset = CommonManager.getInstance().getCommon().returnObject(By.id(sLabelConcatListID));
                    sElementText = sTargetFielset.getText();
                    if (sElementText.equals(sFunValue)) {
                        // logger.info("Expected coverage is displayed in Screen "
                        // +sElementText);
                        // HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"),
                        // PCThreadCache.getInstance().getProperty("methodName"),
                        // "Validate the Added coverage/Exclusion/Condition displayed on UI. Actual
                        // Coverage available in UI is '"
                        // + sElementText +
                        // "'","Expected Coverage is displayed on screen",
                        // "PASS");
                        status = true;
                        break Outer;
                    }

                }
            } else {
                Outer:
                for (WebElement sText : eleCov) {
                    sElementText = sText.getText();
                    if (sElementText.equals(sFunValue)) {
                        logger.info("Expected coverage is displayed in Screen " + sElementText);
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate the Added coverage/Exclusion/Condition displayed on UI. Actual Coverage available in UI is '" + sElementText + "'", "Expected Coverage is displayed on screen", "PASS");
                        status = true;
                        break Outer;
                    }
                }
            }

            if (!status) {
                logger.info("Expected coverage is NOT displayed on Screen " + sFunValue);
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate the Added coverage/Exclusion/Condition displayed on UI. Coverage to be displayed '" + sFunValue + "'", "Expected Coverage is NOT displayed on screen", "FAIL");
            } else {
                logger.info("Expected coverage is displayed in Screen " + sElementText);
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate the Added coverage/Exclusion/Condition displayed on UI. Actual Coverage available in UI is '" + sElementText + "'", "Expected Coverage is displayed on screen", "PASS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        abcd = null;
        return status;

    }

    public static boolean Modifiers(String sheetName) {
        logger.info("Entering into Modifiers ");
        String arg = sheetName;

        sheetName = sheetName.split(":::")[0];

        Common common = CommonManager.getInstance().getCommon();

        XlsxReader sXL = XlsxReader.getInstance();
        Boolean status = false;
        Boolean tcAvailable = false;
        String TCID = null;
        String TCIDAdd = null;
        String sCategory = null;
        String sFieldName = null;
        String sFieldValue = null;
        String sIteration = null;
        int rowcount;
        try {
            rowcount = sXL.getRowCount(sheetName);
            Outer:
            for (int i = 2; i <= rowcount; i++) {
                TCID = PCThreadCache.getInstance().getProperty("TCID");
                TCIDAdd = sXL.getCellData(sheetName, "ID", i);
                sIteration = sXL.getCellData(sheetName, "Iteration", i);
                if (TCIDAdd.equals(TCID) && sIteration.equalsIgnoreCase(PCThreadCache.getInstance().getProperty(PCConstants.Iteration))) {
                    tcAvailable = true;
                    int colcount = sXL.getColumnCount(sheetName);
                    sCategory = sXL.getCellData(sheetName, "Category", i);
                    for (int j = 2; j <= colcount; j++) {

                        sFieldValue = sXL.getCellData(sheetName, j, i);
                        sFieldName = sXL.getCellData(sheetName, j, 1);
                        if (!sFieldName.isEmpty() && !sFieldValue.isEmpty() && !sFieldName.equalsIgnoreCase("Category")) {
                            String ratingTable = sFieldName.substring(3);

                            switch (ratingTable.toUpperCase()) {
                                case "CREDIT(-)/DEBIT(+)":
                                case "MINIMUM":
                                    if (arg.contains("Verify")) {
                                        status = VerifyModifierDetails(sCategory, sFieldName, sFieldValue);
                                    } else
                                        status = ModifierDetails(sCategory, sFieldName, sFieldValue);
                                    break;
                                case "MAXIMUM":
                                    if (arg.contains("Verify")) {
                                        status = VerifyModifierDetails(sCategory, sFieldName, sFieldValue);
                                    } else
                                        status = ModifierDetails(sCategory, sFieldName, sFieldValue);
                                    break;
                                case "GRADING(S, I OR A)":
                                    if (arg.contains("Verify")) {
                                        status = VerifyModifierDetails(sCategory, sFieldName, sFieldValue);
                                    } else
                                        status = ModifierDetails(sCategory, sFieldName, sFieldValue);
                                    break;
                                case "JUSTIFICATION":
                                    status = ModifierDetails(sCategory, sFieldName, sFieldValue);
                                    break;
                                case "GetRatingTable": // yet to write code
                                    if (!(sFieldValue.isEmpty())) {
                                        status = common.coverageFunctionCall(sFieldName, sFieldValue);
                                    }

                                default:
                                    status = common.SafeAction(Common.o.getObject(sFieldName), sFieldValue, sFieldName);
                                    break;
                            }
                        }
                    }
                    if (!status) {
                        break Outer;
                    }
                }
            }
            if (!tcAvailable) {
                logger.info("" + TCID + " is not available in the " + sheetName + " Sheet");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + TCID + " should avilable in the " + sheetName + "", "" + TCID + " is not avilable in the " + sheetName + "", "FAIL");
            } else if (!status) {
                logger.info("Problem in filling the " + sCategory + " Coverage");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TCID = null;
            TCIDAdd = null;
            sCategory = null;
            sFieldName = null;
            sFieldValue = null;
        }
        return status;
    }

    /**
     * @return true/false
     * @throws Exception
     * @function Use to iterate scheduleRating DateSheet
     */
    public static boolean scheduleRating(String sheetName) {
        logger.info("Entering into Schedule Rating ");
        Common common = CommonManager.getInstance().getCommon();
        XlsxReader sXL = XlsxReader.getInstance();
        Boolean status = false;
        Boolean tcAvailable = false;
        String TCID = null;
        String TCIDAdd = null;
        String sCategory = null;
        String sFieldName = null;
        String sFieldValue = null;
        String sIteration = null;
        String ratingTable = null;
        int rowcount;
        int colcount;
        try {
            rowcount = sXL.getRowCount(sheetName);
            Outer:
            for (int i = 2; i <= rowcount; i++) {
                TCID = PCThreadCache.getInstance().getProperty("TCID");
                TCIDAdd = sXL.getCellData(sheetName, "ID", i);
                sIteration = sXL.getCellData(sheetName, "Iteration", i);
                if (TCIDAdd.equals(TCID) && sIteration.equalsIgnoreCase(PCThreadCache.getInstance().getProperty(PCConstants.Iteration))) {
                    tcAvailable = true;
                    colcount = sXL.getColumnCount(sheetName);
                    sCategory = sXL.getCellData(sheetName, "Category", i);
                    for (int j = 2; j <= colcount; j++) {
                        sFieldValue = sXL.getCellData(sheetName, j, i);
                        sFieldName = sXL.getCellData(sheetName, j, 1);
                        if (!sFieldName.isEmpty() && !sFieldValue.isEmpty() && !sFieldName.equalsIgnoreCase("Category")) {
                            ratingTable = sFieldName.substring(3);
                            switch (ratingTable.toUpperCase()) {
                                case "CREDIT(-)/DEBIT(+)":
                                case "JUSTIFICATION":
                                    status = fillScheduleRating(sCategory, sFieldName, sFieldValue);
                                    break;
                                default:
                                    status = common.SafeAction(Common.o.getObject(sFieldName), sFieldValue, sFieldName);
                                    break;

                            }
                            if (sFieldName.equalsIgnoreCase("eljCommonOk")) {
                                System.out.println(sFieldName);
                            }
                        }
                    }
                    if (!status) {
                        break Outer;
                    }
                }
            }
            if (!tcAvailable) {
                logger.info("" + TCID + " is not available in the " + sheetName + " Sheet");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + TCID + " should avilable in the " + sheetName + "", "" + TCID + " is not avilable in the " + sheetName + "", "FAIL");
            } else if (!status) {
                logger.info("Problem in filling the " + sCategory + " Coverage");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TCID = null;
            TCIDAdd = null;
            sCategory = null;
            sFieldName = null;
            sFieldValue = null;
            ratingTable = null;
        }
        return status;
    }

    /**
     * This function use to fill the data for Schedule Mod Justification table
     *
     * @param sCateGoryName
     * @param sFieldName
     * @param sFieldValue
     * @return
     * @throws Exception
     */
    public static Boolean fillScheduleRating(String sCateGoryName, String sFieldName, String sFieldValue) {
        logger.info("Entering into filling the schedule rating");
        Common common = CommonManager.getInstance().getCommon();
        boolean SearchString = false;
        boolean Status = false;
        WebElement mytable = null;
        List<WebElement> rows_table = null;
        List<WebElement> CellElements = null;
        String sElement = null;
        List<WebElement> Columns_row = null;
        String getCategoryName = null;
        try {
            mytable = common.returnObject(Common.o.getObject("eleScheduleRateTbl"));
            rows_table = mytable.findElements(By.tagName("tr"));
            sElement = sFieldName.substring(3);
            Outer:
            for (int i = 1; i < rows_table.size(); i++) {
                Columns_row = rows_table.get(i).findElements(By.tagName("td"));
                getCategoryName = Columns_row.get(0).getText();
                if (getCategoryName.equalsIgnoreCase(sCateGoryName)) {
                    logger.info("" + sCateGoryName + " is available in the rating table");
                    SearchString = true;
                    switch (sElement.toUpperCase()) {
                        case "CREDIT(-)/DEBIT(+)":
                            CellElements = Columns_row.get(3).findElements(By.tagName("div"));
                            for (WebElement element : CellElements) {
                                element.click();
                                Status = common.SafeAction(Common.o.getObject(sFieldName), sFieldValue, sFieldName);
                                Status = common.SafeAction(Common.o.getObject("eleScheduleRatingTitle"), "", "eleScheduleRatingTitle");
                            }
                            break;
                        case "JUSTIFICATION":
                            CellElements = Columns_row.get(4).findElements(By.tagName("div"));
                            for (WebElement element : CellElements) {
                                element.click();
                                Status = common.SafeAction(Common.o.getObject(sFieldName), sFieldValue, sFieldName);
                                Status = common.SafeAction(Common.o.getObject("eleScheduleRatingTitle"), "", "eleScheduleRatingTitle");
                            }
                            break;
                    }
                }
                if (SearchString) {
                    break Outer;
                }
            }
            if (!SearchString || !Status) {
                logger.info("" + sCateGoryName + " is not available in the rating table");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + sCateGoryName + "' should available in the Schedule Mod Justification", "'" + sCateGoryName + "' is not available in the Schedule Mod Justification", "FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mytable = null;
            rows_table = null;
            CellElements = null;
            sElement = null;
            Columns_row = null;
            getCategoryName = null;
        }
        return Status;
    }

    /**
     * @return true/false
     * @throws Exception
     * @function Use to iterate scheduleRating DateSheet
     * @author Sojan
     */
    public static boolean tableHandling(String sheetName, String tablePathLocator, String eleColumnSearchLocator, String pageElement) {
        logger.info("Entering into Table Function");
        Common common = CommonManager.getInstance().getCommon();
        XlsxReader sXL = XlsxReader.getInstance();
        Boolean blnStatus = false;
        Boolean blnTcAvailable = false;
        String strTCID = null;
        String strTCIDAdd = null;
        String strCategory = null;
        String strFieldName = null;
        String strFieldValue = null;
        String strIteration = null;
        String strTableObject = null;
        String strFunctionName = null;
        int intRowCount;
        int intColCount;
        int intTblColCount;
        int intTblRowCount;
        try {
            intRowCount = sXL.getRowCount(sheetName);
            Outer:
            for (int i = 2; i <= intRowCount; i++) {
                strTCID = PCThreadCache.getInstance().getProperty("TCID");
                strTCIDAdd = sXL.getCellData(sheetName, "ID", i);
                strIteration = sXL.getCellData(sheetName, "Iteration", i);
                if (strTCIDAdd.equals(strTCID) && strIteration.equalsIgnoreCase(PCThreadCache.getInstance().getProperty(PCConstants.Iteration))) {
                    blnTcAvailable = true;
                    intColCount = sXL.getColumnCount(sheetName);
                    for (int j = 2; j <= intColCount; j++) {

                        strFieldValue = sXL.getCellData(sheetName, j, i);
                        strFieldName = sXL.getCellData(sheetName, j, 1);
                        if (!strFieldName.isEmpty() && !strFieldValue.isEmpty()) {
                            // strRatingTable = strFieldName.substring(3);
                            strTableObject = strFieldName.substring(strFieldName.length() - 3);
                            switch (strTableObject.toUpperCase()) {
                                case "TBD":
                                    intTblColCount = getTableHeaderColumn(strFieldName, eleColumnSearchLocator);
                                    intTblRowCount = getTableRowCount(tablePathLocator);
                                    if (intTblColCount >= 1 && intTblRowCount >= 1) {

                                        blnStatus = clickTableCell(tablePathLocator, intTblRowCount, intTblColCount, "Single", "div");
                                        blnStatus = common.SafeAction(Common.o.getObject(strFieldName), strFieldValue, strFieldName);
                                        blnStatus = common.SafeAction(Common.o.getObject(pageElement), pageElement, pageElement);
                                    }
                                    break;
                                case "TBA":
                                    intTblColCount = getTableHeaderColumn(strFieldName, eleColumnSearchLocator);
                                    intTblRowCount = getTableRowCount(tablePathLocator);
                                    if (intTblColCount >= 1 && intTblRowCount >= 1) {
                                        blnStatus = clickTableCell(tablePathLocator, intTblRowCount, intTblColCount, "Single", "a");
                                    }
                                    break;
                                case "TBP":
                                    intTblColCount = getTableHeaderColumn(strFieldName, eleColumnSearchLocator);
                                    intTblRowCount = getTableRowCount(tablePathLocator);
                                    if (intTblColCount >= 1 && intTblRowCount >= 1) {
                                        blnStatus = clickTableCell(tablePathLocator, intTblRowCount, intTblColCount, "Single", "div");
                                        blnStatus = common.SafeAction(Common.o.getObject(strFieldName), strFieldValue, strFieldName);
                                        // blnStatus =
                                        // common.SafeAction(Common.o.getObject(pageElement),
                                        // pageElement, pageElement);
                                    }
                                    break;
                                case "RMV":
                                    intTblColCount = getTableHeaderColumn(strFieldName, eleColumnSearchLocator);
                                    blnStatus = SCRCommon.selectTableRowToRemove(intTblColCount, tablePathLocator, strFieldValue);
                                    // blnStatus =
                                    // common.SafeAction(Common.o.getObject(strFieldName),
                                    // strFieldValue, strFieldName);
                                    break;
                                case "TBI":
                                    intTblColCount = getTableHeaderColumn(strFieldName, eleColumnSearchLocator);
                                    intTblRowCount = getTableRowCount(tablePathLocator);
                                    if (intTblColCount >= 1 && intTblRowCount >= 1) {

                                        blnStatus = clickTableCell(tablePathLocator, intTblRowCount, intTblColCount, "Single", "img");
                                        blnStatus = common.SafeAction(Common.o.getObject(pageElement), pageElement, pageElement);
                                    }
                                    break;
                                case "TBF":
                                    strFunctionName = strFieldName.substring(0, strFieldName.length() - 3);
                                    blnStatus = common.coverageFunctionCall(strFunctionName, strFieldValue);
                                    break;
                                default:
                                    blnStatus = common.SafeAction(Common.o.getObject(strFieldName), strFieldValue, strFieldName);
                                    break;
                            }
                        }
                    }
                    if (!blnStatus) {
                        break Outer;
                    }
                }
            }
            if (!blnTcAvailable) {
                logger.info("'" + strTCID + "' TCID or '" + PCThreadCache.getInstance().getProperty(PCConstants.Iteration) + "' IterationNo is not available in the " + sheetName + " Sheet");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + strTCID + "' TCID and '" + PCThreadCache.getInstance().getProperty(PCConstants.Iteration) + "' IterationNo should avilable in the " + sheetName + "", "'" + strTCID + "' TCID or '" + PCThreadCache.getInstance().getProperty(PCConstants.Iteration) + "' IterationNo is not avilable in the " + sheetName + "", "FAIL");
            } else if (!blnStatus) {
                logger.info("Problem in filling the " + strCategory + " Coverage");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        strTCID = null;
        strTCIDAdd = null;
        strCategory = null;
        strFieldName = null;
        strFieldValue = null;
        // strRatingTable =null;
        strTableObject = null;
        return blnStatus;
    }

    public static Boolean selectTableRowToRemove(int intColumnNumber, String tblBodyLocator, String strSearchString) {
        Boolean blnStatus = false;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(tblBodyLocator));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(intColumnNumber).getText();
            if (readText.equals(strSearchString)) {
                blnStatus = true;
                Cells.get(0).click();
                break;
            }
        }
        if (!blnStatus) {
            logger.info("Remove table value " + strSearchString + " is not available in the table");
        }
        return blnStatus;
    }

    public static Boolean ModifierDetails(String sCateGoryName, String sFieldName, String sFieldValue) throws Exception {
        logger.info("Entering into filling the modifier details");
        Common common = CommonManager.getInstance().getCommon();
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        boolean SearchString = false;
        boolean Status = false;
        WebElement mytable = common.returnObject(Common.o.getObject("eleModifierTbl"));
        List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
        String sElement = sFieldName.substring(3);
        Outer:
        for (int i = 1; i < rows_table.size(); i++) {
            List<WebElement> Columns_row = rows_table.get(i).findElements(By.tagName("td"));
            String getCategoryName = Columns_row.get(0).getText();
            if (getCategoryName.equalsIgnoreCase(sCateGoryName)) {
                SearchString = true;
                List<WebElement> CellElements = null;
                Status = SCRCommon.JavaScript(js);
                Status = common.SafeAction(Common.o.getObject("eleModifierTitle"), "", "eleModifierTitle");
                Status = SCRCommon.JavaScript(js);
                switch (sElement.toUpperCase()) {
                    case "CREDIT(-)/DEBIT(+)":
                        CellElements = Columns_row.get(3).findElements(By.tagName("div"));
                        for (WebElement element : CellElements) {
                            element.click();
                            Status = common.SafeAction(Common.o.getObject(sFieldName), sFieldValue, sFieldName);
                            Status = common.SafeAction(Common.o.getObject("eleModifierTitle"), "", "eleModifierTitle");
                        }
                        break;
                    case "JUSTIFICATION":
                        CellElements = Columns_row.get(4).findElements(By.tagName("div"));
                        for (WebElement element : CellElements) {
                            element.click();
                            Status = common.SafeAction(Common.o.getObject(sFieldName), sFieldValue, sFieldName);
                            Status = common.SafeAction(Common.o.getObject("eleModifierTitle"), "", "eleModifierTitle");
                        }
                        break;
                }
            }
            if (SearchString) {
                logger.info("Entered " + sElement + " in " + sFieldName + " for Category: " + sCateGoryName);
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should enter '" + sFieldValue + "' in " + sElement + " for Category: " + sCateGoryName, "Value entered '" + sFieldValue + "' in " + sElement + " for Category: " + sCateGoryName, "PASS");
                break Outer;
            }
        }
        if (!SearchString || !Status) {
            logger.info("" + sCateGoryName + " is not available in the rating table");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + sCateGoryName + "' should available in the Schedule Mod Justification", "'" + sCateGoryName + "' is not available in the Schedule Mod Justification", "FAIL");
        }
        return Status;
    }

    public static Boolean VerifyModifierDetails(String sCateGoryName, String sFieldName, String sFieldValue) throws Exception {
        // logger.info("Entering into filling the modifier details");
        Common common = CommonManager.getInstance().getCommon();
        boolean SearchString = false;

        WebElement mytable = common.returnObject(Common.o.getObject("eleModifierTbl"));
        List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
        String sElement = sFieldName.substring(3);
        Outer:
        for (int i = 1; i < rows_table.size(); i++) {
            List<WebElement> Columns_row = rows_table.get(i).findElements(By.tagName("td"));
            String getCategoryName = Columns_row.get(0).getText();
            if (getCategoryName.equalsIgnoreCase(sCateGoryName)) {
                SearchString = false;
                String CellText = null;
                switch (sElement.toUpperCase()) {
                    case "CREDIT(-)/DEBIT(+)":
                        CellText = Columns_row.get(3).getText();
                        if (CellText.equalsIgnoreCase(sFieldValue)) {
                            SearchString = true;
                        }
                        break;
                    case "JUSTIFICATION":
                        CellText = Columns_row.get(4).getText();
                        if (CellText.equalsIgnoreCase(sFieldValue)) {
                            SearchString = true;
                        }
                        break;
                    case "MINIMUM":
                        CellText = Columns_row.get(1).getText();
                        if (CellText.equalsIgnoreCase(sFieldValue)) {
                            SearchString = true;
                        }
                        break;
                    case "MAXIMUM":
                        CellText = Columns_row.get(2).getText();
                        if (CellText.equalsIgnoreCase(sFieldValue)) {
                            SearchString = true;
                        }
                        break;
                    case "GRADING(S, I OR A)":
                        CellText = Columns_row.get(5).getText();
                        if (CellText.equalsIgnoreCase(sFieldValue)) {
                            SearchString = true;
                        }
                }
            }
            if (SearchString) {
                logger.info(sElement + " for Category: " + sCateGoryName + "displayed as expected. '" + sFieldValue + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should validate value displayed in " + sElement + " for Category: " + sCateGoryName + " as : '" + sFieldValue + "'", "Value displayed as '" + sFieldValue + "' in " + sFieldName + " for Category: " + sCateGoryName, "PASS");
                break Outer;

            }
        }
        if (!SearchString) {
            logger.info("Incorrect Value displayed for " + sCateGoryName + " in the rating table");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), sElement + " for '" + sCateGoryName + "' should be " + sFieldValue, sElement + " for " + "'" + sCateGoryName + "' is not " + sFieldValue, "FAIL");
        }
        return SearchString;
    }

    public static Boolean selectCoverageTableRowToRemove(int intColumnNumber, String tblBodyLocator, String strSearchString) {
        Boolean blnStatus = false;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(By.id(tblBodyLocator));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(intColumnNumber).getText();
            if (readText.equals(strSearchString)) {
                blnStatus = true;
                Cells.get(0).click();
                break;
            }
        }
        if (!blnStatus) {
            logger.info("Remove table value " + strSearchString + " is not available in the table");
        }
        return blnStatus;
    }

    public static int getTableHeaderColumn(String sHeaderName, String strObjectName) throws IOException {
        Common common = CommonManager.getInstance().getCommon();
        boolean blnSearchString = false;
        String strTableHeader = null;
        String splitHeader = null;
        String exactHeader = null;
        String strHeaderName[] = null;
        WebElement mytable = common.returnObject(Common.o.getObject(strObjectName));
        List<WebElement> rows_table = mytable.findElements(By.tagName("span"));
        int intHeaderColumn = 0;
        int intEmptyColumn = 0;
        splitHeader = sHeaderName.substring(3);
        exactHeader = splitHeader.substring(0, splitHeader.length() - 3);
        strHeaderName = exactHeader.split("_");
        for (int i = 1; i <= rows_table.size(); i++) {
            strTableHeader = rows_table.get(i).getText();
            // System.out.println(strTableHeader);
            if (strTableHeader.equalsIgnoreCase(strHeaderName[0])) {
                logger.info("Table Header " + strHeaderName[0] + " found");
                intHeaderColumn = i - intEmptyColumn;
                blnSearchString = true;
                break;
            } else if (strTableHeader.equals("")) {
                intEmptyColumn = intEmptyColumn + 1;
            }

        }
        if (!blnSearchString) {
            logger.info("Table Header " + strHeaderName[0] + " is not found in the Add Class Table");
        }
        return intHeaderColumn;
    }

    /**
     * @param sValue
     * @return boolean
     * @throws IOException
     * @function Verify the warning and error messages on screen
     */
    public static boolean captureErrorMsg(String sValue) throws IOException {
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        List<String> a = new ArrayList<String>();
        String[] expMsg = null;
        boolean matchStatus = false;
        // String expectedText=null;
        if ((common.ElementSize(Common.o.getObject("eleValidationMsg")) == 0)) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen", "FAIL");
            status = true;
            return status;
        } else {

            WebElement eleErrtble = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleValidationMsg"));
            List<WebElement> eleDiv = eleErrtble.findElements(By.className("message")); // all div
            List<WebElement> eleErrIcon = eleErrtble.findElements(By.tagName("img")); // all div
            for (int i = 0; i < eleDiv.size(); i++) {
                String actWarningMsg = eleDiv.get(i).getText();
                String TypeMsg = eleErrIcon.get(i).getAttribute("class");
                expMsg = sValue.split("::");
                String[] Msgtype = TypeMsg.split("_");
                logger.info("" + TypeMsg + " Message - " + actWarningMsg);
                for (String expectedText : expMsg) {
                    if (expectedText.equals(actWarningMsg)) {
                        matchStatus = true;
                        logger.info("Expected " + Msgtype[0] + " Message  is matching with actual message '" + expectedText + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "Expected error text is matching with actual text '" + expectedText + "'", "PASS");
                        break;

                    }
                }

                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", Msgtype[0].toUpperCase() + "Message - " + actWarningMsg + " is displayed on screen", "WARNING");

            }

        }

        status = true;
        return status;

    }

    public static boolean captureErrorMsg_BulkActivity(String sValue) throws IOException {

        logger.info("Getting the Error Message and Verifying");

        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        List<String> a = new ArrayList<String>();
        String[] expMsg = null;
        boolean matchStatus = false;
        // String expectedText=null;
        if ((common.ElementSize(Common.o.getObject("eleValidationMsg_BulkAct")) == 0)) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen", "PASS");
            status = true;
            return status;
        } else {

            logger.info("Comparing Actual Error Message with Expected Error Msg.");

            WebElement eleErrtble = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleValidationMsg_BulkAct"));
            List<WebElement> eleDiv = eleErrtble.findElements(By.className("message")); // all div
            List<WebElement> eleErrIcon = eleErrtble.findElements(By.tagName("img")); // all div
            for (int i = 0; i < eleDiv.size(); i++) {
                String actWarningMsg = eleDiv.get(i).getText();
                String TypeMsg = eleErrIcon.get(i).getAttribute("class");
                expMsg = sValue.split("::");
                String[] Msgtype = TypeMsg.split("_");
                logger.info("" + TypeMsg + " Message - " + actWarningMsg);
                for (String expectedText : expMsg) {
                    if (expectedText.equals(actWarningMsg)) {
                        matchStatus = true;
                        logger.info("Expected " + Msgtype[0] + " Message  is matching with actual message '" + expectedText + "'");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "Expected error text is matching with actual text '" + expectedText + "'", "PASS");
                        break;

                    }
                }

                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", Msgtype[0].toUpperCase() + "Message - " + actWarningMsg + " is displayed on screen", "WARNING");

            }

        }

        status = true;
        return status;

    }

    public static int getCoverageTableHeaderColumn(String sHeaderName, String strObjectName) throws IOException {
        Common common = CommonManager.getInstance().getCommon();
        boolean blnSearchString = false;
        String strTableHeader = null;
        String splitHeader = null;
        String exactHeader = null;
        String strHeaderName[] = null;
        WebElement mytable = common.returnObject(By.xpath(strObjectName));
        List<WebElement> rows_table = mytable.findElements(By.tagName("span"));
        int intHeaderColumn = 0;
        // int intEmptyColumn = 1;
        int intEmptyColumn = 0;
        splitHeader = sHeaderName.substring(3);
        exactHeader = splitHeader.substring(0, splitHeader.length() - 3);
        strHeaderName = exactHeader.split("_");
        for (int i = 1; i < rows_table.size(); i++) {
            strTableHeader = rows_table.get(i).getText();
            // System.out.println(strTableHeader);
            if (strTableHeader.equalsIgnoreCase(strHeaderName[1])) {
                logger.info("Table Header " + strHeaderName[1] + " found");
                intHeaderColumn = i - intEmptyColumn;
                blnSearchString = true;
                break;
            } else if (strTableHeader.equals("")) {
                intEmptyColumn = intEmptyColumn + 1;
            }

        }
        if (!blnSearchString) {
            logger.info("Table Header " + strHeaderName[1] + " is not found in the Add Class Table");
        }
        return intHeaderColumn;
    }

    public static boolean clickTableCell(String strTblLocator, int sRow, int sCol, String ActionClick, String sTagName) {
        Common common = CommonManager.getInstance().getCommon();
        boolean Status = false;
        Actions objActions = new Actions(ManagerDriver.getInstance().getWebDriver());
        WebElement mytable = common.returnObject(Common.o.getObject(strTblLocator));
        List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
        sRow--;
        List<WebElement> Columns_row = rows_table.get(sRow).findElements(By.tagName("td"));
        List<WebElement> CellElements = Columns_row.get(sCol).findElements(By.tagName(sTagName));
        for (WebElement element : CellElements) {
            switch (ActionClick.toUpperCase()) {
                case "SINGLE":
                    element.click();
                    logger.info("Clicked on the table cell");
                    Status = true;
                    break;
                case "DOUBLE":
                    objActions.doubleClick(element).build().perform();
                    Status = true;
                    break;
            }
            break;
        }
        return Status;
    }

    /**
     * function use to click the table blank cell to make the table field to be
     * visible(specific to handle the coverages table)
     *
     * @param strTblLocator
     * @param sRow
     * @param sCol
     * @param ActionClick
     * @param sTagName
     * @return true/false
     * @author CPG7081
     */
    public static boolean clickCoverageTableCell(String strTblLocator, int sRow, int sCol, String ActionClick, String sTagName) {
        Common common = CommonManager.getInstance().getCommon();
        boolean Status = false;
        Actions objActions = new Actions(ManagerDriver.getInstance().getWebDriver());
        WebElement mytable = common.returnObject(By.id(strTblLocator));
        List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
        sRow--;
        List<WebElement> Columns_row = rows_table.get(sRow).findElements(By.tagName("td"));
        List<WebElement> CellElements = Columns_row.get(sCol).findElements(By.tagName(sTagName));
        for (WebElement element : CellElements) {
            switch (ActionClick.toUpperCase()) {
                case "SINGLE":
                    element.click();
                    logger.info("Clicked on the table cell");
                    Status = true;
                    break;
                case "DOUBLE":
                    objActions.doubleClick(element).build().perform();
                    Status = true;
                    break;
            }
            break;
        }
        return Status;
    }

    public static int getTableRowCount(String strLocator) {
        Common common = CommonManager.getInstance().getCommon();
        WebElement table = common.returnObject(Common.o.getObject(strLocator));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int sRowCount = rows_table.size();
        return sRowCount;
    }

    public static int getCoverageTableRowCount(String strLocator) {
        Common common = CommonManager.getInstance().getCommon();
        WebElement table = common.returnObject(By.id(strLocator));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int sRowCount = rows_table.size();
        return sRowCount;
    }

    public static boolean getCoverageNameID(String strCoverageName) {
        Boolean blnStatus = false;
        String getIDofLabel = null;
        try {
            List<WebElement> abcd = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
            for (WebElement element : abcd) {
                String sElementText = element.getText();
                if (sElementText.equals(strCoverageName)) {
                    logger.info("" + strCoverageName + " coverage found in the in the page for finding the button ID");
                    blnStatus = true;
                    getIDofLabel = element.getAttribute("id");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageID, getIDofLabel);
                }
                if (blnStatus) {
                    break;
                }
            }
            if (!blnStatus) {
                logger.info("Coverage '" + strCoverageName + "' is not present in the screen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blnStatus;
    }

    public static Boolean getCoverageTableHeader(String strCoverageName, String strTableName, String strCoverageID) throws IOException {
        Boolean blnStatus = false;
        String[] sSplitID = null;
        String strTableHeaderID = null;
        String strTableHeader = null;
        String strTableBody = null;
        String strAddRemoveID = null;
        String strHeaderBodyID = null;
        String strCoverageButtonID = null;
        try {
            sSplitID = strCoverageID.split("-");
            switch (strTableName.toUpperCase()) {
                case "ADD":
                    strAddRemoveID = (String) PCConstants.class.getDeclaredField(strTableName.toUpperCase() + "_AddRemove").get(null);
                    strTableHeaderID = sSplitID[0].concat(":ScheduleInputSet:0");
                    strCoverageButtonID = sSplitID[0].concat(strAddRemoveID);
                    strTableHeader = ".//*[@id='" + strTableHeaderID + "']/div[2]/div/div";
                    strTableBody = strTableHeaderID.concat("-body");
                    PCThreadCache.getInstance().setProperty(PCConstants.TableHeader, strTableHeader);
                    PCThreadCache.getInstance().setProperty(PCConstants.TableBody, strTableBody);
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADDDEFAULT":
                    strAddRemoveID = (String) PCConstants.class.getDeclaredField(strTableName.toUpperCase()).get(null);
                    strTableHeaderID = sSplitID[0].concat(":BP7ScheduleInputSet:BP7ScheduledItemsLV");
                    strCoverageButtonID = sSplitID[0].concat(strAddRemoveID);
                    strTableHeader = ".//*[@id='" + strTableHeaderID + "']/div[2]/div/div";
                    strTableBody = strTableHeaderID.concat("-body");
                    PCThreadCache.getInstance().setProperty(PCConstants.TableHeader, strTableHeader);
                    PCThreadCache.getInstance().setProperty(PCConstants.TableBody, strTableBody);
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADDR3":
                    strAddRemoveID = (String) PCConstants.class.getDeclaredField(strTableName.toUpperCase() + "_AddRemove").get(null);
                    strTableHeaderID = sSplitID[0].concat(":BP7ScheduleInputSet:BP7ScheduledItemsLV");
                    strCoverageButtonID = sSplitID[0].concat(strAddRemoveID);
                    strTableHeader = ".//*[@id='" + strTableHeaderID + "']/div[2]/div/div";
                    strTableBody = strTableHeaderID.concat("-body");
                    PCThreadCache.getInstance().setProperty(PCConstants.TableHeader, strTableHeader);
                    PCThreadCache.getInstance().setProperty(PCConstants.TableBody, strTableBody);
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADDSOLEPROPRIETORS":
                    strAddRemoveID = (String) PCConstants.class.getDeclaredField(strTableName.toUpperCase() + "_AddRemove").get(null);
                    strCoverageButtonID = sSplitID[0].concat(strAddRemoveID);
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                default:
                    strAddRemoveID = (String) PCConstants.class.getDeclaredField(strTableName.toUpperCase() + "_AddRemove").get(null);
                    strHeaderBodyID = (String) PCConstants.class.getDeclaredField(strTableName.toUpperCase()).get(null);
                    strTableHeaderID = sSplitID[0].concat(strHeaderBodyID);
                    strCoverageButtonID = sSplitID[0].concat(strAddRemoveID);
                    strTableHeader = ".//*[@id='" + strTableHeaderID + "']/div[2]/div/div";
                    strTableBody = strTableHeaderID.concat("-body");
                    PCThreadCache.getInstance().setProperty(PCConstants.TableHeader, strTableHeader);
                    PCThreadCache.getInstance().setProperty(PCConstants.TableBody, strTableBody);
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
            }
            if (!blnStatus) {
                logger.info("Problem in identify the " + strCoverageName + " table header and body ID");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should find the " + strCoverageName + " table header and body ID", "Problem in identify the " + strCoverageName + " table header and body ID", "FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sSplitID = null;
            strTableName = null;
        }
        return blnStatus;
    }

    /**
     * @return true/false
     * @throws Exception
     * @function Use to iterate scheduleRating DateSheet
     * @author Sojan
     */
    public static boolean coverageTableHandling(String strFieldName, String strFieldValue, String strCoverageName, String strPageName) {
        logger.info("Entering into coverage table details");
        Common common = CommonManager.getInstance().getCommon();
        Boolean blnStatus = false;
        String strElementType = null;
        String strTableObject = null;
        String strAddRemoveButtonID = null;
        int intTblColCount;
        int intTblRowCount;
        try {
            strElementType = strFieldName.substring(0, 3);
            if (strElementType.contentEquals("ele") || strElementType.contentEquals("elj") || strElementType.contentEquals("lst") || strElementType.contentEquals("lsj") || strElementType.contentEquals("sel") || strElementType.contentEquals("edj") || strElementType.contentEquals("edt")) {
                strTableObject = strFieldName.substring(strFieldName.length() - 3);
                switch (strTableObject.toUpperCase()) {
                    case "TBD":
                        intTblColCount = getCoverageTableHeaderColumn(strFieldName, PCThreadCache.getInstance().getProperty(PCConstants.TableHeader));
                        intTblRowCount = getCoverageTableRowCount(PCThreadCache.getInstance().getProperty(PCConstants.TableBody));
                        if (intTblColCount >= 1 && intTblRowCount >= 1) {
                            blnStatus = clickCoverageTableCell(PCThreadCache.getInstance().getProperty(PCConstants.TableBody), intTblRowCount, intTblColCount, "Single", "div");
                            blnStatus = common.SafeAction(Common.o.getObject(strFieldName), strFieldValue, strFieldName);
                            blnStatus = common.SafeAction(Common.o.getObject(strPageName), strPageName, strPageName);
                        }
                        break;
                    case "TBA":
                        intTblColCount = getCoverageTableHeaderColumn(strFieldName, PCThreadCache.getInstance().getProperty(PCConstants.TableHeader));
                        intTblRowCount = getCoverageTableRowCount(PCThreadCache.getInstance().getProperty(PCConstants.TableBody));
                        if (intTblColCount >= 1 && intTblRowCount >= 1) {
                            blnStatus = clickCoverageTableCell(PCThreadCache.getInstance().getProperty(PCConstants.TableBody), intTblRowCount, intTblColCount, "Single", "div");
                            blnStatus = common.SafeAction(Common.o.getObject(strFieldName), strFieldValue, strFieldName);
                            blnStatus = common.SafeAction(Common.o.getObject(strPageName), strPageName, strPageName);
                        }
                        break;
                    case "TBP":
                        intTblColCount = getCoverageTableHeaderColumn(strFieldName, PCThreadCache.getInstance().getProperty(PCConstants.TableHeader));
                        intTblRowCount = getCoverageTableRowCount(PCThreadCache.getInstance().getProperty(PCConstants.TableBody));
                        if (intTblColCount >= 1 && intTblRowCount >= 1) {

                            blnStatus = clickCoverageTableCell(PCThreadCache.getInstance().getProperty(PCConstants.TableBody), intTblRowCount, intTblColCount, "Single", "div");
                            blnStatus = common.SafeAction(Common.o.getObject(strFieldName), strFieldValue, strFieldName);
                            // blnStatus =
                            // common.SafeAction(Common.o.getObject(pageElement),
                            // pageElement, pageElement);
                        }
                        break;
                    case "TBL":
                        /*
                         * if(strElementName.toUpperCase().equals("ADD") ||
                         * strElementName.toUpperCase().contains("ADDBLANKETWAIVER") ||
                         * strElementName.toUpperCase().contains("REMOVE")) {
                         */
                        strAddRemoveButtonID = strFieldName.substring(0, strFieldName.length() - 3);
                        // blnStatus = getAddRemoveCoverageButton(strCoverageName,
                        // strAddRemoveButtonID,
                        // PCThreadCache.getInstance().getProperty(PCConstants.CoverageID));
                        blnStatus = common.SafeAction(By.id(PCThreadCache.getInstance().getProperty(PCConstants.CoverageButtonID)), strFieldValue, strFieldName);
                        /*
                         * // } else{ blnStatus = common.SafeAction(Common.o.getObject(strFieldName),
                         * strFieldValue, strFieldName); }
                         */
                        break;
                    case "RMV":
                        String[] strRemoveValues = strFieldValue.split(":::");
                        intTblColCount = getCoverageTableHeaderColumn(strRemoveValues[0], PCThreadCache.getInstance().getProperty(PCConstants.TableHeader));
                        blnStatus = SCRCommon.selectCoverageTableRowToRemove(intTblColCount, PCThreadCache.getInstance().getProperty(PCConstants.TableBody), strRemoveValues[1]);
                        strAddRemoveButtonID = strFieldName.substring(0, strFieldName.length() - 3);
                        blnStatus = getAddRemoveCoverageButton(strCoverageName, strAddRemoveButtonID, PCThreadCache.getInstance().getProperty(PCConstants.CoverageID));
                        blnStatus = common.SafeAction(By.id(PCThreadCache.getInstance().getProperty(PCConstants.CoverageButtonID)), strFieldName, strFieldName);
                        break;
                    case "TAG":
                        intTblColCount = getCoverageTableHeaderColumn(strFieldName, PCThreadCache.getInstance().getProperty(PCConstants.TableHeader));
                        intTblRowCount = getCoverageTableRowCount(PCThreadCache.getInstance().getProperty(PCConstants.TableBody));
                        if (intTblColCount >= 1 && intTblRowCount >= 1) {
                            if (strFieldValue.equalsIgnoreCase("LINK")) {
                                blnStatus = clickCoverageTableCell(PCThreadCache.getInstance().getProperty(PCConstants.TableBody), intTblRowCount, intTblColCount, "ELEMENTEXIST", "a");
                            }
                            // link validation
                            // blnStatus =
                            // clickCoverageTableCell(PCThreadCache.getInstance().getProperty(PCConstants.TableBody),
                            // intTblRowCount, intTblColCount, "ELEMENTEXIST", "a");
                            blnStatus = common.SafeAction(Common.o.getObject(strPageName), strPageName, strPageName);
                            // blnStatus =
                            // common.SafeAction(Common.o.getObject(strFieldName),
                            // strFieldValue, strFieldName);
                            // WebElement element =
                            // ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strFieldName));
                            // String sElementText = element.getText();

                        }
                        break;
                    default:
                        blnStatus = common.SafeAction(Common.o.getObject(strFieldName), strFieldValue, strFieldName);
                        break;
                }
            }
            if (!blnStatus) {
                logger.info("Failed in filling the '" + strFieldName + "' table object");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Should not fail in filling the '" + strFieldName + "' table object", "Failed in filling the '" + strFieldName + "' table object", "FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            strElementType = null;
            // String strElementName = null;
            strTableObject = null;
            strAddRemoveButtonID = null;
        }
        return blnStatus;
    }

    public static Boolean getAddRemoveCoverageButton(String strCoverageName, String strButtonType, String strCoverageNameID) {
        Boolean blnStatus = false;
        String[] sSplitID = null;
        String strCoverageButtonID = null;
        // List <WebElement> abcd =
        // ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
        try {
            Outer:
            /*
             * for(WebElement element : abcd) { String sElementText = element.getText();
             * if(sElementText.equals(strCoverageName)) { logger.info(""+strCoverageName+
             * " coverage found in the in the page for finding the button ID"); sLabelFound
             * = true; getIDofLabel = element.getAttribute("id");
             */
            sSplitID = strCoverageNameID.split("-");
            // strButtonName = strButtonType.substring(3);
            switch (strButtonType.toUpperCase()) {
                case "ADDBLANKETWAIVER":
                    strCoverageButtonID = sSplitID[0].concat(":WC7BlanketWaiverOfSubroLV_tb:Add-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "EDITADDBLANKETWAIVER":
                    strCoverageButtonID = sSplitID[0].concat(":WC7BlanketWaiverLV_tb:Add-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "EDITADDSPECIFICWAIVER":
                    strCoverageButtonID = sSplitID[0].concat(":WC7SpecWOSubroForPolCchangeLV_tb:Add-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADD":
                    strCoverageButtonID = sSplitID[0].concat(":ScheduleInputSet:Add-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADDFOREIGNVOLUNTARY":
                    strCoverageButtonID = sSplitID[0].concat(":WC7ForeignVolunCovLV_tb:Add-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADDSOLEPROPRIETORS":
                    strCoverageButtonID = sSplitID[0].concat(":ContactLV_tb:AddContactsButton-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADDEMPLOYEELEASING":
                    strCoverageButtonID = sSplitID[0].concat(":WC7PolicyLaborContractorDetailsLV_tb:AddWC7PolicyLaborContractor-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "REMOVE":
                    strCoverageButtonID = sSplitID[0].concat(":ScheduleInputSet:Remove-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "REMOVEBLANKET":
                    strCoverageButtonID = sSplitID[0].concat(":WC7BlanketWaiverOfSubroLV_tb:Remove-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "REMOVESPECIFIC":
                    strCoverageButtonID = sSplitID[0].concat(":WC7SpecificWaiverOfSubroLV_tb:Remove-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;

                case "ADDFEDERALEMPLOYEE":
                    strCoverageButtonID = sSplitID[0].concat(":WC7FedCovEmpLV_tb:Add-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;
                case "ADDEMPLOYEELEASINGCLIENT":
                    strCoverageButtonID = sSplitID[0].concat(":WC7PolicyLaborClientDetailsCondLV_tb:AddWC7PolicyLaborClientCond-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;

                case "ADDEMPLOYEELEASINGCLIENTEXCLUSION":
                    strCoverageButtonID = sSplitID[0].concat(":WC7PolicyLaborClientDetailsExclLV_tb:AddWC7PolicyLaborClientExcl-btnInnerEl");
                    PCThreadCache.getInstance().setProperty(PCConstants.CoverageButtonID, strCoverageButtonID);
                    blnStatus = true;
                    break;

            }
            if (!blnStatus) {
                logger.info("" + strCoverageName + " is not present in the page for finding the Add/Remove button ID");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + strCoverageName + "' coverage should available in the page for finding the Add/Remove button ID", "'" + strCoverageName + "' CheckBox is not available in the page for finding the Add/Remove button ID", "FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sSplitID = null;
            strCoverageButtonID = null;
            // Object strButtonName = null;
        }
        return blnStatus;
    }

    /**
     * Function to wait for renewal process to start
     *
     * @return
     * @throws Exception
     */
    public static boolean renewalWorkFlowTimeOut1() throws Exception {
        logger.info("Waiting for the policy to be ready for renewal");
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        status = common.WaitForElementExist(Common.o.getObject("eljPolicyInfo_RenewalCheck"), Integer.valueOf(PCConstants.RenewalWait));
        if (!status) {
            logger.info("Renewal Flow is not ready to use hence try later");
        }
        return status;
    }

    /**
     * @param sFuncValue
     * @return true/false
     * @throws IOException
     * @function This function will select the check box by using the label name
     */
    public static Boolean ValidateCovExistence(String strCovName, String sFuncValue) throws IOException {
        Boolean status = true;
        Boolean sLabelFound = false;
        String getIDofLabel = null;
        String[] sSplitID = null;
        String actualID = null;
        String actualTblID = null;
        Boolean blnExistenceFlag = false;
        String ExistenceMode = null;
        int intCounter = 0;

        ExistenceMode = sFuncValue;
        List<WebElement> abcd = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
        try {
            sLabelLoop:
            for (WebElement element : abcd) {
                String sElementText = element.getText();
                if (sElementText.equals(strCovName)) {
                    logger.info("" + strCovName + " label found in the Screen");
                    sLabelFound = true;
                    intCounter = 1;
                    getIDofLabel = element.getAttribute("id");
                    status = CommonManager.getInstance().getCommon().SafeAction(By.id(getIDofLabel), "scl", "scl");
                    sSplitID = getIDofLabel.split("-");
                    actualID = sSplitID[0].concat(":_checkbox");
                    actualTblID = sSplitID[0].concat("-legendChk");

                    // status=
                    // CommonManager.getInstance().getCommon().ElementDisplayed(By.id(actualID));
                    // //chkbox eistence
                    // status=CommonManager.getInstance().getCommon().ElementExist(By.id(actualID));
                    int eleSize = CommonManager.getInstance().getCommon().ElementSize(By.id(actualID));
                    if (eleSize > 0) {
                        WebElement sCheckBox = CommonManager.getInstance().getCommon().returnObject(By.id(actualTblID));
                        String sClassName = sCheckBox.getAttribute("class");
                        switch (ExistenceMode.toUpperCase()) {

                            case "SUGGESTED":
                            case "ADDITIONAL_ELECTABLE":
                                if (sClassName.endsWith("x-form-cb-checked")) {
                                    blnExistenceFlag = true;
                                    logger.info("Coverage - " + strCovName + "displayed as expected in " + ExistenceMode);
                                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI in Expected Mode", "Coverage - " + strCovName + " displayed in screen in Mode -" + ExistenceMode, "PASS");
                                } else {
                                    blnExistenceFlag = false;
                                    logger.info("Coverage - " + strCovName + "is NOT displayed as expected in " + ExistenceMode);
                                    logger.info("Checkbox is NOT CHECKED by default for Coverage - " + strCovName);
                                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI in Expected Mode", "Coverage - " + strCovName + " NOT displayed in screen in Mode -" + ExistenceMode, "FAIL");
                                }
                                break;
                            case "ELECTABLE":
                                if (!sClassName.endsWith("x-form-cb-checked")) // not
                                // SELECTED
                                {
                                    blnExistenceFlag = true;
                                    logger.info("Coverage - " + strCovName + "displayed as expected in " + ExistenceMode);
                                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI in Expected Mode", "Coverage - " + strCovName + " displayed in screen in Mode -" + ExistenceMode, "PASS");
                                } else {
                                    blnExistenceFlag = false;
                                    logger.info("Coverage - " + strCovName + "is NOT displayed as expected in " + ExistenceMode);
                                    logger.info("Checkbox is CHECKED by default for Coverage - " + strCovName);
                                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI in Expected Mode", "Coverage - " + strCovName + " NOT displayed in screen in Mode -" + ExistenceMode, "FAIL");
                                }
                                break;
                        }
                    } else {
                        if (ExistenceMode.toUpperCase().equals("REQUIRED")) // not
                        // SELECTED
                        {
                            logger.info("Coverage - " + strCovName + "displayed as expected in " + ExistenceMode);
                            blnExistenceFlag = true;
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI in Expected Mode", "Coverage - " + strCovName + " displayed in screen in Mode -" + ExistenceMode, "PASS");
                        } else if (!ExistenceMode.toUpperCase().equals("REQUIRED")) {
                            blnExistenceFlag = false;
                            logger.info("Coverage - " + strCovName + "is NOT displayed as expected in " + ExistenceMode);
                            logger.info("NO checkbox is available Coverage - " + strCovName);
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI in Expected Mode", "Coverage - " + strCovName + " NOT displayed in screen in Mode -" + ExistenceMode, "FAIL");
                        }
                    }

                }

                if (sLabelFound) {
                    intCounter = 1;
                    break sLabelLoop;
                }
            }

            switch (intCounter) {
                case 0:
                    if (ExistenceMode.toUpperCase().equals("NOT_AVAIL")) {
                        // As expected cov not avail
                        blnExistenceFlag = true;
                        logger.info("" + strCovName + " is not present in the Screen");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is NOT displayed in UI", "Coverage - " + strCovName + " not displayed in screen as expected", "PASS");
                    } else {
                        blnExistenceFlag = false;
                        logger.info("" + strCovName + " is not present in the Screen");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI", "Coverage - " + strCovName + " is NOT displayed in screen", "FAIL");
                    }
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getIDofLabel = null;
            sSplitID = null;
            actualID = null;
        }
        return blnExistenceFlag;
    }

    /**
     * Function to wait for renewal process to start
     *
     * @return
     * @throws Exception
     */
    public static boolean renewalWorkFlowTimeOut() throws Exception {
        logger.info("Waiting for the policy to be ready for renewal");
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        for (int i = 0; i <= 10; i++) {
            // status =
            // common.WaitForElementExist(Common.o.getObject("eljPolicyInfo_RenewalCheck"),
            // 2);
            // int size =
            // common.ElementSize(Common.o.getObject("eljPolicyInfo_RenewalCheck"));
            String strStatusCheck = common.ReadElement(Common.o.getObject("eleSORPolicyStatus"), 10);
            if (strStatusCheck.equals("Workflow (Wait Timeout/Manual)")) {
                logger.info("Renewal ready to go");
                break;
            } else {
                status = common.SafeAction(Common.o.getObject("eleCommonNext"), "", "eleCommonNext");
                status = common.SafeAction(Common.o.getObject("eleCommonBack"), "", "eleCommonBack");
            }
        }
        // status =
        // common.WaitForElementExist(Common.o.getObject("eljPolicyInfo_RenewalCheck"),
        // Integer.valueOf(PCConstants.RenewalWait));
        if (!status) {
            logger.info("Renewal Flow is not ready to use hence try later");
            status = true;
        }
        return status;
    }

    public static boolean coverageValidation(String sheetName) throws Exception {
        logger.info("Entering into Product Model coverage validation function");
        Boolean status = true;
        Boolean tcAvailable = false;
        String TCID = null;
        String TCIDAdd = null;
        String sCoverageComponentName = null;
        String sChooseCoverage = null;
        String sCoverageName = null;
        String currentCompoentName = PCThreadCache.getInstance().getProperty("methodName");
        String sFieldName = null;
        String sFieldValue = null;
        String fieldType = null;
        String strFieldType = null;
        String strColumnName = null;
        String sFillPrereq_Data = null;
        String sVerifyExitence = null;

        boolean blnCoverageAvailable = false;
        String strTablePage = null;
        String strTableSpecificTableHeader = null;
        boolean blnTableHeaderBody = false;

        String sFileType = null;
        String sFileDefValue = null;
        String sFileValues = null;
        String sRefCode = null;

        String[] arrColName = {"Coverages", "RefCode", "cfufillCoverages", "cfuPageScreenShot", "cfuVerifyExistence", "Field_Validation"};

        XlsxReader xls = XlsxReader.getInstance();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        // String[] splittcID = tcID.split("_");
        String sFileName = null;
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.clear();
        whereConstraint.put(PCConstants.ID, tcID);
        whereConstraint.put(PCConstants.Iteration, PCThreadCache.getInstance().getProperty("Iteration"));
        whereConstraint.put(PCConstants.componentSheet, currentCompoentName);
        resultListRows = xls.executeSelectQuery(sheetName, whereConstraint);
        if (resultListRows.size() > 0) {
            tcAvailable = true;
            rowsFor:
            for (HashMap<String, Object> processRow : resultListRows) {

                for (int i = 2; i < arrColName.length; i++) {
                    String getKeyValue = (String) processRow.get(arrColName[i]);
                    sCoverageName = (String) processRow.get(arrColName[0]);
                    sRefCode = (String) processRow.get(arrColName[1]);

                    switch (arrColName[i]) {

                        case "cfufillCoverages":
                            if (!sCoverageName.isEmpty() && !getKeyValue.isEmpty()) {
                                status = coverageSheet(getKeyValue);

                            }
                            break;
                        case "cfuPageScreenShot":
                            if (!sCoverageName.isEmpty() && !getKeyValue.isEmpty()) {
                                status = PageScreenShot(getKeyValue);

                            }
                            break;

                        case "cfuVerifyExistence":
                            if (!sCoverageName.isEmpty() && !getKeyValue.isEmpty()) {
                                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validation for Ref Code ----> <BR>" + sRefCode, "Coverage Name  --- " + sCoverageName, "PASS");
                                status = ValidateCovExistence(sCoverageName, getKeyValue);
                                logger.info("sRefCode");
                            }
                            break;
                        case "Field_Validation":
                            for (int f = 1; f < 9; f++) {
                                sFieldName = (String) processRow.get("Validate_FieldName" + f);
                                sFileType = (String) processRow.get("Validate_FieldType" + f);
                                sFileDefValue = (String) processRow.get("Validate_FieldDefaultValue" + f);
                                sFileValues = (String) processRow.get("Validate_FieldValue" + f);

                                if (!sFieldName.isEmpty()) {
                                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validation for Fields inside the Coverage .<BR> Ref Code - " + sRefCode, "Coverage Name  --- " + sCoverageName + " <BR> Field Name - " + sFieldName, "PASS");
                                    status = ValidateFieldLevel(sFieldName, sFileType, sFileDefValue, sFileValues, sCoverageName);
                                }
                                if (!status) {
                                    break;
                                }

                            }
                            break;

                    }
                    if (!status) {
                        break rowsFor;
                    }
                }

            }

        } else {
            logger.info("TCID not available");

        }

        return status;
    }


    public static boolean renewalWorkFlowEditTransaction() throws Exception {
        logger.info("Waiting for the policy to be ready for renewal");
        boolean blnRenewalStatus = false;
        Common common = CommonManager.getInstance().getCommon();
        Outer:
        for (int i = 0; i <= 10; i++) {
            for (int j = 1; j <= 2; j++) {
                blnRenewalStatus = common.SafeAction(Common.o.getObject("eleCommonNext"), "", "eleCommonNext");
                blnRenewalStatus = common.SafeAction(Common.o.getObject("eleCommonBack"), "", "eleCommonBack");
                blnRenewalStatus = false;
            }
            int iEditTransactionSize = common.ElementSize(Common.o.getObject("eleCommonWorkFlowEditTransaction"));
            if (iEditTransactionSize > 0) {
                blnRenewalStatus = true;
                logger.info("Renewal Flow is ready to go");
                break Outer;
            }
        }
        if (!blnRenewalStatus) {
            logger.info("Renewal Flow is not ready to use hence try later");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Renewal Transaction should get ready", "Renewal Transaction should get ready", "FAIL");
        }
        return blnRenewalStatus;
    }

    public static Boolean ValidateFieldLevel(String strFieldName, String sFieldType, String sDefValue, String sFieldAllVal, String sCoverageName) throws Exception {
        Boolean status = true;
        Boolean blnCoverageAvailable = false;
        String sSplitID[] = null;
        String sPCLabelValue = null;
        Boolean sChildLabel = false;
        String sLabelID = null;
        String[] sLabelIDSplit = null;
        String sNewID = null;
        int intCounterCase = 0;
        blnCoverageAvailable = getCoverageNameID(sCoverageName);
        if (blnCoverageAvailable) {
            logger.info("" + sCoverageName + " label found in the Screen");
            String GetCovID = PCThreadCache.getInstance().getProperty(PCConstants.CoverageID);
            sSplitID = GetCovID.split("-");
            By sTargetID = By.id(sSplitID[0]);
            WebElement sTargetLegend = CommonManager.getInstance().getCommon().returnObject(sTargetID);
            List<WebElement> sTargetLegendDiv = sTargetLegend.findElements(By.tagName("label"));
            FieldLoop:
            for (WebElement sLabel : sTargetLegendDiv) // looping all
            // field
            // inside
            // coverage
            {
                sPCLabelValue = (String) sLabel.getText();
                if (strFieldName.toUpperCase().equals(sPCLabelValue.toUpperCase())) {
                    sChildLabel = true;
                    sLabelID = sLabel.getAttribute("id");
                    sLabelIDSplit = sLabelID.split("-");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Field in Coverage is displayed in UI", "Field : " + strFieldName + " displayed in screen", "PASS");
                    status = verifyCovFieldType(sLabelIDSplit[0], sFieldType, sDefValue, sFieldAllVal);
                }
                if (sChildLabel) {
                    intCounterCase = 1;
                    break FieldLoop;
                }
            }
            switch (intCounterCase) {
                case 0:
                    if (sFieldType.equalsIgnoreCase("NOT_AVAIL")) {
                        status = true;
                        logger.info("" + strFieldName + " is not present in the Screen");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the field is NOT displayed in UI", "Field - " + strFieldName + " not displayed in screen", "PASS");
                    } else {
                        status = true;
                        logger.info("" + strFieldName + " is not present in the Screen");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the field is displayed in UI", "Field - " + strFieldName + " not displayed in screen", "FAIL");
                    }
                    break;
            }
        } else {
            logger.info("" + sCoverageName + " is not present in the Screen");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI", "Coverage - " + sCoverageName + " not displayed in screen", "FAIL");
        }
        return status;
    }

    public static boolean renewalFlowToBeReady() throws Exception {
        logger.info("Waiting for the policy to be ready for renewal");
        boolean blnRenewalStatus = false;
        Common common = CommonManager.getInstance().getCommon();
        Outer:
        for (int i = 0; i <= 10; i++) {
            for (int j = 1; j <= 2; j++) {
                blnRenewalStatus = common.SafeAction(Common.o.getObject("eleCommonNext"), "", "eleCommonNext");
                blnRenewalStatus = common.SafeAction(Common.o.getObject("eleCommonBack"), "", "eleCommonBack");
                blnRenewalStatus = false;
            }
            int iTimeOutCheck = common.ElementSize(Common.o.getObject("eleCommonEditTransaction"));
            if (iTimeOutCheck > 0) {
                blnRenewalStatus = true;
                blnRenewalStatus = common.SafeAction(Common.o.getObject("eleCommonEditTransaction"), "", "eleCommonEditTransaction");
                logger.info("Renewal Flow is ready to go");
                break Outer;
            } else {
                int iEditTransactionSize = common.ElementSize(Common.o.getObject("eleCommonWorkFlowEditTransaction"));
                if (iEditTransactionSize > 0) {
                    blnRenewalStatus = common.SafeAction(Common.o.getObject("eleCommonWorkFlowEditTransaction"), "", "eleCommonWorkFlowEditTransaction");
                    int iEditTransactionOkSize = common.ElementSize(Common.o.getObject("eleCommonWorkFlowEditTransaction"));
                    if (iEditTransactionOkSize > 0) {
                        blnRenewalStatus = common.SafeAction(Common.o.getObject("eleEditTransOk"), "", "eleEditTransOk");
                    }
                    logger.info("Renewal Flow is ready to go");
                    break Outer;
                }
            }
        }
        if (!blnRenewalStatus) {
            logger.info("Renewal Flow is not ready to use hence try later");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Renewal Transaction should get ready", "Renewal Transaction is not ready to go", "FAIL");
        }
        return blnRenewalStatus;
    }

    /**
     * Iteration the validation result page
     *
     * @param strFuncValue
     * @return true/false
     * @throws IOException
     */
    public static Boolean validate(String strFuncValue) throws IOException {
        Boolean blnStatus = false;
        int iTblColNum = 0;
        XlsxReader sXL = XlsxReader.getInstance();
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.put("Iteration", PCThreadCache.getInstance().getProperty(PCConstants.Iteration));
        whereConstraint.put("TCValidationCase", strFuncValue);
        whereConstraint.put(PCConstants.ID, PCThreadCache.getInstance().getProperty("TCID"));
        resultListRows = sXL.executeSelectQuery("Validation", whereConstraint);
        logger.info("Entered into Validate function");
        if (!resultListRows.isEmpty()) {
            for (HashMap<String, Object> processRow : resultListRows) {
                String strElement = (String) processRow.get("Element");
                String strExpectedResult = (String) processRow.get("ExpectedResult");
                String strVerificationType = (String) processRow.get("VerificationType");
                String strTableColumnNumber = (String) processRow.get("TableColumnNumber");
                String strCaseName = (String) processRow.get("TCValidationCase");
                // if (!(strTableColumnNumber.isEmpty())) {
                // iTblColNum = Integer.parseInt(strTableColumnNumber);
                // }

                logger.info("Verifying Results");

                blnStatus = verifyResults(strElement, strExpectedResult, strVerificationType, strTableColumnNumber, strCaseName);
                logger.info("Results Verified");
            }
        } else {
            logger.info("No Result Found in the Validation sheet");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Test Case '" + PCThreadCache.getInstance().getProperty("TCID") + "' and Iteration '" + PCThreadCache.getInstance().getProperty(PCConstants.Iteration) + "' should available in the validation sheet",
                    "Test Case '" + PCThreadCache.getInstance().getProperty("TCID") + "' or Iteration '" + PCThreadCache.getInstance().getProperty(PCConstants.Iteration) + "' is not present in the validation sheet", "FAIL");
            blnStatus = false;
        }

        return blnStatus;
    }

    public static boolean verifyCovFieldType(String sObjId, String strFieldType, String DefValue, String sFieldValues) throws Exception {
        boolean status = false;
        String sNewID = null;
        String strAttribute = null;
        String strActualValue = null;
        WebElement sFieldType = null;
        String roletype = null;
        Boolean blnRoleMatched = false;
        switch (strFieldType.toUpperCase()) {
            case "DROPDOWN":
                sNewID = sObjId.concat("-inputEl");
                strAttribute = "role";
                sFieldType = CommonManager.getInstance().getCommon().returnObject(By.id(sNewID));
                roletype = sFieldType.getAttribute(strAttribute);
                if (roletype.toUpperCase().equals("COMBOBOX") && strFieldType.toUpperCase().equals("DROPDOWN")) {
                    logger.info("Field Type matched");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType for Coverage ", "ActualField Type -" + strFieldType + " macthes with the Expected Field type.", "PASS");
                    status = true;
                    blnRoleMatched = true;
                }

                break;
            case "TEXTBOX":
                sNewID = sObjId.concat("-inputEl");
                strAttribute = "role";
                sFieldType = CommonManager.getInstance().getCommon().returnObject(By.id(sNewID));
                roletype = sFieldType.getAttribute(strAttribute);
                if (roletype.toUpperCase().equals(strFieldType.toUpperCase())) {
                    logger.info("Field Type matched");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType for Coverage ", "ActualField Type -" + strFieldType + " macthes with the Expected Field type.", "PASS");
                    status = true;
                    blnRoleMatched = true;
                }
                break;
            case "DATE_FIELD":
                sNewID = sObjId.concat("-inputEl");
                status = VerifyCalendarControlExistence1(sNewID);
                strAttribute = "role";
                sFieldType = CommonManager.getInstance().getCommon().returnObject(By.id(sNewID));
                roletype = sFieldType.getAttribute(strAttribute);
                if (strFieldType.toUpperCase().equals("DATE_FIELD") && roletype.toUpperCase().equals("TEXTBOX")) {
                    logger.info("Field Type matched");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType for Coverage ", "ActualField Type -" + strFieldType + " macthes with the Expected Field type.", "PASS");
                    status = true;
                    blnRoleMatched = true;
                }
                break;
            case "READONLY":
                sNewID = sObjId.concat("-inputEl");
                strAttribute = "class";
                sFieldType = CommonManager.getInstance().getCommon().returnObject(By.id(sNewID));
                roletype = sFieldType.getAttribute(strAttribute);
                if (strFieldType.toUpperCase().equals("READONLY") && roletype.equals("x-form-display-field")) {
                    logger.info("Field Type  matched");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType for Coverage", "ActualField Type -" + strFieldType + " macthes with the Expected Field type.", "PASS");
                    status = true;
                    blnRoleMatched = true;
                }
                break;
            case "RADIO":
                sNewID = sObjId.concat("_true-inputEl");
                strAttribute = "role";
                sFieldType = CommonManager.getInstance().getCommon().returnObject(By.id(sNewID));
                roletype = sFieldType.getAttribute(strAttribute);
                if (roletype.toUpperCase().equals(strFieldType.toUpperCase())) {
                    logger.info("Field Type matched");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType for Coverage ", "ActualField Type -" + strFieldType + " macthes with the Expected Field type.", "PASS");
                    status = true;
                    blnRoleMatched = true;
                }
                break;

            case "CHECKBOX":
                sNewID = sObjId.concat(":_checkbox");
                strAttribute = "role";
                if (roletype.toUpperCase().equals(strFieldType.toUpperCase())) {
                    logger.info("Field Type matched");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType for Coverage ", "ActualField Type -" + strFieldType + " macthes with the Expected Field type.", "PASS");
                    status = true;
                    blnRoleMatched = true;
                }

                break;
        }

        if (!blnRoleMatched) {
            logger.info("Field Type not matched");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType for Coverage - <BR>" + sObjId, "ActualField Type -" + strFieldType + "<BR> Expected Fieldtype -" + roletype + "doesnt match", "FAIL");
            status = false;
        }

        if (status) {
            // validate it default value
            if (DefValue != null && !DefValue.equals("")) {
                status = VerifyFieldDefaultValue(sNewID, strFieldType, DefValue);
            }
            if (sFieldValues != null && !sFieldValues.equals("")) {
                status = VerifyFieldValues(sNewID, strFieldType, sFieldValues);
            }
        }
        return status;

    }

    /**
     * common function to validate the results
     *
     * @param strElement
     * @param strExpectedResult
     * @param strVerificationType
     * @param strTableColumnNumber
     * @param strCaseName
     * @return
     */
    public static Boolean verifyResults(String strElement, String strExpectedResult, String strVerificationType, String strTableColumnNumber, String strCaseName) {
        Boolean blnStatus = false;
        String[] splitColumnNumber = null;
        String[] splitExpectedResult = null;
        try {
            switch (strVerificationType.toUpperCase()) {
                case "VERIFYELEMENTTEXT":
                    // blnStatus =
                    // VerifyErrorMessages(""+strElement+":::::"+strExpectedResult+"");
                    blnStatus = VerifyText("" + strElement + ":::::" + strExpectedResult + "");
                    break;
                case "VALIDATE_ERR_WARNING_MSGS":
                    blnStatus = captureErrorMsg(strExpectedResult);
                    break;
                case "VALIDATE_ERR_MSGS_BULK_ACT":
                    logger.info("Checking for Error Msg");
                    blnStatus = captureErrorMsg_BulkActivity(strExpectedResult);
                case "VERIFYELEMENTEXISTENCEFALSE":
                    blnStatus = VerifyElement("VISIBLEFALSE:::" + strElement + "");
                    break;
                case "VERIFYELEMENTEXISTENCETRUE":
                    blnStatus = VerifyElement("VISIBLETRUE:::" + strElement + "");
                    break;
                case "TABLEVALIDATION":
                    // blnStatus = verifyTextFromTable(strElement,
                    // Integer.parseInt(strTableColumnNumber), strExpectedResult,
                    // strCaseName);
                    blnStatus = verifyTextFromTablePages(strElement, Integer.parseInt(strTableColumnNumber), strExpectedResult, strCaseName);
                    break;
                case "TABLEVALIDATIONELEEXISTENCEFALSE":
                    blnStatus = verifyTextFromTableFalse(strElement, Integer.parseInt(strTableColumnNumber), strExpectedResult, strCaseName);
                    break;
                case "TABLEVALIDATIONELEEXISTENCETRUE":
                    blnStatus = verifyTextFromTableTrue(strElement, Integer.parseInt(strTableColumnNumber), strExpectedResult, strCaseName);
                    break;

                case "VERIFYEDITBOXTEXT":
                    blnStatus = verifyEditBoxTextValue("" + strElement + ":::" + strExpectedResult + "");
                    break;
                case "VERIFYEDITBOXTEXTNOBLANK":
                    blnStatus = verifyEditFieldNoBlank(strElement);

                    break;
                case "READGETTABLE":
                    splitColumnNumber = strTableColumnNumber.split(":::");
                    splitExpectedResult = strExpectedResult.split(":::");
                    blnStatus = verifyTextFromTable(strElement, Integer.parseInt(splitColumnNumber[0]), Integer.parseInt(splitColumnNumber[1]), splitExpectedResult[0], splitExpectedResult[1], strCaseName);
                    break;
                case "FORMSVALIDATION":
                    splitColumnNumber = strTableColumnNumber.split(":::");
                    splitExpectedResult = strExpectedResult.split(":::");

                    // blnStatus = verifyFormsDetail(Common.o.getObject(strElement),
                    // Integer.parseInt(splitColumnNumber[0]),
                    // Integer.parseInt(splitColumnNumber[1]),
                    // splitExpectedResult[0], splitExpectedResult[1]);
                    blnStatus = formsDataValidation(strElement, Integer.parseInt(splitColumnNumber[0]), Integer.parseInt(splitColumnNumber[1]), splitExpectedResult[0], splitExpectedResult[1]);
                    break;
                case "RADIOBUTTONEXIST":
                    blnStatus = verifyRadioExist(strElement, strExpectedResult);
                    break;
                case "VERIFY_SCREEN_ERROR":
                    blnStatus = verify_ScreenErr("ERROR::" + strExpectedResult + "", "");
                    break;
                case "VERIFY_SCREEN_INFO":
                    blnStatus = verify_ScreenErr("INFO::" + strExpectedResult + "", "");
                    break;
                case "VERIFY_SCREEN_WARNING":
                    blnStatus = verify_ScreenErr("WARNING::" + strExpectedResult + "", "");
                    break;
                case "VERIFY_ELE_NOT_NULL":
                    blnStatus = verify_ElementNotNull(strElement);
                    break;
                case "VERIFY_DROPDOWN_VALUES":
                    blnStatus = VerifyDropDownValue(strElement, strExpectedResult);
                    break;
                case "VERIFY_SCREEN_WARNING_NOTAVAIL":
                    blnStatus = verify_ScreenErr("WARNING::" + strExpectedResult + "", "NOERROR");
                    break;
                case "VERIFY_SCREEN_ERROR_NOTAVAIL":
                    blnStatus = verify_ScreenErr("ERROR::" + strExpectedResult + "", "NOERROR");
                    break;
                case "VERIFY_TODAY_DATE":
                    blnStatus = verify_TodayDate(strElement);
                    break;
                case "VERIFYEDITBOXTEXTBLANK":
                    blnStatus = verifyEditField_Blank(strElement);
                    break;
                case "VERIFY_VALIDATION_WARN_MSG":
                    blnStatus = CaptureValidationMessage_Detail(strExpectedResult, "WARNING", "EQUALS", "");
                    break;
                case "VERIFY_VALIDATION_ERR_MSG":
                    blnStatus = CaptureValidationMessage_Detail(strExpectedResult, "ERROR", "EQUALS", "");
                    break;
                case "VERIFY_VALIDATION_INFO_MSG":
                    blnStatus = CaptureValidationMessage_Detail(strExpectedResult, "INFO", "EQUALS", "");
                    break;
                case "VERIFY_VALIDATION_ERR_MSG_CONTAINS":
                    blnStatus = CaptureValidationMessage_Detail(strExpectedResult, "ERROR", "CONTAINS", "");
                    break;
                case "VERIFY_VALIDATION_WARN_MSG_NOTAVAIL":
                    blnStatus = CaptureValidationMessage_Detail(strExpectedResult, "WARNING", "EQUALS", "NOT_AVAIL");
                    break;


            }
            if (!blnStatus) {
                blnStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return blnStatus;
    }

    private static boolean VerifyFieldValues(String sFieldeleID, String sFieldType, String sFieldValues) throws Exception {
        boolean status = false;
        String[] arrFieldValue = sFieldValues.split(":::");
        String[] arrDtValues = null;
        String strDate = null;
        String[] eleObj = null;
        switch (arrFieldValue[0].toUpperCase()) {
            case "CONTAIN_VALUES":
                status = VerifyDropDownValue(sFieldeleID, arrFieldValue[1]);
                break;
            case "LIMIT_VAL":
                status = VerifyEdit_Limitval(sFieldeleID, arrFieldValue[1]);
                break;
            case "NO_DEFAULTS":
                eleObj = sFieldeleID.split("_true-inputEl");
                status = verifyRadioExist(eleObj[0], "NOT_SELECTED", "YES");
                status = verifyRadioExist(eleObj[0], "NOT_SELECTED", "NO");
                break;
            case "NOERROR_VALIDFORMAT":
                strDate = ReturnCurrentDate(); // MM/DD/YYYY'
                arrDtValues = arrFieldValue[1].split("##");
                status = CommonManager.getInstance().getCommon().SafeAction(By.id(sFieldeleID), strDate, "edt");
                status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNGS_SaveDraft"), "ele", "eleNGS_SaveDraft");
                if (arrDtValues[1].contains("<TODAY>")) {
                    arrDtValues[1] = arrDtValues[1].replace("<TODAY>", strDate);
                }
                status = verify_ScreenErr("ERROR::" + arrDtValues[1], "NOERROR");
                break;
            case "INVALID_DTFORMAT":
                strDate = ReturnCurrentDate();
                arrDtValues = arrFieldValue[1].split("##");
                status = CommonManager.getInstance().getCommon().SafeAction(By.id(sFieldeleID), arrDtValues[0], "edt");
                status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNGS_SaveDraft"), "ele", "eleNGS_SaveDraft");
                if (arrDtValues[1].contains("<TODAY>")) {
                    arrDtValues[1] = arrDtValues[1].replace("<TODAY>", strDate);
                }
                status = verify_ScreenErr("ERROR::" + arrDtValues[1], "");
                break;
            case "VALIDATE_NO_ERR_ATQUOTE":
                status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("elePRQuote"), "ele", "elePRQuote");
                status = validatevalidationMsg(sFieldeleID, arrFieldValue[1], "NOERROR");
                break;
            case "VALIDATE_ERR_ATQUOTE":
                status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("elePRQuote"), "ele", "elePRQuote");
                status = validatevalidationMsg(sFieldeleID, arrFieldValue[1], "");
                break;
            case "VALIDATE_ERR_ATNEXT_SCREEN":
                status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNext"), "ele", "eleNext");
                // status = validatevalidationMsg(sFieldeleID, arrFieldValue[1], "");
                status = verify_ScreenErr(arrFieldValue[1], "");
                break;
            case "DEFAULT_SELECTED":
                eleObj = sFieldeleID.split("_true-inputEl");
                status = verifyRadioExist(eleObj[0], "SELECTED", arrFieldValue[1]);

                break;
        }
        return status;
    }

    /**
     * @param obj
     * @param readTextCol
     * @param strReadString
     * @return String
     * @throws Exception
     * @function This function use to get the text from the table according to the
     * column
     */
    public static Boolean verifyTextFromTable(String obj, int readTextCol, String strReadString, String strTableName) throws Exception {
        boolean SearchString = false;
        String readText = null;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(obj));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            readText = Cells.get(readTextCol).getText();
            if (readText.contains(strReadString)) {
                SearchString = true;
                break;
            }
        }
        if (SearchString) {
            // logger.info("Search String available in the table. '" +
            // strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is avilable in the " + strTableName + " table", "PASS");
        } else {
            // logger.info("Search String not available in the table. '" +
            // strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is not avilable in the " + strTableName + " table", "PASS");
            SearchString = false;
        }
        return SearchString;
    }

    /**
     * @param sFieldeleID
     * @param sCellValue
     * @param sErrExistence
     * @return
     * @throws Exception
     */
    private static boolean validatevalidationMsg(String sFieldeleID, String sCellValue, String sErrExistence) throws Exception {
        String[] arrValues = null;
        Boolean status = false;
        arrValues = sCellValue.split("##");
        // status=CommonManager.getInstance().getCommon().SafeAction(By.id(sFieldeleID),
        // arrValues[1], "edt");
        // status=CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNGS_SaveDraft"),
        // "ele" , "eleNGS_SaveDraft");
        status = ComparevalidationErrMsg(arrValues[0], arrValues[1], sErrExistence);
        return status;
    }

    /**
     * Function to check the radio button validation
     *
     * @param strElementName
     * @param strExpected
     * @return
     * @throws Exception
     */
    public static Boolean verifyRadioExist(String strElementName, String strExpected) throws Exception {
        Boolean blnStatus = false;
        WebElement radioButton = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strElementName));
        blnStatus = radioButton.isDisplayed();
        if (blnStatus) {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " element should be selected as " + strExpected + "", "" + strElementName + " element is selected as " + strExpected + "", "PASS");
        } else {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " element should be selected as " + strExpected + "", "" + strElementName + " element is not selected as " + strExpected + "", "FAIL");
            blnStatus = true;
        }
        return blnStatus;
    }

    /**
     * * Function to check the radio button validation
     *
     * @param strElementName
     * @param strExpected
     * @return
     * @throws Exception
     */
    public static Boolean verifyRadioExist(String strElementName, String strExpected, String sLabel) throws Exception {
        Boolean blnStatus = false;

        // String[] eleObj=strElementName.split("_true-inputEl");
        String eleObjFullName = null;
        if (sLabel.equalsIgnoreCase("YES")) {
            eleObjFullName = strElementName.concat("_true");
        } else if (sLabel.equalsIgnoreCase("NO")) {
            eleObjFullName = strElementName.concat("_false");
        }

        String xpath = "//table[@id='<ID>']";
        xpath = xpath.replace("<ID>", eleObjFullName);
        WebElement radioButton = ManagerDriver.getInstance().getWebDriver().findElement(By.xpath(xpath));
        String strClassname = radioButton.getAttribute("class");
        boolean strExpFlag = false;
        switch (strExpected.toUpperCase()) {
            case "NOT_SELECTED":
                if (!strClassname.contains("x-form-cb-checked")) {
                    strExpFlag = true;
                } else {
                    strExpFlag = false;
                }
                break;
            case "SELECTED":
                if (strClassname.contains("x-form-cb-checked")) {
                    strExpFlag = true;
                } else {
                    strExpFlag = false;
                }
        }
        if (strExpFlag) {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " element should be displayed as " + strExpected + "", "" + strElementName + " element is displayed as " + strExpected + "", "PASS");
            blnStatus = true;
        } else {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " element should be displayed as " + strExpected + "", "" + strElementName + " element is not displayed as " + strExpected + "", "FAIL");
            blnStatus = true;
        }
        return blnStatus;
    }

    /**
     * This function is to verify the display of documents in document section.
     *
     * @param obj
     * @param readTextCol
     * @param strReadString
     * @param strTableName
     * @return
     * @throws Exception
     */
    public static Boolean verifyTextFromTablePages(String obj, int readTextCol, String strReadString, String strTableName) throws Exception {
        boolean blnSearchString = false;
        boolean blnStatus = false;
        int icheckNextPageButton = 0;
        String strPageCount = null;
        Common common = CommonManager.getInstance().getCommon();
        try {
            blnSearchString = verifyTextInTable(obj, readTextCol, strReadString, strTableName);
            if (blnSearchString) {
                blnStatus = true;
            }
            if (!blnSearchString) {
                icheckNextPageButton = common.ElementSize(Common.o.getObject("eleNextPage"));
                if (icheckNextPageButton > 0) {
                    strPageCount = common.ReadElement(Common.o.getObject("eleCommonPageNumber"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
                    strPageCount = SCRCommon.getIntFromString(strPageCount);
                    for (int i = 1; i < Integer.parseInt(strPageCount); i++) {
                        blnStatus = common.SafeAction(Common.o.getObject("eleNextPage"), "", "eleNextPage");
                        blnStatus = common.SafeAction(Common.o.getObject("eleDocumentTitle"), "", "eleDocumentTitle");
                        blnSearchString = verifyTextInTable(obj, readTextCol, strReadString, strTableName);
                        if (blnSearchString)
                            blnStatus = true;
                    }
                }
            }
            if (blnSearchString) {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should validate the display of document '" + strReadString + "' ", "Document '" + strReadString + "' is displayed in the document section", "PASS");
            } else {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should validate the display of document '" + strReadString + "' ", "Document '" + strReadString + "' is NOT displayed in the document section", "FAIL");
            }
            if (icheckNextPageButton > 0) {
                blnStatus = common.SafeAction(Common.o.getObject("eleFirstPage"), "", "eleFirstPage");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return blnStatus;
    }

    private static boolean VerifyEdit_Limitval(String sFieldeleID, String sFieldLimit) throws Exception {
        boolean status = false;
        WebElement sEditBoxObj = CommonManager.getInstance().getCommon().returnObject(By.id(sFieldeleID));
        String[] arrFieldLimit = sFieldLimit.split("##");
        String[] arrLimitDef = {"LOWER", "RANGE", "UPPER"};
        String ErrMsg = null;
        String edtStringValue = null;
        int edtValue = 0;
        for (int i = 0; i < arrLimitDef.length; i++) {
            switch (arrLimitDef[i]) {
                case "LOWER":
                    edtValue = Integer.parseInt(arrFieldLimit[0]);
                    edtValue = edtValue - 1;
                    ErrMsg = arrFieldLimit[2];
                    status = CommonManager.getInstance().getCommon().SafeAction(By.id(sFieldeleID), String.valueOf(edtValue), "edtEDITField");
                    status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNGS_SaveDraft"), "ele", "eleNGS_SaveDraft");
                    status = verify_ScreenErr("ERROR::" + ErrMsg, "");
                    break;
                case "UPPER":
                    edtValue = Integer.parseInt(arrFieldLimit[1]);
                    edtValue = edtValue + 1;
                    ErrMsg = arrFieldLimit[3];
                    status = CommonManager.getInstance().getCommon().SafeAction(By.id(sFieldeleID), String.valueOf(edtValue), "edtEDITField");
                    status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNGS_SaveDraft"), "ele", "eleNGS_SaveDraft");
                    status = verify_ScreenErr("ERROR::" + ErrMsg, "");
                    break;
                case "RANGE":
                    edtValue = RandomNumberRange(Integer.parseInt(arrFieldLimit[0]), Integer.parseInt(arrFieldLimit[1]));
                    status = CommonManager.getInstance().getCommon().SafeAction(By.id(sFieldeleID), String.valueOf(edtValue), "edtEDITField");
                    status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNGS_SaveDraft"), "ele", "eleNGS_SaveDraft");
                    status = verify_ScreenErr("ERROR::" + arrFieldLimit[2], "NOERROR"); // validating no error oon screen
                    status = verify_ScreenErr("ERROR::" + arrFieldLimit[3], "NOERROR");
                    break;
            }

        }

        return status;
    }

    public static Boolean verifyTextInTable(String obj, int readTextCol, String strReadString, String strTableName) throws Exception {
        boolean searchString = false;
        String readText = null;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(obj));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            readText = Cells.get(readTextCol).getText();
            if (readText.contains(strReadString)) {
                searchString = true;
                break;
            }
        }
        return searchString;
    }

    /**
     * function uesd to generate random between ranges
     *
     * @param lowerlimt
     * @param upperlimit
     * @return
     */
    public static int RandomNumberRange(int lowerlimt, int upperlimit) {
        if (lowerlimt >= upperlimit) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((upperlimit - lowerlimt) + 1) + lowerlimt;
    }

    /**
     * @param obj ,readTextCol,getTextCol,strReadString
     * @return String
     * @throws Exception
     * @function this function use to get the text from the table according to the
     * input and the column
     */
    public static boolean verifyFormsDetail(By obj, int formNumCol, int descCol, String strformName, String formDesc) throws Exception {
        String text = null;
        boolean SearchString = false;
        boolean firstpage = true;
        boolean blnForm = false;
        boolean blnStatus = false;
        boolean blnformDesc = false;
        String strPageCount;
        Common common = CommonManager.getInstance().getCommon();
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));

        int icheckNextPageButton = common.ElementSize(Common.o.getObject("eleNextPage"));
        if (icheckNextPageButton > 0) {
            strPageCount = common.ReadElement(Common.o.getObject("eleCommonPageNumber"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
            strPageCount = SCRCommon.getIntFromString(strPageCount);
            for (int i = 0; i < Integer.parseInt(strPageCount); i++) {
                if (!firstpage) {
                    blnStatus = common.SafeAction(Common.o.getObject("eleNextPage"), "eleNextPage", "eleNextPage");
                    blnStatus = common.SafeAction(Common.o.getObject("eleFormsTitle"), "eleFormsTitle", "eleFormsTitle");
                }
                firstpage = false;
                for (int j = 0; j <= allrows.size() - 1; j++) {
                    List<WebElement> Cells = allrows.get(j).findElements(By.tagName("td"));
                    String readText = Cells.get(formNumCol).getText();
                    if (readText.contains(strformName)) {
                        blnForm = true;
                        text = Cells.get(descCol).getText();
                        if (text.contains(formDesc)) {
                            blnformDesc = true;
                            SearchString = true;
                        }
                        break;
                    }
                }
                if (blnformDesc)
                    break;
            }
        } else {
            for (int j = 0; j <= allrows.size() - 1; j++) {
                List<WebElement> Cells = allrows.get(j).findElements(By.tagName("td"));
                String readText = Cells.get(formNumCol).getText();
                if (readText.contains(strformName)) {
                    blnForm = true;
                    text = Cells.get(descCol).getText();
                    if (text.contains(formDesc)) {
                        blnformDesc = true;
                        SearchString = true;
                    }
                    break;
                }
            }
        }
        if (blnForm && blnformDesc) {
            logger.info("Form is available in forms table. '" + strformName + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strformName + "'", "Form '" + strformName + "' and its description '" + formDesc + "' is available in forms table", "PASS");
        } else if (blnForm && !blnformDesc) {
            logger.info("Search String not available in the table. '" + strformName + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Form '" + strformName + "' and its description '" + formDesc + "' should be available in forms table", "Form '" + strformName + "' is available. But description'" + formDesc + "' is not availalbe", "FAIL");
            SearchString = false;
        }
        return SearchString;
    }

    /**
     * @param streleID
     * @param sFieldType
     * @param sDefValue
     * @return
     * @throws Exception
     */
    public static boolean VerifyFieldDefaultValue(String streleID, String sFieldType, String sDefValue) throws Exception {

        boolean status = false;
        String strAttibute = null;
        String sActValue = null;
        WebElement sFieldType1 = CommonManager.getInstance().getCommon().returnObject(By.id(streleID));
        switch (sFieldType.toUpperCase()) {
            case "DROPDOWN":
                strAttibute = "value";
                sActValue = sFieldType1.getAttribute(strAttibute);
                break;
            case "READONLY":
                strAttibute = "text";
                sActValue = sFieldType1.getText();
                break;
            case "TEXTBOX":
                strAttibute = "value";
                sActValue = sFieldType1.getAttribute(strAttibute);
                break;

        }

        if (sActValue.equals(sDefValue)) {
            status = PageScreenShot("FieldDropDownValue");
            logger.info("Default value for the element macthed !!");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether default value matches with the expected .", "Expected Default Value -" + sDefValue + "<BR> Actual value in UI - " + sActValue, "PASS");
            status = true;
        } else {
            status = PageScreenShot("FieldDropDownValue");
            logger.info("Default value for the element doesnt match with the expected !!");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether default value matches with the expected .", "Expected Default Value -" + sDefValue + "<BR> Actual value in UI - " + sActValue + "doesnt match", "FAIL");
            status = false;
        }
        return status;

    }

    public static boolean VerifyDropDownValue(String eleObjID, String expValues) throws Exception {
        boolean status = false;
        boolean blnMatchFound = false;
        String[] sActListValue = null;
        String[] sExpListValue = expValues.split("##");

        for (int j = 0; j < sExpListValue.length; j++) {
            blnMatchFound = false;
            status = CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID), "ele", "eleDropdown");
            CommonManager.getInstance().getCommon().WaitForPageToBeReady();
            ManagerDriver.getInstance().getWebDriver().findElement(By.id(eleObjID)).sendKeys(Keys.ARROW_DOWN);
            CommonManager.getInstance().getCommon().WaitForPageToBeReady();
            List<WebElement> gwListBox = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("LI"));
            status = PageScreenShot("FieldDropDownValue");
            for (int k = 0; k < gwListBox.size(); k++) {
                if (sExpListValue[j].equals(gwListBox.get(k).getText())) {
                    logger.info("Expected UI dropdown value - " + sExpListValue[j] + " is available in List");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are available in UI List", "Expected Dropdown Value - '" + sExpListValue[j] + "' available in UI list", "PASS");
                    blnMatchFound = true;
                    break;
                }
            }
            // status=CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID),
            // "ele", "eleDropdown");
            if (!blnMatchFound) {
                logger.info("Expected UI dropdown value - " + sExpListValue[j] + "is not available in List");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are available in UI List", "Expected Dropdown Value - " + sExpListValue[j] + "NOT available in UI list", "FAIL");
                status = CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID), "ele", "eleDropdown");
            }
        }
        return status;
    }

    public static boolean formsDataValidation(String eleName, int readCol, int actCol, String readStr, String actStr) throws Exception {
        boolean blnStatus = false;
        int valCount;
        int icheckNextPageButton = 0;
        Common common = CommonManager.getInstance().getCommon();
        String strPageCount;
        try {

            valCount = ActionOnTableForms(Common.o.getObject(eleName), readCol, actCol, readStr, actStr);
            if (valCount > 0) {
                blnStatus = true;
            }
            Outer:
            if (valCount == 0) {
                icheckNextPageButton = common.ElementSize(Common.o.getObject("eleNextPage"));
                if (icheckNextPageButton > 0) {
                    strPageCount = common.ReadElement(Common.o.getObject("eleCommonPageNumber"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
                    strPageCount = SCRCommon.getIntFromString(strPageCount);
                    for (int i = 1; i < Integer.parseInt(strPageCount); i++) {
                        blnStatus = common.SafeAction(Common.o.getObject("eleNextPage"), "", "eleNextPage");
                        blnStatus = common.SafeAction(Common.o.getObject("eleFormsTitle"), "", "eleFormsTitle");
                        valCount = ActionOnTableForms(Common.o.getObject(eleName), readCol, actCol, readStr, actStr);
                        if (valCount > 0) {
                            blnStatus = true;
                            break Outer;
                        } else {
                            logger.info("Document with name '" + readStr + "' does not exist in un attached document Table");
                        }
                    }
                }
            }
            switch (valCount) {
                case 0:
                    logger.info("" + readStr + " does not exist in un attqched document Table");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + readStr + " should available in the forms Table", "" + readStr + " is not available in forms Table", "FAIL");
                    break;
                case 1:
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should validate the display of form '" + readStr + "' and description '" + actStr + "'", "Form '" + readStr + "' is available but description '" + actStr + "' is not matching as expected", "FAIL");
                    break;
                case 2:
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should validate the display of form '" + readStr + "' and description '" + actStr + "'", "Form '" + readStr + "' and description '" + actStr + "' are matching as expected", "PASS");
                    break;
            }

            if (icheckNextPageButton > 0) {
                blnStatus = common.SafeAction(Common.o.getObject("eleFirstPage"), "", "eleFirstPage");
            }
        } catch (Exception e) {
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + readStr + " should available in forms Table", "" + readStr + " is not available in forms Table", "FAIL");
            e.printStackTrace();
        }
        return blnStatus;

    }

    /**
     * @param sValue
     * @return boolean
     * @throws Exception
     * @function Verify the warning and error messages on screen
     */
    public static boolean captureAndClearValdiationErrMsg(String sValue) throws Exception {
        boolean status = false;
        String blnPrintStatus = null;
        String refClassName = "ERROR::WARNING::INFO";
        String strXpath = null;
        Common common = CommonManager.getInstance().getCommon();
        List<String> a = new ArrayList<String>();
        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleValidationMsg"));
        String[] arvalidate = refClassName.split("::");

        if (CellElements.size() == 0) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen", "PASS");
            status = true;
            return status;
        }
        for (int i = 0; i < arvalidate.length; i++) {
            switch (arvalidate[i].toUpperCase()) {
                case "ERROR":
                    refClassName = "error_icon";
                    blnPrintStatus = "FAIL";
                    strXpath = "//div[img[@class='info_icon']]";
                    break;
                case "WARNING":
                    refClassName = "warning_icon";
                    blnPrintStatus = "WARNING";
                    strXpath = "//div[img[@class='warning_icon']]";
                    break;
                case "INFO":
                    refClassName = "info_icon";
                    blnPrintStatus = "PASS";
                    strXpath = "//div[img[@class='info_icon']]";
                    break;

            }
            for (WebElement obj : CellElements) {

                List<WebElement> Cells = obj.findElements(By.xpath(strXpath));
                if (Cells.size() == 0) {
                    logger.info("NO " + arvalidate[i] + "displayed on screen");

                } else {
                    for (int j = 0; j < Cells.size(); j++) {

                        String actWarningMsg = Cells.get(j).getText();
                        logger.info(actWarningMsg);
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any " + arvalidate[i] + " is displayed on screen", "Error/Warning message ----- " + actWarningMsg + " ------is displayed on screen", blnPrintStatus);
                    }

                }

            }
            if (common.ElementEmpty(Common.o.getObject("eleValidation_ClearBtn"))) {
                status = common.SafeAction(Common.o.getObject("eleValidation_ClearBtn"), "eleValidation_ClearBtn", "eleValidation_ClearBtn");
            }
        }

        // check for Warnging in UI list

        /*
         * for(String expText: expWarnignMsg) { boolean matchStatus = false;
         * expectedText = expText.toString(); for(String actText: a) { if
         * (actText.equals(expText)) { matchStatus = true;
         * logger.info("Expected Warning Message  is matching with actual message '" +
         * expectedText + "'"); HTML.fnInsertResult(PCThreadCache.getInstance()
         * .getProperty("testcasename"),
         * PCThreadCache.getInstance().getProperty("methodName"),
         * "Expected error text should matching with actual text '" + expectedText +
         * "'","Expected error text is matching with actual text '" + expectedText +
         * "'", "PASS"); break; } }
         *
         * if(matchStatus == false) { logger.info(
         * "Expected Warning Message is not matching with actual message '" +
         * expectedText + "'");
         * HTML.fnInsertResult(PCThreadCache.getInstance().getProperty ("testcasename"),
         * PCThreadCache.getInstance().getProperty("methodName"),
         * "Expected error text should matching with actual text '" + expectedText +
         * "'","Expected error text is not matching with actual text '" + expectedText +
         * "'", "FAIL"); //Status = false; } }
         */

        return status;

    }

    /**
     * @param obj ,readCol,actionCol,strReadString,actionObjetName
     * @return status
     * @throws Exception
     * @function This function use to Select the data from the table and click the
     * element accordingly
     */
    public static int ActionOnTableForms(By obj, int readCol, int actionCol, String strReadString, String strGetString) throws Exception {

        boolean SearchString = false;
        boolean getString = false;
        int trueCount = 0;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                SearchString = true;
                trueCount += 1;
                logger.info("Search String is available in the table. '" + strReadString + "'");
                String getText = Cells.get(actionCol).getText();
                if (getText.equals(strGetString)) {
                    getString = true;
                    trueCount += 1;
                    logger.info("Search String is available in the table. '" + strGetString + "'");
                    break;
                }
            }

            if (getString || SearchString) {
                break;
            }
        }
        if (SearchString && !getString) {
            logger.info("Search String not available in the table. '" + strGetString + "'");
            // HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"),
            // PCThreadCache.getInstance().getProperty("methodName"), "Form '" +
            // strReadString+"' and its description '"+strGetString +
            // "' should be available in forms table","Form '" +
            // strReadString+"' is available. But description'"+strGetString+"' is not
            // availalbe",
            // "FAIL");

        }

        return trueCount;
    }

    /**
     * @param sFuncValue
     * @return true/false
     * @throws IOException
     * @function This function will deselct the check box by using the label name
     */
    public static Boolean RemoveCoverageSelected(String sFuncValue) throws IOException {
        Boolean status = false;
        Boolean blnCoverageAvailable = false;
        String getIDofLabel = null;
        String[] sSplitID = null;
        String actualID = null;
        String actualTblID = null;
        @SuppressWarnings("unused")
        List<WebElement> abcd = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
        blnCoverageAvailable = getCoverageNameID(sFuncValue);
        if (blnCoverageAvailable) {
            logger.info("" + sFuncValue + " label found in the Screen");
            String GetCovID = PCThreadCache.getInstance().getProperty(PCConstants.CoverageID);
            WebElement sTargetLegend = CommonManager.getInstance().getCommon().returnObject(By.id(GetCovID));
            getIDofLabel = sTargetLegend.getAttribute("id");
            sSplitID = getIDofLabel.split("-");
            actualID = sSplitID[0].concat(":_checkbox");
            actualTblID = sSplitID[0].concat("-legendChk");

            try {

                WebElement sCheckBox = CommonManager.getInstance().getCommon().returnObject(By.id(actualTblID));
                String sClassName = sCheckBox.getAttribute("class");
                if (sClassName.endsWith("x-form-cb-checked")) {
                    logger.info("Already Checkbox is selected." + sFuncValue + "");
                    status = CommonManager.getInstance().getCommon().SafeAction(By.id(actualID), "elj" + sFuncValue + "", "elj" + sFuncValue + "");
                    logger.info("Clicked the checkbox of " + sFuncValue + "");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the coverage is available to remove", "As expected,Coverage - " + sFuncValue + "is removed from screen", "PASS");
                } else {

                    logger.info("Already Covergae is not in Selected mode " + sFuncValue + "");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the coverage is available to remove", "As expected,Coverage - " + sFuncValue + "is not available to remove", "WARNING");
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.info("Unable to click the elj" + sFuncValue + " checkbox");
                e.printStackTrace();
            }
        } else {

            logger.info("" + sFuncValue + " is not present in the Screen");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "'" + sFuncValue + "' CheckBox should available in the system", "'" + sFuncValue + "' CheckBox is not available in the system", "FAIL");

        }

        return status;
    }

    /**
     * @param obj
     * @return
     * @throws Exception
     * @function This function use to count the rows from the table
     */
    public static int CountTableRows(By obj) throws Exception {

        int trueCount = 0;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        trueCount = allrows.size();
        return trueCount;
    }

    /**
     * @param
     * @return blnstatus
     * @throws Exception
     * @function This function use to count the total number of classcodes from the
     * table
     */
    public static boolean verifyClassCodesCountPC_CDR(String sValue) throws Exception {
        boolean blnstatus = false;
        boolean status;
        int singleCount = CountTableRows(Common.o.getObject("eleClassCodeTable"));
        status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject("eleNavigateLastPage"), "", "ele");
        if (status) {
            WebElement pages = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("edtLastPageCount"));

            int num = Integer.parseInt(pages.getAttribute("value")) - 1;
            num = (singleCount * num) + CountTableRows(Common.o.getObject("eleClassCodeTable"));
            int count = Integer.parseInt(sValue);
            if (num == count) {
                blnstatus = true;
                logger.info("Number of class codes in PC  matches with CDR");

                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + num + " class codes in PC", "" + count + " class codes in CDR", "PASS");
            } else {
                logger.info("Number of class codes in PC DOES NOT matches with CDR");

                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + num + " class codes in PC", "" + count + " class codes in CDR", "FAIL");
            }

        }

        return blnstatus;

    }

    /**
     * @param
     * @return blnstatus
     * @throws Exception
     * @function This function use to match the columns of classcodes table from PC
     * to CDR
     **/
    public static boolean verifyClassCodesDetailsCDR(String sFuncValue) throws Exception {
        boolean blnstatus = true;
        String[] arrclscode = sFuncValue.split(":::");
        int trueCount = 0;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("eleClassCodeTable"));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            for (int j = 1; j <= 11; j++) {

                String pctext = Cells.get(j).getText();

                if (pctext.equals(arrclscode[j])) {
                    logger.info("Column " + j + " matched");

                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + pctext + " displayed in PC", "" + arrclscode[j] + " displayed in CDR", "PASS");

                } else {
                    blnstatus = false;
                    logger.info("Column " + j + " didnt match");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + pctext + " displayed in PC", "" + arrclscode[j] + " displayed in CDR", "FAIL");

                }

            }
        }
        return blnstatus;
    }

    /**
     * @param obj
     * @param readTextCol
     * @param strReadString
     * @return String
     * @throws Exception
     * @function This function used to check the non availability of the Element in
     * the Table
     */
    public static Boolean verifyTextFromTableFalse(String obj, int readTextCol, String strReadString, String strTableName) throws Exception {
        boolean SearchString = false;
        String readText = null;
        Common common = CommonManager.getInstance().getCommon();
        if (common.ElementSize(Common.o.getObject("ele" + obj)) <= 0) {
            SearchString = false;
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should not avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is not avilable in the " + strTableName + " table", "PASS");
        } else {
            WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(obj));
            List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
            for (int i = 0; i <= allrows.size() - 1; i++) {
                List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
                readText = Cells.get(readTextCol).getText();
                if (readText.contains(strReadString)) {
                    SearchString = true;
                    break;
                }
            }
        }

        if (!SearchString) {
            // logger.info("Search String not available in the table. '" +
            // strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should not avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is not avilable in the " + strTableName + " table", "PASS");
        } else {
            // logger.info("Search String available in the table. '" +
            // strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is  avilable in the " + strTableName + " table", "FAIL");

        }
        return SearchString;
    }

    public static Boolean verifyTextFromTableTrue(String obj, int readTextCol, String strReadString, String strTableName) throws Exception {
        boolean SearchString = false;
        String readText = null;
        Common common = CommonManager.getInstance().getCommon();
        if (common.ElementSize(Common.o.getObject("ele" + obj)) <= 0) {
            SearchString = false;
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should not avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is not avilable in the " + strTableName + " table", "FAIL");
        } else {
            WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject("ele" + obj));
            List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
            for (int i = 0; i <= allrows.size() - 1; i++) {
                List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
                readText = Cells.get(readTextCol).getText();
                if (readText.contains(strReadString)) {
                    SearchString = true;
                    break;
                }
            }
        }

        if (!SearchString) {
            logger.info("Search String not available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should not avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is not avilable in the " + strTableName + " table", "FAIL");
        } else {
            logger.info("Search String available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is  avilable in the " + strTableName + " table", "PASS");

        }
        return SearchString;
    }

    /**
     * @param obj
     * @param readTextCol
     * @param strReadString
     * @return String
     * @throws Exception
     * @function This function use to get the text from the table according to the
     * column
     */
    public static Boolean verifyTextFromTable(String obj, int readTextCol, int actionTextCol, String strReadString, String strActionString, String strTableName) throws Exception {
        boolean SearchString = false;
        boolean ActionString = false;
        String readText = null;
        String actionText = null;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(obj));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            readText = Cells.get(readTextCol).getText();
            if (readText.contains(strReadString)) {
                SearchString = true;
                actionText = Cells.get(actionTextCol).getText();
                if (actionText.contains(strActionString)) {
                    ActionString = true;
                }
                break;
            }
        }
        if (SearchString) {
            // logger.info("Search String available in the table. '" +
            // strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Read String '" + strReadString + "' should avilable in the " + strTableName + " table", "Read String '" + strReadString + "' is avilable in the " + strTableName + " table", "PASS");
            if (ActionString) {
                // logger.info("Search String available in the table. '" +
                // strReadString + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Action Search string '" + strActionString + "' should avilable in the " + strTableName + " table", "Action Search string '" + strActionString + "' is avilable in the " + strTableName + " table", "PASS");
            } else {
                // logger.info("Search String not available in the table. '" +
                // strReadString + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Read String '" + strActionString + "' should avilable in the " + strTableName + " table", "Read String '" + strActionString + "' is not avilable in the " + strTableName + " table", "FAIL");
                ActionString = false;
            }
        } else {
            // logger.info("Search String not available in the table. '" +
            // strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Search string '" + strReadString + "' should avilable in the " + strTableName + " table", "Search string '" + strReadString + "' is not avilable in the " + strTableName + " table", "FAIL");
            SearchString = false;
        }
        return SearchString;
    }

    /**
     * @param sValue
     * @return boolean
     * @throws IOException
     * @function Verify the warning and error messages on sNGS screen
     */
    public static boolean verify_ScreenErr(String sValue, String sAvailablity) throws IOException {
        boolean status = true;
        String expectedText = null;
        String refClassName = null;
        String[] arrMessgage = sValue.split("::");
        String[] expWarnignMsg = arrMessgage[1].split(":::");
        String actMsgText = null;
        List<String> a = new ArrayList<String>();
        // ArrayList actWarningMsg=new ArrayList();
        String strXpath = null;
        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCommonErrorObject"));
        if (arrMessgage[0].toUpperCase().contentEquals("ERROR")) {
            refClassName = "error_icon";

        } else if (arrMessgage[0].toUpperCase().contentEquals("WARNING")) {
            refClassName = "warning_icon";
        } else if (arrMessgage[0].toUpperCase().contentEquals("INFO")) {
            refClassName = "info_icon";
        }
        if (CellElements.size() == 0 && expWarnignMsg[0].equals("NIL")) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "As Expected,No Error/Warning messgae in the screen to validate", "PASS");
            status = true;
        } else if (CellElements.size() == 0 && !(expWarnignMsg[0].equals("NIL"))) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "No Error/Warning messgae in the screen to validate", "FAIL");
            status = true;
        }
        for (int i = 0; i <= CellElements.size() - 1; i++) {
            // img[@class='']/../div
            strXpath = "div[img[@class='<refClassName>']]";
            strXpath = strXpath.replace("<refClassName>", refClassName);
            List<WebElement> Cells = CellElements.get(i).findElements(By.xpath(strXpath));
            if (Cells.size() != 0) {
                for (int j = 0; j < Cells.size(); j++) {
                    String actWarningMsg = Cells.get(j).getText();
                    a.add(actWarningMsg);
                    logger.info(actWarningMsg);
                }

            }
        }

        // check for Warnging in UI list

        for (String expText : expWarnignMsg) {
            boolean matchStatus = false;
            expectedText = expText.toString();
            for (String actText : a) {
                actMsgText = actText;
                if (actText.equals(expText)) {
                    matchStatus = true;
                    logger.info("Expected Warning Message  is matching with actual message '" + expectedText + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error/warning text '" + expectedText + "' should matching with actual text '" + expectedText + "'", "Expected error/warning text '" + expectedText + "' is matching with actual text '" + actMsgText + "'", "PASS");
                    break;
                }
            }

            if (matchStatus == false && sAvailablity != "NOERROR") {
                logger.info("Expected Warning Message is not matching with actual message in UI '" + expectedText + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error/warning text '" + expectedText + "' should matching with actual text '" + actMsgText + "'", "Expected error text is not matching with actual text '" + expectedText + "'", "FAIL");
                // Status = false;
            } else if (matchStatus == false && sAvailablity == "NOERROR") {
                logger.info("Expected Warning Message is not matching with actual message in UI '" + expectedText + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected error text should matching with actual text '" + expectedText + "'", "As expected Expected error message is not displayed in UI '" + expectedText + "'", "PASS");
                // Status = false;
            }
        }

        return status;

    }

    /**
     * function perform the actions on action menu with scroll activity handled
     *
     * @param sFuncValue
     * @return true/false
     * @throws Exception
     */
    public static boolean selectActionItems(String sFuncValue) throws Exception {
        Boolean blnStatus = false;
        logger.info("Entering into the selectActionItems function");
        Common common = CommonManager.getInstance().getCommon();
        String[] arrActivtyName = sFuncValue.split("&&");
        int Counter = 0;
        List<WebElement> sGetList = null;
        outer:
        for (String strEachActivity : arrActivtyName) {
            blnStatus = false;
            inner:
            for (int i = 0; i < 50; i++) {
                if (Counter == 2) {
                    sGetList = ManagerDriver.getInstance().getWebDriver().findElements(By.xpath(".//*[@class='x-menu-item-link x-menu-item-indent-no-separator']"));
                } else if (Counter == 0 || Counter == 1) {
                    sGetList = ManagerDriver.getInstance().getWebDriver().findElements(By.xpath(".//*[@class='x-menu-item-link x-menu-item-indent-no-separator x-menu-item-indent-right-arrow']"));
                }
                // List<WebElement> sGetList =
                // ManagerDriver.getInstance().getWebDriver().findElements(By.className("x-menu-item-text"));
                for (WebElement element : sGetList) {
                    String objName = element.getText();
                    System.out.println(objName);
                    if (objName.equals(strEachActivity)) {
                        logger.info("" + strEachActivity + " Activity found");
                        String readAttriID1 = element.getAttribute("id");
                        blnStatus = common.SafeAction(By.id(readAttriID1), "", "ele" + strEachActivity + "");
                        Thread.sleep(500);
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should click the " + strEachActivity + " Activity", "System clicked " + strEachActivity + " Activity", "PASS");
                        blnStatus = true;
                        Counter = Counter + 1;
                        break inner;
                    }
                }
                if (blnStatus == false) {
                    int eleActvityScrollBottomCount = common.ElementSize(Common.o.getObject("eleActvityScrollBottom"));
                    if (eleActvityScrollBottomCount > 0) {
                        for (int j = 0; j <= 10; j++) {
                            common.SafeAction(Common.o.getObject("eleActvityScrollBottom"), "eleActvityScrollBottom", "eleActvityScrollBottom");
                        }
                    } else {
                        if (blnStatus == false) {
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strEachActivity + "Activity should present in the activity list of " + arrActivtyName[1] + "", "" + strEachActivity + " Activity is not present in the activity list of " + arrActivtyName[1] + "", "FAIL");
                            break outer;
                        }
                    }
                }
            }
        }
        return blnStatus;
    }

    public static boolean selectAdminApplicationLinks(String sFuncValue) throws Exception {
        Boolean blnStatus = false;
        logger.info("Entering into the selectActionItems function");
        Common common = CommonManager.getInstance().getCommon();
        String[] arrActivtyName = sFuncValue.split("&&");
        int Counter = 0;
        List<WebElement> sGetList = null;
        outer:
        for (String strEachActivity : arrActivtyName) {
            blnStatus = false;
            inner:
            for (int i = 0; i < 50; i++) {
                if (Counter == 1) {
                    sGetList = ManagerDriver.getInstance().getWebDriver().findElements(By.xpath(".//*[@class='x-menu-item-link x-menu-item-indent-no-separator']"));
                } else if (Counter == 0) {
                    sGetList = ManagerDriver.getInstance().getWebDriver().findElements(By.xpath(".//*[@class='x-menu-item-link x-menu-item-indent-no-separator x-menu-item-indent-right-arrow']"));
                }
                // List<WebElement> sGetList =
                // ManagerDriver.getInstance().getWebDriver().findElements(By.className("x-menu-item-text"));
                for (WebElement element : sGetList) {
                    String objName = element.getText();
                    System.out.println(objName);
                    if (objName.equals(strEachActivity)) {
                        logger.info("" + strEachActivity + " Activity found");
                        String readAttriID1 = element.getAttribute("id");
                        blnStatus = common.SafeAction(By.id(readAttriID1), "", "ele" + strEachActivity + "");
                        Thread.sleep(500);
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should click the " + strEachActivity + " Activity", "System clicked " + strEachActivity + " Activity", "PASS");
                        blnStatus = true;
                        Counter = Counter + 1;
                        break inner;
                    }
                }
                if (!blnStatus) {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strEachActivity + "Activity should present in the activity list of " + arrActivtyName[1] + "", "" + strEachActivity + " Activity is not present in the activity list of " + arrActivtyName[1] + "", "FAIL");
                    break outer;
                }
            }
        }
        return blnStatus;
    }

    public static Boolean ValidateFLS_Field(String strFieldName, String sFieldType, String sDefValue, String sFieldMode, String sCoverageName) throws Exception {
        Boolean status = true;
        Boolean blnCoverageAvailable = false;
        String sSplitID[] = null;
        String sPCLabelValue = null;
        Boolean sChildLabel = false;
        String sFieldID = null;
        String[] sLabelIDSplit = null;
        String sNewID = null;
        int intCounterCase = 0;
        String fieldType = null;
        blnCoverageAvailable = getCoverageNameID(sCoverageName);
        if (blnCoverageAvailable) {
            logger.info("" + sCoverageName + " label found in the Screen");
            String GetCovID = PCThreadCache.getInstance().getProperty(PCConstants.CoverageID);
            sSplitID = GetCovID.split("-");
            By sTargetID = By.id(sSplitID[0]);
            switch (strFieldName.toUpperCase()) {
                case "ADD":
                    sFieldID = sSplitID[0].concat(":CoverageSchedule:BP7ScheduleInputSet:BP7ScheduledItemsLV_tb:AddContactsButton-btnEl");
                    break;
                case "REMOVE":
                    sFieldID = sSplitID[0].concat(":CoverageSchedule:BP7ScheduleInputSet:BP7ScheduledItemsLV_tb:Remove-btnEl");
                    break;
            }
            int eleSize = CommonManager.getInstance().getCommon().ElementSize(By.id(sFieldID));
            if (eleSize > 0) {
                intCounterCase = 1;
                // Valdiate its Field Mode
                status = validateFLS_FieldMode(strFieldName, sFieldID, sFieldMode);
                // Validate Field Type

                WebElement sTargetLegend = CommonManager.getInstance().getCommon().returnObject(By.id(sFieldID));
                switch (sFieldType.toUpperCase()) {
                    case "BUTTON":
                        fieldType = sTargetLegend.getAttribute("class");
                        if (fieldType.equals("x-btn-button")) {
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType  in Coverage is displayed in UI", "Field : " + strFieldName + " displayed in screen", "PASS");
                        } else {
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the FieldType  in Coverage is displayed in UI", "Field : " + strFieldName + " NOT displayed in screen", "FAIL");
                        }
                        break;
                }

            }

            switch (intCounterCase) {
                case 0:
                    if (sFieldType.equalsIgnoreCase("NOT_AVAIL")) {
                        status = true;
                        logger.info("" + strFieldName + " is not present in the Screen");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the field is NOT displayed in UI", "Field - " + strFieldName + " not displayed in screen", "PASS");
                    } else {
                        status = true;
                        logger.info("" + strFieldName + " is not present in the Screen");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the field is displayed in UI", "Field - " + strFieldName + " not displayed in screen", "FAIL");
                    }
                    break;
            }
        } else {
            logger.info("" + sCoverageName + " is not present in the Screen");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Coverage is displayed in UI", "Coverage - " + sCoverageName + " not displayed in screen", "FAIL");
        }
        return status;
    }

    public static Boolean validateFLS_FieldMode(String strFieldName, String sFieldID, String sFieldMode) throws Exception {
        boolean status = true;
        String sClassName = null;
        String NewFieldID = sFieldID.replace("-btnEl", "");
        String sXpath = "//a[@id='" + NewFieldID + "']";
        WebElement sTargetLegend = CommonManager.getInstance().getCommon().returnObject(By.xpath(sXpath));
        switch (sFieldMode.toUpperCase()) {
            case "ENABLED":
                sClassName = sTargetLegend.getAttribute("class");
                if (!sClassName.contains("x-btn-disabled")) {
                    logger.info("" + strFieldName + " is dispalyed as ENABLED in the Screen");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify the Field Existence Mode- Enable/Disable", "Field - " + strFieldName + " is displayed as ENABLED as expected", "PASS");
                } else {
                    logger.info("" + strFieldName + " is NOT dispalyed as ENABLED in the Screen");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify the Field Existence Mode- Enable/Disable", "Field - " + strFieldName + " is NOT displayed as ENABLED as expected", "FAIL");
                }
                break;
            case "DISABLED":
                sClassName = sTargetLegend.getAttribute("class");
                if (sClassName.contains("x-btn-disabled")) {
                    logger.info("" + strFieldName + " is dispalyed as DISABLED in the Screen");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify the Field Existence Mode- Enable/Disable", "Field - " + strFieldName + " is displayed as DISABLED as expected", "PASS");
                } else {
                    logger.info("" + strFieldName + " is NOT dispalyed as DISABLED in the Screen");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify the Field Existence Mode- Enable/Disable", "Field - " + strFieldName + " is NOT displayed as DISABLED as expected", "FAIL");
                }
                break;
        }
        return status;

    }

    public static boolean selectActionApplicationLink(String sFuncValue) throws Exception {
        Boolean blnStatus = false;
        logger.info("Entering into the selectActionItems function");
        Common common = CommonManager.getInstance().getCommon();
        String[] arrActivtyName = sFuncValue.split("&&");
        Integer intsize = 0;
        outer:
        for (String strEachLink : arrActivtyName) {
            blnStatus = false;
            inner:

            for (int i = 0; i <= 50; i++) {

                List<WebElement> sGetList = ManagerDriver.getInstance().getWebDriver().findElements(By.className("x-menu-item-text"));

                for (WebElement element : sGetList) {

                    String readAttriID1 = element.getAttribute("id");
                    int size = common.ElementSize(By.id(readAttriID1));
                    if (size > 0) {
                        String objName = element.getText();
                        if (objName.equals(strEachLink)) {
                            logger.info("" + strEachLink + " MenuItem found");
                            String readAttriID2 = element.getAttribute("id");
                            if (readAttriID2.contains(":UWRef_ExtMenuItemSet:") && strEachLink.equals(arrActivtyName[1])) {
                                blnStatus = common.SafeAction(By.id(readAttriID2), "", "ele" + strEachLink + "");
                                Thread.sleep(500);
                                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should click the " + strEachLink + " Link", "System clicked " + strEachLink + " Link", "PASS");
                                blnStatus = true;
                                break inner;
                            } else if (!readAttriID2.contains(":UWRef_ExtMenuItemSet:") && strEachLink.equals(arrActivtyName[0])) {
                                blnStatus = common.SafeAction(By.id(readAttriID2), "", "ele" + strEachLink + "");
                                Thread.sleep(500);
                                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should click the " + strEachLink + " Link", "System clicked " + strEachLink + " Link", "PASS");
                                blnStatus = true;
                                break inner;
                            }

                            // break inner;
                        }
                    }

                }

            }
            if (blnStatus == false) {
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strEachLink + "Link should present in the list", "" + strEachLink + " Link is not present in the list", "FAIL");
                break outer;
            }
        }
        return blnStatus;
    }

    public static boolean ComparevalidationErrMsg(String sMsgType, String sExpErr, String sErrAvailablity) throws Exception {
        boolean status = false;
        String blnPrintStatus = null;
        String refClassName = null;
        String strXpath = null;
        Common common = CommonManager.getInstance().getCommon();
        List<String> a = new ArrayList<String>();
        Boolean blnMatchFound = false;
        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleValidationMsg"));
        // String[] arvalidate=refClassName.split("::");

        if (CellElements.size() == 0 && sErrAvailablity.equalsIgnoreCase("NOERROR")) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen", "PASS");
            status = true;
            return status;
        } else if (CellElements.size() == 0) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen", "FAIL");
            status = true;
            return status;
        }

        switch (sMsgType.toUpperCase()) {
            case "ERROR":
                refClassName = "error_icon";
                // blnPrintStatus="FAIL";
                strXpath = "//div[img[@class='error_icon']]";
                break;
            case "WARNING":
                refClassName = "warning_icon";
                // blnPrintStatus="WARNING";
                strXpath = "//div[img[@class='warning_icon']]";
                break;
            case "INFO":
                refClassName = "info_icon";
                // blnPrintStatus="PASS";
                strXpath = "//div[img[@class='info_icon']]";
                break;
        }
        for (WebElement obj : CellElements) {

            List<WebElement> Cells = obj.findElements(By.xpath(strXpath));
            if (Cells.size() == 0) {
                logger.info("NO " + sMsgType + "displayed on screen");

            } else {
                for (int j = 0; j < Cells.size(); j++) {

                    String actWarningMsg = Cells.get(j).getText();
                    if (actWarningMsg.equals(sExpErr)) {
                        blnMatchFound = true;
                    }

                }
                if (blnMatchFound && !sErrAvailablity.equalsIgnoreCase("NOERROR")) {
                    logger.info("As expected Expected and Actual Messgae Matches !!");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate expected  " + sMsgType + " is displayed on screen", "Error/Warning message ----- <BR> Expected Message - " + sExpErr + " is displayed on screen", "PASS");
                } else if (!blnMatchFound && sErrAvailablity.equalsIgnoreCase("NOERROR")) {
                    logger.info("As expected Expected is not availabel in Screen !!");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate expected  " + sMsgType + " is NOT displayed on screen", " Expected Error/Warning message ----- <BR>- " + sExpErr + " is NOT displayed on screen", "PASS");
                } else if (!blnMatchFound && !sErrAvailablity.equalsIgnoreCase("NOERROR")) {
                    logger.info("Expected message is not availabel in Screen !!");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate expected  " + sMsgType + " is displayed on screen", " Expected Error/Warning message ----- <BR>- " + sExpErr + " is NOT displayed on screen", "FAIL");
                }

            }

        }
        if (common.ElementEmpty(Common.o.getObject("eleValidation_ClearBtn"))) {
            status = common.SafeAction(Common.o.getObject("eleValidation_ClearBtn"), "eleValidation_ClearBtn", "eleValidation_ClearBtn");
        }

        return status;

    }

    public static Boolean ActionOnTableCheckBox(By obj, int readCol, int actionCol, String strReadString, String sTagName, String strElementName) throws Exception {
        boolean Status = false;
        boolean SearchString = false;
        boolean ActionObject = false;
        Common common = CommonManager.getInstance().getCommon();
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                SearchString = true;
                List<WebElement> CellElements = Cells.get(actionCol).findElements(By.tagName(sTagName));
                for (WebElement element : CellElements) {
                    ActionObject = true;
                    element.click();
                    Status = SCRCommon.JavaScript(js);
                    Status = common.SafeAction(Common.o.getObject(strElementName), "", strElementName);
                    break;
                }
            }
            if (ActionObject == true) {
                break;
            }
        }
        if (SearchString) {
            logger.info("Search String available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + strReadString + "'", "PASS");
            if (ActionObject) {
                logger.info("Search and click on object in the table cell and object name is '" + strReadString + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + strReadString + "'", "System searched object in the table and clicked on object. object name is '" + strReadString + "'", "PASS");
                Status = true;
            } else {
                logger.info("Search and click on object in the table cell and object name is '" + strReadString + "'");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search object in the table cell and click on object. Object name is '" + strReadString + "'", "System searched object in the table and clicked on object. object name is '" + strReadString + "'", "FAIL");
                Status = false;
            }
        } else {
            logger.info("Search String not available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + strReadString + "'", "FAIL");
            Status = false;
        }
        return Status;
    }

    public static String returnDate(int datereduction) {
        String targetDate = null;
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, datereduction);
        targetDate = (date.get(Calendar.MONTH) + 1) + "/" + (date.get(Calendar.DATE) + "/" + (date.get(Calendar.YEAR)));
        /*
         * System.out.println(cal.getTime()); // Output "Wed Sep 26 14:23:28 EST 2012"
         *
         * String formatted = format1.format(cal.getTime());
         * System.out.println(formatted); // Output "2012-09-26"
         *
         * System.out.println(format1.parse(formatted));
         */
        return targetDate;
    }

    public static Boolean ActionOnTable(By obj, int readCol, int actionCol, String strReadString, String sTagName) throws Exception {
        boolean Status = false;
        boolean ActionObject = false;
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                List<WebElement> CellElements = Cells.get(actionCol).findElements(By.tagName(sTagName));
                for (WebElement element : CellElements) {
                    ActionObject = true;
                    element.click();
                    /*
                     * WebDriverWait wait = new WebDriverWait(ManagerDriver
                     * .getInstance().getWebDriver(), Integer.parseInt(HTML.properties
                     * .getProperty("VERYLONGWAIT")));
                     * wait.until(ExpectedConditions.stalenessOf(element));
                     */
                    Status = SCRCommon.JavaScript(js);
                    Status = true;
                    break;
                }
            }
            if (ActionObject == true) {
                break;
            }
        }
        return Status;
    }

    public static boolean ActionOnTable(By obj, int readCol, int readCol1, int actionCol, String strReadString, String strReadString1, String actionObjetName, String sTagName) throws Exception {
        boolean Status = false;
        boolean ActionObject = false;
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                String readText1 = Cells.get(readCol1).getText();
                if (readText1.contains(strReadString1)) {
                    List<WebElement> CellElements = Cells.get(actionCol).findElements(By.tagName(sTagName));
                    for (WebElement element : CellElements) {
                        String objName = element.getText();
                        if (objName.contains(actionObjetName)) {
                            ActionObject = true;
                            element.click();
                            Status = SCRCommon.JavaScript(js);
                            break;
                        }
                    }
                }
            }
            if (ActionObject == true) {
                break;
            }
        }
        return Status;
    }

    public static boolean ActionOnTable(By obj, int readCol, int readCol1, int readCol2, int actionCol, String strReadString, String strReadString1, String strReadString2, String actionObjetName, String sTagName) throws Exception {
        boolean Status = false;
        boolean ActionObject = false;
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                String readText1 = Cells.get(readCol1).getText();
                if (readText1.contains(strReadString1)) {
                    String readText2 = Cells.get(readCol2).getText();
                    if (readText2.contains(strReadString2)) {
                        List<WebElement> CellElements = Cells.get(actionCol).findElements(By.tagName(sTagName));
                        for (WebElement element : CellElements) {
                            String objName = element.getText();
                            if (objName.contains(actionObjetName)) {
                                ActionObject = true;
                                element.click();
                                Status = SCRCommon.JavaScript(js);
                                break;
                            }
                        }
                    }
                }
            }
            if (ActionObject == true) {
                break;
            }
        }
        return Status;
    }


    public static Boolean ActionOnTable(By obj, int readCol, int actionCol, String strReadString, String actionObjetName, String sTagName) throws Exception {
        boolean Status = false;
        boolean SearchString = false;
        boolean ActionObject = false;
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                SearchString = true;
                List<WebElement> CellElements = Cells.get(actionCol).findElements(By.tagName(sTagName));
                for (WebElement element : CellElements) {
                    String objName = element.getText();
                    if (objName.contains(actionObjetName)) {
                        // Status = true;
                        ActionObject = true;
                        element.click();
                        Status = SCRCommon.JavaScript(js);
                        break;
                    }
                }
            }
            if (ActionObject == true) {
                break;
            }
        }
        return Status;
    }

    public static String getIntFromString(String strFuncValue) {
        String str = strFuncValue;
        StringBuilder myNumbers = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                myNumbers.append(str.charAt(i));
                // System.out.println(str.charAt(i) + " is a digit.");
            } else {
                // System.out.println(str.charAt(i) + " not a digit.");
            }
        }
        return myNumbers.toString();
    }

    public static Boolean unDisCardChanges() {
        Boolean blnStatus = false;
        Common common = CommonManager.getInstance().getCommon();
        try {
            int iUnDiscardChanges = common.ElementSize(Common.o.getObject("eleUnDiscardChanges"));
            if (iUnDiscardChanges > 0) {
                logger.info("UnSaved Changes found");
                blnStatus = common.SafeAction(Common.o.getObject("eleUnDiscardChanges"), "", "eleUnDiscardChanges");
                int iEditTransaction = common.ElementSize(Common.o.getObject("eljPolicyInfo_EditTransaction"));
                if (iEditTransaction > 0) {
                    blnStatus = common.SafeAction(Common.o.getObject("eljPolicyInfo_EditTransaction"), "", "eljPolicyInfo_EditTransaction");
                    blnStatus = common.SafeAction(Common.o.getObject("eleAlertPopUp"), "", "eleAlertPopUp");
                }
            } else {
                logger.info("UnSaved Changes not found");
                blnStatus = true;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return blnStatus;
    }

    public static Boolean unDisCardChangesCommon() {
        Boolean blnStatus = false;
        Common common = CommonManager.getInstance().getCommon();
        try {
            int iUnDiscardChanges = common.ElementSize(Common.o.getObject("eleUnDiscardChanges"));
            if (iUnDiscardChanges > 0) {
                logger.info("UnSaved Changes found");
                blnStatus = common.SafeAction(Common.o.getObject("eleUnDiscardChanges"), "", "eleUnDiscardChanges");
            } else {
                logger.info("UnSaved Changes not found");
                blnStatus = true;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return blnStatus;
    }

    public static boolean activityValidation_sheetref(String sheetName) {
        logger.info("*****Entering into Activity Validation function*****");
        Boolean status = false;
        Boolean tcAvailable = false;
        String TCID = null;
        String TCIDAdd = null;
        String strColumnValue = null;
        String strColumnName = null;
        String sIteration = null;
        String strTargetDays = null;
        String strTargetStartPoint = null;
        String strTargetIncludeDays = null;
        String strExpected = null;
        String recDate = null;
        String arnDueDate = null;
        String targetDaysHrs = null;
        String strVal = null;
        String[] strArray = null;
        boolean blnLoggeduser = false;
        int rowcount;
        int addDays, addHrs;
        XlsxReader sXL = XlsxReader.getInstance();
        Common common = CommonManager.getInstance().getCommon();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        DateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        Date baseDate = new Date();
        try {
            rowcount = sXL.getRowCount(sheetName);
            for (int i = 2; i <= rowcount; i++) {
                TCID = PCThreadCache.getInstance().getProperty("TCID");
                TCIDAdd = sXL.getCellData(sheetName, "ID", i);
                sIteration = sXL.getCellData(sheetName, "Iteration", i);
                if (TCIDAdd.equals(TCID) && sIteration.equalsIgnoreCase(PCThreadCache.getInstance().getProperty(PCConstants.Iteration))) {
                    tcAvailable = true;
                    int colcount = sXL.getColumnCount(sheetName);
                    for (int j = 2; j <= colcount; j++) {
                        strColumnValue = sXL.getCellData(sheetName, j, i);
                        strColumnName = sXL.getCellData(sheetName, j, 1);
                        if (!strColumnName.isEmpty() && !strColumnValue.isEmpty()) {
                            // strUserType=sXL.getCellData(sheetName,
                            // colcount-1, i);
                            switch (strColumnName.toUpperCase()) {
                                case "VERIFYLOGGEDUSERNAME":
                                    if (strColumnValue.equalsIgnoreCase("YES")) {
                                        String expUserName = PCThreadCache.getInstance().getProperty("LOGGED_USERNAME");
                                        String strAssignTo = common.ReadElement(Common.o.getObject("Activity_AssignTo"), 10);
                                        if (expUserName.equalsIgnoreCase(strAssignTo.trim())) {
                                            blnLoggeduser = true;
                                        }
                                    }
                                    break;
                                case "SUBJECT":
                                    status = SCRCommon.verifyResults("Activity_ActivitySubject", strColumnValue, "VERIFYELEMENTTEXT", "", "Activity Subject validation");
                                    break;
                                case "DESCRIPTION":
                                    status = SCRCommon.verifyResults("Activity_ActivityDesc", strColumnValue, "VERIFYELEMENTTEXT", "", "Activity Description validation");
                                    break;
                                case "ASSIGNTO":
                                    String[] strLogedUserName = strColumnValue.split(":::");
                                    if (strLogedUserName[0].equalsIgnoreCase("USERROLE")) {
                                        // String
                                        // expUserName=PCThreadCache.getInstance().getProperty("LOGGED_USERNAME");
                                        // strColumnValue=strColumnValue.replace("LOGGEDUSERNAME",
                                        // expUserName);
                                        // status =
                                        // SCRCommon.verifyResults("Activity_AssignTo",
                                        // expUserName, "VERIFYELEMENTTEXT",
                                        // "","Activity Assing-To validation");
                                        status = verifyAssigntoRole(strLogedUserName[1]);
                                    } else {
                                        status = SCRCommon.verifyResults("Activity_AssignTo", strColumnValue, "VERIFYELEMENTTEXT", "", "Activity Assing-To validation");

                                    }
                                    break;
                                case "PRIORITY":
                                    if (blnLoggeduser) {
                                        status = SCRCommon.verifyResults("Activity_Priority", strColumnValue, "VERIFYEDITBOXTEXT", "", "Activity Priority validation");
                                    } else {
                                        status = SCRCommon.verifyResults("Activity_Priority", strColumnValue, "VERIFYELEMENTTEXT", "", "Activity Priority validation");
                                    }
                                    break;
                                case "TARGETDAYS":
                                    strTargetDays = strColumnValue;
                                    // String targetDaysHrs = null;
                                    addDays = Integer.parseInt(strTargetDays);
                                    addHrs = Integer.parseInt(sXL.getCellData(sheetName, j + 1, i));
                                    strTargetStartPoint = sXL.getCellData(sheetName, j + 2, i);
                                    strTargetIncludeDays = sXL.getCellData(sheetName, j + 3, i);
                                    Calendar cal2 = Calendar.getInstance();

                                    recDate = common.ReadElement(Common.o.getObject("eleOrigReceivedDate"), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
                                    // Date baseDate =
                                    // (Date)formatter.parse(recDate);

                                    if (strTargetStartPoint.toUpperCase().contains("ARNDUEDATE")) {
                                        arnDueDate = common.ReadElement(Common.o.getObject("ARNDueDate"), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
                                        baseDate = (Date) dateOnly.parse(arnDueDate);
                                        System.out.println(baseDate);

                                        cal2.setTime(baseDate);
                                    } else if (strTargetStartPoint.toUpperCase().contains("ACTIVITYCREATION")) {
                                        baseDate = (Date) formatter.parse(recDate);
                                        System.out.println(baseDate);

                                        cal2.setTime(baseDate);
                                    } else if (strTargetStartPoint.toUpperCase().contains("POLICYEXPIRDATE")) {
                                        // strVal =
                                        // common.ReadElement(Common.o.getObject("elePolicyPeriod"),
                                        // Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
                                        strVal = SCRCommon.getPolicyPeriod();
                                        strArray = strVal.split("-");
                                        String expDate = strArray[1].trim();
                                        baseDate = (Date) dateOnly.parse(expDate);
                                        cal2.setTime(baseDate);
                                    } else if (strTargetStartPoint.toUpperCase().contains("POLICYEFFDATE")) {
                                        // strVal =
                                        // common.ReadElement(Common.o.getObject("elePolicyPeriod"),
                                        // Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
                                        strVal = SCRCommon.getPolicyPeriod();
                                        strArray = strVal.split("-");
                                        String effDate = strArray[0].trim();
                                        baseDate = (Date) dateOnly.parse(effDate);
                                        cal2.setTime(baseDate);
                                    }

                                    if (strTargetIncludeDays.toUpperCase().contains("BUSINESS")) {
                                        strExpected = SCRCommon.addDaysBusinessNew(cal2, addDays);
                                        Date d = (Date) formatter.parse(strExpected);
                                        cal2.setTime(d);
                                        targetDaysHrs = getTaskEndTime(cal2, addHrs);
                                        PCThreadCache.getInstance().setProperty(PCConstants.TARGETDAYSNDHRS, targetDaysHrs);
                                        strArray = strExpected.split(" ");
                                        strExpected = strArray[0].trim();

                                    } else if (strTargetIncludeDays.toUpperCase().contains("CALENDAR")) {
                                        // strExpected =
                                        // SCRCommon.ReturnDate(addDays);
                                        strExpected = SCRCommon.ReturnDate(cal2, addDays);
                                        strArray = strExpected.split(" ");
                                        strExpected = strArray[0].trim();
                                    }

                                    if (blnLoggeduser) {
                                        status = SCRCommon.verifyResults("Activity_TargetDate", strExpected, "VERIFYEDITBOXTEXT", "", "Activity Target Day validation");
                                    } else {
                                        status = SCRCommon.verifyResults("Activity_TargetDate", strExpected, "VERIFYELEMENTTEXT", "", "Activity Target Day validation");
                                    }
                                    j += 2;
                                    break;
                                case "ESCALATIONDAYS":
                                    String escDayandHrs = null;
                                    String strEscalationDays = strColumnValue;
                                    addDays = Integer.parseInt(strEscalationDays);
                                    addHrs = Integer.parseInt(sXL.getCellData(sheetName, j + 1, i));
                                    String strEscalationStartPoint = sXL.getCellData(sheetName, j + 2, i);
                                    String strEscalationIncludeDays = sXL.getCellData(sheetName, j + 3, i);

                                    recDate = common.ReadElement(Common.o.getObject("eleOrigReceivedDate"), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));

                                    Calendar cal1 = Calendar.getInstance();

                                    if (strEscalationStartPoint.toUpperCase().contains("ARNDUEDATE")) {
                                        arnDueDate = common.ReadElement(Common.o.getObject("ARNDueDate"), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
                                        baseDate = (Date) dateOnly.parse(arnDueDate);
                                        System.out.println(baseDate);

                                        cal1.setTime(baseDate);
                                    } else if (strTargetStartPoint.toUpperCase().contains("ACTIVITYCREATION")) {
                                        baseDate = (Date) formatter.parse(recDate);
                                        System.out.println(baseDate);

                                        cal1.setTime(baseDate);
                                    } else if (strEscalationStartPoint.toUpperCase().contains("POLICYEXPIRDATE")) {
                                        // strVal =
                                        // common.ReadElement(Common.o.getObject("elePolicyPeriod"),
                                        // Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
                                        strVal = SCRCommon.getPolicyPeriod();
                                        strArray = strVal.split("-");
                                        String expDate = strArray[1].trim();
                                        baseDate = (Date) dateOnly.parse(expDate);
                                        cal1.setTime(baseDate);
                                    } else if (strEscalationStartPoint.toUpperCase().contains("POLICYEFFDATE")) {
                                        // strVal =
                                        // common.ReadElement(Common.o.getObject("elePolicyPeriod"),
                                        // Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
                                        strVal = SCRCommon.getPolicyPeriod();
                                        strArray = strVal.split("-");
                                        String effDate = strArray[0].trim();
                                        baseDate = (Date) dateOnly.parse(effDate);
                                        cal1.setTime(baseDate);
                                    }
                                    if (strEscalationIncludeDays.toUpperCase().contains("BUSINESS")) {
                                        strExpected = SCRCommon.addDaysBusinessNew(cal1, addDays);
                                        Date d = (Date) formatter.parse(strExpected);
                                        cal1.setTime(d);
                                        escDayandHrs = getTaskEndTime(cal1, addHrs);
                                        PCThreadCache.getInstance().setProperty(PCConstants.TARGETDAYSNDHRS, escDayandHrs);
                                        strArray = strExpected.split(" ");
                                        strExpected = strArray[0].trim();

                                    } else if (strEscalationIncludeDays.toUpperCase().contains("CALENDAR")) {
                                        strExpected = SCRCommon.ReturnDate(cal1, addDays);
                                        strArray = strExpected.split(" ");
                                        strExpected = strArray[0].trim();
                                    }
                                    if (blnLoggeduser) {
                                        status = SCRCommon.verifyResults("Activity_EscalationDate", strExpected, "VERIFYEDITBOXTEXT", "", "Activity Escalation Day validation");
                                    } else {
                                        status = SCRCommon.verifyResults("Activity_EscalationDate", strExpected, "VERIFYELEMENTTEXT", "", "Activity Escalation Day validation");
                                    }
                                    j += 2;
                                    break;
                            }

                        }
                    }
                }

            }
            if (!tcAvailable) {
                logger.info("" + TCID + " is not available in the '" + sheetName + "' Sheet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TCID = null;
            TCIDAdd = null;
        }
        return status;
    }

    public static Boolean verifyAssigntoRole(String strFuncValue) {
        Boolean blnStatus = false;
        try {
            Common common = CommonManager.getInstance().getCommon();
            String strAssignTo = common.ReadElement(Common.o.getObject("Activity_AssignTo"), 10);
            if (!(strAssignTo == null)) {
                blnStatus = common.SafeAction(Common.o.getObject("eleSubmissionParticipants"), "", "eleSubmissionParticipants");
                if (common.ElementDisplayed(Common.o.getObject("eleParticipantTransTab"))) {
                    blnStatus = common.SafeAction(Common.o.getObject("eleParticipantTransTab"), "eleParticipantTransTab", "eleParticipantTransTab");
                }

                blnStatus = SCRCommon.verifyTextFromTable("eleParticipantTable", 1, 2, strAssignTo, strFuncValue, "Participant Table");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return blnStatus;
    }

    public static Boolean getAccountNamePolicyNumber() {
        Boolean blnStatus = false;
        XlsxReader sXL = XlsxReader.getInstance();
        IconReader iCN = IconReader.getInstance();
        HashMap<String, Object> whereConstraintSelect = new HashMap<String, Object>();
        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> whereConstraintUpdate = new HashMap<String, Object>();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        try {
            whereConstraintSelect.clear();
            whereConstraintSelect.put(PCConstants.ID, tcID);
            resultListRows = iCN.executeSelectQuery("Trans", whereConstraintSelect);
            if (resultListRows.size() > 0) {
                for (HashMap<String, Object> processRow : resultListRows) {
                    String transFieldName = (String) processRow.get("Field_Name"); // AccountName
                    String transFieldValue = (String) processRow.get("Field_Value"); // errtgg
                    if (transFieldName.equals("AccountName")) {
                        updateColumnNameValues.clear();
                        whereConstraintUpdate.clear();
                        whereConstraintUpdate.put(PCConstants.ID, tcID);
                        updateColumnNameValues.put("edtSearchCompanyName", transFieldValue);
                        PCThreadCache.getInstance().setProperty("edtSearchCompanyName", transFieldValue);
                        //blnStatus = sXL.executeUpdateQuery("SearchAccount", updateColumnNameValues, whereConstraintUpdate);

                        updateColumnNameValues.clear();
                        whereConstraintUpdate.clear();
                        whereConstraintUpdate.put(PCConstants.ID, tcID);
                        updateColumnNameValues.put("cfugetAccountNumber", transFieldValue);
                        PCThreadCache.getInstance().setProperty("cfugetAccountNumber", transFieldValue);
                        //blnStatus = sXL.executeUpdateQuery("SearchAccount", updateColumnNameValues, whereConstraintUpdate);
                    } else if (transFieldName.equals("PolicyNumber")) {
                        updateColumnNameValues.clear();
                        whereConstraintUpdate.clear();
                        whereConstraintUpdate.put(PCConstants.ID, tcID);
                        updateColumnNameValues.put("funtrimPolicyNumber", transFieldValue);
                        PCThreadCache.getInstance().setProperty("funtrimPolicyNumber", transFieldValue);
                        //blnStatus = sXL.executeUpdateQuery("SearchPolicy", updateColumnNameValues, whereConstraintUpdate);
                    }
                }
            } else {
                logger.info("TestCase ID " + tcID + " is not available in the Trans Sheet");
                blnStatus = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blnStatus;
    }

    public static String addDaysBusiness(int addNoOfDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = new GregorianCalendar();
        String strReturnDate = null;
        // cal now contains current date
        System.out.println(cal.getTime());
        // add the working days
        int workingDaysToAdd = addNoOfDays;
        for (int i = 1; i <= workingDaysToAdd; i++)
            do {
                cal.add(Calendar.DAY_OF_MONTH, 1);
                // cal.add(Calendar.DATE, 1);
                // System.out.println(cal.getTime());
            } while (!isWorkingDay(cal));
        System.out.println(cal.getTime());
        strReturnDate = sdf.format(cal.getTime());
        return strReturnDate;
    }

    public static String addDaysBusinessNew(Calendar cal, int addNoOfDays) {
        Boolean blnPositiveDate = true;
        int workingDaysToAdd;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String sDate = sdf.format(cal.getTime());
        String strReturnDate = null;
        if (addNoOfDays < 0) {
            blnPositiveDate = false;
            addNoOfDays = Math.abs(addNoOfDays);
        }
        workingDaysToAdd = addNoOfDays;
        for (int i = 1; i <= workingDaysToAdd; i++)
            do {
                if (blnPositiveDate) {
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    // cal.add(Calendar.DATE, 1);
                    // System.out.println(cal.getTime());
                } else {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                }
            } while (!isWorkingDay(cal));
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        System.out.println(formatter.format(cal.getTime()));
        System.out.println(cal.getTime());
        strReturnDate = formatter.format(cal.getTime());
        return strReturnDate;
    }


    private static boolean isWorkingDay(Calendar cal) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String sDate = sdf.format(cal.getTime());
        System.out.println(sDate);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        // if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY ||
        // sDate1.equals(sDate))
        if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY || !isHoliday(sDate)) {
            return false;
        }
        // tests for other holidays here
        // ...
        return true;
    }

    public static String getTaskEndTime(Calendar cal, int hours) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String sDate = sdf.format(cal.getTime());
        System.out.println(sDate);
        while (hours > 0) {
            int step = 0;
            if (hours > 24)
                step = 24;
            else
                step = hours;
            hours -= step;
            cal.add(Calendar.HOUR_OF_DAY, step);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            /*
             * if(dayOfWeek == Calendar.SATURDAY) hours += 24; System.out.println(hours);
             * if(dayOfWeek == Calendar.SUNDAY) hours += 24; System.out.println(hours);
             */
            if (isAddingHrsFallinginWeekend(cal) == 1)
                hours += 24;
            // if(!isHoliday(sDate)) hours +=24;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        System.out.println(formatter.format(cal.getTime()));
        return formatter.format(cal.getTime());
    }

    public static String addDaysHrsToCalendarDay(Calendar cal, int hours) {
        // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        cal.add(Calendar.HOUR_OF_DAY, hours);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        System.out.println(formatter.format(cal.getTime()));
        return formatter.format(cal.getTime());
    }

    private static int isAddingHrsFallinginWeekend(Calendar cal) {
        int hours = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String sDate = sdf.format(cal.getTime());
        // System.out.println(sDate);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        // if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY ||
        // sDate1.equals(sDate))
        if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY || !isHoliday(sDate)) {
            hours = 1;
        }
        // tests for other holidays here
        // ...
        return hours;
    }

    // Holiday List
    public static String[] holidaysList = {"10/25/2017", "01/01/2017"};

    private static boolean isHoliday(String cal) {
        for (String abcd : holidaysList)
            if (cal.equals(abcd))
                return false;
        return true;
    }

    public static int currentMonth() {
        int month;
        GregorianCalendar date = new GregorianCalendar();
        month = date.get(Calendar.MONTH) + 1;
        // month = month+1;
        return month;
    }

    public static boolean odsOuputValue(String sheetName) {
        Boolean status = true;
        if (HTML.properties.getProperty("EXECUTIONAPP").contains("ODS")) {
            logger.info("Entering into ODS value");
            Boolean tcAvailable = false;
            String TCID = null;
            String TCIDAdd = null;
            String strColumnName = null;
            String sIteration = null;
            String strColumnValue = null;
            String[] strColumnValues = null;
            String methodname = null;
            String componentName = null;
            int rowcount;
            XlsxReader sXL = XlsxReader.getInstance();
            try {
                rowcount = sXL.getRowCount("ODSOutputValues");
                Outer:
                for (int i = 2; i <= rowcount; i++) {
                    TCID = PCThreadCache.getInstance().getProperty("TCID");
                    TCIDAdd = sXL.getCellData("ODSOutputValues", "ID", i);
                    sIteration = sXL.getCellData("ODSOutputValues", "Iteration", i);
                    componentName = sXL.getCellData("ODSOutputValues", "Component", i);
                    if (TCIDAdd.equals(TCID) && sIteration.equalsIgnoreCase(PCThreadCache.getInstance().getProperty(PCConstants.Iteration)) && sheetName.equalsIgnoreCase(componentName)) {
                        tcAvailable = true;
                        int colcount = sXL.getColumnCount("ODSOutputValues");
                        for (int j = 2; j <= colcount; j++) {
                            strColumnValue = sXL.getCellData("ODSOutputValues", j, i);
                            strColumnName = sXL.getCellData("ODSOutputValues", j, 1);
                            if (!strColumnName.isEmpty() && !strColumnValue.isEmpty()) {
                                methodname = strColumnName.substring(3);
                                strColumnValues = strColumnValue.split(":::");
                                switch (strColumnName) {
                                    case "getODSText":
                                        status = getODSText(strColumnValues[0], strColumnValues[1]);
                                        break;
                                    case "getValuefromTableForODS":
                                        status = getValuefromTableForODS(strColumnValues[1], strColumnValues[5], strColumnValues[0], strColumnValues[2], strColumnValues[3], strColumnValues[4]);
                                        break;
                                    case "TestData":
                                        status = SCRCommon.testData(strColumnValue);
                                        break;
                                    case "getODSEditText":
                                        status = SCRCommon.getODSEditText(strColumnValues[0], strColumnValues[1]);
                                        break;
                                }
                            }
                            if (!status) {
                                logger.info("Problem in the method '" + methodname + "'");
                                break Outer;
                            }
                        }
                        logger.info("Completed the ods Output value");
                    }
                }
                if (!tcAvailable) {
                    logger.info("" + TCID + " is not available in the '" + sheetName + "' Sheet");
                }
            } catch (Exception e) {
                logger.info("Problem in the ods Output value");
                e.printStackTrace();
            } finally {
                TCID = null;
                TCIDAdd = null;
            }
        }
        return status;
    }


    public static boolean getODSText(String sElement, String strOdsFFName) throws NumberFormatException, Exception {
        boolean Status = true;
        Common common = CommonManager.getInstance().getCommon();
        SCRCommon scrCommon = new SCRCommon();
        FlatFile sReadWrite = FlatFile.getInstance();
        String textValue = common.ReadElement(Common.o.getObject(sElement), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
        String sFileName = scrCommon.FlatFileName();
        Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), strOdsFFName, textValue, "OUTPUT", sFileName);
        if (!Status || textValue.equals("") || textValue == null) {
            logger.info("'" + sElement + "' is not found in the system");
        }
        return Status;
    }


    public static boolean getODSEditText(String sElement, String strOdsFFName) throws NumberFormatException, Exception {
        boolean Status = true;
        SCRCommon scrCommon = new SCRCommon();
        Common common = CommonManager.getInstance().getCommon();
        FlatFile sReadWrite = FlatFile.getInstance();
        String textValue = common.ReadElementGetAttribute(Common.o.getObject(sElement), "value", Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
        String sFileName = scrCommon.FlatFileName();
        Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), strOdsFFName, textValue, "OUTPUT", sFileName);
        if (!Status || textValue.equals("") || textValue == null) {
            logger.info("'" + sElement + "' is not found in the system");
        }
        return Status;
    }


    public static Boolean getValuefromTableForODS(String strTblObject, String strReadString, String strTableHeaderObject, String strReadHeaderName, String strGetHeaderName, String strOdsFFName) throws Exception {
        boolean Status = false;
        boolean SearchString = false;
        FlatFile sReadWrite = FlatFile.getInstance();
        SCRCommon scrCommon = new SCRCommon();
        String sFileName = scrCommon.FlatFileName();
        int readCol = getTableColumn(strReadHeaderName, strTableHeaderObject);
        int actionCol = getTableColumn(strGetHeaderName, strTableHeaderObject);
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strTblObject));
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.contains(strReadString)) {
                SearchString = true;
                String getText = Cells.get(actionCol).getText();
                if (strOdsFFName.equals("PolicyNumber")) {
                    getText = "%" + getText.substring(getText.length() - 6);
                    Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), strOdsFFName, getText, "OUTPUT", sFileName);
                } else {
                    Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), strOdsFFName, getText, "OUTPUT", sFileName);
                }
            }
            if (SearchString) {
                break;
            }
        }
        if (SearchString) {
            logger.info("Search String available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + strReadString + "'", "PASS");
        } else {
            logger.info("Search String not available in the table. '" + strReadString + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should search string in table and Search string is '" + strReadString + "'", "System searched string in table and srarch string is  '" + strReadString + "'", "FAIL");
            Status = false;
        }

        return Status;
    }

    public static int getTableColumn(String sHeaderName, String strObjectName) throws IOException {
        Common common = CommonManager.getInstance().getCommon();
        boolean blnSearchString = false;
        String strTableHeader = null;
        WebElement mytable = common.returnObject(Common.o.getObject(strObjectName));
        List<WebElement> rows_table = mytable.findElements(By.tagName("span"));
        int intHeaderColumn = 0;
        int intEmptyColumn = 0;
        for (int i = 0; i < rows_table.size(); i++) {
            strTableHeader = rows_table.get(i).getText();
            // System.out.println(strTableHeader);
            if (strTableHeader.equalsIgnoreCase(sHeaderName)) {
                logger.info("Table Header " + sHeaderName + " found");
                // intHeaderColumn = i - intEmptyColumn ;
                intHeaderColumn = i;
                blnSearchString = true;
                break;
            } else if (strTableHeader.equals("")) {
                intEmptyColumn = intEmptyColumn + 1;
            }

        }
        if (!blnSearchString) {
            logger.info("Table Header " + sHeaderName + " is not found in the Add Class Table");
        }
        return intHeaderColumn;
    }

    public static Boolean choosePolicyTransaction(String strFuncValue) {
        Common common = CommonManager.getInstance().getCommon();
        Boolean blnStatus = false;
        try {
            blnStatus = common.ActionOnTable(Common.o.getObject("PolicyTransactionTable"), 7, 4, strFuncValue, "a");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return blnStatus;
    }

    public static Boolean funGetUserLoggedName() {
        Common common = CommonManager.getInstance().getCommon();
        Boolean blnStatus = false;
        try {

            blnStatus = common.SafeAction(Common.o.getObject("elePreferences"), "elePreferences", "elePreferences");
            String strUserName = common.ReadElement(Common.o.getObject("eleLogOut"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
            strUserName = strUserName.replace("Log Out", "");
            PCThreadCache.getInstance().setProperty(PCConstants.LOGGED_USERNAME, strUserName.trim());
            logger.info("Logged in UserName is :" + PCThreadCache.getInstance().getProperty("LOGGED_USERNAME"));

            blnStatus = common.SafeAction(Common.o.getObject("eleBuildInfo"), "eleBuildInfo", "eleBuildInfo");
            String strServerName = common.ReadElement(Common.o.getObject("btnServerName"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
            strServerName = strServerName.replace("Server ID: ", "");
            PCThreadCache.getInstance().setProperty(PCConstants.LOGGED_SERVERNAME, strServerName.trim());
            logger.info("Logged in ServerName is :" + PCThreadCache.getInstance().getProperty("LOGGED_SERVERNAME"));

            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Get the Logged in UserName", "Logged in UserName : " + PCThreadCache.getInstance().getProperty("LOGGED_USERNAME") + "'", "PASS");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Get the Logged in ServerName", "Logged in ServerName : " + PCThreadCache.getInstance().getProperty("LOGGED_SERVERNAME") + "'", "PASS");

            blnStatus = common.SafeAction(Common.o.getObject("elePreferences"), "elePreferences", "elePreferences");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return blnStatus;
    }

    public Boolean NewWindow(String funValue) throws Exception {
        boolean status = false;
        // String[] sPair = funValue.split(":::");
        String sPrimaryWindow = driver.getWindowHandle();
        java.util.Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (driver.switchTo().window(handle).getTitle().contains(funValue)) {
                // driver.switchTo().window(handle);
                logger.info("New window is displayed and swithced to that window");
                status = true;
                break;
            }
        }
        if (status) {
            // close the child window
            driver.close();
            // Switch to the parent window
            driver.switchTo().window(sPrimaryWindow);
        } else {
            status = false;
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Switch to New Window", "Could not switch to New Window", "FAIL");
        }
        return status;
    }

    public static String getPolicyPeriod() {
        String period = null;
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        try {
            int iPolicyPeriodSize = common.ElementSize(Common.o.getObject("elePolicyPeriod"));
            if (iPolicyPeriodSize == 1) {

                period = common.ReadElement(Common.o.getObject("elePolicyPeriod"), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
            } else {
                status = common.SafeAction(Common.o.getObject("eleQuoteLHS"), "eleQuoteLHS", "ele");
                period = common.ReadElement(Common.o.getObject("elePolicyPeriod"), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return period;
    }


    public static Boolean getAccountNumber(String strFuncValue) {
        Common common = CommonManager.getInstance().getCommon();
        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        XlsxReader sXL = XlsxReader.getInstance();
        String strAccountNumber = null;
        Boolean blnStatus = false;
        try {
            blnStatus = common.ElementExist(Common.o.getObject("AccountSearchResultsTbl"));
            if (blnStatus) {
                strAccountNumber = common.GetTextFromTable(Common.o.getObject("AccountSearchResultsTbl"), 2, 1, strFuncValue);
                PCThreadCache.getInstance().setProperty(PCConstants.AccountNumber, strAccountNumber);
                whereConstraint.put(PCConstants.ID, PCThreadCache.getInstance().getProperty("TCID"));
                updateColumnNameValues.put("edtaccountNumber", strAccountNumber);
                PCThreadCache.getInstance().setProperty("edtaccountNumber", strAccountNumber);
                //blnStatus = sXL.executeUpdateQuery(PCConstants.SHEET_SEARCHACCOUNT, updateColumnNameValues, whereConstraint);

                updateColumnNameValues.clear();
                updateColumnNameValues.put(PCConstants.AccountNumber, strAccountNumber);
                blnStatus = sXL.executeUpdateQuery(PCConstants.SHEET_ICONValidation, updateColumnNameValues, whereConstraint);
                if (HTML.properties.getProperty("EXECUTIONAPP").contains("ODS")) {
                    FlatFile sReadWrite = FlatFile.getInstance();
                    SCRCommon scrCommon = new SCRCommon();
                    String FlatFileName = scrCommon.FlatFileName();
                    blnStatus = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), "AccountNumber", strAccountNumber, "OUTPUT", FlatFileName);
                }
            } else {
                logger.info("Account Name " + strFuncValue + " is not exist in PC");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return blnStatus;
    }

    public static boolean selectTotalCost(String sFunctionValue) throws Throwable {
        boolean status = false;
        Common common = CommonManager.getInstance().getCommon();
        String[] sValue = sFunctionValue.split(":::");
        int sRowCount = SCRCommon.TableRowCount(Common.o.getObject("eleCLAQTTable"));
        switch (sValue[0].toUpperCase()) {

            case "TOTALCOST":
                try {

                    status = SCRCommon.DataWebTable(Common.o.getObject("eleCLAQTTable"), sRowCount, 6, "", "double", "div");
                    // status=SCRCommon.FillCellValue(Common.o.getObject("eleQuoteTransactionstbl"),
                    // sRowCount, 6,"", "single", sValue[1]);
                    // driver.findElement(Common.o.getObject("lstTotalAnnualCost")).sendKeys(sValue[1]);

                    status = common.SafeAction(Common.o.getObject("lstTotalAnnualCost"), sValue[1], "lstTotalAnnualCost");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

        return status;
    }

    public static Boolean ActionOnTableTrueFalse(By obj, int readCol, int actionCol, String strReadString, String strActionString, String sTagName) throws Exception {
        boolean Status = false;
        // boolean SearchString=false;
        // boolean ActionString = false;
        WebElement mytable = ManagerDriver.getInstance().getWebDriver().findElement(obj);
        List<WebElement> allrows = mytable.findElements(By.tagName("tr"));
        for (int i = 0; i <= allrows.size() - 1; i++) {
            List<WebElement> Cells = allrows.get(i).findElements(By.tagName("td"));
            String readText = Cells.get(readCol).getText();
            if (readText.equalsIgnoreCase(strReadString)) {
                // SearchString = true;
                String getText = Cells.get(actionCol).getText();
                if (getText.equalsIgnoreCase(strActionString)) {
                    Status = true;
                    break;
                }
            }
        }
        return Status;
    }

    public Boolean captureAllFields(String sheetName) {
        Boolean blnStatus = true;
        String[] arrTblCondition = null;
        String sPCPageNaem = null;
        String strTempPageName = null;
        String sPageNavigation = null;

        ArrayList<String> arrScreenName = new ArrayList<String>();
        Set<String> arrScreenName1 = new HashSet<String>();

        String strTemp1 = null;
        Boolean blnFlagPage = false;
        String[] arrLabelValue = null;
        String strTableTempValue = null;

        int i = 0;
        String StrTemp = "";
        HashMap<String, String> hm_ScreenVal = new HashMap<String, String>();
        String sTableTitle = null;
        String sTbleCondition = null;
        String[] arrTbleValues = null;
        String[] arrSubField = null;
        String sValue = null;

        HashMap<String, String> CSV_Hashmap = new HashMap<String, String>();

        String sFileName = PCThreadCache.getInstance().getProperty(PCConstants.Integ_FlatFile);

        //String sheetName = "PageValues";
        //String[] strKeyNames = KeyNames.split(":::");
        String KeyNames = "LABEL:::CHECKBOX";
        String[] strKeyNames = KeyNames.split(":::");
        String sPCFieldName, sPCScreenName, sPCFieldType = null;
        XlsxReader xls = XlsxReader.getInstance();
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.clear();
        whereConstraint.put(PCConstants.ID, PCThreadCache.getInstance().getProperty("TCID"));
        whereConstraint.put(PCConstants.Iteration, PCThreadCache.getInstance().getProperty("Iteration"));
        resultListRows = xls.executeSelectQuery(sheetName, whereConstraint);
        try {
            if (resultListRows.size() > 0) {
                Outer:
                for (HashMap<String, Object> processRow : resultListRows) {

                    sPCFieldName = (String) processRow.get("PC Field Name");
                    sPCScreenName = (String) processRow.get("PC Page Name");
                    if (!StrTemp.equals(sPCScreenName)) {
                        logger.info("diff page");
                        arrScreenName1.add(sPCScreenName);
                        i++;
                    }
                    StrTemp = sPCScreenName;
                }
                Iterator<String> iterator = arrScreenName1.iterator();
                // check values
                while (iterator.hasNext()) {
                    arrScreenName.add(iterator.next());
                }
                // page looping

                for (int k = 0; k < arrScreenName.size(); k++) {
                    blnFlagPage = false;
                    Again:
                    for (HashMap<String, Object> processRow1 : resultListRows) {

                        sPCFieldType = (String) processRow1.get("PC FieldRef");
                        sPCScreenName = (String) processRow1.get("PC Page Name");
                        sPCPageNaem = (String) processRow1.get("PC Page Name");
                        sPageNavigation = (String) processRow1.get("cfuPageNavigation");
                        sPCFieldName = (String) processRow1.get("PC Field Name");
                        sTableTitle = (String) processRow1.get("TableRef_ColumnHeading");
                        sTbleCondition = (String) processRow1.get("TableRef_SplCondiftion");
                        if (arrScreenName.get(k).equals(sPCScreenName)) {
                            if (sPCFieldType.equals("LABEL")) {
                                strTemp1 = strTemp1 + ":::" + sPCFieldName;
                            } else if (sPCFieldType.equals("TABLE")) {
                                if (!sTbleCondition.isEmpty()) {
                                    strTableTempValue = sPCFieldName + ":::" + sTableTitle + ":::" + sTbleCondition + "##" + strTableTempValue;
                                } else {
                                    strTableTempValue = sPCFieldName + ":::" + sTableTitle + ":::null" + "##" + strTableTempValue;
                                }

                            }
                            blnFlagPage = true;
                        }

                    }
                    if (blnFlagPage) {
                        logger.info("Diff page avail in sheet!!");
                        logger.info(arrScreenName.get(k) + "-----" + strTemp1);
                        //Page Navigation:
                        blnStatus = PageNavigation(arrScreenName.get(k));
                        if (!strTemp1.isEmpty()) //label values
                        {

                            blnStatus = findTextEditValues_New(arrScreenName.get(k), hm_ScreenVal);
                            Set<String> keys = hm_ScreenVal.keySet();
                            arrLabelValue = strTemp1.split(":::");
                            for (int arrVal = 0; arrVal < arrLabelValue.length; arrVal++) {

                                for (String key : keys) {
                                    if (hm_ScreenVal.containsKey(arrLabelValue[arrVal])) {

                                        sValue = hm_ScreenVal.get(arrLabelValue[arrVal]);
                                        CSV_Hashmap.put(arrLabelValue[arrVal], sValue);
                                        System.out.println("Key - " + arrLabelValue[arrVal] + " Value ----" + hm_ScreenVal.get(arrLabelValue[arrVal]));
                                        //blnStatus = E2EWrite.writeCSV(arrScreenName.get(k),arrLabelValue[arrVal],sValue, "","", sFileName);
                                        break;
                                    } else if (!arrLabelValue[arrVal].equals("null")) {
                                        System.out.println("Key not found - " + arrLabelValue[arrVal] + " Value ----" + hm_ScreenVal.get(arrLabelValue[arrVal]));
                                        CSV_Hashmap.put(arrLabelValue[arrVal], "NOTFOUND");
                                        //blnStatus = E2EWrite.writeCSV(arrScreenName.get(k),arrLabelValue[arrVal],"NOTFOUND", "","", sFileName);
                                        break;
                                    } else {
                                        System.out.println("NULL Key found - " + arrLabelValue[arrVal]);
                                        break;
                                    }

                                }

                            }
                            //break;
                        }
                        if (strTableTempValue != null) // Tables
                        {
                            arrTbleValues = strTableTempValue.split("##"); //firs row split
                            for (int y = 0; y < arrTbleValues.length - 1; y++) {
                                arrSubField = arrTbleValues[y].split(":::");

                                if (!arrSubField[2].equals("null")) {
                                    arrTblCondition = arrSubField[2].split("==");
                                    blnStatus = verifyTblValue(arrSubField[1], arrTblCondition[0], arrTblCondition[1], arrSubField[0], arrScreenName.get(k));
                                } else {
                                    //blnStatus=verifyTblValue(sTableTitle,"","",sPCFieldName,sPCScreenName);
                                    blnStatus = verifyTblValue(arrSubField[1], "", "", arrSubField[0], arrScreenName.get(k));
                                }
                            }

                        }
                        //ODS PART


                    }
                    //write csv hash value in CSV
                    Set<String> CSVkeys = CSV_Hashmap.keySet();
                    for (String key : CSVkeys) {
                        if (CSV_Hashmap.containsKey(key)) {

                            System.out.println("Key - " + key + " Value ----" + CSV_Hashmap.get(key));
                            blnStatus = E2EWrite.writeCSV(arrScreenName.get(k), key, CSV_Hashmap.get(key), "", "", sFileName);
                        }

                    }
                    //clear csv hasmap for next screen
                    CSV_Hashmap.clear();
                    strTemp1 = null;
                    strTableTempValue = null;

                }

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return blnStatus;
    }

    public Boolean VerifyWarning_ClickNext(String strPageName) throws Exception {
        Boolean status = false;
        String refClassName = null;
        //String strXpath = null;
        String strActualText = null;
        try {

            // ArrayList actWarningMsg=new ArrayList();
            status = common.SafeAction(Common.o.getObject("eljNext"), "eljNext", "eljNext");
            List<WebElement> Objtitle = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleTitleElements"));
            if (Objtitle.size() != 0) {
                for (int i = 0; i <= Objtitle.size() - 1; i++) {
                    strActualText = Objtitle.get(i).getText();
                    if (strActualText.equals(strPageName)) {
                        logger.info("still in the same page after clicking NEXT ...Hence checking for warning");
                        refClassName = "warning_icon";
                        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(By.xpath("//div[contains(@id,'SubmissionWizard:LOBWizardStepGroup')]//div[img[@class='warning_icon']]"));
                        if (CellElements.size() != 0) {
                            logger.info("Warning messages dispalyed in UI");
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify whether any Warnign message is displayed in screen beforeproceeding !!", "Warning message is displayed in screen ", "PASS");
                            status = common.SafeAction(Common.o.getObject("eljNext"), "eljNext", "eljNext");
                            status = true;
                        }
                        break;
                    }
                }
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

    public Boolean clearWarning() throws Exception {
        Boolean status = false;
        String refClassName = null;
        //String strXpath = null;
        try {

            // ArrayList actWarningMsg=new ArrayList();
            if (common.ElementExist(Common.o.getObject("eleValidation_ClearBtn"))) {
                status = common.SafeAction(Common.o.getObject("eleValidation_ClearBtn"), "Clear Btn", "eleValidation_ClearBtn");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

    public static Boolean findTextEditValues(String sheetName) {
        Boolean blnStatus = true;
        String getFieldValue = null;
        String getTagName = null;
        String[] getFieldID = null;
        int counter;
        Common common = CommonManager.getInstance().getCommon();
        XlsxReader sXL = XlsxReader.getInstance();
        try {
            List<WebElement> elementLabels = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("labelClassName"));
            for (WebElement getElement : elementLabels) {
                String getFieldName = getElement.getText();
                counter = 0;
                if (!getFieldName.equals("")) {
                    String getElementID = getElement.getAttribute("id");
                    switch (getFieldName.toUpperCase()) {
                        case "BILLING NUMBER":
                            getFieldID[0] = "PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:BillingNumber_Ext-btnInnerEl";
                            getTagName = "span";
                            break;
                        default:
                            getFieldID = getElementID.split("-");
                            getFieldID[0] = getFieldID[0].concat("-inputEl");
                            int checkFieldExist = common.ElementSize(By.id(getFieldID[0]));
                            if (checkFieldExist == 1) {
                                counter = 1;
                                getTagName = common.getTagName(By.id(getFieldID[0]));
                            }
                            break;
                    }
                    if (counter == 1) {
                        switch (getTagName) {
                            case "div":
                            case "a":
                            case "span":
                                getFieldValue = common.ReadElementforODS(By.id(getFieldID[0]), 5);
                                break;
                            case "input":
                                getFieldValue = common.ReadElementGetAttribute(By.id(getFieldID[0]), "value", 5);
                                break;
                        }
                        if (!getFieldValue.equals("") || !(getFieldValue == null)) {
                            int rowcount = sXL.getRowCount(sheetName);
                            sXL.setCellData(sheetName, PCThreadCache.getInstance().getProperty("TCID"), rowcount, 0);
                            sXL.setCellData(sheetName, getFieldName, rowcount, 1);
                            sXL.setCellData(sheetName, getFieldValue, rowcount, 2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            blnStatus = true;
        }
        return blnStatus;
    }

    public static Boolean checkBoxValues(String sheetName, String checkBoxValue) {
        Boolean blnStatus = true;
        String getCovergeName = null;
        XlsxReader sXL = XlsxReader.getInstance();
        try {
            switch (checkBoxValue.toUpperCase()) {
                case "EDITCHECKBOX":

                    break;
                case "CHECKBOX":
                    List<WebElement> elementLabels = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleCoverages"));
                    for (WebElement getElement : elementLabels) {
                        getCovergeName = getElement.getText();
                    }
                    if (!(getCovergeName == null)) {
                        int rowcount = sXL.getRowCount(sheetName);
                        sXL.setCellData(sheetName, PCThreadCache.getInstance().getProperty("TCID"), rowcount, 0);
                        sXL.setCellData(sheetName, getCovergeName, rowcount, 3);
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            blnStatus = true;
        }
        return blnStatus;
    }

    public static boolean SelectTblRowChkBox(String sValue, String sCoverageName) throws IOException {
        int intTblColCount;
        Boolean blnStatus = false;
        intTblColCount = getCoverageTableHeaderColumn("", PCThreadCache.getInstance().getProperty(PCConstants.TableHeader));
        blnStatus = SCRCommon.selectCoverageTableRowToRemove(intTblColCount, PCThreadCache.getInstance().getProperty(PCConstants.TableBody), "SampleProductModel");
        return blnStatus;

    }

    public static Boolean skillAndTrack(String strSheetName) {
        Boolean blnStatus = true;
        Boolean blnSegment = true;
        Boolean blnTrack = true;
        int segmentCount = 0;
        int trackCount = 0;
        Common common = CommonManager.getInstance().getCommon();
        XlsxReader xls = XlsxReader.getInstance();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.clear();
        whereConstraint.put(PCConstants.ID, tcID);
        whereConstraint.put(PCConstants.Iteration, PCThreadCache.getInstance().getProperty("Iteration"));
        resultListRows = xls.executeSelectQuery(strSheetName, whereConstraint);
        try {
            if (resultListRows.size() > 0) {
                for (HashMap<String, Object> processRow : resultListRows) {
                    String segment = (String) processRow.get("Segment");
                    segment = segment.trim();
                    String skill = (String) processRow.get("Skill");
                    skill = skill.trim();
                    String track = (String) processRow.get("Track");
                    track = track.trim();
                    segmentCount = 0;
                    trackCount = 0;
                    // blnSegment =
                    // ActionOnTableTrueFalse(Common.o.getObject("businessSegementSkill"),
                    // 1, 1, segment,segment, "div");
                    // if(!blnSegment)
                    // {
                    // segmentCount = 1;
                    // blnStatus =
                    // common.SafeAction(Common.o.getObject("eleAddSegement"),
                    // "eleAddSegement", "eleAddSegement");
                    // blnStatus =
                    // common.ActionOnTable(Common.o.getObject("businessSegementSkill"),
                    // 1, 1, "<none>", "<none>", "div");
                    // blnStatus =
                    // common.SafeAction(Common.o.getObject("lstSkill_BusinessSegment"),
                    // segment, "lstSkill_BusinessSegment");
                    // blnStatus =
                    // common.ActionOnTable(Common.o.getObject("businessSegementSkill"),
                    // 2, 2, "<none>", "<none>", "div");
                    // blnStatus =
                    // common.SafeAction(Common.o.getObject("lstSkill_Skill"),
                    // skill, "lstSkill_Skill");
                    // logger.info("Skill '"+skill+"' and segment '"+
                    // segment+"' both are added");
                    // }
                    // if(segmentCount == 0)
                    // {
                    blnSegment = ActionOnTableTrueFalse(Common.o.getObject("businessSegementSkill"), 1, 2, segment, skill, "div");
                    if (!blnSegment) {
                        segmentCount = 1;
                        blnStatus = common.SafeAction(Common.o.getObject("eleAddSegement"), "eleAddSegement", "eleAddSegement");
                        blnStatus = common.ActionOnTable(Common.o.getObject("businessSegementSkill"), 1, 1, "<none>", "<none>", "div");
                        blnStatus = common.SafeAction(Common.o.getObject("lstSkill_BusinessSegment"), segment, "lstSkill_BusinessSegment");
                        blnStatus = common.ActionOnTable(Common.o.getObject("businessSegementSkill"), 2, 2, "<none>", "<none>", "div");
                        blnStatus = common.SafeAction(Common.o.getObject("lstSkill_Skill"), skill, "lstSkill_Skill");
                        logger.info("Skill '" + skill + "' and segment '" + segment + "' are added");

                    } else {
                        logger.info("Skill '" + skill + "' and segment '" + segment + "' combination already available");
                        blnStatus = true;
                    }
                    // }
                    // blnTrack =
                    // ActionOnTableTrueFalse(Common.o.getObject("businessSegementTrack"),
                    // 1, 1, segment,segment, "div");
                    // if(!blnTrack)
                    // {
                    // trackCount = 1;
                    // blnStatus =
                    // common.SafeAction(Common.o.getObject("eleAddSkill"),
                    // "eleAddSkill", "eleAddSkill");
                    // blnStatus =
                    // common.ActionOnTable(Common.o.getObject("businessSegementTrack"),
                    // 1, 1, "<none>", "<none>", "div");
                    // blnStatus =
                    // common.SafeAction(Common.o.getObject("lstSkill_BusinessSegment"),
                    // segment, "lstSkill_BusinessSegment");
                    // blnStatus =
                    // common.ActionOnTable(Common.o.getObject("businessSegementTrack"),
                    // 2, 2, "<none>", "<none>", "div");
                    // blnStatus =
                    // common.SafeAction(Common.o.getObject("lstSkill_Track"),
                    // track, "lstSkill_Track");
                    // logger.info("Track '"+track+"' and segment '"+
                    // segment+"' are added");
                    // }
                    // if(trackCount == 0)
                    // {
                    blnTrack = ActionOnTableTrueFalse(Common.o.getObject("businessSegementTrack"), 1, 2, segment, track, "div");
                    if (!blnTrack) {
                        trackCount = 1;
                        blnStatus = common.SafeAction(Common.o.getObject("eleAddSkill"), "eleAddSkill", "eleAddSkill");
                        blnStatus = common.ActionOnTable(Common.o.getObject("businessSegementTrack"), 1, 1, "<none>", "<none>", "div");
                        blnStatus = common.SafeAction(Common.o.getObject("lstSkill_BusinessSegment"), segment, "lstSkill_BusinessSegment");
                        blnStatus = common.ActionOnTable(Common.o.getObject("businessSegementTrack"), 2, 2, "<none>", "<none>", "div");
                        blnStatus = common.SafeAction(Common.o.getObject("lstSkill_Track"), track, "lstSkill_Track");
                        logger.info("Track '" + track + "' and segment '" + segment + "' are added");
                    } else {
                        logger.info("Track '" + track + "' and segment '" + segment + "' combination already available");
                        blnStatus = true;
                    }
                    // }
                }
            } else {
                logger.info("TestCaseID " + tcID + " or Iteration " + PCThreadCache.getInstance().getProperty("Iteration") + " is not available in the " + strSheetName + " Sheet");
                blnStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blnStatus;
    }

    public static String getMachineName() {
        String hostname = null;
        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
            System.out.println(hostname);
        } catch (UnknownHostException ex) {
            System.out.println("Hostname can not be resolved");
        }
        return hostname;
    }

    private static Boolean funValidatePickerList(String getKeyValue) throws Exception {
        String arrValues[] = null;
        String arrCovID[] = null;
        String arrListValue[] = null;
        String sFieldID = null;
        Boolean status = false;
        Boolean bFlag = false;
        arrValues = getKeyValue.split(":::");
        arrListValue = arrValues[1].split("##");
        String CovID = PCThreadCache.getInstance().getProperty(PCConstants.CoverageID);
        arrCovID = CovID.split("-");
        switch (arrValues[0].toUpperCase()) {
            case "ADD":
                sFieldID = arrCovID[0].concat(":CoverageSchedule:BP7ScheduleInputSet:BP7ScheduledItemsLV_tb:AddContactsButton-btnEl");
                break;
            case "REMOVE":
                sFieldID = arrCovID[0].concat(":CoverageSchedule:BP7ScheduleInputSet:BP7ScheduledItemsLV_tb:Remove-btnEl");
                break;
        }
        status = CommonManager.getInstance().getCommon().SafeAction(By.id(sFieldID), "eleFLSAddButton", "eleFLSAddButton");
        // validate picker list & validate Values inside list
        int iSize = CommonManager.getInstance().getCommon().ElementSize(Common.o.getObject("eleAdd_PickerList"));
        if (iSize > 0) {
            logger.info("Picker List dispalyed");
            Actions objActions = new Actions(ManagerDriver.getInstance().getWebDriver());
            List<WebElement> myListView = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleAdd_PickerList"));
            // WebElement myList =
            // CommonManager.getInstance().getCommon().returnObject(Common.o.getObject("eleAdd_PickerList"));
            // List<WebElement> myListView =
            // myList.findElements(By.xpath("//span[@class='x-menu-item-text']"));

            for (int j = 0; j < arrListValue.length; j++) {
                bFlag = false;
                for (int i = 0; i < myListView.size(); i++) {
                    String strListValue = myListView.get(i).getText();
                    if (strListValue.contains(arrListValue[j])) {

                        logger.info("List value macthed !!");
                        HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the List value are displayed in UI", "Field : '" + strListValue + "' displayed in Picker List", "PASS");
                        bFlag = true;
                        break;
                    }
                }
                if (!bFlag) {
                    logger.info("Picker list value not available ");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the List value are displayed in UI", "Field : '" + arrListValue[j] + "' NOT displayed in Picker List", "FAIL");
                }

            }
        } else {
            logger.info("Picker List not dispalyed");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the List value are displayed in UI", "Picker List box is NOT displayed ", "FAIL");
        }
        return true;
    }

    public static boolean pageCoverage(String sheetName) {
        logger.info("Entering into coverage details function");
        Boolean status = false;
        Boolean tcAvailable = false;
        String TCID = null;
        String TCIDAdd = null;
        String sCoverageComponentName = null;
        String currentCompoentName = PCThreadCache.getInstance().getProperty("methodName");
        String sColumnName = null;
        String sColumnValue = null;
        String fieldType = null;
        int rowcount;
        XlsxReader sXL = XlsxReader.getInstance();
        try {
            rowcount = sXL.getRowCount(sheetName);
            for (int i = 2; i <= rowcount; i++) {
                TCID = PCThreadCache.getInstance().getProperty("TCID");
                TCIDAdd = sXL.getCellData(sheetName, "ID", i);
                sCoverageComponentName = sXL.getCellData(sheetName, "Component", i);
                if (TCIDAdd.equals(TCID) && currentCompoentName.equals(sCoverageComponentName)) {
                    tcAvailable = true;
                    int colcount = sXL.getColumnCount(sheetName);
                    for (int j = 3; j <= colcount; j++) {
                        sColumnValue = sXL.getCellData(sheetName, j, i);
                        sColumnName = sXL.getCellData(sheetName, j, 1);
                        if (!sColumnName.isEmpty() && !sColumnValue.isEmpty()) {
                            fieldType = sColumnName.substring(0, 3);
                            switch (fieldType.toUpperCase()) {
                                case "ELJ":
                                case "ELE":
                                    status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject(sColumnName), "", sColumnName);
                                    break;
                                case "EDT":
                                    status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject(sColumnName), sColumnValue, sColumnName);
                                    break;
                            }

                        }
                    }
                }
            }
            if (!tcAvailable) {
                logger.info("" + TCID + " is not available in the " + sheetName + " Sheet");
            } else if (!status) {
                logger.info("Problem in filling the pageCoverage function");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TCID = null;
            TCIDAdd = null;
            sColumnName = null;
            sColumnValue = null;
            sCoverageComponentName = null;
            currentCompoentName = null;
            fieldType = null;
        }
        return status;
    }

    public static Boolean verify_ElementNotNull(String strElementName) throws Exception {
        Boolean blnStatus = false;
        WebElement value = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strElementName));
        String txt = value.getText();
        if (txt != null && !txt.isEmpty()) {
            blnStatus = true;
        }
        if (blnStatus) {
            logger.info("Element " + strElementName + " contains the value " + txt + "");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " element should NOT be NULL", "" + strElementName + " element is not NULL", "PASS");
        } else {
            logger.info("Element " + strElementName + " does not contain any value " + "");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " element should NOT be NULL", "" + strElementName + " element is NULL", "FAIL");
        }
        return blnStatus;
    }

    public static Boolean verify_TodayDate(String strElementName) throws Exception {
        Boolean blnStatus = false;
        WebElement value = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strElementName));
        String txt = value.getText();
        String exp = ReturnCurrentDate();
        if (txt != null && txt.equals(exp)) {
            blnStatus = true;
        }
        if (blnStatus) {
            logger.info("Today's date '" + exp + "' is matching with Field date '" + txt + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " should display today's date as " + exp, "" + strElementName + " is displaying today's date as " + txt, "PASS");
        } else {
            logger.info("Today's date '" + exp + "' is NOT matching with field date '" + txt + "'");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "" + strElementName + " should display today's date as " + exp, "" + strElementName + " is displaying today's date as " + txt, "FAIL");
        }
        return blnStatus;
    }

    public boolean WriteFlatFile(String sfunvalue) {
        boolean status = false;
        String[] arrfunValue = sfunvalue.split("##");
        try {
            status = getPCValue(arrfunValue[0], arrfunValue[1]);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;

    }

    public static boolean getPCValue(String sElement, String strOdsFFName) throws NumberFormatException, Exception {
        boolean Status = true;
        Common common = CommonManager.getInstance().getCommon();
        SCRCommon scrCommon = new SCRCommon();
        FlatFile sReadWrite = FlatFile.getInstance();
        String textValue = common.ReadElement(Common.o.getObject(sElement), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
        String sFileName = scrCommon.FlatFileName();
        Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), strOdsFFName, textValue, "PC_INPUT", sFileName);
        if (!Status || textValue.equals("") || textValue == null) {
            logger.info("'" + sElement + "' is not found in the system");
        }
        return Status;
    }

    public static String GetxPathValue(String ColumnName, String sXpath, String xmlFilepat) throws Exception {

        String sFilePath = xmlFilepat;
        Scanner scanner = new Scanner(new File(sFilePath));
        String result = scanner.useDelimiter("\\Z").next();
        System.out.println(result);
        Document d = convertStringToDocument(result.toString());
        // String xpath1 =
        // "RetrieveInsuranceScoreResponseMessage//RetrieveInsuranceScoreResponseTransaction//AddressLine1";
        String str1 = getElementByXPath(d, sXpath);
        System.out.println(str1);
        return str1;

    }

    public static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getElementByXPath(Document document, String path) throws Exception {
        XPath xPath = XPathFactory.newInstance().newXPath();
        String value = xPath.compile(path).evaluate(document);
        return value;

    }

    public boolean InputforXML(String SheetName) throws Exception {
        boolean Status = true;

        logger.info("Started Input for ODS Function");
        XlsxReader xls = XlsxReader.getInstance();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        // String sFileName = FlatFileName();
        // FlatFileWriter write = FlatFileWriter.getInstance(sFileName);
        SCRCommon scrCommon = new SCRCommon();
        FlatFile sReadWrite = FlatFile.getInstance();
        String sFileName = scrCommon.FlatFileName();
        int rowcount = xls.getRowCount(SheetName);
        for (int i = 2; i <= rowcount; i++) {
            if (xls.getCellData(SheetName, "ID", i).equals(PCThreadCache.getInstance().getProperty("TCID"))) {
                int colcount = xls.getColumnCount(SheetName);
                for (int j = 2; j <= colcount; j++) {
                    String ColName = xls.getCellData(SheetName, j, 1);
                    String value = xls.getCellData(SheetName, j, i);
                    if (!ColName.isEmpty() && !value.isEmpty()) {
                        String element = ColName.substring(0, 3);
                        String elementName = ColName.substring(3);
                        if (!value.isEmpty()) {
                            if (element.toUpperCase().contains("ODS") || element.toUpperCase().contains("EDT") || element.toUpperCase().contains("EDJ") || element.toUpperCase().contains("LST") || element.toUpperCase().contains("LSJ")) {
                                Status = sReadWrite.write(tcID, PCThreadCache.getInstance().getProperty("methodName"), elementName, value, "input", sFileName);
                            } else if (element.toUpperCase().contains("VAL")) {
                                String strIconElement[] = elementName.split("_");
                                Status = sReadWrite.write(tcID, PCThreadCache.getInstance().getProperty("methodName"), strIconElement[1], value, "input", sFileName);
                            }
                        }
                    }
                }
            }
        }

        return Status;
    }

    public static boolean ReadfromScreenWrToFlatFile(String sElement) throws NumberFormatException, Exception {
        Boolean Status = false;
        Common common = CommonManager.getInstance().getCommon();
        SCRCommon scrCommon = new SCRCommon();
        String[] EleName = sElement.split("##");
        FlatFile sReadWrite = FlatFile.getInstance();

        String textValue = common.ReadElement(Common.o.getObject(EleName[0]), Integer.parseInt(HTML.properties.getProperty("LONGWAIT")));
        String sFileName = scrCommon.FlatFileName();
        Status = sReadWrite.write(PCThreadCache.getInstance().getProperty("TCID"), PCThreadCache.getInstance().getProperty("methodName"), EleName[1], textValue, "OUTPUT", sFileName);
        if (!Status || textValue.equals("") || textValue == null) {
            logger.info("'" + sElement + "' is not found in the system");
        }
        return Status;
    }

    public static Boolean funGetServerName() {
        Common common = CommonManager.getInstance().getCommon();
        Boolean blnStatus = false;
        try {

            blnStatus = common.SafeAction(Common.o.getObject("elePreferences"), "elePreferences", "elePreferences");
            blnStatus = common.SafeAction(Common.o.getObject("eleBuildInfo"), "eleBuildInfo", "eleBuildInfo");
            String strServerName = common.ReadElement(Common.o.getObject("btnServerName"), Integer.valueOf(HTML.properties.getProperty("LONGWAIT")));
            strServerName = strServerName.replace("Server ID: ", "");
            PCThreadCache.getInstance().setProperty(PCConstants.LOGGED_SERVERNAME, strServerName.trim());
            logger.info("Logged in ServerName is :" + PCThreadCache.getInstance().getProperty("LOGGED_SERVERNAME"));

            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Get the Logged in ServerName", "Logged in ServerName : " + PCThreadCache.getInstance().getProperty("LOGGED_SERVERNAME") + "'", "PASS");
            // blnStatus = common.SafeAction(Common.o.getObject("eleDeskTopAction"),
            // "ele","eleDeskTopAction");
            blnStatus = common.SafeAction(Common.o.getObject("elePreferences"), "elePreferences", "elePreferences");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return blnStatus;
    }

    public static String Newe_FlatFileName() {
        XlsxReader xls = XlsxReader.getInstance();
        String tcID = PCThreadCache.getInstance().getProperty("TCID");
        String[] splittcID = tcID.split("_");
        String sFileName = null;
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.clear();
        whereConstraint.put(PCConstants.ID, splittcID[0]);
        resultListRows = xls.executeSelectQuery(PCConstants.SHEET_FLATFILE, whereConstraint);
        for (HashMap<String, Object> processRow : resultListRows) {
            sFileName = (String) processRow.get("FlatFileName");
            break;
        }
        return sFileName;
    }

    public static boolean E2ECSVFile() {
        Boolean status = true;
        E2EWrite = FlatFile.getInstance();
        status = E2EWrite.CreateE2ECSVFile();
        return status;
    }

    public Boolean findTextEditValues_New(String screeName, HashMap hm_Val) {
        Boolean blnStatus = true;
        String getFieldValue = null;
        String getTagName = null;
        String[] getFieldID = null;
        int counter;
        //FlatFile write = FlatFile.getInstance();
        //String sFileName = FlatFileName();

        Common common = CommonManager.getInstance().getCommon();
        XlsxReader sXL = XlsxReader.getInstance();
        try {
            List<WebElement> elementLabels = ManagerDriver.getInstance()
                    .getWebDriver()
                    .findElements(Common.o.getObject("labelClassName"));
            for (WebElement getElement : elementLabels) {
                String getFieldName = getElement.getText();
                counter = 0;
                if (!getFieldName.equals("")) {
                    String getElementID = getElement.getAttribute("id");
                    switch (getFieldName.toUpperCase()) {
                        case "BILLING NUMBER":
                            getFieldID[0] = "PolicyFile_Summary:Policy_SummaryScreen:BillingInformationDV:BillingInformation_ExtInputSet:BillingNumber_Ext-btnInnerEl";
                            getTagName = "span";
                            break;
                        default:
                            getFieldID = getElementID.split("-");
                            getFieldID[0] = getFieldID[0].concat("-inputEl");
                            int checkFieldExist = common.ElementSize(By
                                    .id(getFieldID[0]));
                            if (checkFieldExist == 1) {
                                counter = 1;
                                getTagName = common
                                        .getTagName(By.id(getFieldID[0]));
                            }
                            break;
                    }
                    if (counter == 1) {
                        switch (getTagName) {
                            case "div":
                            case "a":
                            case "span":
                                getFieldValue = common.ReadElementforODS(
                                        By.id(getFieldID[0]), 5);
                                break;
                            case "input":
                                getFieldValue = common.ReadElementGetAttribute(
                                        By.id(getFieldID[0]), "value", 5);
                                break;
                        }
                        if (!getFieldValue.equals("") || !(getFieldValue == null)) {

                            //System.out.println(getFieldName + "------- " + getFieldValue);
                            hm_Val.put(getFieldName, getFieldValue);
							/*if(getFieldName.equalsIgnoreCase(sFieldName))
							{
								System.out.println(getFieldName + "------- " + getFieldValue);
								hm_Val.put(getFieldName, getFieldValue);
							}*/
                        }
                    }
                }
            }
			/*if(hm_Val.size()>0)
			{
				 System.out.println(hm_Val);
			}
			String retuValue=null;
			Set<String> keys = hm_Val.keySet();

	        for(String key: keys)
	        {
	        	if(hm_Val.containsKey(key))
				{
				  retuValue = hm_Val.get(key);
				  System.out.println("Key - "+ key +" Value ----" +retuValue);
				  blnStatus = E2EWrite.writeCSV("PolicyInfo",key,retuValue,"", "", sFileName);
				}

	        }*/
        } catch (Exception e) {
            e.printStackTrace();
            blnStatus = true;
        }

        return blnStatus;
    }

    public boolean CaptureUIValueCSV() {
        Boolean blnStatus = true;
        String sFileName = FlatFileName();
		/*if(PCConstants.hm_Val.size()>0)
		{
			 System.out.println(PCConstants.hm_Val);
		}
		String retuValue=null;
		Set<String> keys = PCConstants.hm_Val.keySet();

        for(String key: keys)
        {
        	if(PCConstants.hm_Val.containsKey(key))
			{
			  retuValue = PCConstants.hm_Val.get(key);
			  //System.out.println("Key - "+ key +" Value ----" +retuValue);
			  blnStatus = E2EWrite.writeCSV("",key,retuValue,"", "", sFileName);
			}

        }*/
        return false;

    }

    public Boolean WriteValuesintoCSV(String sSheetName) throws Exception {
        Boolean status = false;
        status = captureAllFields(sSheetName);
        return status;


    }

    public static boolean CaptureValidationMessage_Detail(String sValue, String sMsgType, String CompareType, String sAvailiblityType) throws Exception {
        boolean status = false;
        String blnPrintStatus = null;
        boolean matchStatus = false;
        String strXpath = null;
        Common common = CommonManager.getInstance().getCommon();
        List<String> a = new ArrayList<String>();
        List<WebElement> CellElements = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleValidationMsg"));


        if (CellElements.size() == 0 && sAvailiblityType.equalsIgnoreCase("NOT_AVAIL")) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen as expected", "PASS");
            status = true;
            return status;
        } else if (CellElements.size() == 0 && !sAvailiblityType.equalsIgnoreCase("NOT_AVAIL")) {
            logger.info("No Error/Warning messages in screen to validate");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Valdiate any error/Warning is displayed on screen", "No warning message is displayed on screen to validate", "FAIL");
            status = true;
            return status;
        } else {
            switch (sMsgType.toUpperCase()) {
                case "ERROR":
                    //refClassName = "error_icon";
                    blnPrintStatus = "FAIL";
                    strXpath = "//div[img[@class='error_icon']]";
                    break;
                case "WARNING":
                    //refClassName = "warning_icon";
                    blnPrintStatus = "WARNING";
                    strXpath = "//div[img[@class='warning_icon']]";
                    break;
                case "INFO":
                    //refClassName = "info_icon";
                    blnPrintStatus = "PASS";
                    strXpath = "//div[img[@class='info_icon']]";
                    break;
            }
            for (WebElement obj : CellElements) {

                List<WebElement> Cells = obj.findElements(By.xpath(strXpath));
                for (int i = 0; i <= Cells.size() - 1; i++) {
                    if (Cells.size() != 0) {
                        String actWarningMsg = Cells.get(i).getText();
                        a.add(actWarningMsg);
                        logger.info(actWarningMsg);

                    }
                }
                // check for Warnging in UI list

                for (String actText : a) {
                    if (CompareType.equalsIgnoreCase("EQUALS")) {
                        if (actText.equals(sValue)) {
                            matchStatus = true;
                            logger.info("Expected Warning Message  is matching with actual message '" + sValue + "'");
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected " + sMsgType + " text should matching with actual text '" + sValue + "'", "Expected " + sMsgType + " text is matching with actual text '" + sValue + "'", "PASS");
                            break;
                        }
                    } else if (CompareType.equalsIgnoreCase("CONTAINS"))
                        if (actText.contains(sValue)) {
                            matchStatus = true;
                            logger.info("Expected Warning Message  is matching with actual message '" + sValue + "'");
                            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected " + sMsgType + " text should matching with actual text '" + sValue + "'", "Expected " + sMsgType + " text is matching with actual text '" + sValue + "'", "PASS");
                            break;
                        }

                }
                if (matchStatus == false && sAvailiblityType.equalsIgnoreCase("NOT_AVAIL")) {
                    logger.info("Expected Warning Message is not matching with actual message '" + sValue + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected " + sMsgType + " text should matching with actual text '" + sValue + "'", "Expected " + sMsgType + " text is NOT matching with actual text available '" + sValue + "'. Expected availability Type-" + sAvailiblityType, "PASS");

                } else if (matchStatus == false && !sAvailiblityType.equalsIgnoreCase("NOT_AVAIL")) {
                    logger.info("Expected Warning Message is not matching with actual message '" + sValue + "'");
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Expected " + sMsgType + " text should matching with actual text '" + sValue + "'", "Expected " + sMsgType + " text is NOT matching with actual text available '" + sValue + "'. Expected availability Type-" + sAvailiblityType, "FAIL");
                }

            }
        }
        return matchStatus;
    }

    public static boolean VerifyDropDownValue_Select(String sFuncvalue) throws Exception {
        boolean status = false;
        boolean blnMatchFound = false;
        String[] sActListValue = null;
        String[] arrVal = sFuncvalue.split(":::");
        String[] sExpListValue = arrVal[1].split("##");

        for (int j = 0; j < sExpListValue.length; j++) {
            blnMatchFound = false;
            status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject(arrVal[0]), "ele", "eleDropdown");
            CommonManager.getInstance().getCommon().WaitForPageToBeReady();
            ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(arrVal[0])).sendKeys(Keys.ARROW_DOWN);
            CommonManager.getInstance().getCommon().WaitForPageToBeReady();
            List<WebElement> gwListBox = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("LI"));
            status = PageScreenShot("FieldDropDownValue");
            for (int k = 0; k < gwListBox.size(); k++) {
                if (sExpListValue[j].equals(gwListBox.get(k).getText())) {
                    logger.info("Expected UI dropdown value - " + sExpListValue[j] + " is available in List");
                    gwListBox.get(k).click();
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are available in UI List", "Expected Dropdown Value - '" + sExpListValue[j] + "' available in UI list", "PASS");
                    blnMatchFound = true;
                    break;
                }
            }
            // status=CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID),
            // "ele", "eleDropdown");
            if (!blnMatchFound) {
                logger.info("Expected UI dropdown value - " + sExpListValue[j] + "is not available in List");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are available in UI List", "Expected Dropdown Value - " + sExpListValue[j] + "NOT available in UI list", "FAIL");
                status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject(arrVal[0]), "ele", "eleDropdown");
            }
        }
        return status;
    }

    public static boolean VerifyDropDownValueUnavailable(String sFuncvalue) throws Exception {
        boolean status = false;
        boolean blnMatchFound = false;
        String[] sActListValue = null;
        String[] arrVal = sFuncvalue.split(":::");
        String[] sExpListValue = arrVal[1].split("##");

        for (int j = 0; j < sExpListValue.length; j++) {
            blnMatchFound = false;
            status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject(arrVal[0]), "ele", "eleDropdown");
            CommonManager.getInstance().getCommon().WaitForPageToBeReady();
            ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(arrVal[0])).sendKeys(Keys.ARROW_DOWN);
            CommonManager.getInstance().getCommon().WaitForPageToBeReady();
            List<WebElement> gwListBox = ManagerDriver.getInstance().getWebDriver().findElements(By.tagName("LI"));
            status = PageScreenShot("FieldDropDownValue");
            for (int k = 0; k < gwListBox.size(); k++) {
                if (sExpListValue[j].equals(gwListBox.get(k).getText())) {
                    logger.info("Expected UI dropdown value - " + sExpListValue[j] + " is available in List");
                    gwListBox.get(k).click();
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are available in UI List", "Expected Dropdown Value - '" + sExpListValue[j] + "' available in UI list", "FAIL");
                    blnMatchFound = true;
                    break;
                }
            }
            // status=CommonManager.getInstance().getCommon().SafeAction(By.id(eleObjID),
            // "ele", "eleDropdown");
            if (!blnMatchFound) {
                logger.info("Expected UI dropdown value - " + sExpListValue[j] + "is not available in List");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Validate whether the Dropdown values are available in UI List", "Expected Dropdown Value - " + sExpListValue[j] + "NOT available in UI list", "PASS");
                status = CommonManager.getInstance().getCommon().SafeAction(Common.o.getObject(arrVal[0]), "ele", "eleDropdown");
            }
        }
        return status;
    }


    public static Boolean verifyEditField_Blank(String strField) throws Exception {

        boolean Status = true;
        CommonManager.getInstance().getCommon();
        WebElement element1 = ManagerDriver.getInstance().getWebDriver().findElement(Common.o.getObject(strField));
        // String txt = element1.getText();
        String txt = element1.getText();

        if (txt.trim().length() == 0) {
            logger.info("Field is displayed '" + strField + "' with NULL value " + txt);
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strField + "' with pre polulated value ", "System displayed '" + strField + "' with pre polulated value", "PASS");
            // Status = true;
        } else {
            logger.info("Field is NOT displayed '" + strField + "' with value");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "System should display '" + strField + "' with pre polulated value ", "System is NOT displayed '" + strField + "' with pre polulated value", "FAIL");
            // Status = false;
        }
        return Status;
    }

    public static Boolean verifyTblValue(String sTblTitle, String sSearchForField, String sSearchString, String sGetTextonColumn, String PageNamme) throws Exception {
        Boolean blnStatus = true;
        String getFieldValue = null;
        String getTagName = null;
        String[] getFieldID = null;
        String strxpath = null;
        String strxpathHeader = null;
        String TblData = null;
        boolean blnSearhcCondition = false;
        String ActualColValue = null;

        String ActColName = null;
        int retColNumber;
        String sActColXpath = null;
        String sNewActColXpath = null;

        int counter;
        Boolean blnColumnAvail = false;
        String strHeaderID = null;
        String strNewDatapath = null;

        Common common = CommonManager.getInstance().getCommon();
        XlsxReader sXL = XlsxReader.getInstance();

        switch (PageNamme.toUpperCase()) {
            case "POLICY SUMMARY":
            case "ACCOUNT SUMMARY":
                strxpath = "//span[text()='<TITLE>']/ancestor::div[@class='x-panel x-panel-default x-grid']//table[contains(@id,'gridview')]//tr[@class='x-grid-row  x-grid-data-row']";
                strxpathHeader = "//span[text()='<TITLE>']/ancestor::div[@class='x-panel x-panel-default x-grid']/div[contains(@id,'headercontainer')]//div[contains(@class,'x-box-item x-column-header-default x-unselectable')]//*[@class='x-column-header-text']";
                break;
            case "PARTICIPANTS":
                strxpath = "//span[text()='<TITLE>']/ancestor::div[@class='x-container g-screen x-container-page x-table-layout-ct']//div[@class='x-panel x-panel-default x-grid']//table[contains(@id,'gridview')]//tr[@class='x-grid-row  x-grid-data-row']";
                strxpathHeader = "//span[text()='<TITLE>']/ancestor::div[@class='x-container g-screen x-container-page x-table-layout-ct']//div[@class='x-panel x-panel-default x-grid']/div[contains(@id,'headercontainer')]//div[contains(@class,'x-box-item x-column-header-default x-unselectable')]//*[@class='x-column-header-text']";
                break;
            default:
                logger.info("Page not found in the switch case");
                break;
        }

        String strDataXpath = "x-grid-cell x-grid-td x-grid-cell-headerId-<REPALCE>";
        strxpath = strxpath.replace("<TITLE>", sTblTitle);
        strxpathHeader = strxpathHeader.replace("<TITLE>", sTblTitle);
        List<WebElement> eleHeader = ManagerDriver.getInstance().getWebDriver().findElements(By.xpath(strxpathHeader));
        try {
            List<WebElement> eleRows = ManagerDriver.getInstance().getWebDriver().findElements(By.xpath(strxpath));
            if (eleRows.size() >= 1) {
                //get Expected column number
                for (int k = 0; k < eleHeader.size(); k++)//for(WebElement getDivData : eleData)
                {
                    ActColName = eleHeader.get(k).getText();
                    if (ActColName.equalsIgnoreCase(sGetTextonColumn)) {
                        blnColumnAvail = true;
                        sActColXpath = eleHeader.get(k).getAttribute("id");
                        sActColXpath = sActColXpath.replace("-textEl", "");
                        sNewActColXpath = strDataXpath.replace("<REPALCE>", sActColXpath);
                        break;
                    }

                }
                if (blnColumnAvail) {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify Column availablity in Table '" + sTblTitle + "' to fetch Value", "'" + sGetTextonColumn + "' Column available in table to fetch value", "PASS");
                    logger.info("GetText on column" + sGetTextonColumn + " avaialble ");
                } else {
                    HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify Column availablity in Table '" + sTblTitle + "' to fetch Value", "'" + sGetTextonColumn + "' Column NOT available in table to fetch value", "FAIL");
                    logger.info("GetText on column" + sGetTextonColumn + " NOT avaialble ");
                }


                for (WebElement gettblData : eleRows) {
                    for (int j = 0; j < eleHeader.size(); j++)//for(WebElement getDivData : eleData)
                    {
                        logger.info("Header ---" + j + "-----" + eleHeader.get(j).getText());
                        if (!sSearchForField.isEmpty() && sSearchForField.equals("")) {
                            if (sSearchForField.equals(eleHeader.get(j).getText())) {
                                strHeaderID = eleHeader.get(j).getAttribute("id");
                                strHeaderID = strHeaderID.replace("-textEl", "");
                                if (!strHeaderID.contains("rowcheckcolumn")) {
                                    strNewDatapath = strDataXpath.replace("<REPALCE>", strHeaderID);
                                    String s = "//td[contains(@class,'" + strNewDatapath + "')]//div";
                                    TblData = ManagerDriver.getInstance().getWebDriver().findElement(By.xpath(s)).getText();
                                    logger.info(TblData);
                                    boolean status = common.CompareStringResult("Searching Column", sSearchString, TblData);
                                    if (status) {
                                        blnSearhcCondition = true;
                                        String ActColValue = "//td[contains(@class,'" + sNewActColXpath + "')]//div";
                                        logger.info(ManagerDriver.getInstance().getWebDriver().findElement(By.xpath(ActColValue)).getText());
                                        break;
                                    }
                                }

                            }
                        } else // searchforfield is blank then directly fetch value
                        {
                            String ActColValue = "//td[contains(@class,'" + sNewActColXpath + "')]//div";
                            logger.info(ManagerDriver.getInstance().getWebDriver().findElement(By.xpath(ActColValue)).getText());
                            break;
                        }

                    }

                    if (blnSearhcCondition) {
                        break;
                    }
                }

            } else //	rows loop
            {
                logger.info("No records found in the table to fetch records");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify rows available in the  Table '" + sTblTitle + "' to fetch Value", "No records available in table to fetch value", "FAIL");
            }

        } catch (Exception e) {

        }

        return blnStatus;
    }

    public boolean PageNavigation(String sPageName) {
        boolean status = false;
        String strHomePage = null;
        String strNavigationScreen = null;
        boolean blnPagefound = false;
        String strActualText = null;
        String srchVal = null;
        String strScreenTab = null;
        String strSubTab = null;

        XlsxReader xls = XlsxReader.getInstance();
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> resultListRows = new ArrayList<HashMap<String, Object>>();
        whereConstraint.clear();
        whereConstraint.put("PC Page Name", sPageName);
        resultListRows = xls.executeSelectQuery("PageNavigation", whereConstraint);
        try {
            if (resultListRows.size() > 0) {
                Outer:
                for (HashMap<String, Object> processRow : resultListRows) {
                    //strFieldType = sFieldName.substring(sFieldName.length() - 3);
                    strHomePage = (String) processRow.get("Click_Desktop");
                    if (strHomePage.toUpperCase().equals("YES") && !strHomePage.isEmpty()) {
                        status = common.SafeAction(Common.o.getObject("melDesktop"), strHomePage, "melDesktop");
                    }

                    strNavigationScreen = (String) processRow.get("funNavigation_Screen");
                    strScreenTab = (String) processRow.get("funNavigation_ScreenTab");
                    strSubTab = (String) processRow.get("funNavigation_ScreenSubTab");


                    if (!strNavigationScreen.isEmpty()) {
                        switch (strNavigationScreen.toUpperCase()) {
                            case "<ACCNUM_SEARCH>":
                                //go to bar type Account accno
                                //625118206481908
                                //srchVal="Account "+PCThreadCache.getInstance().getProperty("AccountNumber");
                                srchVal = "Account 244656332345541";
                                status = common.SafeAction(Common.o.getObject("txtGotoBar"), srchVal, "txtGotoBar");
                                if (!strScreenTab.isEmpty()) {
                                    status = ScreensubTab("eleAccountSubTabs", strScreenTab);
                                }
                                break;
                            case "<POLNUM_SEARCH>":
                                //srchVal="Policy "+PCThreadCache.getInstance().getProperty("CACHE_POLICY_NUMBER");
                                srchVal = "Policy 59SBMAX2HF0";
                                status = common.SafeAction(Common.o.getObject("txtGotoBar"), srchVal, "txtGotoBar");
                                if (!strScreenTab.isEmpty()) {
                                    status = ScreensubTab("elePolicySubTabs", strScreenTab);
                                }
                                break;

							/*case "POLICY INFO":
									status=common.SafeAction(Common.o.getObject("elePolicy Info"),"YES", "elePolicy Info");
									break;
								case "RISK ANALYSIS":
									status=common.SafeAction(Common.o.getObject("eleRiskAnalysisTab"),"YES", "eleRiskAnalysisTab");
									break;*/
                        }
                    }


                }
			/*List<WebElement> Objtitle = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject("eleTitleElements"));
			if (Objtitle.size() != 0)
			{
				for (int i = 0; i <= Objtitle.size() - 1; i++)
				{
					strActualText=Objtitle.get(i).getText();
					if(strActualText.equals(sPageName))
					{
						logger.info("Navigated to the page as expected");
						HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify page is navigated to '"+sPageName+"'", "'"+ sPageName +"'Page has been successfully navigated !!!", "PASS");
						blnPagefound=true;
						break;
					}
				}
				if(!blnPagefound)
				{
					logger.info("NOT Navigated to the page as expected");
					HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify page is navigated to '"+sPageName+"'", "'"+ sPageName +"'Page navigation has been Failed!!!", "FAIL");
				}
			}*/

            } else {
                logger.info("No rows available in sheet for specific criteria !!!");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify page is navigated to '" + sPageName + "'", "No records found in 'Page Navigation' sheet", "FAIL");
            }

        } catch (Exception e) {
            logger.info("Exception occured ----" + e.getMessage());
        }
        return status;

    }

    public boolean ScreensubTab(String strObj, String subTabName) throws IOException {
        String strActTabName = null;
        boolean blnTabFound = false;
        boolean Status = false;
        JavascriptExecutor js = (JavascriptExecutor) ManagerDriver.getInstance().getWebDriver();
        List<WebElement> allSubTabs = ManagerDriver.getInstance().getWebDriver().findElements(Common.o.getObject(strObj));
        for (int i = 0; i < allSubTabs.size(); i++) {
            strActTabName = allSubTabs.get(i).getText();
            if (strActTabName.equals(subTabName)) {
                blnTabFound = true;
                allSubTabs.get(i).click();
                try {
                    Status = JavaScript(js);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                logger.info("Sub tab is available in screen to click !!!");
                HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify sub tab is available in screen and clicked -" + subTabName, "Sub tab is available and clicked", "PASS");
                break;
            }
        }
        if (!blnTabFound) {
            logger.info("Sub tab is NTO available in screen to click !!!");
            HTML.fnInsertResult(PCThreadCache.getInstance().getProperty("testcasename"), PCThreadCache.getInstance().getProperty("methodName"), "Verify sub tab is available in screen and clicked -" + subTabName, "Sub tab is NOT available and clicked", "FAIL");
        }
        return true;

    }

}
