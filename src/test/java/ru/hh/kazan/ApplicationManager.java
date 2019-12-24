package ru.hh.kazan;

import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.hh.kazan.helpers.LoginHelper;
import ru.hh.kazan.helpers.NavigationHelper;
import ru.hh.kazan.helpers.ResumeHelper;
import ru.hh.kazan.models.ResumeData;
import ru.hh.kazan.models.UserData;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  private NavigationHelper navigationHelper;
  private LoginHelper loginHelper;
  private ResumeHelper resumeHelper;
  private Settings settings = new Settings();

  private static ThreadLocal<ApplicationManager> app = new ThreadLocal<ApplicationManager>();

  private ApplicationManager() throws Exception {

    System.setProperty("webdriver.gecko.driver", "D:/Temp/geckodriver-v0.26.0-win64/geckodriver.exe");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    navigationHelper = new NavigationHelper(this, settings.getBaseUrl());
    loginHelper = new LoginHelper(this);
    resumeHelper = new ResumeHelper(this);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public static ApplicationManager getInstance() throws Exception {
    if (app != null){
      ApplicationManager newInstance = new ApplicationManager();
      //newInstance.getNavigationHelper().openHomePage();
      app.set(newInstance);
    }
    return app.get();
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public LoginHelper getLoginHelper() {
    return loginHelper;
  }

  public ResumeHelper getResumeHelper() {
    return resumeHelper;
  }


  public void stop(){
    try {
      driver.quit();
    }catch (Exception e){
      //ignore
    }
  }

}
