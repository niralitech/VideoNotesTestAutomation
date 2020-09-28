package com.testautomation.videonotes.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testautomation.videonotes.common.VideoNotesUser;
import com.testautomation.videonotes.pageobject.RegisterPage;

import junit.framework.Assert;

public class RegisterUserTestcase {

	public String baseUrl = "http://localhost:3000";
	public String chromeDriver = "chromedriver.exe"; 
	static WebDriver driver;
	RegisterPage register;


	@BeforeTest  // Open the Chrome browser and get the URL
	public void setBaseURL() throws Exception {
		String userPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userPath + "/" +chromeDriver);
		driver = new ChromeDriver();
		Reporter.log("The Chrome browser is opened now.");
		driver.get(baseUrl);
		Reporter.log("The website is opened.");

	}

	@Test(priority = 0) // Verify the Register page
	public void verifyRegisterPage() throws InterruptedException {

		register = new RegisterPage(driver);

		register.clickRegisterLink();
		Reporter.log("Click on the register link.");

		String registerPageTitle = register.getRegisterTitle();
		Assert.assertTrue(registerPageTitle.contains("Register"));
		Reporter.log("The title of the page is Register");

	}

	@Test(priority = 1) // Verify the valid Registration

	public void verifyValidRegistration() throws InterruptedException {

		long systime = System.currentTimeMillis();
		String userName = "user" + "-" + systime + "@domain.com";
		//Store in a static variable to be used by other testcases
		VideoNotesUser.USER = userName;
		VideoNotesUser.PASSWORD = String.valueOf(systime);
		register.registerUser(userName, userName , String.valueOf(systime));
		Reporter.log("The valid username, email and password entered. ");
		String registerPageTitle = register.getRegisterTitle();
		System.out.println("registerPageTitle=" + registerPageTitle + ", assert="
				+ registerPageTitle.equals("Get started by making a new note."));
		Assert.assertTrue(registerPageTitle.equals("Get started by making a new note."));
		Reporter.log("The title of the page is: Get started by making a new note.");
		Reporter.log("The registration is successful");

	}

	@AfterTest  // Close the browser
	public void afterTest() {

		driver.quit();
		Reporter.log("The browser is closed.");
	}

}
