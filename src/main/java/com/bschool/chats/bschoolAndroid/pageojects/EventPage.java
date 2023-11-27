package com.bschool.chats.bschoolAndroid.pageojects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.PointerInput.Origin;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class EventPage extends AbstractComponents {
	
	AndroidDriver driver;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String timeStamp = sdf.format(new Date());
    String EventName = "Automation Event: " + timeStamp;
	
	public EventPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//This needs to be changed
	


	@FindBy(xpath="(//android.widget.TextView[@text=\"Events\"])[1]")
	WebElement eventPageElement;	

	@FindBy(xpath="//android.widget.TextView[@text=\"All Events\"]")
	WebElement allEventElement;

	@FindBy(xpath="//android.widget.TextView[@text=\"Past Events\"]")
	WebElement pastEventElement;

	@FindBy(xpath="//android.widget.TextView[@text=\"26\"]")
	WebElement dateElement;

	
	
	//Add event 
	
	//Add event button
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"AddEventButton\"]")
	WebElement addEventElement;
	
	// Add Image 
	@FindBy(xpath="//android.widget.TextView[@text=\"Add Image\"]")
	WebElement addEvenAddImageElement;
	
	//Click Photo of phone 
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/app_icon\"])[2]")
	WebElement addEvenPhotoElement;
	
	//Add recent photo
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"]")
	WebElement addEventRecentElement;
	
	//Event Name Text box
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"EventName\"]")
	WebElement addEventNameElement;

	//Select type dropdown
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"EventsSelectTypeButton\"]")
	WebElement addEventSelectTypeElement;
	
	//Select type public element
	@FindBy(xpath="//android.widget.TextView[@text=\"Public\"]")
	WebElement addEventSelectTypePublicElement;
	
	//Select category
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"EventsSelectCategory\"]")
	WebElement addEventSelectCategoryElement;
	
	//Select category as entertainment
	@FindBy(xpath="//android.widget.TextView[@text=\"Entertainment\"]")
	WebElement addEventSelectCategoryEntertainmentElement;
	
	//Select start date and time
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"EventsSelectStartDateTimeButton\"]")
	WebElement addEventStartTimeAndDateElement;
	
	//Select Done
	@FindBy(xpath="//android.widget.TextView[@text=\"Done\"]")
	WebElement addEventSelectDateDoneElement;
	
	
	//Select end date time and date
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"SelectEventsEndTime\" and @text=\"End Time and date\"]")
	WebElement addEventEndTimeAndDateElement;
	
	//Short description
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"EventsShortDescription\"]")
	WebElement addEventShortDescriptionElement;
	
	//Location
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Select Location\"]")
	WebElement addEventSelectLocationElement;
	
	//Location text box
	@FindBy(xpath="//android.widget.EditText[@text=\"Type a place\"]")
	WebElement addEventTypeLocationElement;
		
	//Add link
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Add Link\"]")
	WebElement addEventAddLinkElement;
	
	//Create Event button
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"CreateEventSubmitButton\"]")
	WebElement addEventCreateEventElement;
	
	//Deny button
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
	WebElement addEventDenyElement;
	
	//Ok Button
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	WebElement addEventOKElement;
	
	//Got it
	//@FindBy(xpath="//android.widget.Button[@resource-id=\"com.google.android.calendar:id/done_button\"]")
	//WebElement addEventGotItElement;
	
	//Select color and Graphite
	//@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.google.android.calendar:id/first_line_text\" and @text=\"Graphite\"]")
	//WebElement addEventColorElement;
	
	//Save event
	//@FindBy(xpath="//android.widget.Button[@resource-id=\"com.google.android.calendar:id/save\"]")
	//WebElement addEventSaveElement;
	
	//Save event
	
	public WebElement dynamicXpathGenerator(String str) {
		String xpathStr = "\"" + str + "\"";
		WebElement dynamicXpath = driver.findElement(By.xpath("//android.widget.TextView[@text="+xpathStr+"]"));
		return dynamicXpath;
	}
	
	
	
	

	public void clickAddEvent() {
		addEventElement.click();
	}
	
	public void addImage() {
		addEvenAddImageElement.click();
		waitForAWhile(15);
		addEventRecentElement.click();
		
			
	}
	
	//Method to fill details of event
	public void addEventDetails() {
		
		waitForAWhile(10);
		addEventNameElement.sendKeys(EventName);
		addEventSelectTypeElement.click();
		waitForAWhile(10);
		addEventSelectTypePublicElement.click();
		addEventSelectCategoryElement.click();
		addEventSelectCategoryEntertainmentElement.click();
		addEventStartTimeAndDateElement.click();
		addEventSelectDateDoneElement.click();
		waitForAWhile(60);
		addEventEndTimeAndDateElement.click();
		addEventSelectDateDoneElement.click();
		addEventShortDescriptionElement.sendKeys("This is a short description");	
		scroll(ScrollDirection.DOWN, 0.5);
		
	}

	
	//Method to create event and handling google related stuff
	public void createEvent()
	{
		
		addEventCreateEventElement.click();
		addEventDenyElement.click();
		addEventOKElement.click();	
		waitForAWhile(20);
		scroll(ScrollDirection.DOWN, 1.0);
		
	}
	
	
	public Boolean VerifyEventPageDisplayed() {

		Boolean match = eventPageElement.isDisplayed();
		return match;

	}
	
	public Boolean VerifyAllEventDisplayed() {
		Boolean match = allEventElement.isDisplayed();
		return match;

	}
	public Boolean VerifyPastEventDisplayed() {
		Boolean match = pastEventElement.isDisplayed();
		return match;

	}
	
	public Boolean VerifyEventIsAdded() {
		
		WebElement addedEvent = dynamicXpathGenerator(EventName);
		Boolean match = addedEvent.isDisplayed();
		return match;
		
		//Boolean match = addEventSaveElement.isDisplayed();	
		//return match;

	}
	

}
