package com.github.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.qa.base.TestBase;

public class IssuePage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(),'New issue')]")
	private WebElement newIssue;
	
	@FindBy(id="issue_title")
	private WebElement issueTitle;
	
	@FindBy(id="issue_body")
	private WebElement issueBody;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement submitBtn;
	
	@FindBy(className="btn btn-sm btn-primary m-0 ml-2 ml-md-2")
	private WebElement newIssueBtn;
	
	@FindBy(xpath = "//a[contains(text(),'+issue+')]")
	private WebElement issuelink;
	
	@FindBy(xpath = "//textarea[@name='comment[body]']")
	public WebElement commentArea;
	
	@FindBy(xpath = "//button[contains(text(),'Comment')]")
	private WebElement commentBtn;
	
	@FindBy(xpath = "//a[contains(text(),'#2')]")
	private WebElement issueInComment;
	
	@FindBy(xpath = "//li[@data-text='+1 thumbsup approve ok']")
	private WebElement emojiIcon;
	
	
	 public void createNewissue(String title, String description) {
		   newIssue.click();
		   issueTitle.sendKeys(title);
		   issueBody.sendKeys(description);
		   submitBtn.click();
	   }
	
	 public void addComment(String comments) {
		 commentArea.sendKeys(comments);
		 commentBtn.click();
	 }
	 
	 public WebElement validateComment(String comments) {
		 WebElement element = driver.findElement(By.xpath("//p[text()='"+comments+"']"));
		return element;
	}
	 
	 public void naviagteToIssue() {
		 issueInComment.click();
	 }
	 
	 public void issueIsDisplayed(String issueTitle) {
		 WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+issueTitle+"')]"));
		 Assert.assertTrue(element.isDisplayed());
	 }
	 
	 public void clickOnParticularIssue(String issue) {
		 WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+issue+"')]"));
		 element.click();
	}
	 
	 public void addEmoji() {
		 commentArea.sendKeys(":");
		 emojiIcon.click();
		 commentBtn.click();
	 }
	
	public IssuePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
