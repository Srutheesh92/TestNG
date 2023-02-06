package file.excel.write;

import java.io.IOException;

import org.openqa.selenium.By;

public class FBloginExlRead {
	public static void main(String[] args) throws IOException {
		Base ba = new Base();
		ba.syssetting();
		ba.chrome();
		ba.maximize();
		ba.geturl("https://www.facebook.com/");
		ba.time();
		String location = "D:\\Project_Dec2\\src\\test\\resources\\TestData\\FB Excelread.xlsx";
			String User = ba.ExlRead(location, "Sheet1", 1, 0);
			String pass = ba.ExlRead(location, "Sheet1", 1, 1);
			ba.sendkys(ba.findelement("//*[@name='email']"),User);
			ba.sendkys(ba.findelement("//*[@name='pass']"), pass);
			ba.click(ba.findelement("//*[@name='login']"));
		}
	}
