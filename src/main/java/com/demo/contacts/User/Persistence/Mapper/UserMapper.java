package com.demo.contacts.User.Persistence.Mapper;
/*
Mapper is a class where we put information external to dto
this works when for some reason the name of a column change we won't to need change all name in the app
just we change the name of property here.
 */
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
/*
mapping works for adapt property to dto from entity
 */
    //this works to adapt entity properties to dto e.g database to client//
    @Mapping(target = "id", source = "user.idUser")
    //@Mapping(target = "password", ignore = true)
    UserDto userToUserDTO(UserEntity user);
/*
this works different 'cause this adapt dto to entity e.g works when user send information and entity
 need get properties from dto
 */
    @Mapping(target = "idUser", source = "userDTO.id")
    UserEntity userDTOToUser(UserDto userDTO);
}
