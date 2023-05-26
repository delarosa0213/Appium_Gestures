package alert;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AlertDialog {
	private AndroidDriver driver;

	public AlertDialog(AndroidDriver driver) {
		this.driver = driver;
	}

	public void nav() {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
	}

	public void alert1() {
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
	}
	public void alert2() {
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
	}
	public void alert3() {
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
	}		
	public void alert4() {
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		driver.findElement(By.xpath("(//android.widget.TextView)[2]")).click();
		driver.navigate().back();
	}
	public void alert5() {
		driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void alert6() {
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]")).click();
		
		//clicking the checkboxes
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[3]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[4]")).click();
		
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
	}
	public void alert7() {
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[1]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[3]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[5]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[6]")).click();
		driver.findElement(By.xpath("(//android.widget.CheckedTextView)[7]")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
	}
	public void alert8() {
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Rostel");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("rostel");
		
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
	}
	public void alert9() {
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[1]")).click();
	}
	public void alert10() {	
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
	}
}
