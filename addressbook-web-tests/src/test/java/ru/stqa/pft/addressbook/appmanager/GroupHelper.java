package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//selectGroup()
/*
  public void selectGroup() {
    click(By.name("selected[]"));
  }
*/

// Модификация, для конкретного выбора группы - selectGroup(int index)
/*
// Модификация, для конкретного выбора группы
  public void selectGroup(int index) {        // в качестве параметра - ИНДЕКС ЭЛЕМЕНТА
//wd.findElements(By.name("selected[]"));    // поиск всех элементов по ЛОКАТОРУ selected[]
//.get(index)                                // среди этих элементов, ОТБОР ПО ИНДЕКСУ
//click                                      //именно по вбранному элементы - выполнить КЛИК
    wd.findElements(By.name("selected[]")).get(index).click();
  }
*/

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

// Метод модификации групп modify(int index)
/*
 // Метод модификации групп (Актуализация кода), принимает 2 параметра: 1. индекс группы для модификации, 2. Обект с новыми данными
  public void modify(int index, GroupData group) {
    selectGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }
*/

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

// delete(int index)
/*
  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }
*/


  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    returnToGroupPage();
  }

// проверка наличия элемента, того самого, которого пытаемся выбирать в selectGroup - isThereAGroup
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

// метод позволяет узнать кол-во групп
/*
// контроль кол-ва элементов
// метод позволяет узнать кол-во групп
  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
// findElements - возвращает список ВСЕХ элементов, т.е. объект типа - List, и размер списка(size)

// ...implicitlyWait(0, TimeUnit.SECONDS) - если будет 60, а не 0, то драйвер(wd),
// подождет, не появятся ли элементы и только по истечению 60 сек - он вернет пустой список, состоящий из 0 элементов

  }
*/

// Метод для получения списка элементов/групп с web-страницы - getGroupList
/*
// Сравнения размера спсисков
  public List<GroupData> getGroupList() {

// 1. создть список для заполнения
    List<GroupData> groups = new ArrayList<GroupData>();

// 2. найти все элементы, котор имеют тег span и класс group
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));

// 3. пройти по всем найденным элементам в цикле и для каждого из них...
    for (WebElement element : elements){  // переменная element - пробегает по списку elements

// 4. из каждого такого элемента - получаем текст, это и будет имя группы
      String name = element.getText();

// 5. Создать объект типа GroupData
      GroupData group = new GroupData(name, null, null); // name - имя группы

// 6. Добавление созданного объекта в список
      groups.add(group);
    }

    return groups;
  }
 */

// Метод для получения списка элементов с web-страницы - list
/*
  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
// добавить id группы, он передается в конструктор и он используется при сравнении
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // поиск елемента, внутри другого элемента
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
*/

// Метод для получения множества элементов с web-страницы - all
  public Set<GroupData> all() {
    Set<GroupData> groups = new HashSet<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // поиск елемента, внутри другого элемента
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }

}















