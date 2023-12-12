package com.demo.contacts.User.Domain.Services;

import com.demo.contacts.Crud.ServiceBase;
import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import com.demo.contacts.User.Domain.Repository.UserRepository;
import com.demo.contacts.User.Persistence.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
Service works for get and send information to DB and use the Interface Repository that contain methods
own e.g get a user for his/her email and method crud
 */
@Service
public class UserServices extends ServiceBase<UserEntity, UserDto> implements UserDetailsService, LoginUserServices
{
    @Autowired
    private final UserRepository userRepository;
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto register(UserDto userDto) throws Exception {
        UserDto user = super.create(userDto);
        return user;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if(user != null){
            return (UserDetails) user;
        }
        return (UserDetails) new UsernameNotFoundException("user doesn't find");
    }
    @Override
    public UserDto getById(Long id) throws Exception {
        return super.getById(id);
    }
    @Override
    public boolean delete(Long id) throws Exception {
      return super.delete(id);
    }
    @Override
    public UserDto update(Long id, UserDto userDto) throws Exception {
        try {
            UserEntity existingEntity = repository.findById(id).orElse(null);
            if (existingEntity != null) {
                existingEntity.setName(userDto.getName());
                existingEntity.setLastName(userDto.getLastName());
                existingEntity.setEmail(userDto.getEmail());
                existingEntity.setPassword(userDto.getPassword());
                existingEntity = repository.save(existingEntity);
                return mapToDTO(existingEntity);
            }
          return null;
        } catch (Exception e) {
            throw new Exception(e);
        }
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
