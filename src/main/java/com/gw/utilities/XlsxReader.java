package com.gw.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.gw.constants.PCConstants;
import com.gw.driver.ParallelExecDriver;


public class XlsxReader {
	private XSSFWorkbook workbook;
	static Logger logger = Logger.getLogger(XlsxReader.class);
	private static XlsxReader xlsReader = null;

	private XlsxReader() {

	}

	public static XlsxReader getInstance() {
		if (xlsReader == null) {
			xlsReader = new XlsxReader(HTML.properties.getProperty("DataSheetName"));
		}
		return xlsReader;
	}

	public static XlsxReader getInstance(String Exccelbook) {
		xlsReader = new XlsxReader(Exccelbook);

		return xlsReader;

	}

	/**
	 * Purpose- Constructor to pass Excel file name
	 * 
	 * @param sFileName
	 */
	private XlsxReader(String sFileName) {

		FileInputStream fis;
		try {
			// app = new ConfigManager("App");
			String dir = null;
			File directory = new File(".");
			dir = directory.getCanonicalPath();
			String sFilePath = dir + "\\src\\main\\resources\\data\\" + sFileName + ".xlsm";
			File file = new File(sFilePath);
			if (file.exists()) {
				fis = new FileInputStream(sFilePath);
				workbook = new XSSFWorkbook(fis);
				fis.close();

			} else {
				// UtilityMethods.infoBox("File with name-'"+sFileName+"' doesn't exists in Data
				// Folder, Please Re-check given file name",
				// "Config.properties");
				logger.error("Error Reading Excel File from Data Folder. Hence shutting down the application");

				Exception e = new Exception("File with name-'" + sFileName + "' doesn't exists in Data Folder");
				logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error Reading Excel File from Data Folder. Hence shutting down the application");

			Exception e1 = new Exception("File with name-'" + sFileName + "' doesn't exists in Data Folder");

			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e1.getMessage(), e1);
			// UtilityMethods.infoBox(e.getMessage(), "Exception");
			System.exit(0);
		}
	}

	public synchronized void setCellData1(String sheetName, String Result, int RowNum, int ColNum) throws Exception {
		XSSFSheet Sheet;
		XSSFRow row;
		int iIndex = workbook.getSheetIndex(sheetName);
		if (iIndex == -1) {
			logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Sheet name-'" + sheetName + " , please Re-check sheet and column names");

			Exception e = new Exception("Sheet with name-'" + sheetName + "' doesn't exists in Data Folder");// .printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
			// UtilityMethods.infoBox("Sheet with name-'"+sheetName+"' doesn't exists in
			// this excel file, please Re-check given sheet name","Missing sheet");
			// System.exit(0);
		} else {
			Sheet = workbook.getSheetAt(iIndex);
			row = Sheet.getRow(RowNum);
			Cell cell2 = row.createCell(ColNum);
			cell2.setCellValue(Result);
			String dir = null;
			FileOutputStream webdataFileOutStream = null;
			File directory = new File(".");
			dir = directory.getCanonicalPath();
			String sFilePath = dir + "\\Data\\" + HTML.properties.getProperty("DataSheetName") + ".xlsm";
			// String sFilePath =
			// "D:\\FrameWorks\\SeleniumJava\\WorkSpace\\GuidewirePC\\Data\\Data.xlsx";
			File file = new File(sFilePath);
			if (file.exists()) {
				webdataFileOutStream = new FileOutputStream(sFilePath);
			}
			workbook.write(webdataFileOutStream);
			webdataFileOutStream.close();
		}
	}

	public synchronized void setCellData(String sheetName, String Result, int RowNum, int ColNum) throws Exception {
		XSSFSheet Sheet;
		XSSFRow row;
		int iIndex = workbook.getSheetIndex(sheetName);
		if (iIndex == -1) {
			logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Sheet name-'" + sheetName + " , please Re-check sheet and column names");

			Exception e = new Exception("Sheet with name-'" + sheetName + "' doesn't exists in Data Folder");// .printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
			// UtilityMethods.infoBox("Sheet with name-'"+sheetName+"' doesn't exists in
			// this excel file, please Re-check given sheet name","Missing sheet");
			// System.exit(0);
		} else {
			Sheet = workbook.getSheetAt(iIndex);
			row = Sheet.getRow(RowNum);
			if (row == null) {
				row = Sheet.createRow(RowNum);
			}
			Cell cell2 = row.createCell(ColNum);
			// Cell cell2 = Sheet.getRow(RowNum).getCell(ColNum);
			cell2.setCellValue(Result);
			String dir = null;
			FileOutputStream webdataFileOutStream = null;
			File directory = new File(".");
			dir = directory.getCanonicalPath();
			String sFilePath = dir + "\\Data\\" + HTML.properties.getProperty("DataSheetName") + ".xlsm";
			// String sFilePath =
			// "D:\\FrameWorks\\SeleniumJava\\WorkSpace\\GuidewirePC\\Data\\Data.xlsx";
			File file = new File(sFilePath);
			if (file.exists()) {
				webdataFileOutStream = new FileOutputStream(sFilePath);
			}
			workbook.write(webdataFileOutStream);
			logger.info("Updating the '" + Result + "' Value in the  " + sheetName + " Sheet");
			webdataFileOutStream.close();
		}
	}

