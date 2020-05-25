package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsMod() {
   if (app.contacts().list().size() == 0) {  /*if (!app.contacts().isThereAContac()) {  - isThereAGroup() - заменили на альтернаивн проверку */
      app.goTo().сontactPage();
      ContactData contact = new ContactData()
              .withFirstname ("Сидор").withMiddlename("Petrovich3").withLastname("Сидоров").withNickname("IPI").withGroup("[none]");
      app.contacts().fill(contact, true);
      app.contacts().submit();
      app.goTo().homePage();
    }
  }

  @Test /*(enabled = false)*/
  public void testContactModification() {

    List<ContactData> before = app.contacts().list();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
    int index = 0;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId()).withFirstname ("Сидор").withMiddlename("Petrovich3").withLastname("Сидоров").withNickname("IPI");
    app.contacts().modify(index, contact);
    app.goTo().homePage();
    List<ContactData> after = app.contacts().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);    // модифицировать старый список, удалить элемент С ТЕМ ЖЕ ИНДЕКСОМ, С КОТОРЫМ МОДИФИЦИРОВАЛИ
    before.add(contact);                    // добавить список, который должен появиться после модификации
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }



}


