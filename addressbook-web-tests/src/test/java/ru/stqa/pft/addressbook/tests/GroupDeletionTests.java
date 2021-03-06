package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

//Начало
/*
public class GroupDeletionTests extends TestBase {

  @Test
    public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();

// ПРОВЕРКА И ОБЕСПЕЧЕНИЕ ВЫПОЛНЕНИЯ ПРЕДУСЛОВИЙ Проверка и обеспечение выполнения предусловий.

*  Проверка на наличие группы. Если группы нет - создать.

*  создать метод "наличия группы" - isThereAGroup
    if (! app.getGroupHelper().isThereAGroup()) {
*  если не существует ни одной группы, то необходимо группу создать, шаги создания группы есть в testGroupCreation:

                  app.getGroupHelper().initGroupCreation();
                  app.getGroupHelper().fillGroupForm(new GroupData("test0", null, null));
                  app.getGroupHelper().submitGroupCreation();
                  app.getGroupHelper().returnToGroupPage();

*  НО... много кода + дублирования, необходимо объеденить все эти шаги в вспомогательный метод createGroup
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
//
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
    }

// КОНТРОЛЬ КОЛ-ВА ЭЛЕМЕНТОВ

* обращать внимание с какой страницы начинается подсчет
   int before = app.getGroupHelper().getGroupCount();              // кол-во групп ДО добавления

// СРАВНЕНИЕ РАЗМЕРА списков before и after
// МЕНЯЕМ КОЛЛИЧЕСТВО групп на СПИСОК групп

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
* выбор последней группы, если надо выбрать НЕ последний элемент, а 2й - ...selectGroup(1);
* если нужно удалить 1 группу передаем 0(selectGroup(0)),
* если последнюю - before - 1, т.к. индекс последнего элемента -1

    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
*  int after = app.getGroupHelper().getGroupCount();             // кол-во групп ПОСЛЕ добавления
* меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1); //кол-во групп ПОСЛЕ - должно уменьшиться по отношению с кол-вом ДО - на 1

// СРАВНЕНИЕ СПИСКА ГРУПП (чтобы убедиться в том, что группа удалилась корректно )

* before(старый) список - содержит на 1 элемент больше, чем after(новый)
* чтобы сравнить списки - они должны быть равными, для этого надо удалить в старом списке лишний элемент
* удалить лишний элемент, с тем же индексом
*
    before.remove(before.size() - 1);
* теперь before/старый список - содрежит те же элементы, что и after/новый список

// ПРОВЕРКА СОВПАДЕНИЙ СПИСКА
    for (int i = 0; i < after.size(); i++){
      Assert.assertEquals(before.get(i), after.get(i));  // сравнение 2х элементов с одинаковыми индексами
    }

// можно проверить совпадение и без цикла
    Assert.assertEquals(before, after);

  }

*/


/*
 public class GroupDeletionTests extends TestBase {

   // Перед каждым тестом - проверка предусловия (Актуализация кода)
   @BeforeMethod
   public void ensurePreconditions() {
     app.goTo().groupPage();
     if (app.group().list().size() == 0) {  //if (! app.group().isThereAGroup()) {  - isThereAGroup() - заменили на альтернаивн проверку
       app.group().create(new GroupData().withName("test2"));
     }
   }

   @Test
   public void testGroupDeletion() throws Exception {

     List<GroupData> before = app.group().list();
     int index = before.size() - 1;
     app.group().delete(index);
     List<GroupData> after = app.group().list();
     Assert.assertEquals(after.size(), before.size() - 1);

     before.remove(index);
     Assert.assertEquals(before, after);
   }
 }
 */


  public class GroupDeletionTests extends TestBase {

  @BeforeMethod
   public void ensurePreconditions(){
     app.goTo().groupPage();
     if (app.group().all().size() == 0) {
       app.group().create(new GroupData().withName("test2"));
     }
   }

   @Test
   public void testGroupDeletion() throws Exception {
     Set<GroupData> before = app.group().all();
     GroupData deletedGroup = before.iterator().next();   // извлечь элемент из множества, любой
     app.group().delete(deletedGroup);
     Set<GroupData> after = app.group().all();
     Assert.assertEquals(after.size(), before.size() - 1);

     before.remove(deletedGroup);
     Assert.assertEquals(before, after);
   }


 }










