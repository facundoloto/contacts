package com.demo.contacts.User.Web.Controller;

import com.demo.contacts.Security.HashPassword;
import com.demo.contacts.Handled.ResponseController;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Domain.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServices userService;
    ResponseController responseController = new ResponseController();

    @Autowired
    public UserController(UserServices userService) {
        this.userService = userService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity getUserById(@PathVariable long id) throws Exception {
//        return responseController.ResponseStatusHttp(userService.getById(id));
//    }

//    @PostMapping("/")
//    public ResponseEntity createUser(@RequestBody UserDto userDTO) throws Exception {
//        CryptPassword cryptPassword = new CryptPassword();
//        String hashPassword = cryptPassword.encoder(userDTO.getPassword());
//        userDTO.setPassword(hashPassword);
//        UserDto user = userService.create(userDTO);
//
//        return responseController.ResponseStatusHttp(user);
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable long id, @RequestBody UserDto userDto) throws Exception {
        HashPassword cryptPassword = new HashPassword();
        String hashPassword = cryptPassword.encoder(userDto.getPassword());
        userDto.setPassword(hashPassword);
        UserDto user = userService.update(id, userDto);
        return responseController.ResponseStatusHttp(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) throws Exception {
        boolean isDelete = userService.delete(id);
        return responseController.ResponseStatusHttpDelete(isDelete);
    }

}

