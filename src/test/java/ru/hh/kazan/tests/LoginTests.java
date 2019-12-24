package ru.hh.kazan.tests;

import org.junit.Test;
import ru.hh.kazan.models.UserData;

public class LoginTests extends TestBase{


  @Test
  public void loginWithValidData() {
    app.getLoginHelper().login(userDto);
    app.getLoginHelper().logout();
  }

  @Test
  public void loginWithInvalidData() {
    app.getLoginHelper().login(new UserData("tsdsf", "jdhsjk"));
    app.getLoginHelper().logout();
  }
}
