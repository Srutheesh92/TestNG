package file.excel.write;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdHotel {
public static void main(String[] args) throws IOException {
	Base b = new Base();
	b.syssetting();
	b.chrome();
	b.maximize();
	b.geturl("http://adactinhotelapp.com/");
	b.time();
	String location = "D:\\Project_Dec2\\src\\test\\resources\\TestData\\Adactin.xlsx";
	String Username = b.ExlRead(location, "Hotel", 1, 0);
	b.sendkys(b.findelement("//*[@id='username']"), Username);
	String Password = b.ExlRead(location, "Hotel", 1, 1);
	b.sendkys(b.id("password"), Password);
	b.time();
	b.click(b.id("login"));
	System.out.println("User successfully logged into Adactin Hotel Website");
	
	FileReader fr = new FileReader("D:\\Project_Dec2\\src\\test\\resources\\TestData\\Adactin.properties");
	Properties p = new Properties();
	p.load(fr);
	String loc = p.getProperty("Location");
	String hotels = p.getProperty("Hotels");
	String roomty = p.getProperty("RoomType");
	String noofrooms = p.getProperty("NumberofRooms");
	String chkin = p.getProperty("CheckInDate");
	String chkout = p.getProperty("CheckOutDate");
	String adults = p.getProperty("AdultsperRoom");
	String childs = p.getProperty("ChildrenperRoom");
	b.time();
	b.sendkys(b.id("location"), loc);
	b.sendkys(b.id("hotels"), hotels);
	b.sendkys(b.id("room_type"), roomty);
	b.sendkys(b.id("room_nos"), noofrooms);
	b.sendkys(b.id("datepick_in"), chkin);
	b.sendkys(b.id("datepick_out"), chkout);
	b.sendkys(b.id("adult_room"), adults);
	b.sendkys(b.id("child_room"), childs);
	b.time();
	b.click(b.cssselector("input.reg_button"));
	
	System.out.println();
	System.out.println("Validating the details which selected by the user");
	String valhotel = b.getAttribute(b.id("hotel_name_0"), "value");
	if(valhotel.equals(hotels))
		System.out.println("Hotel name Matched:"+" "+ "User Selected Hotel- " +valhotel);
	else
		System.out.println("Hotel name mismatched.. Please Check");

	String valloc = b.getAttribute(b.id("location_0"), "value");
	if(valloc.equals(loc))
		System.out.println("Location matched:"+ " "+ "User Selected location- "+valloc);
	else
		System.out.println("Location Mismatch..Please check");
	
	String valroomtype = b.getAttribute(b.id("room_type_0"), "value");
	if(valroomtype.equals(roomty))
		System.out.println("Room Type matched:"+ " " +"Room Type Selected- " +valroomtype);
	
	b.time();
	b.click(b.cssselector("input#radiobutton_0"));
	b.click(b.cssselector("input.reg_button"));
	
	String firstname = p.getProperty("FirstName");
	String lastname = p.getProperty("LastName");
	String addr = p.getProperty("BillingAddress");
	String creditcard = p.getProperty("CreditCardNo");
	b.selectbyvisibletext(b.id("cc_type"), "Master Card");
	b.selectbyvisibletext(b.cssselector("select.select_combobox2"), "August");
	b.selectbyvisibletext(b.cssselector("select#cc_exp_year"), "2022");
	String cvv = p.getProperty("CVVNumber");
	
	b.sendkys(b.id("first_name"), firstname);
	b.sendkys(b.id("last_name"), lastname);
	b.sendkys(b.id("address"), addr);
	b.sendkys(b.id("cc_num"), creditcard);
	b.sendkys(b.id("cc_cvv"), cvv);
	
	b.click(b.id("book_now"));
	b.time();
	
	System.out.println();
	WebElement orderno = b.id("order_no");
	String OrderID  = b.getAttribute(orderno, "value");
	System.out.println("Order ID:" + " "+ OrderID);
	System.out.println();
	
	WebElement finalprice = b.id("final_price");
	String price = b.getAttribute(finalprice, "value");
	System.out.println("Final Billed price:"+ " "+ price);
	
	b.click(b.id("my_itinerary"));
	b.time();
	b.click(b.cssselector("input#logout"));
	System.out.println();
	
	System.out.println("Thank you for Booking");
	
}
}
