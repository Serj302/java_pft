package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends BaseHelper{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }
/*
  public void selectGroup() {
    click(By.name("selected[]"));
  }
*/

// Модификация, для конкретного выбора группы

  public void selectGroup(int index) {        // в качестве параметра - ИНДЕКС ЭЛЕМЕНТА
//wd.findElements(By.name("selected[]"));    // поиск всех элементов по ЛОКАТОРУ selected[]
//.get(index)                                // среди этих элементов, ОТБОР ПО ИНДЕКСУ
//click                                      //именно по вбранному элементы - выполнить КЛИК

    wd.findElements(By.name("selected[]")).get(index).click();
  }


  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  // проверка наличия элемента, того самого, которого пытаемся выбирать в selectGroup
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

// контроль кол-ва элементов
// метод позволяет узнать кол-во групп
  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
// findElements - возвращает список ВСЕХ элементов, т.е. объект типа - List, и размер списка(size)

// ...implicitlyWait(0, TimeUnit.SECONDS) - если будет 60, а не 0, то драйвер(wd),
// подождет, не появятся ли элементы и только по истечению 60 сек - он вернет пустой список, состоящий из 0 элементов

  }

}















