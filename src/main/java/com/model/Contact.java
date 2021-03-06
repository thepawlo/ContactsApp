package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pawel on 2017-05-12.
 */

@Entity
@NamedQuery(name = "Contact.findContactByEmail", query = "select c from Contact c where c.email = :email")
public class Contact implements Serializable {

    public static final String FIND_BY_EMAIL = "Contact.findContactByEmail";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "mainContactCategoryID")
    private MainContactCategory mainContactCategory;

    @ManyToOne
    @JoinColumn(name = "businessContactCategoryID")
    private BusinessContactCategory businessContactCategory;


    private String otherContactCategory;
    private String phoneNumber;
    private Date birthdayDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MainContactCategory getMainContactCategory() {
        return mainContactCategory;
    }

    public void setMainContactCategory(MainContactCategory mainContactCategory) {
        this.mainContactCategory = mainContactCategory;
    }

    public BusinessContactCategory getBusinessContactCategory() {
        return businessContactCategory;
    }

    public void setBusinessContactCategory(BusinessContactCategory businessContactCategory) {
        this.businessContactCategory = businessContactCategory;
    }

    public String getOtherContactCategory() {
        return otherContactCategory;
    }

    public void setOtherContactCategory(String otherContactCategory) {
        this.otherContactCategory = otherContactCategory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
