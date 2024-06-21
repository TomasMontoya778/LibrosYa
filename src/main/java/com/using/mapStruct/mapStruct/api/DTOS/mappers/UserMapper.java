package com.using.mapStruct.mapStruct.api.DTOS.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.using.mapStruct.mapStruct.api.DTOS.request.UserRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.UserResponse;
import com.using.mapStruct.mapStruct.domain.entities.User;

@Mapper
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "fullName", target = "fullNameMapped")
    UserResponse userToUserResponse(User user);

    @Mapping(source = "fullNameMapped", target = "fullName")
    User userResponseToUser(UserResponse user);

    @Mapping(source = "userNameRQ", target = "user")
    User requestToEntity(UserRequest userRequest, User user);
}
