package com.using.mapStruct.mapStruct.api.DTOS.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.using.mapStruct.mapStruct.api.DTOS.request.BookRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.BookResponse;
import com.using.mapStruct.mapStruct.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    BookMapper mapper = Mappers.getMapper(BookMapper.class);

    @InheritInverseConfiguration
    @Mapping(source = "bookId", target = "id")
    BookResponse bookToBookResponse(Book book);

    @Mapping(source = "id", target = "bookId")
    @Mapping(target = "loan", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "isbn", ignore = true)
    Book bookResponseToBook(BookResponse bookResponse);

    List<BookResponse> bookListToBookResponses(List<Book> books);

    default Page<BookResponse> bookPageToBookResponses(Page<Book> books, int page, int size){
        List<BookResponse> bookResponses = books.stream()
        .map(this::bookToBookResponse)
        .collect(Collectors.toList());
        Pageable pageable = PageRequest.of(page, size);
        return new PageImpl<>(bookResponses, pageable, books.getTotalElements());
    }

    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "loan", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Book requestToEntity(BookRequest request);

    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "loan", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    void updateBookRequestToEntity(BookRequest request, @MappingTarget Book book);
}