	/**
	 * Purpose- To check if the sheet with given name exists or not
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @return - if sheet with specified name exists it returns true else it returns
	 *         false
	 * @throws Exception
	 */
	public boolean isSheetExist(String sheetName) throws Exception {
		int iIndex;
		iIndex = workbook.getSheetIndex(sheetName);
		if (iIndex == -1) {
			logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Sheet name-'" + sheetName + " , please Re-check sheet and column names");
			// UtilityMethods.infoBox("Sheet with name-'"+sheetName+"' doesn't exists in
			// this excel file, please Re-check given sheet name","Missing sheet");
			Exception e = new Exception("Sheet with name-'" + sheetName + " , please Re-check given sheet name and column name");// .printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
			// System.exit(0);
			return false;
		} else
			return true;
	}

	/**
	 * Purpose- To check if the sheet with given name exists or not , but not exits
	 * from program
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @return - if sheet with specified name exists it returns true else it returns
	 *         false
	 * @throws Exception
	 */
	public boolean isSheetExistButRuns(String sheetName) throws Exception {
		int iIndex;
		iIndex = workbook.getSheetIndex(sheetName);
		if (iIndex == -1) {
			// UtilityMethods.infoBox("Sheet with name-'"+sheetName+"' doesn't exists in
			// this excel file, please Re-check given sheet name","Missing sheet");
			// System.exit(0);
			logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Sheet name-'" + sheetName + " , please Re-check sheet and column names");
			Exception e = new Exception("Sheet with name-'" + sheetName + " , does not exist");
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
			return false;
		} else
			return true;
	}

	/**
	 * Purpose- To get the number of sheets in a workbook
	 * 
	 * @return- Returns value of number of sheets
	 * @throws Exception
	 */
	public int getNumberOfSheets() throws Exception {
		return workbook.getNumberOfSheets();
	}

	public String getSheetNameOfIndex(int sheetIndex) throws Exception {
		return workbook.getSheetName(sheetIndex);
	}

