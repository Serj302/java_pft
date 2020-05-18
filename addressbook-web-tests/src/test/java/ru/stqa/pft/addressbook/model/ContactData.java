package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String photo;
  private final String title;
  private final String company;
  private final String address;
  private final String tel_home;
  private final String tel_mobile;
  private final String tel_work;
  private final String fax;
  private final String email;
  private final String homepage;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String group;
  private final String address2;
  private final String phone2;
  private final String notes;

  public ContactData(
          String firstname,
          String middlename,
          String lastname,
          String nickname,
          String photo,
          String title,
          String company,
          String address,
          String tel_home,
          String tel_mobile,
          String tel_work,
          String fax,
          String email,
          String homepage,
          String bday,
          String bmonth,
          String byear,
          String group,
          String address2,
          String phone2,
          String notes) {

    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.photo = photo;
    this.title = title;
    this.company = company;
    this.address = address;
    this.tel_home = tel_home;
    this.tel_mobile = tel_mobile;
    this.tel_work = tel_work;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.group = group;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getPhoto() {
    return photo;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getTel_home() {
    return tel_home;
  }

  public String getTel_mobile() {
    return tel_mobile;
  }

  public String getTel_work() {
    return tel_work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getGroup() {
    return group;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

// Необходим, чтобы указать Java, как сравнивать объекты типа ContactData
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }
}
