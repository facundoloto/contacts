package com.demo.contacts.User.Persistence.Mapper;

import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-25T14:52:38-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto mapToDto(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        String lastName = null;
        long id = 0L;
        String name = null;
        String email = null;
        String password = null;

        lastName = user.getLastName();
        if ( user.getId() != null ) {
            id = user.getId();
        }
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();

        UserDto userDto = new UserDto( id, name, lastName, email, password );

        return userDto;
    }

    @Override
    public UserEntity mapToEntity(UserDto userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setLastName( userDTO.getLastName() );
        userEntity.setId( userDTO.getId() );
        userEntity.setName( userDTO.getName() );
        userEntity.setEmail( userDTO.getEmail() );
        userEntity.setPassword( userDTO.getPassword() );

        return userEntity;
    }
}
