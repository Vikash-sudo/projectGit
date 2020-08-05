package com.github.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.qa.base.TestBase;
import com.github.qa.pages.HomePage;
import com.github.qa.pages.IssuePage;
import com.github.qa.pages.LandingPage;
import com.github.qa.pages.LoginPage;
import com.github.qa.pages.SignUpPage;
import com.github.qa.utils.DataproviderClass;
import com.github.qa.utils.TestUtil;

public class CreateRepoTest extends TestBase{
	SignUpPage signUpPage;
	LoginPage loginPage;
	HomePage homepage;
	LandingPage landingPage;
	IssuePage issuePage;
	
	String reponame = RandomStringUtils.randomAlphanumeric(8);
	public CreateRepoTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws IOException{
		inisialize();
		signUpPage = new SignUpPage(driver);
		loginPage = new LoginPage(driver);
		landingPage = new LandingPage(driver);
		homepage = new HomePage(driver);
		issuePage = new IssuePage(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLISIT_WAIT, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void createRepositoryTest() {
		signUpPage.clickLoginButton();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.addRepo();
		landingPage.createRepo(reponame, prop.getProperty("repoDescription"));
	}
	
	@Test(priority=2, dataProvider="SearchProvider",dataProviderClass=DataproviderClass.class)
	public void createIssue(String title, String description) throws InterruptedException {
		Thread.sleep(7000);
		homepage.clickissue();
		issuePage.createNewissue(title, description);
	}
	
	
	@Test(priority=3)
	public void addCommentToIssue() {
		homepage.clickissue();
		issuePage.clickOnParticularIssue(prop.getProperty("issueTitle2"));
		issuePage.addComment(prop.getProperty("comment"));
		Assert.assertTrue(issuePage.validateComment(prop.getProperty("comment")).isDisplayed());
		issuePage.addEmoji();
	}
	
	@Test(priority=4)
	public void mentionIssueInCommentAndNavigateToIt() {
		homepage.clickissue();
		issuePage.clickOnParticularIssue(prop.getProperty("issueTitle1"));
		issuePage.addComment(prop.getProperty("comment") + " #2");
		issuePage.naviagteToIssue();
		issuePage.issueIsDisplayed(prop.getProperty("issueTitle2"));
	}
	
	@Test(priority=5)
	public void deleteRepoTest() {
		homepage.deleteRepo("Vikash-sudo/" +reponame);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
