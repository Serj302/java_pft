package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {

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

    select(By.name("new_group"), contactData.getNew_group());

    type(By.name("address2"), contactData.getAddress2());

    type(By.name("phone2"), contactData.getPhone2());

    type(By.name("notes"), contactData.getNotes());
  }

}
