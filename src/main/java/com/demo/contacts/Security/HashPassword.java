package com.demo.contacts.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashPassword {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    public String encoder(String password_form) {
        return passwordEncoder.encode(password_form);
    }

    public boolean matchPassword(String password_form, String password_encode) {
        return passwordEncoder.matches(password_form, password_encode);
    }
}
