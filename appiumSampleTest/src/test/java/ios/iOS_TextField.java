package ios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class iOS_TextField {

	static IOSDriver driver;
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		configureApp();
		//textField();
		//switches();
		//stackviews();
		datePick();
	}
	private static void configureApp() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		File fs = new File("src/test/resources/resource/UIKitCatalog.app");
		XCUITestOptions cap = new XCUITestOptions();
		
		cap.setDeviceName("iPhone 14 Pro Max");
		cap.setApp(fs.getAbsolutePath());
		cap.setPlatformVersion("16.4");
		cap.setAutomationName("XCUITest");
		cap.setUdid("199638C3-E390-4F92-9972-D24716E4199D");
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20).toMillis(), TimeUnit.MILLISECONDS);
		
	}
	public static void textField() {
		driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == 'Placeholder text'`][3]")).sendKeys("green");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == 'Placeholder text'`][1]")).sendKeys("red");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == 'Placeholder text'`][2]")).sendKeys("blue");
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == 'Placeholder text'`]")).sendKeys("tinted");

		driver.findElement(By.xpath("//XCUIElementTypeSecureTextField")).sendKeys("pink");
		
		
	}
	public static void switches() {
		driver.findElement(AppiumBy.accessibilityId("Switches")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value == '1'`][1]")).click();

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value == '1'`]")).click();
	}
	public static void stackviews() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Stack Views")).click();
		driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"stepper increment\"])[1]")).click();
		//**/XCUIElementTypeButton[`label == "stepper increment"`][1]
		Thread.sleep(2000);
		
		boolean further = driver.findElement(AppiumBy.accessibilityId("Further Detail")).isDisplayed();
		System.out.println("Further Detail is displayed: " + further);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"stepper increment\"])")).click();
		System.out.println("The color is not red");
		
	}
	public static void datePick() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Date Picker")).click();
        //driver.findElement(By.xpath("//XCUIElementTypeButton[5]")).click();
        driver.findElement(AppiumBy.accessibilityId("Date and Time Picker")).click();
        boolean pickerWheelSendKeys = false;
        boolean staticTextClickable =  driver.findElement(AppiumBy.accessibilityId("Next Month")).isEnabled();
        
        
        if (staticTextClickable) {
        	driver.findElement(AppiumBy.accessibilityId("Next Month")).click();
            pickerWheelSendKeys = true;
        } else {
            System.out.println("Element not clickable, cannot  change month");
        }
        
        if (pickerWheelSendKeys) {
            driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`value == 'May'`]")).sendKeys("June");
        } else {
            System.out.println("Cannot send keys to the element");
        }
        
        Thread.sleep(2000);
        
        driver.findElement(AppiumBy.accessibilityId("PopoverDismissRegion")).click();

}
}
