package com.demo.contacts.Auth.Domain.Dto;

public class AuthDto {
    private Long id;
    private String name;
    private String lastName;
    private String token;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setToken(String token) {
        this.token = token;
    }
}
