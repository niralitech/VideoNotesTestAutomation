package com.testautomation.videonotes.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	
	WebDriver driver;
	
	By registerLink = By.xpath("/html/body/nav/div/ul[1]/li[3]/a");
	
	By username = By.id("user_username");
	
	By userEmail= By.id("user_email");
	
	By password = By.id("user_password");
	
	By registerSubmitBtn = By.cssSelector("body > main > div > div > form > div:nth-child(6) > button");
	
	By getRegisterTitle = By.xpath("/html/body/main/div/div/h3");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	// Click on the register link
	public void clickRegisterLink() throws InterruptedException {
		
		driver.findElement(registerLink).click();
		
		Thread.sleep(2000);
		}
	// Enter the username
	public void setUsername(String strUsername) {
		
		driver.findElement(username).sendKeys(strUsername);
	}
	
	// Enter the password
	public void setPassword (String strPassword) {
		
		driver.findElement(password).sendKeys(strPassword);
	}
	
	// Enter the Email
	public void setEmail (String strEmail) {
		
		driver.findElement(userEmail).sendKeys(strEmail);
	}
	
	// Click on the register button
	public void clickRegisterBtn() {
		
		driver.findElement(registerSubmitBtn).click();
	}
	
	// Get the title after the successful registration
	public String getRegisterTitle() throws InterruptedException {
	
		Thread.sleep(1000);
		return
				driver.findElement(getRegisterTitle).getText();
	}
	
	
	
	public void registerUser(String strUsername,String strEmail,String strPassword ) {
		
		this.setUsername(strUsername);
		
		this.setEmail(strEmail);
		
		this.setPassword(strPassword);
		
		this.clickRegisterBtn();
		
	}
}
