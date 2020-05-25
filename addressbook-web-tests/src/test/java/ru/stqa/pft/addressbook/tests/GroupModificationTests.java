package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase{

/*
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
//ПРОВЕРКА НА НАЛИЧИЕ ГРУППЫ. Если группы нет - создает.
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
* БЕЗ ДОП КОНСТРУКТОРА
     app.getGroupHelper().createGroup (new GroupData(null, "test0", null, null));
*
    }

// КОНТРОЛЬ КОЛ-ВА ЭЛЕМЕНТОВ

* обращать внимание с какой страницы начинается подсчет
   int before = app.getGroupHelper().getGroupCount();              // кол-во групп ДО добавления

// ВМЕСТО КОЛЛИЧЕСТВА ГРУПП - СПИСОК

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() -1);      // если надо выбрать НЕ последний элемент, а 2й - ...selectGroup(1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test0", "test33", "test44"));
*   создать Локальную переменную group*

*** БЕЗ ДОП КОНСТРУКТОРА ***
     GroupData group = new GroupData(null, "test0", null, null);


    GroupData group = new GroupData("test1", "test33", "test44");
* При модификации группы, передаются новые: name, header, footer, а старый id - необходимо сохранять

    GroupData group = new GroupData(before.get(before.size() -1).getId(), "test1", "test33", "test44");

    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

    int after = app.getGroupHelper().getGroupCount();             // кол-во групп ПОСЛЕ добавления

*  меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());             //кол-во групп ПОСЛЕ - должно совпасть с кол-вом ДО

// СРАВНЕНИЕ СПИСКА ГРУПП (чтобы убедиться в том, что группа поменялась корректно)

* есть проблема: при изменении группы - меняется и ее имя, из-за этого она может поменять своё место в списке
* т.к. в тестовом приложении - группы сортируются по именам и т.к. порядок элементов в списке меняется - это создает сложности при сравнении 2ух списков
* как решить?
* сравнивать без учета порядка, главное, чтобы все элементы присутсвовали, порядок не важен
* в Java есть: упорядоченные коллекции - списки и НЕ упорядоченные коллекции - множества
* нужно перед сравнением, преобразовать эти списки в множества и сравнивать получившиеся множества

* модифицировать старый список, удалить последний элемент
    before.remove(before.size() - 1);

* и добавить тот, который должен появиться после модификации
    before.add(group);                  // добавить в before new GroupData("test0", "test33", "test44")

* преобразование списка в множества
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

*//* ---------------------------RESULT--------------------------------------

  @Test
  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
    app.getGroupHelper().createGroup (new GroupData("test0", null, null));
    }

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() -1).getId(), "test1", "test33", "test44");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

/* ---------------------------RESULT--------------------------------------*/

/* СОРТИРОВКА СПИСКА */

// выше мы игнорировали учета порядка групп и сравнивали множества
// теперь наводим порядок
// УПОРЯДОЧИВАЕМ ГРУППЫ
/*
  @Test
  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
    }

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() -1).getId(), "test2", "test33", "test44");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);

// СОРТИРОВКА СПИСКА
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
*/

// Актуализация кода

// Перед каждым тестом - проверка предусловия (Актуализация кода)
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {  /*if (! app.group().isThereAGroup()) {  - isThereAGroup() - заменили на альтернаивн проверку */
      app.group().create(new GroupData("test0", null, null));
    }
  }

  @Test
  public void testGroupModification() {

    /* предусловие перенести в @BeforeMethod

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
    }

     */

    List<GroupData> before = app.group().list();
    int index = before.size() -1;
    GroupData group = new GroupData(before.get(index).getId(), "test12", "test33", "test44");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);

// СОРТИРОВКА СПИСКА
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}











