package ru.hh.kazan.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.hh.kazan.ApplicationManager;
import ru.hh.kazan.models.ResumeData;

public class ResumeHelper extends HelperBase {
  public ResumeHelper(ApplicationManager applicationManager) {
    super(applicationManager);
  }


  public void createNewResume(ResumeData resume){

    driver.findElement(By.linkText("Создать резюме")).click();

    driver.findElement(By.name("phone[0].formatted")).click();
    driver.findElement(By.name("phone[0].formatted")).clear();
    driver.findElement(By.name("phone[0].formatted")).sendKeys(resume.getPhone());
    driver.findElement(By.name("birthday[0].date")).click();
    driver.findElement(By.name("birthday[0].date")).sendKeys(resume.getDateOfBirth());

    driver.findElement(By.cssSelector(".bloko-select:nth-child(2)")).click();
    {
      WebElement dropdown = driver.findElement(By.cssSelector(".bloko-select-wrapper > .bloko-select"));
      dropdown.findElement(By.xpath("//option[. = 'мая']")).click();
    }

    driver.findElement(By.cssSelector("option:nth-child(6)")).click();
    driver.findElement(By.cssSelector(".bloko-control-group__content-sized:nth-child(3) > .bloko-input")).click();
    driver.findElement(By.cssSelector(".bloko-control-group__content-sized:nth-child(3) > .bloko-input")).sendKeys(resume.getYearOfBirth());

    driver.findElement(By.cssSelector(".bloko-column_s-4 > .bloko-form-item-baseline:nth-child(1) .bloko-radio__text")).click();




    driver.findElement(By.cssSelector(".bloko-column_s-8 > .bloko-form-item-baseline:nth-child(2) .bloko-radio__text")).click();
    driver.findElement(By.cssSelector(".no-experience-reasons > .resume-switcher-wrapper:nth-child(2) > .bloko-link-switch")).click();
//    driver.findElement(By.cssSelector(".bloko-column_s-8 > .resume-form-row > .bloko-form-item:nth-child(2) .bloko-radio__text")).click();
    driver.findElement(By.name("skills[0].string")).click();
    driver.findElement(By.name("skills[0].string")).sendKeys(resume.getSkills());
    driver.findElement(By.name("title[0].string")).click();
    driver.findElement(By.name("title[0].string")).clear();
    driver.findElement(By.name("title[0].string")).sendKeys(resume.getPosition());
    driver.findElement(By.name("salary[0].amount")).click();
    driver.findElement(By.name("salary[0].amount")).sendKeys("30 000");
    driver.findElement(By.cssSelector(".bloko-column:nth-child(4) .bloko-section")).click();
    driver.findElement(By.cssSelector(".bloko-button_large")).click();
  }

}
