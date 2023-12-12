package com.demo.contacts.Contact.Persistence.Entity;
import com.demo.contacts.Person.PersonEntity;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import jakarta.persistence.*;

@Entity(name = "Contact")
@Table(name = "contact")
public class ContactEntity extends PersonEntity {
    @Column(name = "phone_number")
    private Long phoneNumber;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    public ContactEntity(){

    }
    public ContactEntity(Long id, String name, String lastName, String email, Long phoneNumber, UserEntity user) {
        super(id, name, lastName, email);
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
