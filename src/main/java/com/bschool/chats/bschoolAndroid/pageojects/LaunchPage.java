package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class LaunchPage extends AbstractComponents {
	
	AndroidDriver dr;
	public LaunchPage(AndroidDriver dr) {
		super(dr);
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	// This needs to be changed
	
	@FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	WebElement allow;
	
	@FindBy(id="skip")
	WebElement skip;
	
	@FindBy(id="login")
	WebElement login;
	
	public void ClickAllow() {
		allow.click();
	}
	
	public void ClickSkip() {
		login.click();
	}
	
	

}
