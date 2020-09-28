package com.testautomation.videonotes.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testautomation.videonotes.common.VideoNotesUser;
import com.testautomation.videonotes.pageobject.LoginPage;

import junit.framework.Assert;

public class LoginTestcase {
	
	public String baseUrl = "http://localhost:3000";
	public String chromeDriver = "chromedriver.exe"; 
	static WebDriver driver;
	
	LoginPage login;
 
  @BeforeTest  // Open the Chrome browser and get the URL
  public void setBaseURL() throws Exception {
		String userPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userPath + "/" +chromeDriver);
		driver = new ChromeDriver();
		Reporter.log("The Chrome browser is opened now.");
		driver.get(baseUrl);
		Reporter.log("The website is opened.");

	}
  
  @Test(priority=0) // Verify the Login Page
  public void verifyLoginPage() throws InterruptedException {
	  
	  login = new LoginPage(driver);
	  login.clickLoginLink();
	  Reporter.log("The login link is clicked.");
	  
	  	String loginPageTitle = login.getLoginTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		Reporter.log("The title of the page is Register");
	  
	  
	  
  }
  
  @Test(priority=1) // Verify the login with empty field
  public void verifyEmptyLoginField() {
	  
	  driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
	  login = new LoginPage(driver);
	  login.clickLoginBtn();
	  Reporter.log("Click on login link without entering the email and password. ");
	  
	  String emptyField = login.getEmptyLoginText();
	  
	  System.out.println("Empty field is: "+emptyField);
	  Assert.assertTrue(emptyField.contains("Error on login"));
	  Reporter.log("The error on the page is displayed: Error on login");
  }
  
	
	  @Test(priority=2) // Verify the login with valid inputs
	  
	  public void verifyValidLogin() {
	  
	  login.userLogin(VideoNotesUser.USER, VideoNotesUser.PASSWORD);	  
	  Reporter.log("Enter the valid email and password.");
	  String successTitle = login.getSuccessLoginTitle(); 
	  String loginText = login.getLoginLinkText(); 
	  Assert.assertTrue(successTitle.equals(loginText));
	  Reporter.log("The name of the username on the right side of the corner and title of the successful login is matched.");
	  Reporter.log("Login successfully.");
	  }
	 

  
  @AfterTest  // Close the browser
  public void afterTest() {
	  
	  driver.quit();
	  Reporter.log("The browser is closed.");
	  
  }

}
