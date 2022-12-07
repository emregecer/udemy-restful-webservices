package com.emregecer.udemy.springboot.mapper;

import com.emregecer.udemy.springboot.dto.UserDto;
import com.emregecer.udemy.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    @Mapping(source = "email", target = "email")
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

}
