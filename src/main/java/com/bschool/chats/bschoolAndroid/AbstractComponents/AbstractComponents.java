package com.bschool.chats.bschoolAndroid.AbstractComponents;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.*;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// this class will have common methods of the app under test
public class AbstractComponents { 
	
	
	AndroidDriver driver;

	public AbstractComponents(AndroidDriver dr) {
		this.driver = dr;
		PageFactory.initElements(driver, this);
		
	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	
	public void scrollApp () {
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,250)");
		
		//int startX = driver.manage().window().getSize().width / 2;
        //int startY = driver.manage().window().getSize().height / 2;
        //int endY = driver.manage().window().getSize().height / 4;

        //TouchAction touchAction = new TouchAction(driver);
        //touchAction.press(PointOption.point(startX, startY))
      //.moveTo(PointOption.point(startX, endY))
               // .release()
               // .perform();
		final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    var start = new Point(1078, 2160);
	    var end = new Point (1137, 413);
	    var swipe = new Sequence(finger, 1);
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
	        PointerInput.Origin.viewport(), start.getX(), start.getY()));
	    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
	        PointerInput.Origin.viewport(), end.getX(), end.getY()));
	    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    driver.perform(Arrays.asList(swipe));
		
	}
	
	public void waitForAWhile(int secs) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
}
	
	//Application specific methods and elements
	@FindBy(xpath="//android.widget.TextView[@text=\"Events\"]")
	WebElement eventMenuElement;
	
	public void clickEvent() {
		eventMenuElement.click();
	}
	
	
}
