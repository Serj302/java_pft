package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
    public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
// контроль кол-ва элементов
// обращать внимание с какой страницы начинается подсчет
    int before = app.getGroupHelper().getGroupCount();  // кол-во групп ДО добавления

/* Проверка и обеспечение выполнения предусловий.
       Проверка на наличие группы. Если группы нет - создать.

     создать метод "наличия группы" - isThereAGroup
    if (! app.getGroupHelper().isThereAGroup()) { //если не существует ни одной группы

           то необходимо группу создать, шаги создания группы есть в testGroupCreation:
                  app.getGroupHelper().initGroupCreation();
                  app.getGroupHelper().fillGroupForm(new GroupData("test0", null, null));
                  app.getGroupHelper().submitGroupCreation();
                  app.getGroupHelper().returnToGroupPage();

             НО... много кода + дублирования, необходимо объеденить все эти шаги в вспомогательный метод createGroup

      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
*/
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
    }
    app.getGroupHelper().selectGroup(before - 1);
    // если нужно удалить 1 группу передаем 0(selectGroup(0)),
    // если последнюю - before - 1, т.к. индекс последнего элемента -1
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();  // кол-во групп ПОСЛЕ добавления
    Assert.assertEquals(after, before - 1); //кол-во групп ПОСЛЕ - должно уменьшиться по отношению с кол-вом ДО - на 1
  }




}
