package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
//Проверка на наличие группы. Если группы нет - создает.
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup (new GroupData("test0", null, null));
/* без Доп конструктора
*     app.getGroupHelper().createGroup (new GroupData(null, "test0", null, null));
*/

    }
// контроль кол-ва элементов
// обращать внимание с какой страницы начинается подсчет
//  int before = app.getGroupHelper().getGroupCount();              // кол-во групп ДО добавления
// меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() -1);      // если надо выбрать НЕ последний элемент, а 2й - ...selectGroup(1);
    app.getGroupHelper().initGroupModification();
/*  app.getGroupHelper().fillGroupForm(new GroupData("test0", "test33", "test44"));
*   создать докальную переменную group*
*/

/* без Доп конструктора
*     GroupData group = new GroupData(null, "test0", null, null);
*/

/*    GroupData group = new GroupData("test1", "test33", "test44");
* При модификации группы, передаются новые: name, header, footer, а старый id - необходимо сохранять
*/
    GroupData group = new GroupData(before.get(before.size() -1).getId(), "test1", "test33", "test44");

    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
//  int after = app.getGroupHelper().getGroupCount();             // кол-во групп ПОСЛЕ добавления
//  меняем КОЛЛИЧЕСТВО групп на СПИСОК групп
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());             //кол-во групп ПОСЛЕ - должно совпасть с кол-вом ДО

/* СРАВНЕНИЕ списка групп (чтобы убедиться в том, что группа поменялась корректно)
* есть проблема: при изменении группы - меняется и ее имя, из-за этого она может поменять своё место в списке
* т.к. в тестовом приложении - группы сортируются по именам и т.к. порядок элементов в списке меняется - это создает сложности при сравнении 2ух списков
* как решить?
* сравнивать без учета порядка, главное, чтобы все элементы присутсвовали, порядок не важен
* в Java есть: упорядоченные коллекции - списки и НЕ упорядоченные коллекции - множества
* нужно перед сравнением, преобразовать эти списки в множества и сравнивать получившиеся множества
 */

//модифицировать старый список, удалить последний элемент
    before.remove(before.size() - 1);

// и добавить тот, который должен появиться после модификации
    before.add(group);                  // добавить в before new GroupData("test0", "test33", "test44")

// преобразование списка в множества
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}











