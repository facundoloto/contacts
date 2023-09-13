package com.demo.contacts.User.Web.Controller;

import com.demo.contacts.Handled.HandledException;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Persistence.Mapper.UserMapper;
import com.demo.contacts.User.Domain.Repository.UserRepository;
import com.demo.contacts.User.Domain.Services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/api/users")
    public class UserController {
        private final UserServices userService;

        @Autowired
        public UserController(UserServices userService) {
            this.userService = userService;
        }

        @GetMapping("/{id}")
        public UserDto getUserById(@PathVariable Long userId) throws HandledException {
            return userService.getUserById(userId);
        }
        @PostMapping("/")
        public UserDto createUser(@RequestBody UserDto userDTO) {
            return userService.createUser(userDTO);
        }
        // Add endpoints for creating, updating, and deleting users
    }
        // Other controller methods

