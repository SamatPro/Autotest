package ru.hh.kazan.helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.hh.kazan.ApplicationManager;
import ru.hh.kazan.models.UserData;

public class LoginHelper extends HelperBase {
  public LoginHelper(ApplicationManager applicationManager) {
    super(applicationManager);
  }

  public void logout() {
    driver.findElement(By.cssSelector(".supernova-logo")).click();
    driver.findElement(By.cssSelector(".supernova-icon_profile")).click();

    Assert.assertEquals("Выход", driver.findElement(By.cssSelector("form > .supernova-dropdown-option")).getAttribute("value"));


    driver.findElement(By.cssSelector("form > .supernova-dropdown-option")).click();
  }

  public void login(UserData userData) {

    if (isLoggedIn()){
      if (isLoggedIn(userData.getLogin())){
        return;
      }
      logout();
    }

    {
      WebElement element = driver.findElement(By.name("username"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.name("username"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.name("username"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys(userData.getLogin());
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys(userData.getPassword());
    driver.findElement(By.cssSelector(".bloko-checkbox__text")).click();
    driver.findElement(By.cssSelector(".bloko-button_primary")).click();

    //isLoggedIn("tukimuki@list.ru");

  }

  public boolean isLoggedIn(){
    Cookie cookie = driver.manage().getCookieNamed("crypted_id");
    return cookie != null;
  }

  public boolean isLoggedIn(String username){
    driver.get("https://kazan.hh.ru/applicant/settings?from=header_new");
    String email = driver.findElement(By.cssSelector(".HH-ApplicantSettings-Section:nth-child(6) .form-accordion-section__value")).getText();
    System.out.println(email);
    return username.equals(email);
  }

}
