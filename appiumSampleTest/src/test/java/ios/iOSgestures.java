package ios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.HashMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;

public class iOSgestures {
	static IOSDriver driver;
	public static void main (String args[]) throws MalformedURLException {
		  configureApp();
		  touchAndHold();
		  scroll();
		  DateTimePicker();
		  slider();
		  
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20).toMillis(), TimeUnit.MILLISECONDS);
		
	}
	public static void touchAndHold() { 
	driver.findElement (AppiumBy.accessibilityId("Steppers")).click();
	

	WebElement ele = driver.findElement(AppiumBy.iOSClassChain ("**/XCUIElementTypeButton[`label=='Increment'`]"));

	HashMap<String, Object> params = new HashMap<String, Object>();
	params.put("element", ((RemoteWebElement)ele).getId());

	params.put("duration", 5);

	driver.executeScript("mobile:touchAndHold", params);
	}
	
	public static void scroll() {
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'UIKitCatalog'`]")).click();
		
		WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
		
		HashMap<String, Object> scroll = new HashMap<String, Object>();
		scroll.put("element", ((RemoteWebElement)ele).getId());
		
		scroll.put("direction", "down");
		driver.executeScript("mobile:scroll", scroll);
		
		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
		
	}
	public static void DateTimePicker() {
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'UIKitCatalog'`]")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Picker View'`]")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`label == 'Red color component value'`]")).sendKeys("155");
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`label == 'Green color component value'`]")).sendKeys("50");
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`label == 'Blue color component value'`]")).sendKeys("125");
	}
	public static void slider() {
	    driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'UIKitCatalog'`]")).click();
	    driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Sliders'`]")).click();

	    WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == '50%'`][1]"));
	   

	    TouchAction touchAction = new TouchAction(driver);
	    touchAction.press(PointOption.point(199, 267))
	               .moveTo(PointOption.point(344, 268))
	               .release()
	               .perform();

	    System.out.println("Slider value after dragging: " + slider.getAttribute("value"));

	    slider.click();
	    System.out.println("Slider value after clicking: " + slider.getAttribute("value"));
	}

}
