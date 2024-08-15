package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class homepage extends base {
    
    @FindBy(id = "signin2")
    WebElement homesignup;
    
    @FindBy(id = "login2")
    WebElement homelogin;

    
	public homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public signuppage signhome() {
        clickbtn(homesignup);
        return new signuppage(driver);
    }

    public loginpage loginhome() {
        clickbtn(homelogin);
        return new loginpage(driver);
    }
}
