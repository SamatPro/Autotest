package ru.hh.kazan.tests;

import org.junit.After;
import org.junit.Test;
import ru.hh.kazan.models.ResumeData;
import ru.hh.kazan.models.UserData;

public class LogInOutTest extends AuthBase {

  @Test
  public void logInOut() {
    app.getNavigationHelper().openHomePage();
    app.getLoginHelper().login(userDto);
    app.getLoginHelper().logout();
  }

  @After
  public void closePage(){
    app.stop();
  }
}