	/**
	 * Purpose- To get the row count of specified sheet
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @return- Returns value of row count
	 * @throws Exception
	 */
	public int getRowCount(String sheetName) throws Exception {
		int number = 0;
		XSSFSheet Sheet;
		if (isSheetExist(sheetName)) {
			Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);
			number = Sheet.getLastRowNum() + 1;
		}
		return number;

	}

	/**
	 * Purpose- To get column count of specified sheet
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @return- Returns value of column count
	 * @throws Exception
	 */
	public int getColumnCount(String sheetName) throws Exception {
		XSSFSheet Sheet;
		XSSFRow row;
		if (isSheetExist(sheetName)) {
			Sheet = workbook.getSheet(sheetName);
			row = Sheet.getRow(0);

			if (row == null)
				return -1;

			return row.getLastCellNum();
		}
		return 0;
	}

	public int getRowCountUntilEmptyCell(String sheetName, int rowPadding, int columnPadding) throws Exception {
		int number = 0;
		XSSFRow row;
		XSSFSheet Sheet;
		if (isSheetExist(sheetName)) {
			Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);

			//System.out.println("yes" + Sheet.getLastRowNum());

			for (int i = rowPadding; i <= Sheet.getLastRowNum(); i++) {
				row = Sheet.getRow(i);
				if (row.getCell(columnPadding).getStringCellValue().trim().isEmpty())

					break;
				//System.out.println(row.getCell(columnPadding).getStringCellValue());
				number++;
			}

		}
		//System.out.println(number);
		return number + rowPadding;

	}

	/**
	 * Purpose- To get the column count of specified sheet and the column count ends
	 * if it has not found any value
	 * 
	 * @param sheetName
	 *            - Sheet name,row padding,column padding should be provided
	 * @return- Returns value of column count
	 * @throws Exception
	 */
	public int getColumnCountUntilEmptyCell(String sheetName, int rowPadding, int columnPadding) throws Exception {
		int number = 0;
		XSSFSheet Sheet;
		XSSFRow row;
		if (isSheetExist(sheetName)) {
			Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);

			row = Sheet.getRow(rowPadding);

			for (int i = columnPadding; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().isEmpty())

					break;
				number++;
			}

		}
		return number;

	}

	public String getCellData(String sheetName, String colName, int rowNum, int rowPadding, int columnPadding) {
		try {
			XSSFSheet Sheet;
			XSSFRow row;
			XSSFCell cell;
			if (isSheetExist(sheetName)) {
				if (rowNum <= 0) {

					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with rownum = " + rowNum + " Sheet Name= " + sheetName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Row number should be greater than 0",
					// "");
					// System.exit(0);
					return "";
				}
				int col_Num = -1;
				Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);

				row = Sheet.getRow(rowPadding);

				for (int i = columnPadding; i < row.getLastCellNum(); i++) {
					if (row.getCell(i).getStringCellValue().trim().contains(colName.trim())) {
						col_Num = i;

						break;
					}

				}

				if (col_Num == -1) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with col_Num = " + col_Num + " Sheet Name= " + sheetName + " Column Name =" + colName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Column with specified name"+colName+" is not being
					// displayed",
					// "Config.properties");
					// System.exit(0);
					return "";
				}

				row = Sheet.getRow(rowNum - 1);
				if (row == null)
					return "";
				cell = row.getCell(col_Num);

				if (cell == null)
					return "";
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
					return cell.getStringCellValue();
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

					String cellText = NumberToTextConverter.toText(cell.getNumericCellValue());

					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of D/M/YY
						double d = cell.getNumericCellValue();
						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DAY_OF_MONTH);
						int Month = cal.get(Calendar.MONTH) + 1;
						cellText = Day + "/" + Month + "/" + (String.valueOf(Year)).substring(2);
					}
					return cellText;
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());
			}
			return "";
		} catch (Exception e) {
			System.out.println("Exceptione is =" + e.getMessage());
			// UtilityMethods.infoBox("row "+rowNum+" or column "+colName
			// +" does not exist in xls", "Config.properties");
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/**
	 * Purpose- Returns the value from Excel based on Sheetname, column name, row
	 * value
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @param colName
	 *            - Column Name should be provided
	 * @param rowNum
	 *            - Row value should be provided
	 * @return
	 */
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			XSSFSheet Sheet;
			XSSFRow row;
			XSSFCell cell;
			if (isSheetExist(sheetName)) {
				if (rowNum <= 0) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with rowNum = " + rowNum + " Sheet Name= " + sheetName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Row number should be greater than 0",
					// "");
					// System.exit(0);
					return "";
				}
				int col_Num = -1;
				Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);

				row = Sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
						col_Num = i;
				}
				if (col_Num == -1) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with col_Num = " + col_Num + " Sheet Name= " + sheetName + " Column Name=" + colName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Column with specified name"+colName+" is not being
					// displayed",
					// "Config.properties");
					// System.exit(0);
					return "";
				}

				row = Sheet.getRow(rowNum - 1);
				if (row == null)
					return "";
				cell = row.getCell(col_Num);

				if (cell == null)
					return "";
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
					return cell.getStringCellValue();
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					// String cellText =
					// String.valueOf(cell.getNumericCellValue());
					String cellText = NumberToTextConverter.toText(cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of D/M/YY
						double d = cell.getNumericCellValue();
						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DAY_OF_MONTH);
						int Month = cal.get(Calendar.MONTH) + 1;
						cellText = Day + "/" + Month + "/" + (String.valueOf(Year)).substring(2);
					}
					return cellText;
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());
			}
			return "";
		} catch (Exception e) {
			System.out.println("Exceptione is =" + e.getMessage());
			// UtilityMethods.infoBox("row "+rowNum+" or column "+colName
			// +" does not exist in xls", "Config.properties");
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/**
	 * Purpose- Returns the value from Excel based on Sheetname, column number, row
	 * number
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @param colNum
	 *            - Column number should be provided
	 * @param rowNum
	 *            - Row number should be provided
	 * @return
	 */
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			XSSFSheet Sheet;
			XSSFRow row;
			XSSFCell cell;
			if (isSheetExist(sheetName)) {
				if (rowNum <= 0) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with rowNum = " + rowNum + " Sheet Name= " + sheetName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Row number should be greater than 0",
					// "");
					// System.exit(0);
					return "";
				}

				Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);
				row = Sheet.getRow(rowNum - 1);
				if (row == null)
					return "";
				cell = row.getCell(colNum);

				if (cell == null)
					return "";
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
					return cell.getStringCellValue();
				// else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC ||
				// cell.getCellType()==Cell.CELL_TYPE_FORMULA )
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					// String cellText =
					// String.valueOf(cell.getNumericCellValue());
					String cellText = NumberToTextConverter.toText(cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of D/M/YY
						double d = cell.getNumericCellValue();
						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DAY_OF_MONTH);
						int Month = cal.get(Calendar.MONTH) + 1;
						cellText = Day + "/" + Month + "/" + (String.valueOf(Year)).substring(2);
					}
					return cellText;
				} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA)
					return cell.getStringCellValue();
				else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());
			}
			return "";
		} catch (Exception e) {
			System.out.println("Exceptione is =" + e.getMessage());
			// UtilityMethods.infoBox("row "+rowNum+" or column "+colNum
			// +" does not exist in xls", "Config.properties");
			return "row " + rowNum + " or column " + colNum + " does not exist in xls";
		}
	}

	/**
	 * Purpose- Returns the value from Excel based on Sheetname, column name, row
	 * value
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @param colName
	 *            - Column Name should be provided
	 * @param rowNum
	 *            - Row value should be provided
	 * @return
	 */
	public String getCellDataValue(String sheetName, String colName, int rowNum, int columnNum) {
		try {
			XSSFSheet Sheet;
			XSSFRow row;
			XSSFCell cell;
			if (isSheetExist(sheetName)) {
				if (rowNum <= 0) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with rowNum = " + rowNum + " Sheet Name= " + sheetName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Row number should be greater than 0",
					// "");
					// System.exit(0);
					return "";
				}
				int col_Num = -1;
				Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);

				row = Sheet.getRow(0);
				for (int i = columnNum; i < row.getLastCellNum(); i++) {
					if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
						col_Num = i;
						break;
					}
				}
				if (col_Num == -1) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with col_Num = " + col_Num + " Sheet Name= " + sheetName + " Column Name =" + colName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Column with specified name"+colName+" is not being
					// displayed",
					// "Config.properties");
					// System.exit(0);
					return "";
				}

				row = Sheet.getRow(rowNum - 1);
				if (row == null)
					return "";
				cell = row.getCell(col_Num);

				if (cell == null)
					return "";
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
					return cell.getStringCellValue();
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					// String cellText =
					// String.valueOf(cell.getNumericCellValue());
					String cellText = NumberToTextConverter.toText(cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of D/M/YY
						double d = cell.getNumericCellValue();
						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						int Year = cal.get(Calendar.YEAR);
						int Day = cal.get(Calendar.DAY_OF_MONTH);
						int Month = cal.get(Calendar.MONTH) + 1;
						cellText = Day + "/" + Month + "/" + (String.valueOf(Year)).substring(2);
					}
					return cellText;
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());
			}
			return "";
		} catch (Exception e) {
			System.out.println("Exceptione is =" + e.getMessage());
			// UtilityMethods.infoBox("row "+rowNum+" or column "+colName
			// +" does not exist in xls", "Config.properties");
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/**
	 * @function This method is used to retrieve all test cases from TestCase sheet
	 *           name where execution is set as YES
	 * @param testCases
	 * @return true/false
	 * @throws Exception
	 */
	public boolean addTestCasesFromDataSheetName(ConcurrentLinkedQueue<String> testCases) throws Exception {
		boolean status = false;
		boolean isExecuteByGroup = false;
		if ("YES".equalsIgnoreCase((String) HTML.properties.get("EXECUTE_BY_TEST_CASE_GROUP"))) {
			isExecuteByGroup = true;
		}
		String strColumnName = PCConstants.Execution;
		String strCondition = PCConstants.YES;
		XlsxReader sXL = XlsxReader.getInstance(); // new
													// XlsxReader(DataSheetName);
		String sheetname = PCConstants.SHEET_TESTCASE;
		String testCaseID = null;
		int rowcount = sXL.getRowCount(sheetname);
		for (int i = 2; i <= rowcount; i++) {
			if (sXL.getCellData(sheetname, strColumnName, i).equalsIgnoreCase(strCondition)) {
				if (isExecuteByGroup) {
					testCaseID = sXL.getCellData(sheetname, PCConstants.TestCaseGroup, i);
				} else {
					testCaseID = sXL.getCellData(sheetname, PCConstants.ID, i);
				}
				if (testCaseID != null && testCaseID.length() > 0 && !testCases.contains(testCaseID)) {
					testCases.add(testCaseID);
					logger.info("Adding TestCaseID  " + testCaseID);
				}
				status = true;
			}
		}
		return status;
	}

	/**
	 * @functionThis method is used to update data into excel sheet. All the values
	 *               in updateColumnNameValues parameter will be updated into excel
	 *               sheet. Not all rows will be updated, only the rows matching the
	 *               whereConstraint parameter will be updated.
	 * @param sheetName
	 * @param updateColumnNameValues
	 * @param whereConstraint
	 */
	public synchronized boolean executeUpdateQuery(String sheetName, HashMap<String, Object> updateColumnNameValues, HashMap<String, Object> whereConstraint) {
		logger.info("Entering UpdateQuery = " + sheetName + " Thread ID =" + Thread.currentThread().getId());
		boolean status = false;
		try {
			XlsxReader sXL = XlsxReader.getInstance();
			Set<String> updtColumnNames = updateColumnNameValues.keySet();// We will get column name as acountnumber
			Set<String> whereColumnNames = whereConstraint.keySet(); // we will get ID as key
			// Here one more map with testcaseid and acountnumbers
			XSSFSheet sheet;
			XSSFRow row;
			int iIndex = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (iIndex == -1) {
				logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
				Exception e = new Exception("Problem with Sheet Name = " + sheetName);
				logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
				// UtilityMethods.infoBox("Sheet with name-'"+sheetName+"' doesn't exists in
				// this excel file, please Re-check given sheet name","Missing sheet");
				// System.exit(0);
			}
			sheet = workbook.getSheetAt(iIndex);
			int rowcount = sXL.getRowCount(sheetName);
			int colcount = sXL.getColumnCount(sheetName);
			for (int i = 2; i <= rowcount; i++) {
				boolean updateRowValues = false;
				boolean exitColumnLoop = false;
				for (int j = 0; j <= colcount; j++) {
					String currentColName = sXL.getCellData(sheetName, j, 1);
					if (exitColumnLoop) {
						break;
					}
					if (!currentColName.isEmpty()) {
						for (String columnName : whereColumnNames) {

							if (columnName.equalsIgnoreCase(currentColName)) {
								// (String)whereColumnNames.get(columnName) =
								if (((String) whereConstraint.get(columnName)).equalsIgnoreCase((String) sXL.getCellData(sheetName, columnName, i))) {
									updateRowValues = true;
								} else {
									updateRowValues = false;
									exitColumnLoop = true;
									break;
								}
							}
						}
					}
				}
				if (updateRowValues) {
					for (String columnName : updtColumnNames) {
						row = sheet.getRow(i - 1);
						colNum = sXL.getCellIndex(sheetName, columnName, i);
						logger.info("inside update excel section = " + sheetName + " Row ID =" + i + " columnName =" + columnName + " colNum =" + colNum + " update value =" + (String) updateColumnNameValues.get(columnName));
						Cell cell2 = row.createCell(colNum);
						cell2.setCellValue((String) updateColumnNameValues.get(columnName));
						XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
						logger.info("inside update excel section = " + sheetName + " Row ID =" + i + " columnName =" + columnName + " colNum =" + colNum + "Status = success");
						logger.info("1 Row Updated");
					}
				}
			}
			status = true;
			String dir = null;
			FileOutputStream webdataFileOutStream = null;
			File directory = new File(".");
			dir = directory.getCanonicalPath();
			String sFilePath = dir + "\\Data\\" + HTML.properties.getProperty("DataSheetName") + ".xlsm";
			// String sFilePath = dir + "\\Data\\" +
			// PCThreadCache.getInstance().getProperty("DataSheetName") +
			// ".xlsm";
			// String sFilePath =
			// "D:\\FrameWorks\\SeleniumJava\\WorkSpace\\GuidewirePC\\Data\\Data.xlsx";
			File file = new File(sFilePath);
			if (file.exists()) {
				webdataFileOutStream = new FileOutputStream(sFilePath,true);
			}
			workbook.write(webdataFileOutStream);
			webdataFileOutStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
		}
		return status;
	}

	public synchronized boolean executeUpdateQuery(String sheetName, HashMap<String, Object> updateColumnNameValues, HashMap<String, Object> whereConstraint, String datasheet) {
		logger.info("Entering UpdateQuery = " + sheetName + " Thread ID =" + Thread.currentThread().getId());
		boolean status = false;
		try {
			XlsxReader sXL = XlsxReader.getInstance();
			System.out.println("sXL is:::: executeUpdateQuery" + sXL);
			Set<String> updtColumnNames = updateColumnNameValues.keySet();
			Set<String> whereColumnNames = whereConstraint.keySet();
			XSSFSheet sheet;
			XSSFRow row;
			int iIndex = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (iIndex == -1) {
				logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
				Exception e = new Exception("Problem with Sheet Name = " + sheetName);
				logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
				// UtilityMethods.infoBox("Sheet with name-'"+sheetName+"' doesn't exists in
				// this excel file, please Re-check given sheet name","Missing sheet");
				// System.exit(0);
			}
			sheet = workbook.getSheetAt(iIndex);
			int rowcount = sXL.getRowCount(sheetName);
			int colcount = sXL.getColumnCount(sheetName);
			for (int i = 2; i <= rowcount; i++) {
				boolean updateRowValues = false;
				boolean exitColumnLoop = false;
				for (int j = 0; j <= colcount; j++) {
					String currentColName = sXL.getCellData(sheetName, j, 1);
					if (exitColumnLoop) {
						break;
					}
					if (!currentColName.isEmpty()) {
						for (String columnName : whereColumnNames) {

							if (columnName.equalsIgnoreCase(currentColName)) {
								// (String)whereColumnNames.get(columnName) =
								if (((String) whereConstraint.get(columnName)).equalsIgnoreCase((String) sXL.getCellData(sheetName, columnName, i))) {
									updateRowValues = true;
								} else {
									updateRowValues = false;
									exitColumnLoop = true;
									break;
								}
							}
						}
					}
				}
				if (updateRowValues) {
					for (String columnName : updtColumnNames) {
						row = sheet.getRow(i - 1);
						colNum = sXL.getCellIndex(sheetName, columnName, i);
						logger.info("inside update excel section = " + sheetName + " Row ID =" + i + " columnName =" + columnName + " colNum =" + colNum + " update value =" + (String) updateColumnNameValues.get(columnName));
						Cell cell2 = row.createCell(colNum);
						cell2.setCellValue((String) updateColumnNameValues.get(columnName));
						XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
						logger.info("inside update excel section = " + sheetName + " Row ID =" + i + " columnName =" + columnName + " colNum =" + colNum + "Status = success");
						logger.info("1 Row Updated");
					}
				}
			}
			status = true;
			String dir = null;
			FileOutputStream webdataFileOutStream = null;
			File directory = new File(".");
			dir = directory.getCanonicalPath();
			logger.info("dir is:::" + dir);
			String sFilePath = dir + "\\Data\\" + datasheet + ".xlsm";
			logger.info("sFilePath is:::" + sFilePath);
			// String sFilePath = dir + "\\Data\\" +
			// PCThreadCache.getInstance().getProperty("DataSheetName") +
			// ".xlsm";
			// String sFilePath =
			// "D:\\FrameWorks\\SeleniumJava\\WorkSpace\\GuidewirePC\\Data\\Data.xlsx";
			File file = new File(sFilePath);
			logger.info("file is:::" + file);
			if (file.exists()) {
				webdataFileOutStream = new FileOutputStream(sFilePath,true);
			}

			workbook.write(webdataFileOutStream);
			webdataFileOutStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
		}
		return status;
	}

	/**
	 * Purpose- This method is used to select set of rows and all columns from excel
	 * sheet based on the whereConstraint
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @param whereConstraint
	 *            - it will contain columnName and Values. If a row matches all the
	 *            values present in this parameter then that row will be added to
	 *            the resultData.
	 * @return
	 */
	public ArrayList<HashMap<String, Object>> executeSelectQuery(String sheetName, HashMap<String, Object> whereConstraint) {
		ArrayList<HashMap<String, Object>> resultData = new ArrayList<HashMap<String, Object>>();
		try {

			XlsxReader sXL = XlsxReader.getInstance();
			// Set<String> updtColumnNames = updateColumnNameValues.keySet();
			Set<String> whereColumnNames = whereConstraint.keySet();
			XSSFSheet sheet;
			XSSFRow row;
			int iIndex = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (iIndex == -1) {
				logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
				Exception e = new Exception("Problem with Sheet Name = " + sheetName);
				logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
				// UtilityMethods.infoBox("Sheet with name-'"+sheetName+"' doesn't exists in
				// this excel file, please Re-check given sheet name","Missing sheet");
				// System.exit(0);
			}
			sheet = workbook.getSheetAt(iIndex);
			int rowcount = sXL.getRowCount(sheetName);
			int colcount = sXL.getColumnCount(sheetName);
			for (int i = 2; i <= rowcount; i++) {
				HashMap<String, Object> resultHashMap = new HashMap<String, Object>();
				boolean selectRowValues = false;
				boolean exitColumnLoop = false;
				for (int j = 0; j <= colcount; j++) {
					if (exitColumnLoop) {
						break;
					}
					String currentColName = sXL.getCellData(sheetName, j, 1);
					if (!currentColName.isEmpty()) {
						for (String columnName : whereColumnNames) {

							if (columnName.equalsIgnoreCase(currentColName)) {
								// (String)whereColumnNames.get(columnName) =
								if (((String) whereConstraint.get(columnName)).equalsIgnoreCase(sXL.getCellData(sheetName, columnName, i))) {
									selectRowValues = true;
								} else {
									selectRowValues = false;
									exitColumnLoop = true;
									break;
								}
							}
						}
					}
				}

				if (selectRowValues) {
					for (int j = 0; j <= colcount; j++) {
						String currentColName = sXL.getCellData(sheetName, j, 1);
						resultHashMap.put(currentColName, sXL.getCellData(sheetName, j, i));
					}
					resultData.add(resultHashMap);
				}
			}
			return resultData;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
		}

		return resultData;
	}

	/**
	 * Purpose- Returns the column index from Excel based on Sheetname, column name,
	 * row value
	 * 
	 * @param sheetName
	 *            - Sheet name should be provided
	 * @param colName
	 *            - Column Name should be provided
	 * @param rowNum
	 *            - Row value should be provided
	 * @return
	 */
	public int getCellIndex(String sheetName, String colName, int rowNum) {
		int col_Num = -1;
		try {
			XSSFSheet Sheet;
			XSSFRow row;
			// XSSFCell cell;
			if (isSheetExist(sheetName)) {
				if (rowNum <= 0) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with RowNum = " + rowNum + " Sheet Name= " + sheetName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Row number should be greater than 0",
					// "");
					// System.exit(0);
					return -1;
				}

				Sheet = workbook.getSheet(sheetName);// workbook.getSheetAt(iIndex);

				row = Sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
						col_Num = i;
				}
				if (col_Num == -1) {
					logger.error("Issue in TestCase ID# " + PCThreadCache.getInstance().getProperty("TCID") + " Please check below exception log for more details.");
					Exception e = new Exception("Problem with col_Num = " + col_Num + " Column Name=" + colName + " Sheet Name= " + sheetName);
					logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
					// UtilityMethods.infoBox("Column with specified name"+colName+" is not being
					// displayed",
					// "Config.properties");
					// System.exit(0);
					return col_Num;
				}

				row = Sheet.getRow(rowNum - 1);
				if (row == null)
					return col_Num;
				// cell = row.getCell(col_Num);

				return col_Num;
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
		}
		return col_Num;
	}

	public void closeConnections() {
		try {
			workbook.close();
			// webdataFileOutStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
		}
	}

	/*
	 * public void failuresReader(String sExpected, String sAcutal, String
	 * sElementName, String sElementProperty, String sException) throws Exception {
	 * String sheetName = "FailureHub"; XlsxReader sXL = XlsxReader.getInstance();
	 * int rowcount = sXL.getRowCount(sheetName); sXL.setCellData(sheetName,
	 * PCThreadCache.getInstance().getProperty("TCID"), rowcount, 0);
	 * sXL.setCellData(sheetName,
	 * PCThreadCache.getInstance().getProperty("testcasename"), rowcount, 1);
	 * sXL.setCellData(sheetName,
	 * PCThreadCache.getInstance().getProperty("methodName"), rowcount, 2);
	 * sXL.setCellData(sheetName, sExpected, rowcount, 4);
	 * sXL.setCellData(sheetName, sAcutal, rowcount, 5); sXL.setCellData(sheetName,
	 * sElementName, rowcount, 6); sXL.setCellData(sheetName, sElementProperty,
	 * rowcount, 7); sXL.setCellData(sheetName, sException, rowcount, 8);
	 * 
	 * }
	 */
	/*public void failuresReader(String sExpected, String sAcutal, String sElementName, String sElementProperty, String sException, BufferedWriter writer) throws Exception {
		System.out.println("It is in failuresReader function ");
		System.out.println("BufferedWriter is:::" + writer);
		String ID = PCThreadCache.getInstance().getProperty("TCID");
		String TestCaseID = PCThreadCache.getInstance().getProperty("TestCaseID");
		String newTestcaseID = TestCaseID;
		if (TestCaseID.contains(",")) {
			newTestcaseID = TestCaseID.replace(",", "||");
		}
		String name = PCThreadCache.getInstance().getProperty("testcasename");
		String methodName = PCThreadCache.getInstance().getProperty("methodName");
		System.out.println("Id is :::" + ID);
		System.out.println("Writer is :::" + writer);
		writer.write(ID);
		writer.write(",");
		writer.write(newTestcaseID);
		writer.write(",");
		// write new line
		writer.write(name);
		writer.write(",");
		writer.write(methodName);
		writer.write(",");
		writer.write(sExpected);
		writer.write(",");
		writer.write(sAcutal);
		writer.write(",");
		writer.write(sElementName);
		writer.write(",");
		writer.write(sElementProperty);
		writer.write("\r\n");
		writer.flush();
		System.out.println("File saved::::");

	}*/
	
