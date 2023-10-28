package com.demo.contacts.Contact.Domain.Service;

import com.demo.contacts.Contact.Domain.Dto.ContactDto;
import com.demo.contacts.Contact.Domain.Repository.ContactRepository;
import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
import com.demo.contacts.Crud.ServiceBase;

public class ContactService extends ServiceBase<ContactEntity, ContactDto> {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactDto getById(Long id) throws Exception {
        return super.getById(id);
    }

    @Override
    public ContactDto create(ContactDto contactDto) throws Exception {
        return super.create(contactDto);
    }

    @Override
    public ContactDto update(Long id, ContactDto contactDto) throws Exception {
        return super.update(id, contactDto);
    }

    @Override
    public void delete(Long id) throws Exception {
        super.delete(id);
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
