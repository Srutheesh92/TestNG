package file.excel.write;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excelread {
public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver", "D:\\Test\\Chrome\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	String location = "D:\\Project_Dec2\\src\\test\\resources\\TestData\\FB Excelread.xlsx";
	XSSFWorkbook wf = new XSSFWorkbook(location);
	XSSFSheet sheet = wf.getSheetAt(0);
	XSSFRow row = sheet.getRow(1);
	XSSFCell cell = row.getCell(0);
	String Username = cell.getStringCellValue();
	
	XSSFRow row2 = sheet.getRow(1);
	XSSFCell cell2 = row2.getCell(1);
	String Password = cell2.getStringCellValue();
	
	driver.findElement(By.id("email")).sendKeys(Username);
	driver.findElement(By.id("pass")).sendKeys(Password);
	driver.findElement(By.name("login")).click();
	wf.close();
}
}
