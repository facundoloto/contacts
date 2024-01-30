package com.demo.contacts.Auth.Domain.Service;

import com.demo.contacts.Auth.Domain.Dto.LoginDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
public interface IAuthServices {

    public HashMap<String, String> login(LoginDto loginRequest) throws Exception;
    public HashMap<String, String> register(UserEntity user) throws Exception;
}
