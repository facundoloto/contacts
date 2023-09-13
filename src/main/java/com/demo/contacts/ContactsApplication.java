package com.demo.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

}
