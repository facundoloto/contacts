package com.demo.contacts.Auth.Web.Controller;

import com.demo.contacts.Auth.Domain.Dto.LoginDto;
import com.demo.contacts.Auth.Domain.Service.IAuthServices;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthServices authService;

    @PostMapping("/register/")
    private ResponseEntity<HashMap<String, String>> addUser(@RequestBody UserEntity user) throws Exception {
        HashMap<String, String> register= authService.register(user);
        if(register.get("created")=="true"){
            return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(authService.register(user), HttpStatus.FORBIDDEN);

        }
    }

    @PostMapping("/login/")
    private ResponseEntity login(@RequestBody LoginDto loginRequest) throws Exception {
        HashMap<String, String> login = authService.login(loginRequest);
        if (login.containsKey("jwt")) {
            return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.ACCEPTED);

        } else {
            return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.UNAUTHORIZED);
        }
    }
}