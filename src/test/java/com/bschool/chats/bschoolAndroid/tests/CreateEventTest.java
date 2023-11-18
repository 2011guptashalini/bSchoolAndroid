package com.bschool.chats.bschoolAndroid.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bschool.chats.bschoolAndroid.Data.DataReader;
import com.bschool.chats.bschoolAndroid.TestComponents.BaseTest;

public class CreateEventTest extends BaseTest {
	@Test(dataProvider="getData",groups= {"Smoke"})
	public void createEvent_addTest(HashMap<String,String> input) throws MalformedURLException
	{			
			createEventPage = loginPage.loginApplication(input.get("email"), input.get("password"));
			Boolean match = createEventPage.VerifyNewsFeedDisplayed();
			Assert.assertTrue(match);
		}
		
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
            DataReader dataReader = new DataReader();
			String filePath = System.getProperty("user.dir")+"//src//test//java//com//bschool//chats//bschoolAndroid//Data//LoginCreds.json";
			List<HashMap<String,String>> data = dataReader.getJsonDataToMap(filePath);
			return new Object[][]  {{data.get(0)}};
			
		}
		
	}
	
		
