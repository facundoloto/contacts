package com.demo.contacts.Contact.Web.Controller;

import com.demo.contacts.Contact.Domain.Dto.ContactDto;
import com.demo.contacts.Contact.Domain.Service.ContactService;
import com.demo.contacts.Handled.ResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;
    ResponseController responseController = new ResponseController();

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getContactById(@PathVariable long id) throws Exception {
        return responseController.ResponseStatusHttp(contactService.getById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getAllContactsByUser(@PathVariable long id) throws Exception {
        System.out.println(id);
        List<ContactDto> contactsOfUser = contactService.getAllContactsByUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(contactsOfUser);
//      return responseController.ResponseStatusHttp(contactsOfUser);
    }

    @PostMapping("/")
    public ResponseEntity createContact(@RequestBody ContactDto contactDto) throws Exception {
        System.out.println(contactDto.getUserId());
        ContactDto contact = contactService.create(contactDto);
        return ResponseEntity.status(HttpStatus.OK).body(contact);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable long id, @RequestBody ContactDto contactDto) throws Exception {
        ContactDto contact = contactService.update(id, contactDto);
        return responseController.ResponseStatusHttp(contactDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) throws Exception {
        boolean isDelete = contactService.delete(id);
        return responseController.ResponseStatusHttpDelete(isDelete);
    }
}
