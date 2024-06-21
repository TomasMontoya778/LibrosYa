package com.using.mapStruct.mapStruct.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.using.mapStruct.mapStruct.api.DTOS.response.UserResponse;
import com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces.IUserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "Endpoints User")
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<Page<UserResponse>> insert(){
        
    }

}
