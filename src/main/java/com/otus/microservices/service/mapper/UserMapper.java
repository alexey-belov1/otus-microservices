package com.otus.microservices.service.mapper;

import com.otus.microservices.model.User;
import com.otus.microservices.rest.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {
}
