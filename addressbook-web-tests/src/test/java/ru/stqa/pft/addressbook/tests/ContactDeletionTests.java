package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{
// Перед каждым тестом - проверка предусловия (Актуализация кода)
  @BeforeMethod
  public void ensurePreconditionsDel() {
  // Проверка на наличие контакта. Если контакта нет - создать. (По аналогии testGroupDeletion)
    if (!app.getContactHelper().isThereAContac()){
      app.getNavigationHelper().gotoContactPage();
      ContactData contact = new ContactData (
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
                    null);
    app.getContactHelper().fillContactForm(contact,true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    }
  }

    @Test /*(enabled = false )*/
    public void testContactDeletion(){

      List<ContactData> before = app.getContactHelper().getContactList();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
      int index = 0;
      app.getContactHelper().deletionContact(index);
      app.getNavigationHelper().returnToHomePage();       // нужен переход на "home" c 3 sec time-out, т.к. идет задержка после удаления
      List<ContactData> after = app.getContactHelper().getContactList();  // меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
      Assert.assertEquals(after.size(), before.size() - 1);

//СРАВНЕНИЕ СПИСКОВ

// удалить лишний элемент, С ТЕМ ЖЕ ИНДЕКСОМ, С КОТОРЫМ УДАЛЯЛИ (стр. 47)
      before.remove(index); // теперь before/старый список - содрежит те же элементы, что и after/новый список
/* ПРОВЕРКА СОВПАДЕНИЙ СПИСКА
      for (int i = 0; i < after.size(); i++){
        Assert.assertEquals(before.get(i), after.get(i));  // сравнение 2х элементов с одинаковыми индексами
      }
// можно проверить совпадение и без цикла
*/
      Assert.assertEquals(before, after);

    }

}
