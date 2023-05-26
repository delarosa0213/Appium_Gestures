package ios;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import java.io.*;


import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import io.appium.java_client.TouchAction;

public class iosSampleLaunching {
	static IOSDriver driver;
	
  public static void main (String args[]) throws MalformedURLException {
	  configureApp();
	  
  }

private static void configureApp() throws MalformedURLException {
	// TODO Auto-generated method stub
	
	File fs = new File("src/test/resources/resource/UIKitCatalog.app");
	XCUITestOptions cap = new XCUITestOptions();
	
	cap.setDeviceName("iPhone 14 Pro");
	cap.setApp(fs.getAbsolutePath());
	cap.setPlatformVersion("16.4");
	cap.setAutomationName("XCUITest");
	cap.setUdid("199638C3-E390-4F92-9972-D24716E4199D");
	
	driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20).toMillis(), TimeUnit.MILLISECONDS);
	
	//clicking the Activity Indicators and wait for 3 secs
//	driver.findElement(By.xpath("(//XCUIElementTypeCell)[1]")).click();	
//	try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	driver.navigate().back();
//	
//	
//	driver.findElement(By.xpath("(//XCUIElementTypeCell)[2]")).click();	
//	try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	driver.navigate().back();
	
	driver.findElement(By.xpath("(//XCUIElementTypeCell)[3]")).click();	
	
	
	// Find the button element long press the BUTTON btn
	WebElement button = driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Button'])[1]"));

	// Create a new TouchAction instance
	TouchAction touchAction = new TouchAction(driver);

	// Perform the long press on the button element
	touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(button)).withDuration(Duration.ofSeconds(2))).release().perform();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// Find the button element long press the BUTTON btn
	WebElement button2 = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"add\"]"));

		// Create a new TouchAction instance
		TouchAction touchAction2 = new TouchAction(driver);

		// Perform the long press on the button element
		touchAction2.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(button2)).withDuration(Duration.ofSeconds(2))).release().perform();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Find the button element long press the BUTTON btn
		WebElement button3 = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"More Info\"]"));

		// Create a new TouchAction instance
		TouchAction touchAction3 = new TouchAction(driver);

		// Perform the long press on the button element
		touchAction3.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(button3)).withDuration(Duration.ofSeconds(2))).release().perform();
				
		try {
		Thread.sleep(3000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// Find the button element long press the BUTTON btn
		WebElement button4 = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"X Button\"]"));

		// Create a new TouchAction instance
		TouchAction touchAction4 = new TouchAction(driver);

		// Perform the long press on the button element
		touchAction4.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(button4)).withDuration(Duration.ofSeconds(2))).release().perform();
						
		try {
		Thread.sleep(3000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		// Find the button element long press the BUTTON btn
		WebElement button5 = driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Button\"])[2]"));

		// Create a new TouchAction instance
		TouchAction touchAction5 = new TouchAction(driver);

		// Perform the long press on the button element
		touchAction5.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(button5)).withDuration(Duration.ofSeconds(2))).release().perform();
				
		try {
		Thread.sleep(3000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		// Find the button element long press the BUTTON btn
		WebElement button6 = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Person\"]"));

		// Create a new TouchAction instance
		TouchAction touchAction6 = new TouchAction(driver);

		// Perform the long press on the button element
		touchAction6.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(button6)).withDuration(Duration.ofSeconds(2))).release().perform();
						
		try {
		Thread.sleep(3000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		// Find the button element long press the BUTTON btn
		WebElement button7 = driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Button\"])[3]"));

		// Create a new TouchAction instance
		TouchAction touchAction7 = new TouchAction(driver);

		// Perform the long press on the button element
		touchAction7.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(button7)).withDuration(Duration.ofSeconds(2))).release().perform();
						
		try {
		Thread.sleep(3000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}		
}
}
