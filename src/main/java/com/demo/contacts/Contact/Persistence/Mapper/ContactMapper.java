package com.demo.contacts.Contact.Persistence.Mapper;

import com.demo.contacts.Contact.Domain.Dto.ContactDto;
import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    /*
    mapping works for adapt property to dto from entity
     */
    //this works to adapt entity properties to dto e.g database to client//
    @Mapping(target = "number", source = "contact.phone_number")
    @Mapping(target = "userId", source = "contact.user_id")
    //@Mapping(target = "password", ignore = true)
    ContactMapper mapToDto(ContactEntity contactEntity);
    /*
    this works different 'cause this adapt dto to entity e.g works when user send information and entity
     need get properties from dto
     */
    @Mapping(target = "phone_number", source = "userDTO.number")
    @Mapping(target = "user_id", source = "userDTO.userId")
    ContactEntity mapToEntity(ContactDto contactDto);
}
