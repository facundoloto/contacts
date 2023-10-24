package com.demo.contacts.User.Domain.Dto;
/*
Dto user works as a model when it'll to receive data external
 */

import com.demo.contacts.Person.PersonDto;

public class UserDto extends PersonDto {
    private String password;

    public UserDto(long id, String name, String lastName, String email, String password) {
        super(id, name, lastName, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
