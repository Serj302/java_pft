// Задание №8

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
//  int before = app.getContactHelper().getContactCount();
//  меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
    List<ContactData> before = app.getContactHelper().getContactList();  // before - содержит список элементов/ before - содержит список объектов типа ContactData

    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData
                    (
                            "С",
                            "А",
                            "Е",
                            "TCC",
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
//    int after = app.getContactHelper().getContactCount();
// меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);

//СРАВНЕНИЕ СПИСКОВ



  }
}
