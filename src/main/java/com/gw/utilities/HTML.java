package com.gw.utilities;

import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import com.gw.constants.PCConstants;
import com.gw.driver.ParallelExecDriver;
import com.gw.screen.SCRCommon;

public class HTML {

    static String Actualval = "";
    static String screenshotpath = "";
    public static String g_sFileName = "";
    public static String g_iCapture_Count = "";// 'Number of Image capture
    public static int g_iImage_Capture;// =""; //'Flag for Image Capture in Result File
    public static int g_iPass_Count = 0; // 'Pass Count
    public static int g_iFail_Count;// =0; //'Fail Count
    public static Date g_tStart_Time; // 'Start Time
    public static int g_Total_TC;// =0;
    public static int g_Total_Pass;// =0;
    public static int g_SummaryReTotal_Pass;//=0;
    public static int g_Total_Fail;// =0;
    public static int g_Flag;// =0;
    public static int g_Flag1;// =0;
    public static Date g_tSummaryStart_Time;// 'Start Time
    public static Date g_tSummaryEnd_Time; // 'End Time
    public static int g_SummaryReTotal_Fail;//=0;
    public static int g_SummaryTotal_TC;// =0;
    public static int g_SummaryTotal_Pass;// =0;
    public static int g_SummaryTotal_Fail;// =0;
    public static int g_SummaryFlag = 0;
    public static String g_ScriptName = "";
    public static String g_sSection = "";
    public static File file;
    public static String actualexpectedvalue;
    public static String reportsFolder = null;
    static Logger log = Logger.getLogger(Common.class);

    public static Properties properties = new Properties();

    /*
     * Summary Initialization Start Called once for all Threads.
     *
     */
    public static void fnSummaryInitialization(String strSummaryReportName) throws IOException {
        File directory = new File(".");
        String sConfigfilespath = directory.getCanonicalPath() + "\\src\\main\\resources\\config";
        FileInputStream fis = new FileInputStream(sConfigfilespath + "\\Sys.properties");
        properties.load(fis);
        fis.close();
        properties.setProperty("SummaryFileName", "");
        reportsFolder = directory.getCanonicalPath() + "\\target\\Reports\\HTMLReports";
        File objDir = new File(reportsFolder);
        if (!objDir.exists()) {
            objDir.mkdir();
        }
        fnSummaryOpenHtmlFile(strSummaryReportName);// 'logo, heading
        fnSummaryInsertSection(); // 'TestCaseID,Scenario Name and Result
    }

    public static void fnSummaryOpenHtmlFile(String sSection) throws IOException {
        g_iPass_Count = 0;
        g_iFail_Count = 0;
        g_sFileName = "sScriptName";
        // g_iImage_Capture = 1
        g_SummaryReTotal_Pass = 0;
        g_SummaryTotal_TC = 0;
        g_SummaryTotal_Pass = 0;
        g_SummaryReTotal_Fail = 0;
        g_SummaryTotal_Fail = 0;
        g_SummaryFlag = 0;
        g_ScriptName = "sScriptName";

        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String DateToStr = format.format(curDate);

        String gsTempFile = properties.getProperty("SummaryFileName");
        if (gsTempFile == null || gsTempFile == "") {
            gsTempFile = reportsFolder + "\\" + sSection + DateToStr + ".htm";
            properties.setProperty("SummaryFileName", gsTempFile);
        }
        Path objPath = Paths.get(gsTempFile);
        FileWriter objFile = new FileWriter(gsTempFile, true);
        objFile.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
        objFile.write("<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://www.thehartford.com/sites/the_hartford/img/logo.png'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=3><B>&nbsp;Automation Test Results<BR/><FONT FACE=VERDANA COLOR=SILVER SIZE=2>&nbsp; Date: " + curDate + "</BR>&nbsp;On Machine :" + SCRCommon.getMachineName() + "</B></FONT></TD><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://www.thehartford.com/sites/the_hartford/img/logo.png'></TD></TR></TABLE>");
        objFile.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
        objFile.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Module Name:</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699 ><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>" + sSection + "</B></FONT></TD></TR>");
        objFile.write("</TABLE></BODY></HTML>");
        objFile.close();
        g_tSummaryStart_Time = curDate;
        g_sSection = sSection;
    }

