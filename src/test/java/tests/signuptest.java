package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base;
import pages.homepage;

public class signuptest extends base{
	
	@BeforeTest
	public void excelreads() {
		 excelfile="POM_Demoblaze";
		 sheetname="Signup_test";
	}
	
	@Test(dataProvider="Readingexceldata")
	public void signuptesth(String Username, String Password, String DataMatch) throws InterruptedException {
	    homepage obj = new homepage(driver);
	    obj.signhome()
	       .signupusername(Username)
	       .signuppassword(Password)
	       .signuptestbtn();
		
		if(DataMatch.equals("new user")) {
			Thread.sleep(2000);
			Alert al=driver.switchTo().alert();
			String text=driver.switchTo().alert().getText();
			AssertJUnit.assertEquals(text,"Sign up successful.");
			al.accept();
			
		}else if(DataMatch.equals("ExistingUser")) {
			Thread.sleep(2000);
			Alert al=driver.switchTo().alert();
			String text=driver.switchTo().alert().getText();
			AssertJUnit.assertEquals(text,"This user already exist.");
			al.accept();
			
			
		}else if(DataMatch.equals("Invalid username")) {
			Thread.sleep(2000);
			Alert al=driver.switchTo().alert();
			String text=driver.switchTo().alert().getText();
			AssertJUnit.assertEquals(text,"Please fill out Username and Password.");
			al.accept();
			
			
		}else  {
			Thread.sleep(2000);
			Alert al=driver.switchTo().alert();
			String text=driver.switchTo().alert().getText();
			AssertJUnit.assertEquals(text,"Please fill out Username and Password.");
			al.accept();
			
			
		}
	}
}
