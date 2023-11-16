package com.bschool.chats.bschoolAndroid.TestComponents;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bschool.chats.bschoolAndroid.pageojects.*;

public class BaseTest {
	
	public static AndroidDriver dr;
	public static WebDriver driver;
	Properties prop = new Properties();
	
	// Create objects of pages
	public LaunchPage launchPage = new LaunchPage(dr);
	public LoginPage loginPage = new LoginPage(dr);
	public CreateEventPage createEventPage = new CreateEventPage(dr);

	
	public AndroidDriver initializeDriver(String deviceName) throws MalformedURLException
	{
		//When testing needs to be performed on mobile app, some capabilities will change. 
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("deviceName", deviceName);
				cap.setCapability("platformName", "Android"); 
				cap.setCapability("appPackage","com.bschool.chats");
				cap.setCapability("appActivity","com.bschool.chats.MainActivity");
				dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				return dr;
	}
	
	public void initializeDesktopDriver() throws IOException {
		// Properties extraction
		//Properties prop = new Properties();
		FileInputStream fis = new FileInputStream((System.getProperty("user.dir")+ "//src//main//java//com//bschool//chats//bschoolAndroid//resources//GlobalData.properties"));
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
	
	
	}
	
	@BeforeMethod
	public CreateEventPage logintoApp() throws MalformedURLException
	{
		String deviceName = "Pixel 4 API 33";
		initializeDriver(deviceName);
		
		launchPage.ClickAllow();
		launchPage.ClickSkip();
		
		loginPage.fill_schoolEmail(prop.getProperty("schoolemail"));
		loginPage.fill_password(prop.getProperty("password"));
		loginPage.ClickLogin();
		return createEventPage;	
		
	}
	
	public CreateEventPage logintoSecondDevice() throws MalformedURLException
	{
		String deviceName = "Pixel 4 API 33";
		initializeDriver(deviceName);
		
		launchPage.ClickAllow();
		launchPage.ClickSkip();
		
		loginPage.fill_schoolEmail(prop.getProperty("schoolemail"));
		loginPage.fill_password(prop.getProperty("password"));
		loginPage.ClickLogin();
		return createEventPage;	
		
	}
	
	@AfterMethod
	public void tearDown() {
		dr.close();
	}
	

}
