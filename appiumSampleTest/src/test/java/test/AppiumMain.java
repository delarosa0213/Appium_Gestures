package test;

import test.BaseClass;
import test.Preferences;
import test.Views;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumMain {
  private BaseClass base;
  private Preferences pref;
  private Views v;
  
  @BeforeClass
  public void setup() throws MalformedURLException {
	  BaseClass.configureAppLaunch();

	}
  @Test(priority = 1)
  public void preference() {
	  pref = new Preferences(base.driver);
	  pref.wifiSettings();
  }
  
  @Test(priority = 2)
  public void prefPreference() {
	  pref = new Preferences(base.driver);
	  pref.Preference();
  }
  
  @Test(priority = 3)
  public void prefLaunch() {
	  pref = new Preferences(base.driver);
	  pref.Launching();
  }
  
  @Test(priority = 4)
  public void viewClass() {
	  v = new Views(base.driver);
	  v.expandableList();
  }
  
  @Test(priority = 5)
  public void dragANDdrop() {
	  v = new Views(base.driver);
	  v.DragAndDrop();
  }
  
  @Test(priority = 6)
  public void scrollDown() {
	  v = new Views(base.driver);
	  v.ScrollDown();
  }
  

}
