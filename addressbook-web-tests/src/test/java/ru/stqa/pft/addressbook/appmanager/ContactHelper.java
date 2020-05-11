package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.openqa.selenium.By.*;

public class ContactHelper extends BaseHelper{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    type(name("firstname"), contactData.getFirstname());

    type(name("middlename"), contactData.getMiddlename());

    type(name("lastname"), contactData.getLastname());

    type(name("nickname"), contactData.getNickname());

    photo(name("photo"), contactData.getPhoto());

    type(name("title"), contactData.getTitle());

    type(name("company"), contactData.getCompany());

    type(name("address"), contactData.getAddress());

    type(name("home"), contactData.getTel_home());

    type(name("mobile"), contactData.getTel_mobile());

    type(name("work"), contactData.getTel_work());

    type(name("fax"), contactData.getFax());

    type(name("email"), contactData.getEmail());

    type(name("homepage"), contactData.getHomepage());

    select(name("bday"), contactData.getBday());

    select(name("bmonth"), contactData.getBmonth());

    type(name("byear"), contactData.getByear());

    /* выбор элемента из выпадающего списка:
     *
     1. new Select () - вспомогательный класс

     2. в качестве параметра - указывается элемент, который найден на странице приложения()

     new Select(wd.findElement(By.name("new_group"))

     3. в объекте типа Select - вызвать метод

     new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

     4. при вызове new Select, в testContactModification - возникнет исключение, т.к. драйвер(wd.findElement)
        не сможет найти элемент с таким локатором By.name("new_group"), т.к. его на странице просто нет.

     5. чтобы исключение предотвратить - проверка:

      if (isElementPresent(By.name("new_group"))) {   //если, элемент isElementPresent, с таким локатором - By.name("new_group"))
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

     // тогда использовать выпадающий список и выбрать какой-нибудь пункт
     }

     6. метод isElementPresent - не существует, создаем его:

     protected boolean isElementPresent(By locator) {

     // имя параметра-более общее, т.к. проверяется наличие/отсутсвие
     произвольного элемента с произвольным локатором, при помощи этого метода

     //далее сталкиваемся с ситуацией, когда нельзя предотвратить исключение,
       драйвер Selenium, не предоставляет возможности узнать за ранне, есть элемент на странице или нет
       можно этот элемент поискать

     wd.findElement(locator)

     //если элемент есть, то он найдется, если элемента нет - будет выброшенно исключение,
       поэтому оборачиваем в try

     try {                                    // если элемент нашелся
     wd.findElement(locator);
     return true;                             // то возвращаем true
     } catch (NoSuchElementException ex){     //если возникло исключение NoSuchElementException
     return false;                            // то возвращаем false
     }

     // Метод isElementPresent - для проверки наличия/отсутсвия элемента.

     testContactCreation - увидет на странице By.name("new_group") - и выберет значение из выпадающ списка по имени
     testContactModification - заметит, что такого элемента нет и пропустит эту строчку

        Метод получился достаточно общим, поэтому может быть использован и в других "помощниках",
        поэтому перенести его в BaseHelper

     7. При случае, если поле By.name("new_group"), на форме создания контакта - потеряли, его там нет, тогда тест упадет.
        Чтобы этого не произошло, необходимо создать доп параметр в методе fillContactForm, который будет указывать:
        контакт создается или можифицируется.

     public void fillContactForm(ContactData contactData, boolean creation)

        // boolean creation - передаем всего 2 значения:
                true - означает, что это форма создания, и там должен быть элемент By.name("new_group")
                false - означает, что это форма модификации, и элемент By.name("new_group") - отсутствует

        В тестах:

     testContactCreation, в методе fillContactForm - добавить true
     testContactModification, в методе fillContactForm - добавить false

     Добавить проверку на наличие нужного элемента на конкретной форме:

         //если это форма создания - значит элемент By.name("new_group") должен быть

     if (creation){

         // и необходимо выбирать какой-то элемент/значение из этого списка

     new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

        // если окажется, что элемента (By.name("new_group")) - нет, то ТЕСТ ДОЛЖЕН УПАСТЬ

        //иначе, мы не на форме создания и...

     } else {
     Assert.assertFalse(isElementPresent(By.name("new_group")));
     }
        // ... в этом случае, элемента (By.name("new_group")) - быть не должно
        // если окажется, что элемент (By.name("new_group")) - есть, то ТЕСТ ДОЛЖЕН УПАСТЬ

     */

    if (creation){
      //
      new Select(wd.findElement(name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(name("new_group")));
    }

    type(name("address2"), contactData.getAddress2());

    type(name("phone2"), contactData.getPhone2());

    type(name("notes"), contactData.getNotes());
  }

  public void selectContact() {
    click(name("selected[]"));
  }

  public void deletedContact() {
    click(xpath("//input[@value='Delete']"));
  }

  public void confirmationDeletedContact() {
    wd.switchTo().alert().accept();
  }

  public void editContact() {
    click(xpath("//img[@alt='Edit']"));
  }

  public void updateModification() {
    click(xpath("(//input[@name='update']"));
  }

  public boolean isThereAContac() {
    return isElementPresent(name("selected[]"));
  }

}
