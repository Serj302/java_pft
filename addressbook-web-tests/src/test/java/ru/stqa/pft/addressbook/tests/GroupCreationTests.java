package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

/*
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test0", null, null));
  }
*/

// КОЛЛЕКЦИИ

// при добавлении новой группы, они должны увеличиваться на 1
// нужен метод getGroupCount(), который позволяет узнать кол-во групп
/*
  @Test
    public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().getGroupCount();  // кол-во групп ДО добавления... before - содержит кол-во элементов
      app.getGroupHelper().createGroup(new GroupData("test2", "test_test", "test_test_test"));
      int after = app.getGroupHelper().getGroupCount();  // кол-во групп ПОСЛЕ добавления
// и проверка
      Assert.assertEquals(after, before + 1); //кол-во групп ПОСЛЕ - должно совпадать с кол-вом ДО (+1)
    }
*/


// Получение списка элементов с web-страницы

@Test
    public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
//    int before = app.getGroupHelper().getGroupCount();              // кол-во групп ДО добавления
// меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
      List<GroupData> before = app.getGroupHelper().getGroupList();  // before - содержит список элементов/ before - содержит список объектов типа GroupData

      app.getGroupHelper().createGroup(new GroupData("test1", "test_test", "test_test_test"));

//    int after = app.getGroupHelper().getGroupCount();             // кол-во групп ПОСЛЕ добавления
// меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
      List<GroupData> after = app.getGroupHelper().getGroupList();  // after - - содержит список элементов после создания новой группы

// и проверка
      Assert.assertEquals(after.size(), before.size() + 1); // сравнение РАЗМЕРОВ списка...
      // after.size() - размер списка ПОСЛЕ добавления = размеру before.size() - ДО, +1
    }



}






















