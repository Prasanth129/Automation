package org.excel;

import static org.testng.Assert.assertThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenAllMethods {
//Get all excel data
	public static void getAllDatas() throws IOException {
		String property = System.getProperty("user.dir");
		File f= new File(property+ "\\src\\test\\java\\org\\excel\\DataBase.xlsx");
		FileInputStream fin= new FileInputStream(f);
		Workbook wb= new XSSFWorkbook(fin);
		Sheet sheet = wb.getSheet("Sheet1");
		
		int NumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(NumberOfRows);
		for (int i = 0; i < NumberOfRows; i++) {
		Row row = sheet.getRow(i);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			String cellValue=null;
			
			if (cell.getCellType().equals(CellType.STRING)) {
				cellValue = cell.getStringCellValue();
			}else if (cell.getCellType().equals(CellType.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				long l=(long) numericCellValue;
				cellValue=String.valueOf(l);
			}
System.out.println(cellValue);			
		}
		}
	}
// Get Excel Value
	public static String getExcelValue(int i, int j) throws IOException {
		String property = System.getProperty("user.dir");
		File f=new File(property+"\\src\\test\\java\\org\\excel\\DataBase.xlsx");
		FileInputStream fin= new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fin);
		Sheet sheet = wb.getSheet("Sheet1");
		
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		String cellvalue1=null;
		if (cell.getCellType().equals(CellType.STRING)) {
			cellvalue1 = cell.getStringCellValue();
		}else if (cell.getCellType().equals(CellType.NUMERIC)) {
			double numericCellValue1 = cell.getNumericCellValue();
			long l=(long) numericCellValue1;
			cellvalue1=String.valueOf(l);
		}
return cellvalue1;		
	}
// Get Particular Column	
public static void getParticularcolumn(int i) throws IOException {
		String property = System.getProperty("user.dir");
		File f=new File(property+"\\src\\test\\java\\org\\excel\\DataBase.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fin);
		Sheet sheet = wb.getSheet("Sheet1");
		
		for (Row row : sheet) {
			Cell cell = row.getCell(i);
		System.out.println(cell);
		}
}
public static void main(String[] args) throws IOException {
	//getAllDatas();
	String excelValue = getExcelValue(2, 2);
	System.out.println(excelValue);
	//getParticularcolumn(0);
}
}
