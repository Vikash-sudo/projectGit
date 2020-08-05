package com.github.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath ="//*[@aria-label='Create new…']")
	private WebElement addButton;
	
	@FindBy(xpath ="//a[contains(text(),'New repository')]")
	private WebElement newRepo;
	
	@FindBy(xpath ="//span[contains(text(),'Settings')]")
	private WebElement setting;

	@FindBy(xpath ="//summary[contains(text(),'Delete this repository')]")
	private WebElement deleteRepo;
	
	@FindBy(xpath ="//button[contains(text(),'delete this repository')]")
	private WebElement deleteRepoButton;
	
	@FindBy(xpath ="//form[contains(@action,'delete')]//input[@name='verify']")
	private WebElement repoNameInput;
	
	@FindBy(xpath ="//span[contains(text(),'Issues')]")
	private WebElement issues;
	
	@FindBy(xpath = "//div[@class='container-lg px-2']")
	private WebElement repoDeleteMsg;	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
   public LandingPage addRepo() {
	   addButton.click();
	   newRepo.click();
	   return new LandingPage(driver);
   }
   
   public void deleteRepo(String repoName) {
	   setting.click();
	   deleteRepo.click();
	   repoNameInput.sendKeys(repoName);
	   deleteRepoButton.click();
	   Assert.assertTrue(repoDeleteMsg.isDisplayed());
   }
   
   public IssuePage clickissue() {
	   issues.click();
      return new IssuePage(driver);
   }
   
   

}
