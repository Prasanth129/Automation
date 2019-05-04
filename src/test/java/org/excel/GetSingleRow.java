package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GetSingleRow {
	
	public static String getRowvalue(String value) throws IOException {
		File location=new File(System.getProperty("user.dir")+"\\src\\test\\java\\org\\excel\\DataBase.xlsx");
		FileInputStream fin=new FileInputStream(location);
		Workbook wb=new XSSFWorkbook(fin);
		Sheet sheet=wb.getSheet("sheet1");
		String cellValue= null;
		
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Total number of Row in Sheet ="+physicalNumberOfRows);
		
		for (int k = 0; k < physicalNumberOfRows; k++) {
			Row row = sheet.getRow(k);
			
			Cell cell = row.getCell(0);
			String cellPara=null;
			if (cell.getCellType().equals(CellType.NUMERIC)) {
				double d1 = cell.getNumericCellValue();
				long ln=(long) d1;
				cellPara=String.valueOf(ln);
			}else if (cell.getCellType().equals(CellType.STRING)) {
				cellPara = cell.getStringCellValue();
			} 
			if (cellPara.equals(value)) {
				String username=row.getCell(3).getStringCellValue();
				String password=row.getCell(4).getStringCellValue();
				String empname =row.getCell(2).getStringCellValue();
				cellValue= "Employee Name is = " +empname+ " , email id = "+username+ " , password = "+password;
			}
		}
		return cellValue;
	}	
public static void main(String[] args) throws IOException {
	String ob= getRowvalue("3");
	System.out.println(ob);
}
}
