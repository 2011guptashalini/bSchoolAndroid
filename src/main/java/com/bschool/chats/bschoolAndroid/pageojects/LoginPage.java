package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends AbstractComponents {
	
	AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// This needs to be changed
	@FindBy(id="school_email")
	WebElement school_email;
	
	@FindBy(id="password")
	WebElement password_ele;
	
	@FindBy(id="login")
	WebElement login;
	
	// login to the app
	public CreateEventPage loginApplication(String email, String password) {
		school_email.sendKeys(email);
		password_ele.sendKeys(password);
		login.click();
		CreateEventPage createEventPage = new CreateEventPage(driver);
		return createEventPage;
		
		
	}
	
	
	

}
