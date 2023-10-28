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
    public UserDto getById(Long id) throws Exception {
        return super.getById(id);
    }

    /**
     * @param userDto
     * @return
     */
    @Override
    public UserDto create(UserDto userDto) throws Exception {
        UserDto user = super.create(userDto);
        return user;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) throws Exception {
        return super.update(id, userDto);
    }

    @Override
    public void delete(Long id) throws Exception {
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
