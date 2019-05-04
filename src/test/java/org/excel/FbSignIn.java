package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FbSignIn {

@DataProvider(name ="Authentication")
	
	public static Object[][]excelFile() throws Throwable {
	
	File f= new File(System.getProperty("user.dir")+"\\src\\test\\java\\org\\excel\\DataBase.xlsx");
	FileInputStream fin= new FileInputStream(f);
	Workbook wb= new XSSFWorkbook(fin);
	Sheet sheet= wb.getSheetAt(0);
	int row= sheet.getPhysicalNumberOfRows();
	Object[][] obj = null;
	String v=null; String w=null;
	int k=0;
	Map<String, String>mapdata=new HashMap<String, String>();
	for (int i = 0; i < row; i++) {
		
		if (sheet.getRow(i).getCell(0).getNumericCellValue()==100) {
			Cell x= sheet.getRow(i).getCell(1);
			if (x.getCellType().equals(CellType.STRING)) {
				v=sheet.getRow(i).getCell(1).getStringCellValue();
			}else if (x.getCellType().equals(CellType.NUMERIC)) {
			double d=sheet.getRow(i).getCell(1).getNumericCellValue();
				v=String.valueOf(d);
			}
			Cell y=sheet.getRow(i).getCell(2);
			if (y.getCellType().equals(CellType.STRING)) {
				w=sheet.getRow(i).getCell(2).getStringCellValue();
			}else if (y.getCellType().equals(CellType.NUMERIC)) {
			double d=sheet.getRow(i).getCell(2).getNumericCellValue();
				w=String.valueOf(d);
			}
				mapdata.put(v, w);
			}
			}
			obj=new Object[mapdata.size()][2];
			Set<Entry<String,String>> entrySet = mapdata.entrySet();
			for (Entry<String, String> e : entrySet) {
				k++;
				obj[k-1][0] = e.getKey();
				obj[k-1][1] = e.getValue();
			}
			return obj;
}
@Test(dataProvider="Authentication")
	public static void test(String name, String pass) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.findElement(By.id("email")).sendKeys(name);
	driver.findElement(By.id("pass")).sendKeys(pass);
	}
}