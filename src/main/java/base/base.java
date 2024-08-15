package base;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utility.util;

public class base extends util{

	//@Parameters({"browser","url"})
	@BeforeMethod
	public void start() {
		
		launchbrowserandurl("chrome","https://www.demoblaze.com/");
	}
	
	@AfterMethod
	public void end() {
		closebtn();
	}
	
	@DataProvider(name="Readingexceldata")
	public String[][] excelread1() throws IOException {
		String[][] data1=excelread(excelfile,sheetname);
		return data1;
		
	}
}
