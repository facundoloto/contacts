package com.demo.contacts.User.Domain.Services;

import com.demo.contacts.Crud.ServiceBase;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import com.demo.contacts.User.Domain.Repository.UserRepository;
import com.demo.contacts.User.Persistence.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Service works for get and send information to DB and use the Interface Repository that contain methods
own e.g get a user for his/her email and method crud
 */
@Service
public class UserServices extends ServiceBase<UserEntity, UserDto> {
    @Autowired
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getById(Long id) {
        return super.getById(id);
    }

    @Override
    public UserDto create(UserDto userDto) {
        return super.create(userDto);
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return super.update(id, userDto);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    protected UserDto mapToDTO(UserEntity userEntity) {
        return UserMapper.INSTANCE.mapToDto(userEntity);
    }

    @Override
    protected UserEntity mapToEntity(UserDto userDto) {
        return UserMapper.INSTANCE.mapToEntity(userDto);
    }

}
