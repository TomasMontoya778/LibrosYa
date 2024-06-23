package com.using.mapStruct.mapStruct.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.using.mapStruct.mapStruct.api.DTOS.request.BookRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.BookResponse;
import com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces.IBookService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
@Tag(name = "Endpoints Book")
public class BookController {
    @Autowired
    private final IBookService iBookService;

    @PostMapping
    public ResponseEntity<BookResponse> insert(@Validated @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(this.iBookService.create(bookRequest));
    }

}
