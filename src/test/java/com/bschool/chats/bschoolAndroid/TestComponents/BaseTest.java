package com.bschool.chats.bschoolAndroid.TestComponents;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.bschool.chats.bschoolAndroid.pageojects.*;

public class BaseTest {
	
	public static AndroidDriver driver;
	Properties prop = new Properties();
	
	// Create objects of pages
	public LaunchPage launchPage; 
	public LoginPage loginPage;
	public HomePage homePage;
	public EventPage eventPage;

	
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
	public HomePage logintoApp() throws MalformedURLException, URISyntaxException
	{
		String deviceName = "Pixel 7 Pro API 30";
		initializeDriver(deviceName);
		launchPage = new LaunchPage(driver);
		launchPage.goTo();
		loginPage = new LoginPage(driver);
		loginPage.loginApplication("ntr8igay4h@mailers.edu.pl", "kingofstl1");
		homePage = new HomePage(driver);
		//loginPage.loginApplication("test", "test");
		return homePage;
		
		
	}
	
	public LoginPage logintoSecondDevice() throws MalformedURLException, URISyntaxException
	{
		String deviceName = null;
		initializeDriver(deviceName);
		
		launchPage = new LaunchPage(driver);
		launchPage.goTo();
		loginPage = new LoginPage(driver);		
		return loginPage;
		
	}

	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		//driver.close();
	}
	

}
