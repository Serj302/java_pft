package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
//Проверка на наличие группы. Если группы нет - создает.
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
      //int before = app.getGroupHelper().getGroupCount();
    }
// контроль кол-ва элементов
// обращать внимание с какой страницы начинается подсчет
//  int before = app.getGroupHelper().getGroupCount();              // кол-во групп ДО добавления
// меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() -1);      // если надо выбрать НЕ последний элемент, а 2й - ...selectGroup(1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test0", "test33", "test44"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
//  int after = app.getGroupHelper().getGroupCount();             // кол-во групп ПОСЛЕ добавления
// меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());             //кол-во групп ПОСЛЕ - должно совпасть с кол-вом ДО
  }

}
