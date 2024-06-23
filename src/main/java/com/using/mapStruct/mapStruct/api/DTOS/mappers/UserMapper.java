package com.using.mapStruct.mapStruct.api.DTOS.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.using.mapStruct.mapStruct.api.DTOS.request.UserRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.UserResponse;
import com.using.mapStruct.mapStruct.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    // UserMapper mapper = Mappers.getMapper(UserMapper.class);

    // @Mapping(source = "id", target = "id")
    // @Mapping(source = "fullName", target = "fullNameMapped")
    // @Mapping(source = "email", target = "emailMapped")
    // @Mapping(source = "role", target = "roleMapped")
    // @Mapping(source = "reservations", target = "reservationResponseToUsers")
    // @Mapping(source = "loan", target = "loanResponseToUsers")
    // UserResponse userToUserResponse(User user);

    // @Mapping(source = "fullNameMapped", target = "fullName")
    // User userResponseToUser(UserResponse user);

    // @Mapping(source = "userNameRQ", target = "user")
    // User requestToEntity(UserRequest userRequest, User user);
}