    public static void fnSummaryInsertSection() throws IOException {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String DateToStr = format.format(d);
        String gsTempFile = properties.getProperty("SummaryFileName");
        Path objPath = Paths.get(gsTempFile);
        FileWriter objFile = new FileWriter(gsTempFile, true);
        objFile.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
        objFile.write("<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=15><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case ID</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=45%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case Name</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Scenario Name</B></FONT></TD><TD BGCOLOR=#FFCC99 SIZE=2 WIDTH=10%><B>Time</B></FONT></TD><TD BGCOLOR=#FFCC99 SIZE=2 WIDTH=10%><B>Result</B></FONT></TD></TR>");
        objFile.close();
    }
    public static void fnInitilization(String BprocessName) throws IOException, AWTException {
        PCThreadCache.getInstance().setProperty("FileName", "");
        PCThreadCache.getInstance().setProperty("FolderName1", reportsFolder + "\\" + BprocessName);
        fnOpenHtmlFile(BprocessName);
        fnInsertSection();
        fnInsertTestCaseName("");
    }

    public static void fnOpenHtmlFile(String sSection) throws IOException, AWTException {
        g_iPass_Count = 0;
        g_iFail_Count = 0;
        g_sFileName = "sScriptName";
        g_iImage_Capture = 1;
        g_Total_TC = 0;
        g_Total_Pass = 0;
        g_Total_Fail = 0;
        g_Flag = 0;
        g_Flag1 = 0;
        g_ScriptName = "sScriptName";
        String machinename = null;
        String relativePath = null;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String DateToStr = format.format(d);
        String gsTempFile = PCThreadCache.getInstance().getProperty("FileName");
        Path objPath = Paths.get(gsTempFile);
        if (gsTempFile == "") {
            gsTempFile = reportsFolder + "\\" + sSection + DateToStr + "_" + Thread.currentThread().getId() + ".htm";
            PCThreadCache.getInstance().setProperty("FileName", gsTempFile);
            relativePath = sSection + DateToStr + "_" + Thread.currentThread().getId() + ".htm";
            PCThreadCache.getInstance().setProperty("relativePath", relativePath);
        }
        if (Files.exists(objPath)) {
            FileWriter objFile = new FileWriter(gsTempFile, true);
            objFile.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
            objFile.write("<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='https://www.thehartford.com/sites/the_hartford/img/logo.png'></TD><TD WIDTH=94% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=3><B>ComPAS Automation Test Results<BR/><FONT FACE=VERDANA COLOR=SILVER SIZE=2>Date: " + d + "</BR>on Machine :" + machinename + "</B></FONT></TD><TD BGCOLOR=WHITE WIDTH=6%><IMG  SRC='https://www.thehartford.com/sites/the_hartford/img/logo.png'></TD></TR></TABLE>");
            objFile.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
            objFile.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Module Name:</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699 ><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>" + sSection + "</B></FONT></TD></TR>");
            objFile.write("</TABLE></BODY></HTML>");
            objFile.close();
        }
        g_tStart_Time = d;
        g_sSection = sSection;
    }

    public static void fnInsertSection() throws IOException {
        Date d = new Date();
        String gsTempFile = PCThreadCache.getInstance().getProperty("FileName");
        Path objPath = Paths.get(gsTempFile);
        if (Files.exists(objPath)) {
            FileWriter objFile = new FileWriter(gsTempFile, true);
            objFile.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
            objFile.write(
                    "<TR COLS=6><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Case Name</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Component</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Expected Value</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Actual Value</B></FONT></TD><TD BGCOLOR=#FFCC99 WIDTH=25%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Result</B></FONT></TD></TR>");
            objFile.close();
        }
    }

