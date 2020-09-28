package com.testautomation.videonotes.newnote;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testautomation.videonotes.common.VideoNotesUser;
import com.testautomation.videonotes.pageobject.LoginPage;
import com.testautomation.videonotes.pageobject.NewNotePage;

public class NewNoteTestcase {

	public String baseUrl = "http://localhost:3000";
	public String chromeDriver = "chromedriver.exe"; 
	static WebDriver driver;
	NewNotePage newNote;
	LoginPage login;

	@BeforeTest // Open the Chrome browser and get the URL
	public void setBaseURL() throws Exception {
		String userPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userPath + "/" +chromeDriver);
		driver = new ChromeDriver();
		Reporter.log("The Chrome browser is opened now.");
		driver.get(baseUrl);
		Reporter.log("The website is opened.");

	}

	@Test(priority = 0) // Create a new video note
	public void createNewNote() throws InterruptedException {

		newNote = new NewNotePage(driver);
		login = new LoginPage(driver);
		
		login.clickLoginLink();
		Reporter.log("The login link is clicked.");
		login.setEmail(VideoNotesUser.USER);
		Reporter.log("Entered the email.");
		login.setPassword(VideoNotesUser.PASSWORD);
		Reporter.log("Entered the password.");
		login.clickLoginBtn();
		Reporter.log("Clicked on the Login button. ");

		Thread.sleep(2000);
		newNote.clickNewNoteLink();
		Reporter.log("Clicked on the 'new note' link ");
		System.out.println("The title of the page is " + newNote.getNoteText());
		String title = newNote.getNoteText();
		Assert.assertTrue(title.contains("Get started by making a new note."));
		Reporter.log("The title of the page is: Get started by making a new note.");
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);

		long systime = System.currentTimeMillis();

		String text = "Test Automation" + systime;
		newNote.setNoteText(text);
		Reporter.log("The title entered.");
		newNote.clickNoteSubmitBtn();
		Reporter.log("Clicked on the submit button.");
		newNote.enterVideoLink("https://www.youtube.com/watch?v=Nd31XiSGJLw");
		Reporter.log("The YouTube videw link entered");
		newNote.enterVideoTitle("Automation Testing");
		Reporter.log("The title of the Video entered.");
		System.out.println("Before Video Submit");
		newNote.clickVideoSubmitBtn();
		Reporter.log("Clicked on Submit button");
		Thread.sleep(5000);
		newNote.clickAddTimeIcon();
		Reporter.log("Clicked on Add Time Icon.");
		newNote.enterBodyMsg("Selenium");
		Reporter.log("Entered the message Selenium.");
		newNote.clickTimeSubmitBtn();
		Reporter.log("Clicked on submit button.");
		String strNoteText = newNote.validateNoteText();
		
		Assert.assertTrue(strNoteText.equals("Selenium"), "The note Selenium created.");
		Reporter.log("The Selenium note has been created successfully.");
		
	}


	@AfterTest // Close the browser
	public void afterTest() {

		driver.quit();
		 Reporter.log("The browser is closed.");
	}

}
