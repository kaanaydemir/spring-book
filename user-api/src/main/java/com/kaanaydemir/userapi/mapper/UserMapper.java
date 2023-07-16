package com.kaanaydemir.userapi.mapper;

import com.kaanaydemir.userapi.dto.UserDto;
import com.kaanaydemir.userapi.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto convert(User user);

    User convert(UserDto userDto);
}
