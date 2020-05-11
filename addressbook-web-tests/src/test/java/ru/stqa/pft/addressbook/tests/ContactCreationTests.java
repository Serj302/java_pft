// Задание №8

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

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
}
