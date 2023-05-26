package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidDebugRealDevice {
private static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException{
	
	File fil = new File("src/test/resources/resource/");
	File fs = new File(fil, "ApiDemos-debug.apk");

	AndroidDriver ad;

	
	DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi 12T");
    cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	
	
	try {
		ad = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
	catch (Exception e){
		System.out.println(e);
	}
	
	}
}
