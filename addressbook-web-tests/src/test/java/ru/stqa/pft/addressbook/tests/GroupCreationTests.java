package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
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

*//*---------------------RESULT--------------------------------------------

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
/*---------------------RESULT--------------------------------------------

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

---------------------------------------------------------------------*/
/*
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test3", "test_test", "test_test_test");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() + 1);

// ПОЛУЧЕНИЕ MAX ID

    // I ВАРИАНТ - Цикл

    int max = 0;

    for (GroupData g : after){
      if (g.getId() > max){
        max = g.getId();
      }
    }


    // II ВАРИАНТ - Comparator



*  2.
* реализовать сравниватель (byId)
    Comparator<? super GroupData> byId = ... ;
*  3. переменную byId - надо инициализировать, присвоить в нее какое-то конкретное значение

    Comparator<? super GroupData> byId = new Comparator<GroupData>() {  // Comparator<? super GroupData> byId = сtrl+пробел
* создаем объект типа Компаратор - это интерфейс без реализации, он только декларирует (объявляет, какие методы должны быть), но
* реализацию этих методов - не содержит
      @Override
      public int compare(GroupData o1, GroupData o2) {  // о1 о2 - это два id, котор будут сравниваться
        return Integer.compare(o1.getId(), o2.getId());   // метод для сравнения чисел
      }
    };

*  1.
* превратить список в поток (stream), у потока есть метод max, для вычисления max элемента
* в качестве параметра - надо передать компаратор(сравниватель (byId))
    after.stream().max(byId) - нашли max элемент, далее
* получить этот max элемент get()
* и взять у этого max элемента - id - getId()
* далее надо реализовать сравниватель (byId)

    int max1 = after.stream().max(byId).get().getId();
    group.setId(max1);


// III ВАРИАНТ - Лямбда-выражения / анонимные функции


 1.
* Comparator<? super GroupData> byId = new Comparator<GroupData>() - нажать Alt + Enter на new Comparator - Replace with lambda

   Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

* (o1, o2) - параметры
* Integer.compare(o1.getId(), o2.getId()); - тело функции

    int max1 = after.stream().max(byId).get().getId();

 2.
* (o1, o2) -> Integer.compare(o1.getId(), o2.getId()) - эту анонимную фун-ию / лямбла-выражение, можно передать в качестве параметра byId

    int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

*  список превращаем в поток - по этому потоку пробегает фун-ия-сравниватель и находит max елемент
*                              при этом сравниваются объекты типа GroupData, путем сравнения их id
*                                            на ВЫХОДЕ функции - будет max объект(группа с max id)
*                                                           остается только взять группу с max id

** I ВАРИАНТ - Цикл можно убрать
* от max1 - можно избавиться
*   int max1 =
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

*//*---------------------RESULT--------------------------------------------*/

     @Test

     public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test4", "test_test", "test_test_test");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size() + 1);

    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
}

}






















