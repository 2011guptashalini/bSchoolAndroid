package com.bschool.chats.bschoolAndroid.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.bschool.chats.bschoolAndroid.pageojects.*;


public class BaseTestBS {
	
	public static AndroidDriver driver;
	public static AndroidDriver driver1;
	Properties prop = new Properties();
	
	// Create objects of pages
	public LaunchPage launchPage; 
	public LoginPage loginPage;
	public HomePage homePage;
	public EventPage eventPage;
	public ChatPage chatPage;
	
	public AndroidDriver initializeDriver(String deviceName) throws URISyntaxException, IOException
	{
		//When testing needs to be performed on mobile app, some capabilities will change.
		
		//Path to apk file
		        
				//String apkPath = System.getProperty("user.dir")+"/app-debug.apk";	
		        
		  String userName = "shalinig_Io3WYc";
	      String accessKey = "eTWGdzWxEcL1fzKqGGaD";
	     
	     // String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
	//      String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
	      //String app = System.getenv("BROWSERSTACK_APP_ID");
	
	      
	      DesiredCapabilities capabilities = new DesiredCapabilities();
	      //capabilities.setCapability("autoGrantPermissions", true);
	      capabilities.setCapability("os_version", "13.0");
	      capabilities.setCapability("interactiveDebugging", true);
	      capabilities.setCapability("deviceName", "Google Pixel 7 Pro");
	      capabilities.setCapability("app", "bs://ba39209dbcf5e0eba6b4cb3e891382550ac401e4");
	      capabilities.setCapability("project", "bschool");
	      capabilities.setCapability("build", "debug");
	      capabilities.setCapability("name", "bSchool");
	      capabilities.setCapability("browserstack.appium_version", "1.22.0");

	
	//      URL url = new URL("https://hub-cloud.browserstack.com/wd/hub");
	//      URL url = new URL("https://hub.browserstack.com/wd/hub");
	      URL url = new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub");
	
	      driver = new AndroidDriver(url, capabilities);
	              
   
 
		// Specify the path of the photo you want to send
		//String photoPath = System.getProperty("user.dir")+"//testphoto.jpeg";
		//File photo = new File(photoPath);
        
        // Push the photo file to the device
        //driver.pushFile("/sdcard/Pictures/photo.jpg", photo);
		return driver;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public HomePage logintoApp() throws URISyntaxException, IOException
	{
		//String deviceName = "Pixel 7 Pro API 30";
		String dName = getProp("device_name");
		initializeDriver(dName);
		launchPage = new LaunchPage(driver);
		launchPage.goTo();
		loginPage = new LoginPage(driver);
		loginPage.loginApplication(getProp("schoolemail"), getProp("password"));
		homePage = new HomePage(driver);
		//loginPage.loginApplication("test", "test");
		return homePage;
		
		
	}
	
	public HomePage logintoSecondDevice() throws URISyntaxException, IOException
	{
		//String deviceName = null;
		String dName = getProp("second_device_name");
		initializeDriver(dName);
		
		launchPage = new LaunchPage(driver);
		launchPage.goTo();
		loginPage = new LoginPage(driver);	
		
		loginPage.loginApplication(getProp("second_school_email"), getProp("password"));
		homePage = new HomePage(driver);
		return homePage;
		
	}
	public String getScreenshot(String testCaseName,AndroidDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	public String getProp(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java/com//bschool//chats//bschoolAndroid//resources//GlobalData.properties");
		prop.load(fis);
		String keyValue = prop.getProperty(key);
		return keyValue;
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		//driver.removeApp("com.bschool.chats");
		driver.close();
		
	}
	
}