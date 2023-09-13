package com.demo.contacts.Contact.Persistence.Entity;

import com.demo.contacts.User.Persistence.Entity.UserEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "contact")
public class ContactEntity {

    @Id
    @Column(name = "id_contact")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContact;
    @Column
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String email;
    @Column
    private int number;

    public ContactEntity(int idContact, String name, String lastName, String email, int number) {
        this.idContact = idContact;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
    }
    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }




}