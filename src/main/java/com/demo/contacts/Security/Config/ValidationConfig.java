package com.demo.contacts.Security.Config;

import com.demo.contacts.User.Validations.UserValidations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    @Bean
    public UserValidations userValidations(){
        return new UserValidations();
    }
}