public void failuresReader (String sExpected, String sAcutal,  String htmllink, String screenpath, String logfileloc, String value, String tccount) throws Exception {
		
		ParallelExecDriver.failrow = ParallelExecDriver.failrow+1;
		System.out.println("entere in failurereader for new one");
		HSSFWorkbook my_workbook = ParallelExecDriver.my_workbook;
        HSSFSheet my_sheet =ParallelExecDriver.my_sheet;
        HSSFCreationHelper helper= ParallelExecDriver.helper;
        String ID = PCThreadCache.getInstance().getProperty("TCID");
		String TestCaseID = PCThreadCache.getInstance().getProperty("TestCaseID");
		String newTestcaseID = TestCaseID;
		if (TestCaseID.contains(",")) {
			newTestcaseID = TestCaseID.replace(",", "||");
		}
		HSSFCellStyle my_style = my_workbook.createCellStyle();
	       
        my_style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        my_style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        my_style.setWrapText(true);
        
        Row row = my_sheet.createRow(ParallelExecDriver.failrow); 
        
        Cell cell1 = row.createCell(0);
        cell1.setCellStyle(my_style);
        cell1.setCellValue(ID); 
        
        Cell cell2 = row.createCell(1);
        cell2.setCellStyle(my_style);
        cell2.setCellValue(newTestcaseID);
        String name = PCThreadCache.getInstance().getProperty("testcasename");
        Cell cell3 = row.createCell(2);
        cell3.setCellStyle(my_style);
        cell3.setCellValue(name);
        
        Cell tccounts = row.createCell(3);
        tccounts.setCellStyle(my_style);
        tccounts.setCellValue(tccount);
        String methodName = PCThreadCache.getInstance().getProperty("methodName");
        Cell cell4 = row.createCell(4);
        cell4.setCellStyle(my_style);
        cell4.setCellValue(methodName);
       /* Cell cell5 = row.createCell(4);
        cell5.setCellStyle(my_style);
        cell5.setCellValue(sExpected);*/
        Cell cell6 = row.createCell(5);
        cell6.setCellStyle(my_style);
        cell6.setCellValue(sAcutal);
        HSSFHyperlink url_link=helper.createHyperlink(Hyperlink.LINK_URL);
        String Path =HTML.properties.getProperty("ResultsFolderPath")+"\\"+htmllink;
        System.out.println("Path  is :::"+Path);
        url_link.setAddress(Path);
        Cell cell7 = row.createCell(6);
        cell7.setCellStyle(my_style);
        cell7.setCellValue(value);
        /*HSSFHyperlink url_link=helper.createHyperlink(Hyperlink.LINK_URL);
        String Path =HTML.properties.getProperty("ResultsFolderPath")+"\\"+htmllink;*/
        /*System.out.println("Path  is :::"+Path);
        url_link.setAddress(Path);*/
        Cell cell8 = row.createCell(7);
        
        cell8.setCellStyle(my_style);
       // File f = new File
        cell8.setCellValue("Click here for html report");
        cell8.setHyperlink(url_link);
        HSSFHyperlink screenshotlinkpath=helper.createHyperlink(Hyperlink.LINK_URL);
        String screenlinkpath =screenpath;
        
        System.out.println("screenlinkpath  is :::"+screenlinkpath);
        screenshotlinkpath.setAddress(screenlinkpath);
        Cell cell9 = row.createCell(8);
        cell9.setCellStyle(my_style);
        cell9.setCellValue("Click here for Screnshot");
        cell9.setHyperlink(screenshotlinkpath);
        
        HSSFHyperlink Logfilepath=helper.createHyperlink(Hyperlink.LINK_URL);
        String logfile =logfileloc;
        System.out.println("log file inn xlsreader is:::"+logfile);
        System.out.println("screenlinkpath  is :::"+screenlinkpath);
        Logfilepath.setAddress(logfile);
        Cell cell10 = row.createCell(9);
        cell10.setCellValue("Click here for Log");
        cell10.setHyperlink(Logfilepath);
        /*Cell cell8 = row.createCell(7);
        cell7.setCellValue("Screenshot Link");*/
        FileOutputStream out = new FileOutputStream(new File(ParallelExecDriver.sFilePath));
        my_workbook.write(out);
        out.flush();
        System.out.println("Csv file inserted successfully");
		
		

	}
	
}
