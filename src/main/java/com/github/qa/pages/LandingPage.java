package com.github.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.qa.base.TestBase;


public class LandingPage extends TestBase{
	
	@FindBy(id="repository_name")
	private WebElement repoName;
	
	@FindBy(id= "repository_description")
	private WebElement repoDesc;
	
	@FindBy(id= "repository_auto_init")
	private WebElement checkBoxReadMe;
	
	@FindBy(xpath ="//button[contains(text(),'Create repository')]")
	private WebElement createRepoBtn;
	
	
	public void createRepo(String repo, String description) {
		repoName.sendKeys(repo);
		repoDesc.sendKeys(description);
		checkBoxReadMe.click();
		createRepoBtn.click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+repo+"')]"));
		Assert.assertTrue(element.isDisplayed());
	}

	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
