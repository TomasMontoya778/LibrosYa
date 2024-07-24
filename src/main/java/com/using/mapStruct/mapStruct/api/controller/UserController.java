package com.using.mapStruct.mapStruct.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.using.mapStruct.mapStruct.api.DTOS.request.UserRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.UserResponseFull;
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
    public ResponseEntity<UserResponseFull> insert(@Validated @RequestBody UserRequest request){
        return ResponseEntity.ok(this.userService.create(request));
    }
    @GetMapping
    public ResponseEntity<Page<UserResponseFull>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(this.userService.getAll(page - 1, size));
    }

}
