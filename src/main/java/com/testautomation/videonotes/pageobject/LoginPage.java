package com.testautomation.videonotes.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	WebDriver driver;
	
	By loginLink = By.xpath("/html/body/nav/div/ul[1]/li[2]/a");
	
	By userEmail= By.id("session_email");
	
	By password = By.id("session_password");
	
	By loginSubmitBtn = By.cssSelector("body > main > div > div > form > div:nth-child(5) > button > i");
	
	By getLoginTitle = By.xpath("/html/body/main/div/div/h3");
	
	By successLoginTitle = By.xpath("/html/body/main/div/div/header/h2");
	
	By emptyLogin = By.xpath("/html/body/main/div");
	
   
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Click on login link
	public void clickLoginLink() throws InterruptedException {
		
		driver.findElement(loginLink).click();
		
		Thread.sleep(2000);
		}
	
	// Get the text of the username from header of the page
	 public String getLoginLinkText() {
	  
	  return driver.findElement(loginLink).getText(); }
	 
	 // Enter the password
	public void setPassword (String strPassword) {
		
		driver.findElement(password).sendKeys(strPassword);
	}
	
	//Enter the email
	public void setEmail (String strEmail) {
		
		driver.findElement(userEmail).sendKeys(strEmail);
	}
	
	public void clickLoginBtn() {
		
		driver.findElement(loginSubmitBtn).click();
	}
	// Get the title of the login page
	public String getLoginTitle() throws InterruptedException {
		
		Thread.sleep(1000);
		return
				driver.findElement(getLoginTitle).getText();
	}
	
	// Get the successful login title
	public String getSuccessLoginTitle() {
		return
				driver.findElement(successLoginTitle).getText();	}
	
	// Get the error message text after clicking on login button without entering the field
	public String getEmptyLoginText() {
		return
				driver.findElement(emptyLogin).getText();	}
	
	
	public void userLogin(String strEmail,String strPassword ) {
		
		
		this.setEmail(strEmail);
		
		this.setPassword(strPassword);
		
		this.clickLoginBtn();
		
	}
}
