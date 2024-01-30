package com.demo.contacts.Auth.Domain.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

//class that works as a model for data login
@Data
@NoArgsConstructor
public class LoginDto {
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
