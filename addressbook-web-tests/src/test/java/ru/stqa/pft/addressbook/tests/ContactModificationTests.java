// Задание №8

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification(){
    if (! app.getContactHelper().isThereAContac()){

      app.getNavigationHelper().gotoContactPage();
      app.getContactHelper().fillContactForm(new ContactData
                      (
                              "Сидор",
                              "Petrovich3",
                              "Sidor",
                              "IPI",
                              "C:\\tools\\Koala.jpg",
                              "Hello",
                              "Home",
                              "Moscow, st. Lenina 27, kv. 5",
                              "+7495256231",
                              "+79604512309",
                              "+7495255231 (dob 999)",
                              "+7812",
                              "IPI@gmail.com",
                              "software",
                              "9",
                              "September",
                              "1999",
                              "[none]",
                              "Moscow, st. Lenina 72, kv. 55",
                              "+7495",
                              "Test contact"
                      ),
              true);
      app.getContactHelper().submitContactCreation();
      app.getNavigationHelper().returnToHomePage();
    }
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData
                    (
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
                            null,
                            null,
                            null,
                            null,
                            null
                    ),
            false);
    app.getContactHelper().updateModification();
    app.getNavigationHelper().returnToHomePage();

  }

}
