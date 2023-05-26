package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Preferences{
	private AndroidDriver driver;

	  public Preferences(AndroidDriver drivers) 
	  {
	    this.driver = drivers;
	  }
	  
		public void wifiSettings() {
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Rostel's WiFi");
		
		List<WebElement>buttons = driver.findElements(By.xpath("//android.widget.Button"));
		System.out.println("" + buttons.size());
		buttons.get(1).click();
		
		driver.navigate().back();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void Preference() {
		
		driver.findElement(AppiumBy.accessibilityId("1. Preferences from XML")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[1]")).click();
		
		//EditText Preference
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle1 = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle1, "Enter your favorite animal");
		driver.findElement(By.id("android:id/edit")).sendKeys("Dog");
		List<WebElement>buttons = driver.findElements(By.xpath("//android.widget.Button"));
		System.out.println("" + buttons.size());
		buttons.get(1).click();
		
		//Radio Button
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[3]")).click();
		String alertTitle2 = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle2, "Choose one");
		
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[3]")).click();

		driver.navigate().back();
		driver.navigate().back();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void Launching() {
		driver.findElement(AppiumBy.accessibilityId("2. Launching preferences")).click();
		
		// Find the button element using the class name
		WebElement button = driver.findElement(By.className("android.widget.Button"));
		button.click();
		
		for (int i = 0; i < 10; i++) {
	        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[1]")).click();
	    }
		
		for (int x = 0; x < 3; x++) {
		driver.navigate().back();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
