package alert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class BaseClass {
  static AndroidDriver driver;
  
  @BeforeClass
  public static void configureAppLaunch() throws MalformedURLException{
	  File fil = new File("src/test/resources/resource/");
	  File fs = new File(fil, "ApiDemos-debug.apk");
	  
	  DesiredCapabilities cap2 = new DesiredCapabilities();
	  DesiredCapabilities cap = new DesiredCapabilities();
	  
	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_ANDROID9");
	  cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	  

	  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "RedTab1");
	  cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
	  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	  
	  
	  try {
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		  //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap2);
	  }
	  catch(Exception e){
		  System.out.println(e);
	  }
  }
  @AfterClass
  public void closeTest() {
	  //driver.quit();
  }
}
