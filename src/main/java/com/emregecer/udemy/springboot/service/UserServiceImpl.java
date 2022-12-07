package com.emregecer.udemy.springboot.service;

import com.emregecer.udemy.springboot.dto.UserDto;
import com.emregecer.udemy.springboot.entity.User;
import com.emregecer.udemy.springboot.mapper.AutoUserMapper;
import com.emregecer.udemy.springboot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    //private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto into User JPA Entity
        // User user = UserMapper.mapToUser(userDto);

        // User user = modelMapper.map(userDto, User.class);

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        // return UserMapper.mapToUserDto(savedUser);

        // return modelMapper.map(savedUser, UserDto.class);

        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();

        // return UserMapper.mapToUserDto(user);
        // return modelMapper.map(user, UserDto.class);

        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        //return users.stream()
        //        .map(UserMapper::mapToUserDto)
        //        .collect(Collectors.toList());

        //return users.stream()
        //        .map(user -> modelMapper.map(user, UserDto.class))
        //        .collect(Collectors.toList());

        return users.stream()
                .map(AutoUserMapper.MAPPER::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);

        //return UserMapper.mapToUserDto(updatedUser);

        //return modelMapper.map(updatedUser, UserDto.class);

        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
