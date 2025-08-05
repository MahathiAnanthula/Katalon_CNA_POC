package com.customkeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.reader.CSVReader
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.Select
import org.testng.Assert
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.lang.Exception
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.supercsv.io.CsvListReader
import org.supercsv.io.CsvListWriter
import com.kms.katalon.core.testdata.reader.CsvWriter

public class reusableMethods {

	@Keyword
	def click_outside() {
		try {
			WebDriver driver=DriverFactory.getWebDriver()
			Actions action=new Actions(driver)
			action.moveByOffset(0, 0).click().build().perform()
		}catch(Exception e){
			KeywordUtil.markFailed("Failed to Click Out Side")
			e.printStackTrace()
			WebUI.takeScreenshot()
		}
	}

	@Keyword
	def writeTestResultToExcel(String filePath, String sheetName, int rowIndex, int cellIndex, String result) {
		FileInputStream fileInputStream = new FileInputStream(new File(filePath))
		Workbook workbook = WorkbookFactory.create(fileInputStream)
		Sheet sheet = workbook.getSheet(sheetName)

		Row row = sheet.getRow(rowIndex)
		if (row == null) {
			row = sheet.createRow(rowIndex)
		}

		Cell cell = row.getCell(cellIndex)
		if (cell == null) {
			cell = row.createCell(cellIndex)
		}

		cell.setCellValue(result)

		fileInputStream.close()

		FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))
		workbook.write(fileOutputStream)
		fileOutputStream.close()
		workbook.close()
	}

	@Keyword
	def CSVToExcelConverter(String excelpath){

		ArrayList arList=null;
		ArrayList al=null;
		String fName = excelpath;
		String thisLine;
		int count=0;
		FileInputStream fis = new FileInputStream(fName);
		DataInputStream myInput = new DataInputStream(fis);
		int i=0;
		arList = new ArrayList();
		while ((thisLine = myInput.readLine()) != null) {
			al = new ArrayList();
			String strar[] = thisLine.split(",");
			for(int j=0;j<strar.length;j++) {
				al.add(strar[j]);
			}
			arList.add(al);
			System.out.println();
			i++;
		}

		try {
			HSSFWorkbook hwb = new HSSFWorkbook();
			HSSFSheet sheet = hwb.createSheet("new sheet");
			for(int k=0;k<arList.size();k++) {
				ArrayList ardata = (ArrayList)arList.get(k);
				HSSFRow row = sheet.createRow((short) 0+k);
				for(int p=0;p<ardata.size();p++) {
					HSSFCell cell = row.createCell((short) p);
					String data = ardata.get(p).toString();
					if(data.startsWith("=")){
						cell.setCellType(Cell.CELL_TYPE_STRING);
						data=data.replaceAll("\"", "");
						data=data.replaceAll("=", "");
						cell.setCellValue(data);
					}else if(data.startsWith("\"")){
						data=data.replaceAll("\"", "");
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cell.setCellValue(data);
					}else{
						data=data.replaceAll("\"", "");
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);
						cell.setCellValue(data);
					}
					//*/
					// cell.setCellValue(ardata.get(p).toString());
				}
				System.out.println();
			}
			FileOutputStream fileOut = new FileOutputStream("test.xls");
			hwb.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated");
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} //main method ends
	}

	@Keyword
	def updateCSVfile(String fileToUpdate){

		FileWriter fw = new FileWriter(fileToUpdate, true); // 'true' appends to file
		PrintWriter pw = new PrintWriter(fw)

		// Write header (optional, do this once)
		pw.println("Name,Email,Phone");

		// Sample data (replace this with data you scrape using Selenium)
		pw.println("John Doe,john@example.com,1234567890");
		pw.println("Jane Smith,jane@example.com,0987654321");

		System.out.println("Data written to CSV successfully.");
	}
}


