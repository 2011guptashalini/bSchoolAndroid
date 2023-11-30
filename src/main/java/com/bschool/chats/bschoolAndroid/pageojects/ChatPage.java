package com.bschool.chats.bschoolAndroid.pageojects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bschool.chats.bschoolAndroid.AbstractComponents.AbstractComponents;

import io.appium.java_client.android.AndroidDriver;

public class ChatPage extends AbstractComponents {
	
	AndroidDriver driver;
	public ChatPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Chat heading
	@FindBy(xpath="(//android.widget.TextView[@text=\"Chats\"])[1]")
	WebElement chatHeading;
	
	//Recent tab
	@FindBy(xpath="//android.widget.TextView[@text=\"RECENT\"]")
	WebElement recentTab;
	
	//All chats tab
	@FindBy(xpath="//android.widget.TextView[@text=\"ALL CHATS\"]")
	WebElement allChatsTab;
	
	//All chats tab
	@FindBy(xpath="//android.widget.TextView[@text=\"BOISE STATE UNIVERSITY CHATS\"]")
	WebElement boiseStateUniversityChatasTab;
	
	//Recent chats
	@FindBy(xpath="//android.widget.TextView[@text=\"Recent Chat Messages \"]")
	WebElement recentChats;
	
	//Cover image
	@FindBy(xpath="//android.widget.TextView[@text=\"+\"]")
	WebElement coverImages;
	
	//Select an smiley, no xpath as of now
	
	//Group name , no xpath as of now
	
	//Close smileys popup
	@FindBy(xpath="//android.widget.TextView[@text=\"X\"]")
	WebElement closeButtonForSmileys;
	
	//Group type public
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"CreateChatTypePublicButton\"]")
	WebElement groupTypePublic;
	
	//Group type public
	@FindBy(xpath="//android.widget.TextView[@text=\"Add Member\"]")
	WebElement addMember;
	
	//Create group
	@FindBy(xpath="//android.widget.TextView[@text=\"Create Group\"]")
	WebElement createGroup;
	
	//Member 1
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
	WebElement member1;
	
	//Member 2
	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
	WebElement member2;
	
	//Invite member
	@FindBy(xpath="//android.widget.TextView[@text=\"Invite friend\"]")
	WebElement inviteMember;
	
	//This will be used for asserting but need to take the xpath dynamically as it is based on group name
	@FindBy(xpath="//android.widget.TextView[@text=\"techno group\"]")
	WebElement createdGroup;
	
	//Message box
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"auto-complete-text-input\"]")
	WebElement sendMessageTextBox;
	
	//Select a group
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"channel-list-messenger\"]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
	WebElement selectAGroupWithChat;
	
	//Other user message
	@FindBy(xpath="(//android.view.ViewGroup[@resource-id=\"message-simple-wrapper\"])[1]")
	WebElement otherUserMessage;
	

	
	//Methods
	public Boolean VerifyChatHeadingIsDisplayed() {

		Boolean match = chatHeading.isDisplayed();
		return match;

	}
	
	public Boolean VerifyRecentTabIsDisplayed() {

		Boolean match = recentTab.isDisplayed();
		return match;

	}
	public Boolean VerifyBoiseAndStateTabIsDisplayed() {

		Boolean match = boiseStateUniversityChatasTab.isDisplayed();
		return match;

	}
	public Boolean VerifyAllChatsTabIsDisplayed() {

		Boolean match = allChatsTab.isDisplayed();
		return match;

	}
	
	public Boolean VerifyRecentChatsIsDisplayed() {

		Boolean match = recentChats.isDisplayed();
		return match;

	}
	
}
	

