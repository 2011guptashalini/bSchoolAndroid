package com.bschool.chats.bschoolAndroid.AbstractComponents;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

// this class will have common methods of the app under test
public class AbstractComponents { 
	

	
	AndroidDriver dr;

	public AbstractComponents(AndroidDriver dr) {
		this.dr = dr;
		
	}

	public void waitForElement(By findBy)
	{
		//TO DO
	}

}
