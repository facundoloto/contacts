package com.demo.contacts.User.Web.Controller;

import com.demo.contacts.Handled.ResponseController;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Domain.Services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.contacts.Crypto.CryptPassword;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServices userService;
    ResponseController responseController = new ResponseController();

    @Autowired
    public UserController(UserServices userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable long id) throws Exception {
        return responseController.ResponseStatusHttp(userService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody UserDto userDTO) throws Exception {
        CryptPassword cryptPassword = new CryptPassword();
        String hashPassword = cryptPassword.encoder(userDTO.getPassword());
        userDTO.setPassword(hashPassword);
        UserDto user = userService.create(userDTO);

        return responseController.ResponseStatusHttp(user);
    }
}

