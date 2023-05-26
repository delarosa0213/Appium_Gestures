package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Launching {

  static AndroidDriver driver;
  @Test
  public static void configureAppLaunch() throws MalformedURLException{
	  File fil = new File("src/test/resources/resource/");
	  File fs = new File(fil, "PocketBit.apk");
	  
	  AndroidDriver ad;
	  
	  DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_ANDROID9");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	  
	  try {
		  ad = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  }
	  catch(Exception e){
		  System.out.println(e);
	  }
	  driver.findElement(By.id("com.example.proiectmobilebanking:id/login_main_button")).click();
}
  }
