package com.emregecer.udemy.springboot.service;

import com.emregecer.udemy.springboot.dto.UserDto;
import com.emregecer.udemy.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}
