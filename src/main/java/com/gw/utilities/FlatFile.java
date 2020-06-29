package com.gw.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.gw.constants.PCConstants;
import com.gw.driver.ParallelExecDriver;


public class FlatFile {

    static Logger logger = Logger.getLogger(FlatFile.class);
    private static FlatFile flatFile = null;
    private static BufferedReader read;
    private static BufferedWriter write;
    private static FileWriter fw;
    private static FileReader fr;
    private static final String FILE_HEADER = "ID,Component_Name,Key_Name,Key_Value,Value_type";
    private static final String COMMA_DELIMITER = ",";
    private static final String Pipe_DELIMITER = "---";
    private static final String newLine = System.getProperty("line.separator");

    private FlatFile() {

    }

    public static FlatFile getInstance(String sReadorWrite, String sFileName) {
        // if (flatFile == null){
        flatFile = new FlatFile(sReadorWrite, sFileName);
        // }
        return flatFile;
    }

    public static FlatFile getInstance() {
        flatFile = new FlatFile();
        return flatFile;
    }

    public static FlatFile getInstanceCSV(String sReadorWrite, String sFileName, String sFileFormt) {
//		if (flatFile == null){
        flatFile = new FlatFile(sReadorWrite, sFileName, sFileFormt);
//		}
        return flatFile;
    }

