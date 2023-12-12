package com.demo.contacts.User.Domain.Services;

import com.demo.contacts.User.Domain.Dto.UserDto;

public interface LoginUserServices{
    UserDto register(UserDto userDto) throws Exception;
}
