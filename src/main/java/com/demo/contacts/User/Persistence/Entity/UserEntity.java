package com.demo.contacts.User.Persistence.Entity;
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
    private long idUser;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;

    public UserEntity(long idUser, String name, String lastName, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
//I've created this constructor 'cause when You'll need get a information, the constructor doesn't need params
    public UserEntity(){

    }


    public long getIdUser() {
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