package com.demo.contacts.User.Persistence.Entity;
import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
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
    private List<ContactEntity> contactEntities = new ArrayList<>();

    public UserEntity(Long id, String name, String lastName, String email, String password, List<ContactEntity> contactEntities) {
        super(id, name, lastName, email);
        this.password = password;
        this.contactEntities = contactEntities;
    }

    public UserEntity() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ContactEntity> getContacts() {
        return contactEntities;
    }

    public void setContacts(List<ContactEntity> contactEntities) {
        this.contactEntities = contactEntities;
    }
}
