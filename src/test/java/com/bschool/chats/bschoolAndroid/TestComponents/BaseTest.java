package com.bschool.chats.bschoolAndroid.TestComponents;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.bschool.chats.bschoolAndroid.pageojects.*;

public class BaseTest {
	
	public static AndroidDriver driver;
	Properties prop = new Properties();
	
	// Create objects of pages
	public LaunchPage launchPage; 
	public LoginPage loginPage;
	public CreateEventPage createEventPage;

	
	public AndroidDriver initializeDriver(String deviceName) throws MalformedURLException, URISyntaxException
	{
		//When testing needs to be performed on mobile app, some capabilities will change. 
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", deviceName);
				cap.setCapability("platformName", "Android"); 
				cap.setCapability("appPackage","com.bschool.chats");
				cap.setCapability("appActivity","com.bschool.chats.MainActivity");
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), cap);
				return driver;
	}
	
	
	
	@BeforeMethod
	public LoginPage logintoApp() throws MalformedURLException, URISyntaxException
	{
		String deviceName = "Pixel 4 API 33";
		initializeDriver(deviceName);
		LaunchPage launchPage = new LaunchPage(driver);
		launchPage.goTo();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;	
		
	}
	
	public LoginPage logintoSecondDevice() throws MalformedURLException, URISyntaxException
	{
		String deviceName = null;
		initializeDriver(deviceName);
		
		LaunchPage launchPage = new LaunchPage(driver);
		launchPage.goTo();
		LoginPage loginPage = new LoginPage(driver);
		
		return loginPage;
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
