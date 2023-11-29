package com.bschool.chats.bschoolAndroid.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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

public class ChatPageTest extends BaseTest {
	@Test(groups= {"Smoke"})
	public void eventPage_displayedTest() 
	{			
		    chatPage = homePage.goToChatPage();
		    Boolean match = chatPage.VerifyChatHeadingIsDisplayed();
			Assert.assertTrue(match, "Chat Heading is displayed");
			match = chatPage.VerifyRecentTabIsDisplayed();
			Assert.assertTrue(match, "Recent tab is displayed");
			match = chatPage.VerifyAllChatsTabIsDisplayed();
			Assert.assertTrue(match, "All chat tab is displayed");
			match = chatPage.VerifyBoiseAndStateTabIsDisplayed();
			Assert.assertTrue(match, "Boise and state university tab is displayed");
			match = chatPage.VerifyRecentChatsIsDisplayed();
			Assert.assertTrue(match, "Recent chats are displayed");
			
		}
		
}