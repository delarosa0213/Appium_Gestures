package test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class Appium_Amazon {
	private static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException{
	
	File fil = new File("src/test/resources/resource/");
	File fs = new File(fil, "ApiDemos-debug.apk");

	AndroidDriver ad;
	
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_ANDROID9");
	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	
	try {
		ad = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		ad.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
		ad.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Events\"]")).click();
		ad.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"End Immediately\"]")).click();
		ad.findElement(By.xpath("//android.widget.Button[@content-desc=\"Play\"]")).click();
		
		Thread.sleep(5000);
		
		ad.findElement(By.xpath("//android.widget.CheckBox[@content-desc=\"End Immediately\"]")).click();
		ad.findElement(By.xpath("//android.widget.Button[@content-desc=\"Play\"]")).click();
		
	}
	catch (Exception e){
		System.out.println(e);
	}

}
}
