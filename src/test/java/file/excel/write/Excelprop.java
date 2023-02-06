package file.excel.write;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excelprop {
public static void propread() throws IOException
{
	System.setProperty("webdriver.chrome.driver", "D:\\Test\\Chrome\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	FileReader read = new FileReader("D:\\Project_Dec2\\src\\test\\resources\\TestData\\Credentials.properties");
	Properties p = new Properties();
	p.load(read);
	String Username = p.getProperty("Username");
	String Password = p.getProperty("Password");
	
	driver.findElement(By.id("email")).sendKeys(Username);
	driver.findElement(By.id("pass")).sendKeys(Password);
	driver.findElement(By.name("login")).click();
}
}
