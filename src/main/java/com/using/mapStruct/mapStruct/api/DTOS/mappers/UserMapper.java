package com.using.mapStruct.mapStruct.api.DTOS.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.using.mapStruct.mapStruct.api.DTOS.request.UserRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.UserResponseFull;
import com.using.mapStruct.mapStruct.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "reservation", ignore = true)
    @Mapping(target = "loan", ignore = true)
    UserResponseFull userToUserResponse(User user);

    @InheritInverseConfiguration
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "loan", ignore = true)
    @Mapping(target = "password", ignore = true)
    User userResponseToUser(UserResponseFull user);

    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "loan", ignore = true)
    @Mapping(source = "userRequest.password", target = "password")
    @Mapping(source = "userRequest.role", target = "role")
    @Mapping(source = "userRequest.fullName", target = "fullName")
    @Mapping(source = "userRequest.user", target = "user")
    @Mapping(source = "userRequest.email", target = "email")
    User requestToEntity(UserRequest userRequest, User user);

    default Page<UserResponseFull> userPageToUserResponses(Page<User> users, int page, int size){
        List<UserResponseFull> userResponses = users.stream()
        .map(this::userToUserResponse)
        .collect(Collectors.toList());
        Pageable pageable = PageRequest.of(page, size);
        return new PageImpl<>(userResponses, pageable, users.getTotalElements());
    }
}
