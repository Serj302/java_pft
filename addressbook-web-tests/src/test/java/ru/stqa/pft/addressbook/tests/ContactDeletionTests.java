// Задание №8

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion(){
      // Проверка на наличие контакта. Если контакта нет - создать. (По аналогии testGroupDeletion)
        if (! app.getContactHelper().isThereAContac()){
        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().fillContactForm(new ContactData
                        (
                                "Сидор",
                                "Petrovich3",
                                "Сидоров",
                                "IPI",
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                "[none]",
                                null,
                                null,
                                null
                        ),
                true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
     }
      List<ContactData> before = app.getContactHelper().getContactList();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().deletedContact();
      app.getContactHelper().confirmationDeletedContact();
      app.getNavigationHelper().returnToHomePage();       // нужен переход на "home" c 3 sec time-out, т.к. идет задержка после удаления
      List<ContactData> after = app.getContactHelper().getContactList();  // меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
      Assert.assertEquals(after.size(), before.size() - 1);

//СРАВНЕНИЕ СПИСКОВ

// удалить лишний элемент, С ТЕМ ЖЕ ИНДЕКСОМ, С КОТОРЫМ УДАЛЯЛИ (стр. 47)
      before.remove(before.size() - 1); // теперь before/старый список - содрежит те же элементы, что и after/новый список
/* ПРОВЕРКА СОВПАДЕНИЙ СПИСКА
      for (int i = 0; i < after.size(); i++){
        Assert.assertEquals(before.get(i), after.get(i));  // сравнение 2х элементов с одинаковыми индексами
      }
// можно проверить совпадение и без цикла
*/
      Assert.assertEquals(before, after);

    }
 }