    public static void fnInsertTestCaseName(String sDesc) {
        Date d = new Date();
        g_Total_TC = g_Total_TC + 1;
        if (g_Flag1 != 0) {
            if (g_Flag == 0) {
                g_Total_Pass = g_Total_Pass + 1;
            } else {
                g_Total_Fail = g_Total_Fail + 1;
            }
        }
        g_Flag = 0;
    }
    public static void fnInsertResult(String sTestCaseName, String sDesc, String sExpected, String sActual, String sResult) throws IOException {

        XlsxReader sXL = XlsxReader.getInstance();
        // added for testing - may be required permanently
        // common = CommonManager.getInstance().getCommon();

        // log.debug("Thread ID = " + Thread.currentThread().getId() + " common = "+
        // common);
        try {
            g_Flag1 = 1;
            Date d = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String DateToStr = format.format(d);
            String gsTempFile = PCThreadCache.getInstance().getProperty("FileName");
            String strSSPath = null;
            Path objPath = Paths.get(gsTempFile);
            if (Files.exists(objPath)) {
                FileWriter objFile = new FileWriter(gsTempFile, true);
                if (sResult.toUpperCase() == "PASS") {
                    g_iPass_Count = g_iPass_Count + 1;
                    if (properties.getProperty("CaptureScreenShotforPass").equalsIgnoreCase("YES")) {
                        String I_sFile = "";
                        g_iCapture_Count = "Screen" + DateToStr;
                        I_sFile = reportsFolder + "\\Screen_" + DateToStr + "_" + Thread.currentThread().getId() + ".png";
                        strSSPath = "Screen_" + DateToStr + "_" + Thread.currentThread().getId() + ".png";
                        PCThreadCache.getInstance().setProperty(PCConstants.FailureSSPath, strSSPath);
                        // if(driver != null)
                        /*
                         * if(ManagerDriver.getInstance().getWebDriver() != null) { File
                         * scrFile=((TakesScreenshot)ManagerDriver.getInstance().getWebDriver()).
                         * getScreenshotAs(OutputType.FILE); FileUtils.copyFile(scrFile, new
                         * File(I_sFile)); }
                         */
                        try {
                            if (ManagerDriver.getInstance().getWebDriver() != null) {
                                File scrFile = ((TakesScreenshot) ManagerDriver.getInstance().getWebDriver()).getScreenshotAs(OutputType.FILE);
                                FileUtils.copyFile(scrFile, new File(I_sFile));
                            }
                        } catch (TimeoutException e) {
                            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
                            e.printStackTrace();
                        } catch (WebDriverException e) {
                            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
                            e.printStackTrace();
                        }
                        objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=WINGDINGS SIZE=4>2></FONT><FONT FACE=VERDANA SIZE=2><A HREF='" + strSSPath + "'>" + sActual
                                + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
                    } else {
                        objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sActual
                                + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
                    }
                } else if (sResult.toUpperCase() == "FAIL") {

                    String currenturl = ManagerDriver.getInstance().getWebDriver().getCurrentUrl();
                    //System.out.println("currenturl is:::" + currenturl);
                    String title = ManagerDriver.getInstance().getWebDriver().getTitle();
                    //System.out.println("title is:::" + title);
                    String pagesource = ManagerDriver.getInstance().getWebDriver().getPageSource();
                    //System.out.println("pagesource is:::" + pagesource);
                    String windowhandle = ManagerDriver.getInstance().getWebDriver().getWindowHandle();
                    //System.out.println("windowhandle is:::" + windowhandle);
                    //Set<String> windowhandles =ManagerDriver.getInstance().getWebDriver().
                    // Set<String> windowhandles =ManagerDriver.getInstance().getWebDriver().getWindowHandles();
					/* for (String handle : windowhandles) {
						 System.out.println("handle is :::"+handle);


					 }*/
					/* for(int i=0;i<=windowhandles.size(); i++)
					 {
						 System.out.println("element is :::"+windowhandles.);
					 }*/
					/*WebClient wc = new WebClient(BrowserVersion.CHROME);
					javax.swing.text.html.HTML page = webClient.getPage("");*/
                    Actualval = Actualval + "   " + sActual;
                    //System.out.println("Actualval is :::" + Actualval);
                    g_Flag = 1;
                    g_SummaryFlag = 1;
                    // added to fix overall summary status start
                    //PCThreadCache.getInstance().setProperty(PCConstants.CACHE_TEST_CASE_STATUS, "FAIL");
                    PCThreadCache.getInstance().setProperty(PCThreadCache.getInstance().getProperty("TCID"), "FAIL");
                    g_iFail_Count = g_iFail_Count + 1;
                    if (properties.getProperty("CaptureScreenShotforFail").equalsIgnoreCase("YES")) {
                        String I_sFile = "";
                        g_iCapture_Count = "Screen" + DateToStr;
                        I_sFile = reportsFolder + "\\Screen_" + DateToStr + "_" + Thread.currentThread().getId() + ".png";
                        // strSSPath = "Screen" + g_iCapture_Count + ".png";
                        strSSPath = "Screen_" + DateToStr + "_" + Thread.currentThread().getId() + ".png";
                        String strALMUploadSSPath = reportsFolder + "\\" + strSSPath;
                        screenshotpath = strALMUploadSSPath;
                        PCThreadCache.getInstance().setProperty(PCConstants.FailureSSPath, strALMUploadSSPath);
                        try {
                            if (ManagerDriver.getInstance().getWebDriver() != null) {
                                File scrFile = ((TakesScreenshot) ManagerDriver.getInstance().getWebDriver()).getScreenshotAs(OutputType.FILE);
                                FileUtils.copyFile(scrFile, new File(I_sFile));
                            }
                        } catch (TimeoutException e) {
                            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
                            e.printStackTrace();
                        } catch (WebDriverException e) {
                            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
                            e.printStackTrace();
                        }
                        if (Common.actualandexpected == 0) {
                            actualexpectedvalue = sExpected;
                        }

                        objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=WINGDINGS SIZE=4>2></FONT><FONT FACE=VERDANA SIZE=2><A HREF='" + strSSPath + "'>" + sActual
                                + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" + sResult + "</B></FONT></TD></TR>");
                        Common.actualandexpected = 1;
                    } else {
                        objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sActual
                                + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" + sResult + "</B></FONT></TD></TR>");
                    }
                    //String rpath = HTML.properties.getProperty("LogPath");
                    File directory = new File(".");
                    String rpath = directory.getCanonicalPath() + "\\target\\Reports\\HTMLReports\\Log";

                    String logs = rpath + "/" + PCThreadCache.getInstance().getProperty("TCID") + ".log";
                    String tccount = PCThreadCache.getInstance().getProperty(sTestCaseName + PCThreadCache.getInstance().getProperty("TCID"));
                    sXL.failuresReader("Component should run properly", sActual, PCThreadCache.getInstance().getProperty("relativePath"), screenshotpath, logs, sExpected, tccount);

                } else if (sResult.toUpperCase() == "WARNING") {
                    if (properties.getProperty("CaptureScreenShotforWarning").equalsIgnoreCase("YES")) {
                        String I_sFile = "";
                        g_iCapture_Count = "Screen" + DateToStr;
                        I_sFile = reportsFolder + "\\Screen_" + DateToStr + "_" + Thread.currentThread().getId() + ".png";
                        strSSPath = "Screen_" + DateToStr + "_" + Thread.currentThread().getId() + ".png";
                        try {
                            if (ManagerDriver.getInstance().getWebDriver() != null) {
                                File scrFile = ((TakesScreenshot) ManagerDriver.getInstance().getWebDriver()).getScreenshotAs(OutputType.FILE);
                                FileUtils.copyFile(scrFile, new File(I_sFile));
                            }
                        } catch (TimeoutException e) {
                            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
                            e.printStackTrace();
                        } catch (WebDriverException e) {
                            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
                            e.printStackTrace();
                        }
                        objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=WINGDINGS SIZE=4>2></FONT><FONT FACE=VERDANA SIZE=2><A HREF='" + strSSPath + "'>" + sActual
                                + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
                    } else {
                        objFile.write("<TR COLS=5><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sTestCaseName + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA SIZE=2>" + sDesc + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sExpected + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + sActual
                                + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + sResult + "</B></FONT></TD></TR>");
                    }
                }
                objFile.close();
            }
        } catch (Exception e) {
            log.info("'TestCaseName:' " + sTestCaseName + " 'Description:' " + sDesc + " 'Expected Value' '" + sExpected + " 'Actual Value' " + sActual + " 'Results' " + sResult + "");
            e.printStackTrace();
            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
        }
    }

