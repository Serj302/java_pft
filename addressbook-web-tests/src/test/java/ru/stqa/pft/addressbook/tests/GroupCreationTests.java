package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

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
// нужен метод, который позволяет узнать кол-во групп
    @Test
    public void testGroupCreation() throws Exception {
      app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().getGroupCount();  // кол-во групп ДО добавления
      app.getGroupHelper().createGroup(new GroupData("test2", "test_test", "test_test_test"));
      int after = app.getGroupHelper().getGroupCount();  // кол-во групп ПОСЛЕ добавления
// и проверка
      Assert.assertEquals(after, before + 1); //кол-во групп ПОСЛЕ - должно совпадать с кол-вом ДО (+1)
    }

}






















