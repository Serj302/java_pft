package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification(){
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Куб", "Petrovich3", "Красный", "IPI",
            "C:\\tools\\Koala.jpg", "Hello", "Home", "Moscow, st. Lenina 27, kv. 5",
            "+7495256231", "+79604512309", "+7495255231 (dob 999)", "+78121234567",
            "IPI@gmail.com", "software-testing.ru", "9", "September", "1999",
            "Moscow, st. Lenina 72, kv. 55", "+7495254251", "Test contact"));
    app.getContactHelper().updateModification();
    app.getContactHelper().returnToHomePage();

  }
}