    /**
     * Purpose- Constructor to pass Excel file name
     *
     * @param sFileName
     */
    private FlatFile(String sReadorWrite, String sFileName) {

        try {
            // app = new ConfigManager("App");
            String dir = null;
            File directory = new File(".");
            dir = directory.getCanonicalPath();
            String sFilePath = dir + "\\Data\\FlatFiles\\" + sFileName + ".txt";
            // String sFilePath =
            // "D:\\FrameWorks\\SeleniumJava\\WorkSpace\\GuidewirePC\\Data\\Data.xlsx";
            File file = new File(sFilePath);
            if (file.exists()) {
                if (sReadorWrite.toUpperCase().contains("WRITE")) {
                    // fw = new FileWriter(file);
                    fw = new FileWriter(file, true);
                    write = new BufferedWriter(fw);
                } else {
                    fr = new FileReader(file);
                    read = new BufferedReader(fr);
                }
            } else {
                // UtilityMethods.infoBox("File with name-'"+sFileName+"' doesn't exists in Data
                // Folder, Please Re-check given file name", "Config.properties");
                logger.error("Error Reading Flat File from FlatFiles Folder. Hence shutting down the application");

                Exception e = new Exception("File with name-'" + sFileName + "' doesn't exists in FlatFiles Folder");
                logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
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

    public Boolean CreateFile() {
        Boolean status = false;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String sFileName = "" + ThreadCache.getInstance().getProperty("TCID") + "_" + timeStamp + "";
        ThreadCache.getInstance().setProperty("FlatFileName", sFileName);
        ThreadCache.getInstance().setProperty(PCConstants.FlatFile, sFileName);
        FileWriter fw = null;
        BufferedWriter fileWriter = null;
        String dir = null;
        try {
            File directory = new File(".");
            dir = directory.getCanonicalPath();
            String sFilePath = dir + "\\Data\\FlatFiles\\" + sFileName + ".txt";
            File file = new File(sFilePath);
            file.createNewFile();
            fw = new FileWriter(file);
            fileWriter = new BufferedWriter(fw);
            /*
             * bw.write("ID"); bw.write(","); bw.write("COMPONENTS"); bw.write(",");
             * bw.write("KEYNAME"); bw.write(","); bw.write("KEYVALUE"); bw.flush();
             * bw.close();
             */
            fileWriter.append(FILE_HEADER.toString());
            System.out.println("CSV file was created successfully !!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                fw = null;
                fileWriter = null;
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        return status;
    }

    public String Read(String readValue, String sFileName) {
        FlatFile.getInstance("Read", sFileName);
        Boolean status = false;
        String strLine = "";
        String FlatFileValue = null;
        String targetValue = null;
        try {
            while ((strLine = read.readLine()) != null) {
                String[] Values = strLine.split(",");
                for (int i = 2; i < Values.length; i++) {
                    FlatFileValue = Values[i];
                    // System.out.println(FlatFileValue);
                    if (FlatFileValue.toUpperCase().equals(readValue.toUpperCase())) {
                        targetValue = Values[i + 1];
                        status = true;
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
            }
            if (!status) {
                logger.info("" + readValue + " is not avilable in the " + sFileName + " file");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        return targetValue;
    }

    public Boolean write(String ID, String ComponentName, String KeyName, String KeyValue, String ValueType, String sFileName) {
        Boolean status = false;
        FlatFile.getInstance("Write", sFileName);
        try {
            /*
             * write.newLine(); write.write(a); write.write(","); write.write(b);
             * write.write(","); write.write(c); write.write(","); write.write(d);
             */
            write.write(newLine);
            write.append(ID);
            write.append(COMMA_DELIMITER);
            write.append(ComponentName);
            write.append(COMMA_DELIMITER);
            write.append(KeyName);
            write.append(COMMA_DELIMITER);
            write.append(KeyValue);
            write.append(COMMA_DELIMITER);
            write.append(ValueType);
            // write.flush();
            logger.info(KeyName + " Key is updated with the value of " + KeyValue);
            status = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // write.close();
                write.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return status;
    }

    public Boolean flatFileClose() {
        Boolean status = false;
        try {
            if (read != null && write != null) {
                read.close();
                write.close();
                status = true;
            }
            status = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<HashMap<String, Object>> executeSelectQuery(String sheetName, HashMap<String, Object> whereConstraint) throws IOException {
        ArrayList<HashMap<String, Object>> resultData = new ArrayList<HashMap<String, Object>>();
        whereConstraint.keySet();
        int rowcount = TotalRow();
        new HashMap<String, Object>();
        boolean selectRowValues = false;
        for (int i = 0; i < rowcount - 1; i++) {
            if (selectRowValues) {
                break;
            }
            // String whereColumnValue= ReadCSV(i);

        }
        return resultData;

    }

    public Boolean writeText() throws IOException {
        Boolean status = true;
        write.write("\n");
        write.write("aa");
        write.write("bb");
        return status;
    }

    public static int count(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int count = 0;
        while ((bufferedReader.readLine()) != null) {
            count++;
        }

        System.out.println("Count : " + count);
        return count;
    }

   /* public static long adsf() throws URISyntaxException, IOException {
        final Path path = Paths.get(ClassLoader.getSystemResource("sdf").toURI());
        System.out.println(Files.lines(path).skip(1L).count());
        return Files.lines(path).skip(1L).count();
    }*/

    public static int TotalRow() throws IOException {
        // csv file containing data
        String strFile = "C:\\Selenium\\WorkSpace\\PC\\Data\\New Text Document.csv";

        // create BufferedReader to read csv file
        BufferedReader br = new BufferedReader(new FileReader(strFile));
        int lineNumber = 0;
        // long lineCount = adsf();
        // System.out.println("Row COunt Is "+lineCount+"");
        // read comma separated file line by line
        while ((br.readLine()) != null) {
            lineNumber++;
            System.out.println(lineNumber);

        }
        return lineNumber;
    }

    public BufferedWriter CreateTextFile() {
        Boolean status = false;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String sFileName = timeStamp;
        ThreadCache.getInstance().setProperty(PCConstants.FlatFile, sFileName);
        FileWriter fw = null;
        BufferedWriter bufferedWriter = null;
        String dir = null;
        try {
            File directory = new File(".");
            dir = directory.getCanonicalPath();
            String sFilePath = dir + "\\Reports\\FailureHub\\" + sFileName + ".csv";
            File file = new File(sFilePath);
            file.createNewFile();
            fw = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write("ID");
            bufferedWriter.write(",");
            bufferedWriter.write("TestCaseID");
            bufferedWriter.write(",");
            bufferedWriter.write("TestCaseName");
            bufferedWriter.write(",");
            bufferedWriter.write("Component");
            bufferedWriter.write(",");
            bufferedWriter.write("Actual msg");
            bufferedWriter.write(",");
            bufferedWriter.write("Error Msg");
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();

            System.out.println("CSV file was created successfully !!!");
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println("bufferedWriter in create text file is :::" + bufferedWriter);
        return bufferedWriter;
    }

    /**
     * referring CSV file:
     * /**
     * Purpose- Constructor to pass Excel file name
     *
     * @param sFileName
     */
    private FlatFile(String sReadorWrite, String sFileName, String sExt) {

        try {
            //app = new ConfigManager("App");
            String dir = null;
            File directory = new File(".");
            dir = directory.getCanonicalPath();
            String sFilePath = dir + "\\Data\\FlatFiles\\" + sFileName + "." + sExt;
            //String sFilePath = "D:\\FrameWorks\\SeleniumJava\\WorkSpace\\GuidewirePC\\Data\\Data.xlsx";
            File file = new File(sFilePath);
            if (file.exists()) {
                if (sReadorWrite.toUpperCase().contains("WRITE")) {
//				fw = new FileWriter(file);
                    fw = new FileWriter(file, true);
                    write = new BufferedWriter(fw);
                } else {
                    fr = new FileReader(file);
                    read = new BufferedReader(fr);
                }
            } else {
                //UtilityMethods.infoBox("File with name-'"+sFileName+"' doesn't exists in Data Folder, Please Re-check given file name", "Config.properties");
                logger.error("Error Reading CSV File from FlatFiles Folder. Hence shutting down the application");

                Exception e = new Exception("File with name-'" + sFileName + "' doesn't exists in FlatFiles Folder");
                logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e.getMessage(), e);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error Reading Excel File from Data Folder. Hence shutting down the application");
            Exception e1 = new Exception("File with name-'" + sFileName + "' doesn't exists in Data Folder");
            logger.error("Thread ID = " + Thread.currentThread().getId() + " Error Occured =" + e1.getMessage(), e1);
            //UtilityMethods.infoBox(e.getMessage(), "Exception");
            System.exit(0);
        }
    }

    public Boolean CreateE2ECSVFile() {
        Boolean status = false;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String sFileName = "" + ThreadCache.getInstance().getProperty("TCID") + "_" + timeStamp + "";
        ThreadCache.getInstance().setProperty(PCConstants.Integ_FlatFile, sFileName);
        FileWriter fw = null;
        BufferedWriter fileWriter = null;
        String dir = null;
        try {
            File directory = new File(".");
            dir = directory.getCanonicalPath();
            String sFilePath = dir + "\\Data\\FlatFiles\\" + sFileName + ".csv";
            File file = new File(sFilePath);
            file.createNewFile();
            fw = new FileWriter(file);
            fileWriter = new BufferedWriter(fw);
            fileWriter.write("ScreenName");
            fileWriter.write(Pipe_DELIMITER);
            fileWriter.write("UIFieldName");
            fileWriter.write(Pipe_DELIMITER);
            fileWriter.write("PC Value");
            fileWriter.write(Pipe_DELIMITER);
            fileWriter.write("ODS Value");
            fileWriter.write(Pipe_DELIMITER);
            fileWriter.write("Status");
            fileWriter.write("\r\n");

            //fileWriter.append(FILE_HEADER.toString());
            System.out.println("CSV file was created successfully !!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                fw = null;
                fileWriter = null;
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        return status;
    }

    public Boolean writeCSV(String screeName, String sFeildName, String sPCValue, String sICONValue, String sStatus, String sFileName) {
        Boolean status = false;
        FlatFile.getInstanceCSV("Write", sFileName, "csv");
        try {

            write.write(newLine);
            write.append(screeName);
            write.append(Pipe_DELIMITER);
            write.append(sFeildName);
            write.append(Pipe_DELIMITER);
            write.append(sPCValue);
            write.append(Pipe_DELIMITER);
            write.append(sICONValue);
            write.append(Pipe_DELIMITER);
            write.append(sStatus);
            write.append(Pipe_DELIMITER);
            //write.append("\r\n");
//		write.flush();
            logger.info(sFeildName + " Key is updated with the value");
            status = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
//			write.close();
                write.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return status;
    }

    public String ReadCSV(String readValue, String sFileName, String delimiter) {
        FlatFile.getInstanceCSV("Read", sFileName, "csv");

        Boolean status = false;
        String strLine = "";
        String FlatFileValue = null;
        String targetValue = null;
        try {
            while ((strLine = read.readLine()) != null) {
                String[] Values = strLine.split(delimiter);
                for (int i = 2; i < Values.length; i++) {
                    FlatFileValue = Values[i];
                    // System.out.println(FlatFileValue);
                    if (FlatFileValue.toUpperCase().equals(readValue.toUpperCase())) {
                        targetValue = Values[i + 1];
                        status = true;
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
            }
            if (!status) {
                logger.info("" + readValue + " is not avilable in the " + sFileName + " file");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        return targetValue;
    }

    public static String FindandAppendCSV(String strSearchString, String sFileName, String ValtobeAdded, String delimiter) {
        //FlatFile.getInstanceCSV("Write", sFileName, "csv");
        FlatFile.getInstanceCSV("Read", sFileName, "csv");
        Boolean status = false;
        String strLine = "";
        String FlatFileValue = null;
        String targetValue = null;
        try {
            while ((strLine = read.readLine()) != null) {
                String[] Values = strLine.split(delimiter);
                for (int i = 2; i < Values.length; i++) {
                    FlatFileValue = Values[i];
                    // System.out.println(FlatFileValue);
                    if (FlatFileValue.toUpperCase().equals(strSearchString.toUpperCase())) {

                        //Values[i + 2]=ValtobeAdded;
                        strLine.replace("<ODSVAL>", ValtobeAdded);
                        //targetValue = Values[i + 1];
                        status = true;
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
            }
            try {
//			write.close();
                write.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (!status) {
                logger.info("" + strSearchString + " is not avilable in the " + sFileName + " file");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        return targetValue;
    }

/*public static void main(String arg[]) throws IOException
{
	String NewFile="C:\\Selenium\\WorkspaceR3\\bi_compas_auto_ngs_pc\\Data\\FlatFiles\\TCE2E27_20180801_151907_Temp.csv";
	String oldFile="C:\\Selenium\\WorkspaceR3\\bi_compas_auto_ngs_pc\\Data\\FlatFiles\\TCE2E27_20180801_151907.csv";
	File file = new File(oldFile);
	// File (or directory) with new name
	File file2 = new File(NewFile);

	if (file2.exists())
	   throw new java.io.IOException("file exists");

	// Rename file (or directory)
	
	BufferedReader reader = new BufferedReader(new FileReader(oldFile));
	String outFileName =NewFile;
	
	//BufferedWriter writer = new BufferedWriter(new FileWriter(output),true);
	StringBuilder stringBuilder = new StringBuilder();
	String ls = System.getProperty("line.separator");
	String line = null;
	
	
	while ((line = reader.readLine()) != null) 
	{
		if(line.contains("<ODSVAL>"))
		{
			
			line=line.replace("<ODSVAL>", "HELLO");
			stringBuilder.append(line.trim());
			stringBuilder.append(ls);
		}
		else
		{
			stringBuilder.append(line.trim());
			stringBuilder.append(ls);
		}
		
	}
	
	reader.close();
	
	File output = new File(outFileName);
	FileWriter writer=new FileWriter(output);
	writer.write(stringBuilder.toString());
	writer.close();
	writer.flush();
	
	
}*/


    public void CreateCSVFile() throws IOException {
        String timeStamp = ParallelExecDriver.timeStamp;
	/*String sFileName = timeStamp;
	String dir = null;
	File directory = new File(".");
	dir = directory.getCanonicalPath();
	String sFilePath = dir + "\\Reports\\FailureHub\\" + sFileName + ".csv";*/
        HSSFWorkbook my_workbook = ParallelExecDriver.my_workbook;
        HSSFSheet my_sheet = ParallelExecDriver.my_sheet;
        HSSFCreationHelper helper = ParallelExecDriver.helper;
        HSSFCellStyle my_style = my_workbook.createCellStyle();

        my_style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        my_style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        my_style.setWrapText(true);

        // HSSFHyperlink url_link=helper.createHyperlink(Hyperlink.LINK_URL);
        Row row = my_sheet.createRow(0);
        row.setRowStyle(my_style);
        Cell cell1 = row.createCell(0);
        cell1.setCellStyle(my_style);
        cell1.setCellValue("ID");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("TestCaseID");
        cell2.setCellStyle(my_style);

        Cell testcasecount = row.createCell(3);
        testcasecount.setCellStyle(my_style);
        testcasecount.setCellValue("TCCount");

        Cell cell3 = row.createCell(2);
        cell3.setCellStyle(my_style);
        cell3.setCellValue("TestCaseName");
        Cell cell4 = row.createCell(4);
        cell4.setCellStyle(my_style);
        cell4.setCellValue("Component");
    /*Cell cell5 = row.createCell(4);
    cell5.setCellStyle(my_style);
    cell5.setCellValue("Actual msg");*/

        Cell cell6 = row.createCell(5);
        cell6.setCellStyle(my_style);
        cell6.setCellValue("Actual Msg");
        Cell cell7 = row.createCell(6);
        cell7.setCellStyle(my_style);
        cell7.setCellValue("Expected Value");
        Cell cell8 = row.createCell(7);
        cell8.setCellStyle(my_style);
        cell8.setCellValue("Report");
        Cell cell9 = row.createCell(8);
        cell9.setCellStyle(my_style);
        cell9.setCellValue("Screenshot");

        Cell cell10 = row.createCell(9);
        cell10.setCellStyle(my_style);
        cell10.setCellValue("Log File");
        FileOutputStream out = new FileOutputStream(new File(ParallelExecDriver.sFilePath));
        my_workbook.write(out);
        out.flush();
        out.close();
        //System.out.println("Csv file created successfully");
    }
}
