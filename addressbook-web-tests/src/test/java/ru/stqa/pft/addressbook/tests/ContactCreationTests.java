
package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test /*(enabled = false)*/
  public void testContactCreation() throws Exception {
//  int before = app.getContactHelper().getContactCount();
//  меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
    List<ContactData> before = app.contacts().list();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
    app.goTo().сontactPage();
    ContactData contact = new ContactData()
            .withFirstname ("Александр").withMiddlename("Иванович").withLastname("Куприн").withNickname("TCC").withGroup("[none]");
    app.contacts().fill(contact, true);
    app.contacts().submit();
    app.goTo().homePage();
//    int after = app.getContactHelper().getContactCount();
// меняем КОЛЛИЧЕСТВО контактов на СПИСОК контактов
    List<ContactData> after = app.contacts().list();

    Assert.assertEquals(after.size(), before.size() + 1);

//СРАВНЕНИЕ СПИСКОВ

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}





