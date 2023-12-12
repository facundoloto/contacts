package com.demo.contacts.Login.Domain.Service;

import com.demo.contacts.User.Domain.Dto.UserDto;
import com.demo.contacts.User.Domain.Repository.UserRepository;
import com.demo.contacts.User.Domain.Services.UserServices;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//public class LoginService extends UserServices implements UserDetailsService {
//    private UserRepository userRepository;
//
//    public UserRepository getUserRepository() {
//        return userRepository;
//    }
//
//    //    @Override
////    public UserDto create(UserDto userDto) throws Exception {
////        //before save user on dateBase we encode the password
////        userDto.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
////        return super.create(userDto);
////    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByEmail(email);
//        if(user != null){
//            return (UserDetails) user;
//        }
//        return (UserDetails) new UsernameNotFoundException("user doesn't find");
//    }
//}
////
////    @Override
////    protected UserDto mapToDTO(UserEntity userEntity) {
////        return super.mapToDTO(userEntity);
////    }
////
////    @Override
////    protected UserEntity mapToEntity(UserDto userDto) {
////        return super.mapToEntity(userDto);
////    }
////}
