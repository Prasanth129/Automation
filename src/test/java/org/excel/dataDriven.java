package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.asm.Advice.Return;

public class dataDriven {

	
	private void getExcel() throws IOException {
	System.out.println(System.getProperty("user.dir"));
		File excelLocation = new File(System.getProperty("user.dir")+ "\\src\\test\\java\\org\\excel\\DataBase.xlsx");
		FileInputStream fin=new FileInputStream(excelLocation);
		Workbook wb=new XSSFWorkbook(fin);
		Sheet sheet=wb.getSheet("Sheet1");
	
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);
		
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
		
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell c = row.getCell(j);
			String cellValue= null;
	
			if (c.getCellType().equals(CellType.STRING)) {
				cellValue = c.getStringCellValue();
			}else if (c.getCellType().equals(CellType.NUMERIC)) {
				double numericCellValue = c.getNumericCellValue();
				long l= (long) numericCellValue;
				cellValue= String.valueOf(l);
			}
				System.out.println(cellValue);
			}
			}}	
public static String getExcelValues(int i, int j) throws IOException {
	File Xlocation= new File(System.getProperty("user.dir")+"\\src\\test\\java\\org\\excel\\DataBase.xlsx");
	FileInputStream fin= new FileInputStream(Xlocation);
	Workbook wb=new XSSFWorkbook(fin);
	Sheet sheet=wb.getSheet("Sheet1"); 
	
	int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
	System.out.println(physicalNumberOfRows);

	Row row = sheet.getRow(i);
	Cell cell = row.getCell(j);
	String cellvalue=null;
	if (cell.getCellType().equals(CellType.STRING)) {
		cellvalue=cell.getStringCellValue();
	}else if (cell.getCellType().equals(CellType.NUMERIC)) {
		double numericCellValue = cell.getNumericCellValue();
		long l= (long) numericCellValue;
		cellvalue=String.valueOf(l);
	}
	return cellvalue;

}

public static void main(String[] args) throws IOException {
	String values = getExcelValues(4, 4);
	System.out.println(values);
}

}

