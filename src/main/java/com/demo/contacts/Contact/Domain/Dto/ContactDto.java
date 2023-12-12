package com.demo.contacts.Contact.Domain.Dto;

import com.demo.contacts.Person.PersonDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;

public class ContactDto extends PersonDto {
    private Long number;
    private Long userId;

    public ContactDto(long id, String name, String lastName, String email, Long number, Long userId) {
        super(id, name, lastName, email);
        this.number = number;
        this.userId = userId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
