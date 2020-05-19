// Задание №8

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
//  int before = app.getContactHelper().getContactCount();
//  меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
    List<ContactData> before = app.getContactHelper().getContactList();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
    app.getNavigationHelper().gotoContactPage();
    ContactData contact = new ContactData (
                    "Сdf",
                    "Аdf",
                    "Еdf",
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
            );
    app.getContactHelper().fillContactForm(contact, true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
//    int after = app.getContactHelper().getContactCount();
// меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);

//СРАВНЕНИЕ СПИСКОВ


    int max = 0;
    for (ContactData c : after){
      if (c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


  }
}
