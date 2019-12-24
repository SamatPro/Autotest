package ru.hh.kazan.helpers;

import org.openqa.selenium.WebDriver;
import ru.hh.kazan.ApplicationManager;

public class HelperBase {
  protected ApplicationManager manager;
  protected WebDriver driver;

  public HelperBase(ApplicationManager manager) {
    this.manager = manager;
    this.driver = manager.getDriver();
  }
}
