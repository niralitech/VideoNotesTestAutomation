package com.testautomation.videonotes.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NewNotePage {

	WebDriver driver;

	By newNoteLink = By.xpath("/html/body/nav/div/ul[1]/li[1]/a");

	By noteTitleInput = By.id("note_title");

	By noteText = By.xpath("/html/body/main/div/div/h3");

	By noteSubmitBtn = By.cssSelector("body > main > div > div > form > div:nth-child(5) > button > i");

	By clickUsername = By.xpath("/html/body/nav/div/ul[1]/li[2]/a");

	By clickFirstNote = By.cssSelector("body > main > div > div > table > tbody > tr > td:nth-child(1) > a");

	By videoTitleText = By.id("note-show-title");

	By videoLinkInput = By.id("video_link");

	By videoTitleInput = By.id("video_title");

	By videoSubmitBtn = By.cssSelector("#video-submit > i");

	By clickAddTime = By.id("get-time");

	By getTimeInput = By.id("time-input");

	By messageBodyText = By.id("textarea1");

	By timeSubmitBtn = By.cssSelector(
			"body > main > div > div.row > div:nth-child(1) > div:nth-child(2) > div > form > div:nth-child(3) > div.col.s1 > button > i");

	By validateNote = By.xpath("/html/body/main/div/div[3]/div[2]/div/div/div/div/ul/li/div[1]/div[1]/div[2]/div");

	public NewNotePage(WebDriver driver) {
		this.driver = driver;
	}
	// Click on new note link
	public void clickNewNoteLink() throws InterruptedException {

		driver.findElement(newNoteLink).click();

		Thread.sleep(2000);
	}
	// Get the text of the title for new note
	public String getNoteText() {

		return driver.findElement(noteText).getText();
	}
	// Enter the title in the input field
	public void setNoteText(String strText) {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(noteTitleInput));
		actions.click();
		actions.sendKeys(strText);
		actions.build().perform();

	}
	// Click on the submit button for the new note
	public void clickNoteSubmitBtn() {

		driver.findElement(noteSubmitBtn).click();
	}

	// Enter the YouTube Video link 
	public void enterVideoLink(String strLink) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(videoLinkInput));
		actions.click();
		actions.sendKeys(strLink);
		actions.build().perform();
	}
	// Enter the video title
	public void enterVideoTitle(String strTitle) {

		driver.findElement(videoTitleInput).sendKeys(strTitle);
	}
	// Click on the video submit button
	public void clickVideoSubmitBtn() {

		driver.findElement(videoSubmitBtn).click();
	}
	// Click on plus button to add time
	public void clickAddTimeIcon() {

		driver.findElement(clickAddTime).click();

	}

	// Enter the message
	public void enterBodyMsg(String strMsg) {

		driver.findElement(messageBodyText).sendKeys(strMsg);
	}
	// Click on the submit button
	public void clickTimeSubmitBtn() {

		driver.findElement(timeSubmitBtn).click();
	}
	// Validate the text of the note
	public String validateNoteText() {

		return driver.findElement(validateNote).getText();
	}
}
