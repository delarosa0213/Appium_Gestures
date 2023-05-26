package test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class Views {
	private AndroidDriver driver;
	
	public Views(AndroidDriver driver) {
	    this.driver = driver;
	  }
	//longPress gesture
	public void expandableList() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		int x = 140;
		int y = 250;
		int duration = 1000;

		// Create a HashMap object to hold the command parameters
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("x", x);
		params.put("y", y);
		params.put("duration", duration);

		// Use the JavascriptExecutor to execute the long click gesture command
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", params);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("(//android.widget.TextView)[2]")).click();
		
		for (int a = 0; a < 2; a++) {
			driver.navigate().back();
			}
	}
	public void DragAndDrop() {
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		// locate the element to drag
		WebElement dragElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		// perform drag and drop gesture
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("elementId", ((RemoteWebElement) dragElement).getId());
		args.put("endX", 620);
		args.put("endY", 970);
		js.executeScript("mobile: dragGesture", args);
		
		
		driver.navigate().back();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ScrollDown() {
		// locate the element you want to scroll from
		RemoteWebElement scrollFromElement = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Game Controller Input"));

		int startX = 1819;
		int startY = 1626;
		int endY = (int) (startY * 0.1); // adjust this value to change the scroll distance

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release().perform();


	}
  
}
