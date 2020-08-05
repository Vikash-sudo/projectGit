package com.github.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.qa.base.TestBase;


public class LoginPage extends TestBase{
	

	@FindBy(id="login_field")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="commit")
	private WebElement signIn;
	

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String userid, String pwd) {
		username.sendKeys(userid);
		password.sendKeys(pwd);
		signIn.click();
		return new HomePage(driver);
	}

}
