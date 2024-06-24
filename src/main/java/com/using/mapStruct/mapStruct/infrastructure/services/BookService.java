package com.using.mapStruct.mapStruct.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.using.mapStruct.mapStruct.api.DTOS.mappers.BookMapper;
import com.using.mapStruct.mapStruct.api.DTOS.request.BookRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.BookResponse;
import com.using.mapStruct.mapStruct.domain.entities.Book;
import com.using.mapStruct.mapStruct.domain.repositories.BookRepository;
import com.using.mapStruct.mapStruct.infrastructure.abstract_services.interfaces.IBookService;
import com.using.mapStruct.mapStruct.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BookService implements IBookService{

    @Autowired
    private final BookRepository bookRepository;

    @Override
    public BookResponse create(BookRequest request) {
        Book book = BookMapper.mapper.requestToEntity(request);
        Book savedBook = this.bookRepository.save(book);
        return BookMapper.mapper.bookToBookResponse(savedBook);
    }
    private Book find(String id) throws BadRequestException{
        return this.bookRepository.findById(id).orElseThrow(() -> new BadRequestException("There are not book registered"));
    }
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
    }

    @Override
    public Page<BookResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Book> bookPage = this.bookRepository.findAll(pageRequest);
        Page<BookResponse> bookResponse = BookMapper.mapper.bookPageToBookResponses(bookPage, page, size);
        return bookResponse;
    }

    @Override
    public BookResponse getById(String id) {
        return BookMapper.mapper.bookToBookResponse(this.find(id));
    }

    @Override
    public BookResponse update(String id, BookRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    

}
