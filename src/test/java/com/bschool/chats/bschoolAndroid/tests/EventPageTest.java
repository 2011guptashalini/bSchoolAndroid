package com.bschool.chats.bschoolAndroid.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bschool.chats.bschoolAndroid.Data.DataReader;
import com.bschool.chats.bschoolAndroid.TestComponents.BaseTest;

public class EventPageTest extends BaseTest {
	@Test(groups= {"Smoke"})
	public void eventPage_displayedTest() 
	{			
		    eventPage = homePage.goToEventPage();
			Boolean match = eventPage.VerifyEventPageDisplayed();
			Assert.assertTrue(match);
			match = eventPage.VerifyAllEventDisplayed();
			Assert.assertTrue(match);
			match = eventPage.VerifyPastEventDisplayed();
			Assert.assertTrue(match);
			
		}
		
	@Test(groups= {"Smoke"})
	public void eventPage_addEventTest() {
		
		eventPage = homePage.goToEventPage();
		eventPage.clickAddEvent();
		eventPage.addImage();
		eventPage.addEventDetails();
		eventPage.createEvent();
		Boolean match = eventPage.VerifyEventIsAdded();
		Assert.assertTrue(match);
	}
	
	@Test(groups= {"Smoke"})
	public void eventPage_viewPastEvents()
	{
		
	}
	
	
		
	}
	
		
