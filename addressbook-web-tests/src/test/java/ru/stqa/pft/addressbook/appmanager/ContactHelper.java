package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
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

    type(By.name("firstname"), contactData.getFirstname());

    type(By.name("middlename"), contactData.getMiddlename());

    type(By.name("lastname"), contactData.getLastname());

    type(By.name("nickname"), contactData.getNickname());

    photo(By.name("photo"), contactData.getPhoto());

    type(By.name("title"), contactData.getTitle());

    type(By.name("company"), contactData.getCompany());

    type(By.name("address"), contactData.getAddress());

    type(By.name("home"), contactData.getTel_home());

    type(By.name("mobile"), contactData.getTel_mobile());

    type(By.name("work"), contactData.getTel_work());

    type(By.name("fax"), contactData.getFax());

    type(By.name("email"), contactData.getEmail());

    type(By.name("homepage"), contactData.getHomepage());

    select(By.name("bday"), contactData.getBday());

    select(By.name("bmonth"), contactData.getBmonth());

    type(By.name("byear"), contactData.getByear());

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
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("address2"), contactData.getAddress2());

    type(By.name("phone2"), contactData.getPhone2());

    type(By.name("notes"), contactData.getNotes());
  }

  public void selectContact() {
    click(By.name("selected[]"));
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
    return isElementPresent(By.name("selected[]"));
  }

}
