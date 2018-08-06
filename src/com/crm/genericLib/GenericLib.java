package com.crm.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;


/**
 * 
 * @author Yasmeen
 *
 */
public class GenericLib {
	
	String excelData="./TestData/TestData.xlsx";
/**
 * 	
 * @param filepath
 * @return
 * @throws IOException
 * This is used to fetch the data from the property file
	*/
	public Properties getPropertiesFileObj(String filepath) throws IOException
	{
		FileInputStream fis=new FileInputStream(filepath);
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj;
	}
	
	public void WaitForElement(WebElement wb)
	{
		int count=20;
		while(count>=0)
		{
			try {
			if(wb.isDisplayed())
			{
				wb.click();
				break;
			}
			}
			catch(Exception e)
			{
				
			}
		}
		
	}
	/**
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 * It fetches the data from the excel file,The return type is String. 
	 */
	public String getExcelData(String sheetName, int rowNum,int colNum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream file=new FileInputStream(excelData);
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		String data=row.getCell(colNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	
	public void setCellData(String sheet,int rowNum,int cellNum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream(excelData);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet1=wb.getSheet(sheet);		
		Row row=sheet1.getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		FileOutputStream fos=new FileOutputStream(excelData);
		cell.setCellValue(data);
		wb.write(fos);
		
	}
	


	

}
