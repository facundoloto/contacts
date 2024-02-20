package com.demo.contacts.Contact.Domain.Service;

import com.demo.contacts.Contact.Domain.Dto.ContactDto;
import com.demo.contacts.Contact.Domain.Repository.ContactRepository;
import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
import com.demo.contacts.Crud.ServiceBase;
import com.demo.contacts.User.Domain.Repository.UserRepository;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService extends ServiceBase<ContactEntity, ContactDto> {
    private final ContactRepository contactRepository;
    private final UserRepository userRepository;
    public ContactService(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    private ContactEntity setContactToSave(ContactDto contactDto){
        ContactEntity contact = new ContactEntity();
        UserEntity user = userRepository.findById(contactDto.getUserId()).orElse(null);
        contact.setName(contactDto.getName());
        contact.setLastName(contactDto.getLastName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhoneNumber(contactDto.getNumber());
        contact.setUser(user);
        return contact;
    }

    public List<ContactDto> getAllContactsByUser(Long userId){
        List<ContactEntity> contacts = contactRepository.findContactByUserId(userId);
        return contacts.stream()
                .map(contact -> {
                    ContactDto contactDTO = new ContactDto(contact.getId(), contact.getName(), contact.getLastName(), contact.getEmail(), contact.getPhoneNumber(), userId);
                    return contactDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto getById(Long id) throws Exception {
        return super.getById(id);
    }

    @Override
    public ContactDto create(ContactDto contactDto) throws Exception {
        ContactEntity contact = this.setContactToSave(contactDto);
        ContactEntity contactSave= contactRepository.save(contact);
        return mapToDTO(contactSave);
    }

    @Override
    public ContactDto update(Long id, ContactDto contactDto) throws Exception {
        Optional<ContactEntity> existingContact = contactRepository.findById(id);

        if (existingContact.isPresent()) {
            ContactEntity contact = existingContact.get();
            UserEntity user = userRepository.findById(contactDto.getUserId()).orElse(null);

            contact.setName(contactDto.getName());
            contact.setLastName(contactDto.getLastName());
            contact.setEmail(contactDto.getEmail());
            contact.setPhoneNumber(contactDto.getNumber());
            contact.setUser(user);

            ContactEntity updateContact = contactRepository.save(contact);
            return mapToDTO(updateContact);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
    @Override
    public boolean delete(Long id) throws Exception {
        return super.delete(id);
    }
    @Override
    protected ContactDto mapToDTO(ContactEntity contactEntity) {
        return null;
    }
    @Override
    protected ContactEntity mapToEntity(ContactDto contactDto) {
        return null;
    }
}
