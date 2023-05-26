package alert;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


public class AppiumMain {
	private BaseClass base;
	private AlertDialog al;

//	@BeforeClass
//	public void setup() throws MalformedURLException {
//		BaseClass.configureAppLaunch();
//		
//	}
	
	@Test(threadPoolSize = 2, invocationCount = 1)
	public void ad() throws MalformedURLException {
		BaseClass.configureAppLaunch();
	}

	@Test(priority = 1)
	public void al1() {
		al = new AlertDialog(base.driver);
		al.nav();
	}

	@Test(priority = 2)
	public void al2() {
		al = new AlertDialog(base.driver);
		al.alert1();
	}
	@Test(priority = 3)
	public void al3() {
		al = new AlertDialog(base.driver);
		al.alert2();
	}
	@Test(priority = 4)
	public void al4() {
		al = new AlertDialog(base.driver);
		al.alert3();
	}
	@Test(priority = 5)
	public void al5() {
		al = new AlertDialog(base.driver);
		al.alert4();
	}
	@Test(priority = 7)
	public void al7() {
		al = new AlertDialog(base.driver);
		al.alert5();
	}
	@Test(priority = 8)
	public void al8() {
		al = new AlertDialog(base.driver);
		al.alert6();
	}
	@Test(priority = 9)
	public void al9() {
		al = new AlertDialog(base.driver);
		al.alert7();
	}
	@Test(priority = 10)
	public void al10() {
		al = new AlertDialog(base.driver);
		al.alert8();
	}
	@Test(priority = 11)
	public void al11() {
		al = new AlertDialog(base.driver);
		al.alert9();
	}
	@Test(priority = 11)
	public void al12() {
		al = new AlertDialog(base.driver);
		al.alert10();
	}
}
