package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Tomy", "Petrovich3", "Tuz", "IPI",
            "C:\\tools\\Koala.jpg", "Hello", "Home", "Moscow, st. Lenina 27, kv. 5",
            "+7495256231", "+79604512309", "+7495255231 (dob 999)", "+78121234567",
            "IPI@gmail.com", "software-testing.ru", "9", "September", "1999",
            "test4","Moscow, st. Lenina 72, kv. 55", "+7495254251", "Test contact"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }
}
