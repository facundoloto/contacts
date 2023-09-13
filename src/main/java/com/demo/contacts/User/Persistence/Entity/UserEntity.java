package com.demo.contacts.User.Persistence.Entity;
import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
Entity's a model to create a table in a database
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
//    @Column
//    @OneToMany(mappedBy = "contact")
//    private List<ContactEntity> contacts= new ArrayList<>();

    public UserEntity(int idUser, String name, String lastName, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
//        this.contacts = contacts;
    }



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
