package com.demo.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //exclude config security form spring
@RestController
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

}
