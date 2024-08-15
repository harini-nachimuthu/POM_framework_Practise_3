package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class signuppage extends base {

    public signuppage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sign-username")
    WebElement sign_username;
    
    @FindBy(id = "sign-password")
    WebElement sign_password;
    
    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    WebElement Sign_up;

    public signuppage signupusername(String username) {
        sign_username.sendKeys(username);
        return this;
    }

    public signuppage signuppassword(String password) {
        sign_password.sendKeys(password);
        return this;
    }
    
    public signuppage signuptestbtn() {
        clickbtn(Sign_up);
        return this;
    }
}
