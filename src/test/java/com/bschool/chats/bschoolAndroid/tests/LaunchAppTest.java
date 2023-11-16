package com.bschool.chats.bschoolAndroid.tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.bschool.chats.bschoolAndroid.TestComponents.BaseTest;

public class LaunchAppTest extends BaseTest {
	
	@Test
	public void launchApp() throws MalformedURLException
	{
		String deviceName = "Pixel 4 API 33";
		initializeDriver(deviceName);
		
	}
	

}
