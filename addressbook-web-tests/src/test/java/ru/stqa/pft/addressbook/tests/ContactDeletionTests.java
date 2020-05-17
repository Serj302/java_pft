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
                                "C:\\tools\\Koala.jpg",
                                "Hello",
                                "Home",
                                "Moscow, st. Lenina 27, kv. 5",
                                "+7495256231",
                                "+79604512309",
                                "+7495255231 (dob 999)",
                                "+78121234567",
                                "IPI@gmail.com",
                                "software-testing.ru",
                                "9",
                                "September",
                                "1999",
                                "[none]",
                                "Moscow, st. Lenina 72, kv. 55",
                                "+7495254251",
                                "Test contact"
                        ),
                true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
     }
      int before = app.getContactHelper().getContactCount();
      //List<ContactData> before = app.getContactHelper().getContactList();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
      app.getContactHelper().selectContact(before -1);
      app.getContactHelper().deletedContact();
      app.getContactHelper().confirmationDeletedContact();
      app.getNavigationHelper().returnToHomePage();       // нужен переход на "home" c 3 sec time-out, т.к. идет задержка после удаления
      int after = app.getContactHelper().getContactCount();
      //List<ContactData> after = app.getContactHelper().getContactList();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
      Assert.assertEquals(after, before - 1);
    }
  }
