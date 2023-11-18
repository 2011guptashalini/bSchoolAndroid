package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class CreateEventPage extends AbstractComponents {
	
	AndroidDriver dr;
	public CreateEventPage(AndroidDriver dr) {
		super(dr);
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	
@FindBy(xpath="//h1[text()='News Feed']")
WebElement newsFeed;
	
public Boolean VerifyNewsFeedDisplayed() {
	Boolean match = newsFeed.isDisplayed();
	return match;


}
}
	
	

