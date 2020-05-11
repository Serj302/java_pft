// Задание №8

package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseHelper {
  protected WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null){ // если передаем null - то ничего не делать, в противном - выполнить код:
      String existingText = wd.findElement(locator).getAttribute("value"); // получили значение с поля ввода
      // этот if необходим для оптимизации больших полей ввода, куда вводится длинный текст, от 1000-2000 и более символов
      if (! text.equals(existingText)){ // если не верно, что передаваемый текст совпадает уже с существующ текстом в форме, то выполнить код:
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  private boolean isAlertPresent() {
    try {                               // попытаться, если получилось - true
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {  //поймать/перехватить исключение
      return false;
    }
  }

  protected void select(By locator, String text) {
    if (text != null) //выполнять условие, только если передается какое-то значение, если null - ничего делать не нужно
    new Select(wd.findElement(locator)).selectByVisibleText(text);
  }

  protected void photo(By locator, String value) {
    if (value != null) //выполнять условие, только если передается какое-то значение, если null - ничего делать не нужно
    wd.findElement(locator).sendKeys(value);
  }

  // Метод isElementPresent - проверяет наличие/отсутсвие элемента

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }
  }

}
