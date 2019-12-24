package ru.hh.kazan.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import ru.hh.kazan.ApplicationManager;
import ru.hh.kazan.Settings;
import ru.hh.kazan.models.ResumeData;
import ru.hh.kazan.models.UserData;

import java.util.*;

public class TestBase {
  protected ApplicationManager app;
  protected Settings settings;

  {
    try {
      settings = new Settings();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  UserData userDto = new UserData();
  ResumeData resumeData = new ResumeData();


  void init(){
    userDto.setLogin(settings.getLogin());
    userDto.setPassword(settings.getPassword());

    resumeData.setFirstName("Тестировщик");
    resumeData.setLastName("Селениум");
    resumeData.setPosition("Тестировщик ПО");
    resumeData.setCityName("Казань");
    resumeData.setDateOfBirth("5");
    resumeData.setYearOfBirth("1996");
    resumeData.setPhone("9083488771");
    resumeData.setSkills("Демо резюме, ДЗ по тестированию (Автотест)");
  }


  @Before
  public void setUp() throws Exception {
    init();
    app = ApplicationManager.getInstance();
    app.getNavigationHelper().openHomePage();
  }

}