    public static void fnSummaryInsertTestCase() throws IOException {
        File directory = new File(".");
        String rpath = directory.getCanonicalPath() + "\\target\\Reports\\HTMLReports\\Log";

        //String rpath = HTML.properties.getProperty("LogPath");
        Common Common = CommonManager.getInstance().getCommon();
        String tCaseID = PCThreadCache.getInstance().getProperty("TestCaseID");
        String tSetID = PCThreadCache.getInstance().getProperty("TestSetID");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date g_tSummaryTCEnd_Time;
        Date g_tSummaryTCStart_Time = null;
        String testCaseExecStartTime = PCThreadCache.getInstance().getProperty("testCaseExecutionStartTime");
        try {
            g_tSummaryTCStart_Time = sdf.parse(testCaseExecStartTime);

        } catch (ParseException e) {
            e.printStackTrace();
            log.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
            log.error("Not able to get TC Execution Start time");
        }
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String DateToStr = format.format(curDate);
        Date d = new Date();
        String gsTempFile = properties.getProperty("SummaryFileName");
        Path objPath = Paths.get(gsTempFile);
        if (ParallelExecDriver.count == 0) {
            g_SummaryTotal_TC = g_SummaryTotal_TC + 1;
        }
        String testCaseLevelStatus = PCThreadCache.getInstance().getProperty(PCThreadCache.getInstance().getProperty("TCID"));
        String strStatus = "";
        String almStatus = "1";
        if (!(ParallelExecDriver.count == 0)) {

            if (testCaseLevelStatus == null || testCaseLevelStatus.length() == 0) {
                log.info("IT is in first if condition:::");
                g_SummaryReTotal_Pass = g_SummaryReTotal_Pass + 1;
                strStatus = "PASSED";
                almStatus = "0";
            } else if (testCaseLevelStatus != null && testCaseLevelStatus.length() > 0 && "FAIL".equalsIgnoreCase(testCaseLevelStatus)) {
                g_SummaryReTotal_Fail = g_SummaryReTotal_Fail + 1;
                log.info("g_SummaryTotal_Fail is :::" + g_SummaryTotal_Fail);
                strStatus = "FAILED";
                almStatus = "1";
            }
        }
        if (testCaseLevelStatus == null || testCaseLevelStatus.length() == 0) {
            log.info("IT is in first if condition:::");
            g_SummaryTotal_Pass = g_SummaryTotal_Pass + 1;
            strStatus = "PASSED";
            almStatus = "0";
        } else if (testCaseLevelStatus != null && testCaseLevelStatus.length() > 0 && "FAIL".equalsIgnoreCase(testCaseLevelStatus)) {
            g_SummaryTotal_Fail = g_SummaryTotal_Fail + 1;
            log.info("g_SummaryTotal_Fail is :::" + g_SummaryTotal_Fail);
            strStatus = "FAILED";
            almStatus = "1";
        }
        g_tSummaryTCEnd_Time = d;

        HashMap<String, Object> updateColumnNameValues = new HashMap<String, Object>();
        HashMap<String, Object> whereConstraint = new HashMap<String, Object>();
        updateColumnNameValues.clear();
        whereConstraint.clear();
        updateColumnNameValues.put("Status", strStatus);
        whereConstraint.put("ID", PCThreadCache.getInstance().getProperty("TCID"));
        XlsxReader sXL = XlsxReader.getInstance();
        PCThreadCache.getInstance().setProperty("Status", strStatus);
        String intDateDiff = "";
        long diff = g_tSummaryTCEnd_Time.getTime() - g_tSummaryTCStart_Time.getTime();
        long starttotalsecs = ((g_tSummaryTCStart_Time.getMinutes() + (g_tSummaryTCStart_Time.getHours()) * 60) * 60) + g_tSummaryTCStart_Time.getSeconds();
        g_tSummaryEnd_Time = d;
         long endtotalsecs = ((g_tSummaryEnd_Time.getMinutes() + (HTML.g_tSummaryEnd_Time.getHours() * 60)) * 60) + g_tSummaryEnd_Time.getSeconds();
        long diffofsec = endtotalsecs - starttotalsecs;
        String ssn = "";
        long diffinmin = 0;
        if (diffofsec > 60) {
            diffinmin = diffofsec / 60;
            long remainsec = diffofsec % 60;
            if (diffinmin > 60) {
                long hours1 = (int) Math.floor(diffinmin / 60);
                long minutes = diffinmin % 60;
                ssn = Long.toString(hours1) + "hrs" + Long.toString(minutes) + "mins";
            } else {
                ssn = Long.toString(diffinmin) + "min" + Long.toString(remainsec) + "sec";
            }
        } else {
            ssn = Long.toString(diffofsec) + "secs";
        }
        intDateDiff = ssn;
        if (Files.exists(objPath)) {
            FileWriter objFile = new FileWriter(gsTempFile, true);
            if (strStatus.toUpperCase() == "PASSED") {
                if (ParallelExecDriver.count != 0) {
                    ParallelExecDriver.failureGroup.remove(PCThreadCache.getInstance().getProperty("TCID"));
                }
                objFile.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + PCThreadCache.getInstance().getProperty("TCID") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=45%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><A HREF='" + PCThreadCache.getInstance().getProperty("relativePath") + "'>" + PCThreadCache.getInstance().getProperty("testcasename") + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>"
                        + PCThreadCache.getInstance().getProperty("testcasename") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + intDateDiff + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=WINGDINGS 2' SIZE=5 COLOR=GREEN>P</FONT><FONT FACE=VERDANA SIZE=2 COLOR=GREEN><B>" + strStatus + "</B></FONT></TD></TR>");
            } else if (strStatus.toUpperCase() == "FAILED") {
                String re = "no";
                if (ParallelExecDriver.failureGroup.contains(PCThreadCache.getInstance().getProperty("TCID"))) {
                    re = "yes";
                }
                BufferedWriter writer = Common.getFile();
				if ((re.equals("no")) && (ParallelExecDriver.count == 0)) {
                    ParallelExecDriver.failureGroup.add(PCThreadCache.getInstance().getProperty("TCID"));
                }
                log.info("It in in files.exists strStatus failed:::");
                objFile.write("<TR COLS=6><TD BGCOLOR=#EEEEEE WIDTH=15%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + PCThreadCache.getInstance().getProperty("TCID") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=45%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><A HREF='" + PCThreadCache.getInstance().getProperty("relativePath") + "'>" + PCThreadCache.getInstance().getProperty("testcasename") + "</A></FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>"
                        + PCThreadCache.getInstance().getProperty("testcasename") + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2>" + intDateDiff + "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=WINGDINGS 2' SIZE=5 COLOR=RED>O</FONT><FONT FACE=VERDANA SIZE=2 COLOR=RED><B>" + strStatus + "</B></FONT></TD></TR>");
            }
            objFile.close();
            String ALMUpdate = properties.getProperty("ALMUpdate");
            String Screenshot = properties.getProperty("Screenshot");
            if (ALMUpdate.contains("YES") && Screenshot.contains("NO")) {
                Common.RunScript(tCaseID, tSetID, almStatus, PCThreadCache.getInstance().getProperty("FileName") + "*****" + PCThreadCache.getInstance().getProperty(PCConstants.FailureSSPath) + "", PCThreadCache.getInstance().getProperty("testcasename"), properties.getProperty("ALMUserName"), properties.getProperty("ALMPassword"), properties.getProperty("sQCURL"), properties.getProperty("sDomain"), properties.getProperty("sProject"), properties.getProperty("ALMDraftRun"));
            }
            if (ALMUpdate.contains("YES") && Screenshot.contains("YES")) {
                Common.RunScript(tCaseID, tSetID, almStatus, PCThreadCache.getInstance().getProperty("FileName") + "*****" + PCThreadCache.getInstance().getProperty(PCConstants.ALMScreenshotPath) + ".zip", PCThreadCache.getInstance().getProperty("testcasename"), properties.getProperty("ALMUserName"), properties.getProperty("ALMPassword"), properties.getProperty("sQCURL"), properties.getProperty("sDomain"), properties.getProperty("sProject"), properties.getProperty("ALMDraftRun"));
            }
            g_SummaryFlag = 0;
        }
    }

    public static void fnSummaryCloseHtml(String strRelease) throws IOException {
        Common Common = CommonManager.getInstance().getCommon();
        Date d = new Date();
        //System.out.println("start time is:::" + g_tSummaryStart_Time);
        int starttotalsecs = ((HTML.g_tSummaryStart_Time.getMinutes() + (HTML.g_tSummaryStart_Time.getHours() * 60)) * 60) + (HTML.g_tSummaryStart_Time.getSeconds());
        String gsTempFile = properties.getProperty("SummaryFileName");
        Path objPath = Paths.get(gsTempFile);
        g_tSummaryEnd_Time = d;
        int endtotalsecs = ((HTML.g_tSummaryEnd_Time.getMinutes() + (HTML.g_tSummaryEnd_Time.getHours() * 60)) * 60) + (HTML.g_tSummaryEnd_Time.getSeconds());
        int diffofsec = endtotalsecs - starttotalsecs;
        String ssn = "";
        int diffinmin = 0;
        String failssn = "";
        int rediffinmin = 0;
        if (diffofsec < 0) {
            int start = 26400 - starttotalsecs;
            starttotalsecs = start;
            diffofsec = endtotalsecs - starttotalsecs;
        }
        if (diffofsec > 60) {
            diffinmin = diffofsec / 60;
            if (diffinmin > 60) {
                long hours1 = (int) Math.floor(diffinmin / 60);
                long minutes = diffinmin % 60;
                ssn = Long.toString(hours1) + "hrs" + Long.toString(minutes) + "mins";
            } else {
                ssn = Long.toString(diffinmin) + "mins";
            }

        } else {
            ssn = Long.toString(diffofsec) + "secs";
        }
        String sTime = "";
        sTime = ssn;
        if (HTML.properties.getProperty("FailureCasesExecution").equals("YES")) {
            int ReExecutionStarttotalsecs = ((ParallelExecDriver.g_tSummaryReStart_Time.getMinutes() + (ParallelExecDriver.g_tSummaryReStart_Time.getHours() * 60)) * 60) + (ParallelExecDriver.g_tSummaryReStart_Time.getSeconds());
            int diffofResec = endtotalsecs - ReExecutionStarttotalsecs;
            if (diffofResec > 60) {
                rediffinmin = diffofResec / 60;
                long reremainsec = diffofResec % 60;
                if (rediffinmin > 60) {
                    long hours1 = (int) Math.floor(rediffinmin / 60);
                    long minutes = rediffinmin % 60;
                    failssn = Long.toString(hours1) + "hrs " + Long.toString(minutes) + "mins";
                } else {
                    failssn = Long.toString(rediffinmin) + "mins " + Long.toString(reremainsec) + "sec";
                }

            } else {
                failssn = Long.toString(diffofResec) + "sec";
            }
        }
        String failsTime = "";
        failsTime = failssn;
        if (Files.exists(objPath)) {
            FileWriter objFile = new FileWriter(gsTempFile, true);
            objFile.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
            objFile.write("<TR><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Release :</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>" + strRelease + "</B></FONT></TD></TR>");
            objFile.write("<TR COLS=5><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total Test Case Executed : " + g_SummaryTotal_TC + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total Test Cases Passed : " + g_SummaryTotal_Pass + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B> Total Test Cases Failed : " + g_SummaryTotal_Fail
                    + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total Execution Time : " + sTime + " </B></FONT></TD></TR>");
            if (HTML.properties.getProperty("FailureCasesExecution").equals("YES")) {
                objFile.write("<TR COLS=5><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total Test Case Re-Executed : " + ParallelExecDriver.nooffailcasesinfirstrun + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=15%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Re-Executed Test Cases Passed : " + g_SummaryReTotal_Pass + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B> Re-Executed Test Cases Failed : " + g_SummaryReTotal_Fail + "</B></FONT></TD><TD BGCOLOR=#66699 WIDTH=25%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Total FailCaes Re-Execution Time : " + failsTime + " </B></FONT></TD></TR>");
            }
            objFile.write("</TABLE></BODY></HTML>");
            objFile.close();
        }
        String SendMail = properties.getProperty("SendMail");
        if (SendMail.contains("YES")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Common.SendMail(properties.getProperty("MailTo"), properties.getProperty("MailCC"), gsTempFile, formatter.format(g_tSummaryEnd_Time), formatter.format(g_tSummaryStart_Time), strRelease, properties.getProperty("ModuleName"), String.valueOf(g_SummaryTotal_TC), String.valueOf(g_SummaryTotal_Pass), String.valueOf(g_SummaryTotal_Fail), properties.getProperty("Region"));
        }
    }

    public static String fnSecondsToTime(int intSeconds) {
        int hours, minutes, seconds;
        hours = intSeconds / 3600;
        intSeconds = intSeconds % 3600;
        minutes = intSeconds / 60;
        seconds = intSeconds % 60;
        return hours + ":" + minutes + ":" + seconds;

    }
}
