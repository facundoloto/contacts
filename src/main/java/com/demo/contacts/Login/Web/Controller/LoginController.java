package com.demo.contacts.Login.Web.Controller;

import com.demo.contacts.Handled.ResponseController;
import com.demo.contacts.Login.Domain.Dto.LoginDto;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Domain.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final UserServices loginService;
    private PasswordEncoder passwordEncoder;
    ResponseController responseController = new ResponseController();

    public LoginController(UserServices loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/")
    public ResponseEntity register(@RequestBody UserDto userDTO) throws Exception {
        String hashPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(hashPassword);
        UserDto user = loginService.create(userDTO);
        return responseController.ResponseStatusHttp(user);
    }

    @PostMapping("/signin")
    public ResponseEntity login(@RequestBody LoginDto loginDto) throws Exception {
//        CryptPassword cryptPassword = new CryptPassword();
//        String hashPassword = cryptPassword.encoder(userDTO.getPassword());
//        userDTO.setPassword(hashPassword);
        UserDto user = (UserDto) loginService.loadUserByUsername(loginDto.getUsername());
        return responseController.ResponseStatusHttp(user);
    }
}
