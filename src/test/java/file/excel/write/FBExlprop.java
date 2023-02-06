package file.excel.write;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FBExlprop {
public static void main(String[] args) throws IOException {
	Base ba = new Base();
	ba.syssetting();
	ba.chrome();
	ba.maximize();
	ba.geturl("https://www.facebook.com/");
	ba.time();
	FileReader read = new FileReader("D:\\Project_Dec2\\src\\test\\resources\\TestData\\Credentials.properties");
	Properties p = new Properties();
	p.load(read);
	String User = p.getProperty("Username");
	String Pass = p.getProperty("Password");
	ba.sendkys(ba.findelement("//*[@name='email']"), User);
	ba.sendkys(ba.findelement("//*[@name='pass']"), Pass);
	ba.click(ba.findelement("//*[@name='login']"));
}
}
