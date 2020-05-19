package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification(){
    if (! app.getContactHelper().isThereAContac()){
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
              null
      );
      app.getContactHelper().fillContactForm(contact, true);
      app.getContactHelper().submitContactCreation();
      app.getNavigationHelper().returnToHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();  // before - содержит список элементов/ before - содержит список объектов типа ContactData
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().editContact(before.size()-1);  //***  надо параметризовать этот метод и в качестве параметра передавать индекс последней строки в списке контактов.  ****
    ContactData contact = new ContactData (before.get(before.size() -1).getId(),  // использование id контакта
                    "Tom",
                    "Cruzeevich",
                    "Cruzer",
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
                    null,       // срабатывает time-out
                    null,
                    null,
                    null,
                    null
            );
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().updateModification();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

// МНОЖЕСТВА
    before.remove(before.size()-1);    // модифицировать старый список, удалить элемент С ТЕМ ЖЕ ИНДЕКСОМ, С КОТОРЫМ МОДИФИЦИРОВАЛИ
    before.add(contact);                    // добавить список, который должен появиться после модификации
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));  // преобразование списка в множества

  }

}
