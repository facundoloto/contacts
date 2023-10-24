package com.demo.contacts.User.Persistence.Entity;
import com.demo.contacts.Contact.Persistence.Entity.Contact;
import com.demo.contacts.Person.PersonEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends PersonEntity {
    @Column
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();

    public UserEntity(Long id, String name, String lastName, String email, String password, List<Contact> contacts) {
        super(id, name, lastName, email);
        this.password = password;
        this.contacts = contacts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
