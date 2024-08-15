package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base;
import pages.homepage;

public class logintest extends base {
	
	@BeforeTest
	public void excelreads() {
		 excelfile="POM_Demoblaze";
		 sheetname="Login_test";
	}
	
	@Test(dataProvider="Readingexceldata")
	public void logintesth(String Username, String Password, String datamatch) throws InterruptedException {
	    homepage obj = new homepage(driver);
	    obj.loginhome()
	       .loginusername(Username)
	       .loginpassword(Password)
	       .loginuptestbtn();

		if(datamatch.equals("bothcorrect")) {
			Thread.sleep(2000);
			WebElement name=driver.findElement(By.id("nameofuser"));
			System.out.println("text : "+name.getText());
			AssertJUnit.assertTrue(name.isDisplayed());
			
		}else if(datamatch.equals("wrongusername")) {
			Thread.sleep(2000);
			Alert al=driver.switchTo().alert();
			String text=driver.switchTo().alert().getText();
			al.accept();
			AssertJUnit.assertEquals(text, "User does not exist.");
			
		}else if(datamatch.equals("wrongPassword")){
			Thread.sleep(2000);
			Alert al=driver.switchTo().alert();
			String text=driver.switchTo().alert().getText();
			al.accept();
			AssertJUnit.assertEquals(text, "Wrong password.");
		}else {
			Thread.sleep(2000);
			Alert al=driver.switchTo().alert();
			String text=driver.switchTo().alert().getText();
			al.accept();
			AssertJUnit.assertEquals(text, "User does not exist.");
		}
	}
}
