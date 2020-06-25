package com.gw.driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gw.utilities.FlatFile;
import com.gw.utilities.HTML;
//import com.gw.utilities.ReportUtil;
import com.gw.utilities.XlsxReader;

public class ParallelExecDriver {
	
	static Logger log = Logger.getLogger(ParallelExecDriver.class);
	private static ConcurrentLinkedQueue<String> testCaseIDorGroup = new ConcurrentLinkedQueue<String>();
	static int i;
	public static BufferedWriter writer;
	public static String timeStamp;
	public static String sFileNames;
	public static String dir = null;
	public static HSSFWorkbook my_workbook;
	public static HSSFSheet my_sheet;
	public static HSSFCreationHelper helper;
	public static String name;
	public static int failrow = 0;
	public static String sFilePath;
	public static HashMap<String, String> hm = new HashMap<String, String>();
	public static List<String> failureGroup = new ArrayList<String>();
	public static int count =0;
	public static Date g_tSummaryReStart_Time;
	public static int nooffailcasesinfirstrun =0;
	public static int NumberOfFailureCasesExecution;
	public String noOfExecutions;


	@BeforeSuite
	public void loadConfig() throws Exception {
		//PropertyConfigurator.configure("log4j.properties");
	}

	@Parameters({ "DataSheetName", "Region" })
	@Test(priority = 1, enabled = true)
	public void execution(String DataSheetName, String Region) throws Exception {
		ParallelExecutor parallelExecutor;
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		sFileNames = timeStamp;
		dir = null;
		File directory = new File(".");
		dir = directory.getCanonicalPath();
		sFilePath = dir + "\\target\\Reports\\HTMLReports\\FailureHub\\" + sFileNames + ".csv";
		my_workbook = new HSSFWorkbook();
		my_sheet = my_workbook.createSheet("Cell Hyperlink");
		helper = my_workbook.getCreationHelper();
		boolean status = false;
		FlatFile ff = FlatFile.getInstance();
		ff.CreateCSVFile();
		System.out.println("Writer in Parallel1 is :::" + writer);
		HTML.fnSummaryInitialization("Execution Summary Report");
		String sFileName = HTML.properties.getProperty("DataSheetName");
		String[] Excelbooks = sFileName.split(",");

		for (i = 0; i < Excelbooks.length; i++) {
			status = XlsxReader.getInstance(Excelbooks[i]).addTestCasesFromDataSheetName(testCaseIDorGroup);
			if (HTML.properties.getProperty("DataBaseUpdate").equalsIgnoreCase("YES")) {
				//ReportUtil.loadTestCases();
			}
			if (!status) {
				log.info("None of the testcase selected as 'YES' to execute");
				System.exit(0);
			}
			boolean isExitLoop = false;
			int nThreads = Integer.parseInt((String) HTML.properties.getProperty("THREAD_COUNT"));
			ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(nThreads);
			ExecutorService multiThreadExecutorforFailCases = Executors.newFixedThreadPool(nThreads);
			String testCaseName = null;
			noOfExecutions = HTML.properties.getProperty("NumberOfFailureCasesExecution");
			NumberOfFailureCasesExecution = Integer.parseInt(noOfExecutions);
			try {
				testCaseName = testCaseIDorGroup.remove();

			} catch (NoSuchElementException e) {
				isExitLoop = true; 
			}
			if (testCaseName == null) {
				isExitLoop = true;
			}
			while (!isExitLoop) {
				if (!multiThreadExecutor.isTerminated()) {
					parallelExecutor = new ParallelExecutor("RunModeNo",	testCaseName, Excelbooks[i], Region);
					multiThreadExecutor.submit(parallelExecutor);
					try {
						testCaseName = testCaseIDorGroup.remove();
					} catch (java.util.NoSuchElementException e) {
						multiThreadExecutor.shutdown();
						multiThreadExecutor.awaitTermination(24, TimeUnit.HOURS);
						count++;
					}
				} else if(NumberOfFailureCasesExecution>0&&(HTML.properties.getProperty("FailureCasesExecution").equals("YES"))){
					nooffailcasesinfirstrun = nooffailcasesinfirstrun+failureGroup.size();
					multiThreadExecutorforFailCases = Executors.newFixedThreadPool(nThreads);
					log.info("size of failure group is:::"+failureGroup.size());
					if(count==1){
						 Date d= new Date();
						 g_tSummaryReStart_Time = d;
					}
					NumberOfFailureCasesExecution--;
					for(int fg=0;fg<failureGroup.size();fg++){
						log.info("size of failure group is:::"+failureGroup.size());
						testCaseName = failureGroup.get(fg);
						//System.out.println("testcase name is:::"+testCaseName);
						parallelExecutor = new ParallelExecutor("RunModeNo",
								testCaseName, Excelbooks[i], Region);
						multiThreadExecutorforFailCases.submit(parallelExecutor);
					}
					multiThreadExecutorforFailCases.shutdown();
					multiThreadExecutorforFailCases.awaitTermination(24, TimeUnit.HOURS);
				}
				 else {
						isExitLoop = true;
				 }
			}
			multiThreadExecutor.shutdown();
			multiThreadExecutor.awaitTermination(24, TimeUnit.HOURS);
		}
		log.info("Executed All Test Cases");
	}

	@AfterSuite
	public void exitConfig() {
		try {
			XlsxReader.getInstance().closeConnections();
			//if (HTML.properties.getProperty("EXECUTIONAPP").equals("ODS") && FlatFile.getInstance().flatFileClose() != null) {
			//	FlatFile.getInstance().flatFileClose();
			//}
			HTML.fnSummaryCloseHtml(HTML.properties.getProperty("Release"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("Inside AfterSuite");
	}
}
