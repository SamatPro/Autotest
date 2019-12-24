package ru.hh.kazan.tests;

import org.junit.Test;
import org.testng.annotations.AfterClass;
import ru.hh.kazan.models.ResumeData;
import ru.hh.kazan.models.UserData;

import java.io.IOException;

public class CreateNewResumeTest extends AuthBase {

  UserData userDto = new UserData("mylogin@list.ru", "qwerty");

  ResumeData resumeData = new ResumeData();
  void init(){
    resumeData.setFirstName("Джереми");
    resumeData.setLastName("Фейбер");
    resumeData.setPosition("Тестировщик ПО");
    resumeData.setCityName("Казань");
    resumeData.setDateOfBirth("5");
    resumeData.setYearOfBirth("1996");
    resumeData.setPhone("9083488771");
    resumeData.setSkills("Демо резюме, ДЗ по тестированию (Автотест)");
  }


  @Test
  public void hhCreateResumeTest() throws IOException {
    app.getNavigationHelper().openHomePage();
    app.getLoginHelper().login(userDto);
    app.getResumeHelper().createNewResume(resumeData);
    app.getLoginHelper().logout();
  }

  @AfterClass
  public void closePage(){
    app.stop();
  }
}
