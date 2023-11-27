package com.bschool.chats.bschoolAndroid.AbstractComponents;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableList;

//import org.openqa.selenium.interactions.touch.TouchActions;

// this class will have common methods of the app under test
public class AbstractComponents { 
	
	
	AndroidDriver driver;

	public AbstractComponents(AndroidDriver driver) {
		this.driver = driver;
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
	
	
	public enum ScrollDirection {
		UP,DOWN, LEFT,RIGHT
		
	}
	
	public void scroll(ScrollDirection dir, double scrollRatio) {
		Duration SCROLL_DUR = Duration.ofMillis(300);
		Dimension size = driver.manage().window().getSize();
		Point midPoint = new Point((int)(size.width * 0.5), (int)(size.height * 0.5));
		int bottom = midPoint.y + (int)(midPoint.y * scrollRatio);
		int top = midPoint.y - (int)(midPoint.y * scrollRatio);
		
		int left = midPoint.x - (int)(midPoint.x * scrollRatio);
		int right = midPoint.x + (int)(midPoint.x * scrollRatio);
		
		if (dir == ScrollDirection.UP) {
			swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR );
		}else if (dir == ScrollDirection.DOWN ) {
			swipe(new Point(midPoint.x, bottom),new Point(midPoint.x, top), SCROLL_DUR );
		}else if (dir == ScrollDirection.LEFT) {
			swipe(new Point(left, midPoint.y),new Point(right, midPoint.y),SCROLL_DUR );
		}else if (dir == ScrollDirection.RIGHT) {
			swipe(new Point(right, midPoint.y),new Point(left, midPoint.y),SCROLL_DUR );
		}
		
		
	}
	
	
	
	public void swipe(Point start, Point end, Duration duration) {
		PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) driver).perform(ImmutableList.of(swipe));
		
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
