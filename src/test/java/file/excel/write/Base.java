package file.excel.write;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	WebDriver driver;
public void syssetting()
{
	System.setProperty("webdriver.chrome.driver", "D:\\\\Test\\\\Chrome\\\\chromedriver.exe");
}
public void chrome()
{
	driver = new ChromeDriver();
}
public void geturl(String g)
{
	driver.get(g);
}
@SuppressWarnings("deprecation")
public void time()
{
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
}
public void maximize()
{
	driver.manage().window().maximize();
}
public String ExlRead(String filepath,String sheetnam,int rownum,int cellnum) throws IOException
{
	XSSFWorkbook wf = new XSSFWorkbook(filepath);
	XSSFSheet sheet = wf.getSheet(sheetnam);
	XSSFRow row = sheet.getRow(rownum);
	XSSFCell cell = row.getCell(cellnum);
	String cellValue = cell.getStringCellValue();
	wf.close();
	return cellValue;
	}
public void sendkys(WebElement element, String value)
{
	element.sendKeys(value); 
	}
public WebElement findelement(String value)
{
	return driver.findElement(By.xpath(value));
}
public void click(WebElement element)
{
	element.click();
}
public WebElement id(String value)
{
	return driver.findElement(By.id(value));
}
public WebElement cssselector(String value)
{
	return driver.findElement(By.cssSelector(value));
}
public String getAttribute(WebElement element ,String value)
{
	String attribute = element.getAttribute(value);
	return attribute;
}
public void selectbyvisibletext(WebElement element, String value)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(value);
}
}
