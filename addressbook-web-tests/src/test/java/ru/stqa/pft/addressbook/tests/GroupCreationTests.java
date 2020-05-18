package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
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


// ПОЛУЧЕНИЕ СПИСКА ЭЛЕМЕНТОВ С WEB-СТРАНИЦЫ

/*
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

*//*---------------------TOTAL--------------------------------------------

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test3", "test_test", "test_test_test");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() + 1);

-------------------------------------------------------------------------*/

/* ПОИСК MAX ЭЛЕМЕНТА В КОЛЛЕКЦИИ

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test3", "test_test", "test_test_test");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() + 1);


 * нужно узнать новый id добавленной группы
 *
 * как сделать?
 * в новом списке - добавленная группа уже имеет id
 * и этот id  - предсказанный/ожидаемый max среди всех
 * группа с таким id - должна иметь как раз те самые св-ва, с которыми мы патались ее создать
 * теперь задача:
 *                как узнать max id?


// устраить цикл по всем элементам,
    int max = 0;
//  затем сравнивнить уже найденный max c id каждого элемента, если id > max - max++
    for (GroupData g : after){      // переменная g пробегает список after
      if (g.getId() > max){         // если новый g.id > max (найден id - больше чем все встреченные)
        max = g.getId();            // сделать max - этим id
      }
    }

// в конце цикла найдется САМЫЙ большой id - именно его присвоить в качестве id, новой группе
    group.setId(max);
// добавить список, который должен появиться после модификации
    before.add(group);                  // добавить в before new GroupData("test0", "test33", "test44")
// преобразование списка в множества
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
*/
/*---------------------TOTAL--------------------------------------------*/

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test3", "test_test", "test_test_test");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;

    for (GroupData g : after){
      if (g.getId() > max){
        max = g.getId();
      }
    }

    group.setId(max);

    before.add(group);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}






















