package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification(){
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Квадрат", null, null, null,
            null, null, null, null,
            null, null, null, null,
            null, null, null, null, null,
            null, null, null));
    app.getContactHelper().updateModification();
    app.getContactHelper().returnToHomePage();

  }
}
