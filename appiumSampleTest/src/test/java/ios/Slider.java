package ios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Slider {
static IOSDriver driver;
	
//	public static void main(String args[]) throws MalformedURLException, InterruptedException {
//		configureApp();
//		slider1();
//	}
	@BeforeClass
	private void configureApp() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		File fs = new File("src/test/resources/resource/UIKitCatalog.app");
		XCUITestOptions cap = new XCUITestOptions();
		
		cap.setDeviceName("iPhone 14 Pro Max");
		cap.setApp(fs.getAbsolutePath());
		cap.setPlatformVersion("16.4");
		cap.setAutomationName("XCUITest");
		cap.setUdid("14714F30-2473-4253-80F2-1CCB4A0AB899");
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20).toMillis(), TimeUnit.MILLISECONDS);
		
	}
	
	@Test
	public void slider1() {

		driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
		

		WebElement slider1 = driver.findElement(By.xpath("//XCUIElementTypeSlider"));
		slider1.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("direction", "left");
		params.put("element", ((RemoteWebElement) slider1).getId());
		//params.put("value", 0);
		js.executeScript("mobile: swipe", params);

		//test.log(LogStatus.INFO, "Performed swipe gesture on the slider");
	}
	
}

