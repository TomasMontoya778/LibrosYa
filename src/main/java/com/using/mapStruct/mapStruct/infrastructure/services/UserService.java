package com.using.mapStruct.mapStruct.infrastructure.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.using.mapStruct.mapStruct.api.DTOS.mappers.UserMapper;
import com.using.mapStruct.mapStruct.api.DTOS.request.UserRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.UserResponseFull;
import com.using.mapStruct.mapStruct.domain.entities.User;
import com.using.mapStruct.mapStruct.domain.repositories.UserRepository;
import com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces.IUserService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;
    @Override
    public UserResponseFull create(UserRequest request) {
        User user = UserMapper.mapper.requestToEntity(request, new User());
        User userSaved = this.userRepository.save(user);
        return UserMapper.mapper.userToUserResponse(userSaved);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Page<UserResponseFull> getAll(int page, int size) {
        if(page < 0) page = 0;
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> user = userRepository.findAll(pageRequest);
        Page<UserResponseFull> userResponse = UserMapper.mapper.userPageToUserResponses(user, page, size);
        return userResponse;
    }

    @Override
    public UserResponseFull getById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserResponseFull update(String id, UserRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

}
