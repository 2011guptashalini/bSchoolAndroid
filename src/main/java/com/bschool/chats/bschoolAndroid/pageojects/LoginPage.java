package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends AbstractComponents {
	
	AndroidDriver dr;
	public LoginPage(AndroidDriver dr) {
		super(dr);
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	// This needs to be changed
	@FindBy(id="school_email")
	WebElement school_email;
	
	@FindBy(id="password")
	WebElement password_ele;
	
	@FindBy(id="login")
	WebElement login;
	
	public void fill_schoolEmail(String schoolemail) {
		school_email.sendKeys(schoolemail);;
	}
	
	public void fill_password(String password) {
		password_ele.sendKeys(password);;
	}
	
	public void ClickLogin() {
		login.click();
	}
	
	
	

}
