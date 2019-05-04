package org.excel;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookDataDriven {

	static WebDriver driver;

	public static void launchBrowser() throws InterruptedException {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Thread.sleep(4000);
	}

	public static String getRowValue(String value) throws IOException {
		File location = new File(System.getProperty("user.dir") + "\\src\\test\\java\\org\\excel\\DataBase.xlsx");
		FileInputStream fin = new FileInputStream(location);
		Workbook wb = new XSSFWorkbook(fin);
		Sheet sheet = wb.getSheet("sheet1");
		String cellValue = null;

		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Total number of Row in Sheet =" + physicalNumberOfRows);

		for (int k = 0; k < physicalNumberOfRows; k++) {
			Row row = sheet.getRow(k);

			Cell cell = row.getCell(0);
			String cellPara = null;
			if (cell.getCellType().equals(CellType.NUMERIC)) {
				double d1 = cell.getNumericCellValue();
				long ln = (long) d1;
				cellPara = String.valueOf(ln);
			} else if (cell.getCellType().equals(CellType.STRING)) {
				cellPara = cell.getStringCellValue();
			}
			if (cellPara.equals(value)) {
				String username = row.getCell(3).getStringCellValue();
				String password = row.getCell(4).getStringCellValue();
				String empname = row.getCell(2).getStringCellValue();
				cellValue = "Employee Name is = " + empname + " , email id = " + username + " , password = " + password;
			}
		}
		return cellValue;
		
	}
	
	public static void signIn() throws IOException, InterruptedException {
		Thread.sleep(3000);
		getRowValue("2");
		driver.findElement(By.id("email")).sendKeys("username");
		driver.findElement(By.id("pass")).sendKeys("password");
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		launchBrowser();
		signIn();
	}

}
