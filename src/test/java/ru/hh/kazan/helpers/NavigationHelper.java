package ru.hh.kazan.helpers;

import org.openqa.selenium.By;
import ru.hh.kazan.ApplicationManager;

public class NavigationHelper extends HelperBase {
  private String baseUrl;

  public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
    super(applicationManager);
    this.baseUrl = baseUrl;
  }

  public void openHomePage() {
    driver.get(baseUrl);
    driver.findElement(By.linkText("Войти")).click();
  }
}
