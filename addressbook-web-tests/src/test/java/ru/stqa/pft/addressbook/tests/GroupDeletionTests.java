package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
    public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();

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

    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }




}
