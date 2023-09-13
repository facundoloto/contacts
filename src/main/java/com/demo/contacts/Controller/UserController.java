//package com.demo.contacts.Controller;
//import com.demo.contacts.Model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//@RestController
//@RequestMapping("/api/users")
//
//public class UserController {
//
//    private final UserEntity userEntity;
//
//    @Autowired
//    public UserController(UserEntity userEntity) {
//        this.userEntity = userEntity;
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userEntity.createUser(user);
//    }
//    @GetMapping("/")
//    public String helloWord() {
//        return ("hello welcome to my api");
//    }
//    @GetMapping("/{userId}")
//    public User getUserById(@PathVariable Long userId) {
//        return userEntity.getUserById(userId);
//    }
//
////    @PutMapping("/{userId}")
////    public UserService updateUser(@PathVariable Long userId, @RequestBody UserService updatedUser) {
////        return userService.updateUser(userId, updatedUser);
////    }
//
//    @DeleteMapping("/{userId}")
//    public void deleteUser(@PathVariable Long userId) {
//        userEntity.deleteUser(userId);
//    }
//}




