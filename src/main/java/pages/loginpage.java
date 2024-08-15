package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class loginpage extends base{

	public loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="loginusername")
	WebElement loginusername1;
	
	
	@FindBy(id="loginpassword")
	WebElement loginpassword1;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement Login1;
	
//	@FindBy(id="nameofuser")
//	WebElement nameofuser1;
	
	public loginpage loginusername(String username) {
		findelementbyidandsendkeys("loginusername", username);
		return this;
		
	}

	public loginpage loginpassword(String password) {
		findelementbyidandsendkeys("loginpassword", password);
		return this;
	}
	
	public loginpage loginuptestbtn() {
		Login1.click();
		return this;
		
	}

}
