package com.using.mapStruct.mapStruct.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(this.iBookService.getAll(page - 1, size));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable String id){
        return ResponseEntity.ok(this.iBookService.getById(id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable String id){
        this.iBookService.delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "The book has been deleted");
        return ResponseEntity.ok(response);
    }

}
