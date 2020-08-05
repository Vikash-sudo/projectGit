package com.github.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.qa.base.TestBase;

public class SignUpPage extends TestBase{

	
	@FindBy(xpath="//a[@href='/login']")
    private WebElement loginButton;
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickLoginButton() {
		loginButton.click();
		return new LoginPage(driver);
	}

}
