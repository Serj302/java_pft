package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class ContactCreationTests {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    //wd = new FirefoxDriver();
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testContactCreation() throws Exception {
    wd.get("http://localhost/addressbook/edit.php");
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
    wd.findElement(By.linkText("add new")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("Ivan");
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys("Petrovich");
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Ivanov");
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys("IPI");
    wd.findElement(By.name("photo")).clear();
    wd.findElement(By.name("photo")).sendKeys("C:\\tools\\Koala.jpg");
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys("Hello");
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys("Home");
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys("Moscow, st. Lenina 27, kv. 5");
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys("+7495256231");
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("+79604512309");
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys("+7495255231 (dob 999)");
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys("+78121234567");
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("IPI@gmail.com");
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys("software-testing.ru");
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText("9");
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("September");
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys("1999");
    wd.findElement(By.name("new_group")).click();
    wd.findElement(By.name("new_group")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("Moscow, st. Lenina 72, kv. 55");
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys("+7495254251");
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("Test contact");
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    wd.findElement(By.linkText("home page")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
