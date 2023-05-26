package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class sampleLaunch {
    static AndroidDriver<WebElement> driver;

    public static void main(String[] args) throws MalformedURLException {
        configureAppLaunch();
        btnReg();
//        btnClick();
        credentials();
        transacHistory();
        transactions();
        DeleteAcc();
        credentials();
    }
    
    public static void configureAppLaunch() throws MalformedURLException {
        File fil = new File("src/test/resources/resource/");
        File fs = new File(fil, "PocketBit.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_ANDROID9");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        
        
    }
    public static void btnReg() {
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/register_button_main")).click();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_firstName")).sendKeys("Red");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_lastName")).sendKeys("dela Rosa");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_email")).sendKeys("rostel@gmail.com");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_iban")).sendKeys("63987654321");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_password")).sendKeys("rostel");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_confirmPassword")).sendKeys("rostel");
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/rb_male")).click();
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/bt_register")).click();
    }

    public static void btnClick() {
    	WebElement button = driver.findElement(By.className("android.widget.Button"));
		button.click();
    }
    public static void credentials() {
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/tv_username")).sendKeys("rostel@gmail.com");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/tv_password")).sendKeys("rostel");
    	
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/login_button")).click();
    }
    public static void transacHistory() {
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnHistory")).click();
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/fabAdd")).click();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Add 1st acc
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_beneficiary2")).sendKeys("Red dela Rosa");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_accountNumber2")).sendKeys("63123456789");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_amount2")).sendKeys("5000");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btn_send2")).click();
    	
    	//add 2nd acc
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/fabAdd")).click();
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_beneficiary2")).sendKeys("R dela Rosa");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_accountNumber2")).sendKeys("63012345678");
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/et_amount2")).sendKeys("4000");
    	
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/spinner_status")).click();
    	driver.findElement(By.xpath("(//android.widget.TextView)[2]")).click();
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btn_send2")).click();
    	
    	String firstAcc = driver.findElement(By.xpath("(//android.widget.TextView)[1]")).getText();
    	System.out.println("Validated First Account: " + firstAcc);
    	
    	driver.findElement(By.xpath("(//android.view.ViewGroup)[4]")).click();
    	String secAcc = driver.findElement(By.xpath("(//android.widget.TextView)[5]")).getText();
    	System.out.println("Validated Second Account: " + secAcc);
    }
    public static void transactions() {
    	driver.navigate().back();
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnRaport")).click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnRaportAmount")).click();
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/etRaportAmount")).sendKeys("500");
    	
    	driver.findElement(By.id("com.example.proiectmobilebanking:id/btnViewRaportAmount")).click();
    	
    	//validating 1st account
    	WebElement firstAcc = driver.findElement(By.xpath("(//android.widget.TextView)[1]"));
    	if(firstAcc.isDisplayed()) {
    	    System.out.println("Element is displayed");
    	} else {
    	    System.out.println("Element is not displayed");
    	}
    	
    	//validating 2nd acc
    	WebElement secAcc = driver.findElement(By.xpath("(//android.widget.TextView)[5]"));
    	if(secAcc.isDisplayed()) {
    	    System.out.println("Element is displayed");
    	} else {
    	    System.out.println("Element is not displayed");
    	}

    }
    
    
    public static void DeleteAcc() {
    	driver.navigate().back();
    	driver.navigate().back();
    	
    	WebElement delBtn = driver.findElement(By.id("com.example.proiectmobilebanking:id/btnDeleteAccount"));
    	
    	if (delBtn.isDisplayed()) {
    		delBtn.click();
    	}
    	else {
    		System.out.println("Element is not available");
    	}
    }
}
