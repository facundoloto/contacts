package com.demo.contacts.Contact.Domain.Dto;

import com.demo.contacts.Person.PersonDto;

public class ContactDto extends PersonDto {
    private int number;

    public ContactDto(long id, String name, String lastName, String email, int number) {
        super(id, name, lastName, email);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
