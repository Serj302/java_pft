package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  /* public void gotoGroupPage() {

     Присутсвие на нужой странице,
          т.е. клик, если мы не находимся на нужной странице (с заголовком Groups и кнопкой new group)


    * 1. Проверяем наличие заголовка:
     if (isElementPresent(By.tagName("h1"))) // заголовок представлен тегом h1

         * после того, как убедились в наличии нужного элемента, проверяем текст:

    * 2. ищем елемент(wd.findElement) по тому же локатору (By.tagName("h1"))
     if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")) )

    * берем текст локатора (getText() и сравниваем с текстом Groups(.equals("Groups"))
     if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups")

    * 3. еще добавить поиск кнокпи new_group-new
     if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                    && isElementPresent(By.name("new"))) {
    }

        * Итого: проверили наличие заголовка + проверили текст заголовка + проверили наличие кнопки


    * Соответственно, клик должен быть, когда условие выше не выполняется:

    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {

    } else {
      click(By.linkText("groups"));
    }

        * НО... так не принято, чтобы if оставался пустым, а else - не пустым, поэтому есть 2 варианта:

 == 1 ==

    if (! isElementPresent(By.tagName("h1"))                                  // если элемент не присутсвует
            || ! wd.findElement(By.tagName("h1")).getText().equals("Groups") //или, не верно, что текст заголовка = Groups
            || ! isElementPresent(By.name("new"))) {                     // или, не присутствует элемент с атрибутом = new
            click(By.linkText("groups"));                               // то переход по ссылке
    }

    * при 1 варианте - условие становится громостким, поэтому пробуем 2

 == 2 ==

     if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;                                       //если условие выполняется - просто выход из этого метода
    }
    click(By.linkText("groups"));                // в противном переход по ссылке

 */

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoContactPage() {
    click(By.linkText("add new"));
  }

  public void returnToHomePage() {
    // Присутсвие на нужой странице,
   // т.е. клик, если мы не находимся на нужной странице (с таблицей id= maintable)

    if (isElementPresent(By.id("maintable"))){  // если элемент с id = maintable
    return;                                   // то делать ничего не надо
    }
    click(By.linkText("home"));
  }

}
