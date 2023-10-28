package com.demo.contacts.Handled;

import com.demo.contacts.Person.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseController {
    private PersonDto dto;

    public ResponseController() {
    }

    public ResponseEntity ResponseStatusHttp(PersonDto dto) {
        if (dto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
