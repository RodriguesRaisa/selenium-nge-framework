package com.qa.nge.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtil {
	
	private WebDriver driver;
	private static Workbook workbook;
	private static Sheet sheet;
	private static final String EXCEL_FILE_PATH="./src/test/resources/testdata/NGETestData.xlsx";
	
	public static Object[][] getUserData(String sheetName)
	{
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(EXCEL_FILE_PATH);
			workbook = WorkbookFactory.create(ip);
			sheet = workbook.getSheet(sheetName);
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
		} catch (IOException | InvalidFormatException e) {
			
			e.printStackTrace();
		}
		
		return data;
	}

}
