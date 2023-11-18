package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class LaunchPage extends AbstractComponents {
	
	AndroidDriver driver;
	public LaunchPage(AndroidDriver dr) {
		super(dr);
		this.driver = dr;
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
		skip.click();
	}
	
	public void ClickLoginLink() {
		login.click();
	}
	
	// Reaching to login page
	public LoginPage goTo() {
		ClickAllow();
		ClickSkip();
		ClickLoginLink();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
		
	}

	
	

}
