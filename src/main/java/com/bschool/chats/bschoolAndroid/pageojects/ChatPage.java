package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class ChatPage extends AbstractComponents {
	
	AndroidDriver driver;
	public ChatPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Chat heading
	@FindBy(xpath="(//android.widget.TextView[@text=\"Chats\"])[1]")
	WebElement chatHeading;
	
	//Recent tab
	@FindBy(xpath="//android.widget.TextView[@text=\"RECENT\"]")
	WebElement recentTab;
	
	//All chats tab
	@FindBy(xpath="//android.widget.TextView[@text=\"ALL CHATS\"]")
	WebElement allChatsTab;
	
	//All chats tab
	@FindBy(xpath="//android.widget.TextView[@text=\"BOISE STATE UNIVERSITY CHATS\"]")
	WebElement boiseStateUniversityChatasTab;
	
	//Recent chats
	@FindBy(xpath="//android.widget.TextView[@text=\"Recent Chat Messages \"]")
	WebElement recentChats;
	
	
	//Methods
	public Boolean VerifyChatHeadingIsDisplayed() {

		Boolean match = chatHeading.isDisplayed();
		return match;

	}
	
	public Boolean VerifyRecentTabIsDisplayed() {

		Boolean match = recentTab.isDisplayed();
		return match;

	}
	public Boolean VerifyBoiseAndStateTabIsDisplayed() {

		Boolean match = boiseStateUniversityChatasTab.isDisplayed();
		return match;

	}
	public Boolean VerifyAllChatsTabIsDisplayed() {

		Boolean match = allChatsTab.isDisplayed();
		return match;

	}
	
	public Boolean VerifyRecentChatsIsDisplayed() {

		Boolean match = recentChats.isDisplayed();
		return match;

	}
	
}
	

