package com.demo.contacts.User.Domain.Services;
import com.demo.contacts.Handled.HandledException;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import com.demo.contacts.User.Domain.Repository.UserRepository;
import com.demo.contacts.User.Persistence.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
Service works for get and send information to DB and use the Interface Repository that contain methods
own e.g get a user for his/her email and method crud
 */
@Service
public class UserServices {

    @Autowired
    private final UserRepository userRepository;
    private static String DATABASE_EXCEPTION = "DATABASE_EXCEPTION";
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto userDTO) {
        UserEntity user = UserMapper.INSTANCE.userDTOToUser(userDTO);
        UserEntity savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(savedUser);
    }
    public UserDto getUserById(long userId) throws HandledException {
        try {
            UserEntity user= userRepository.findById(userId).orElse(null);
            UserDto userFindById = UserMapper.INSTANCE.userToUserDTO(user);
            return  userFindById;
        } catch (Exception e) {
            e.printStackTrace();
            throw new HandledException(DATABASE_EXCEPTION,"Failed to get user", e);
        }
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::userToUserDTO)
                .collect(Collectors.toList());
    }

}
