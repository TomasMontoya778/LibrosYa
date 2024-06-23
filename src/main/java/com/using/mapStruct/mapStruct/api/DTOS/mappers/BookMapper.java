package com.using.mapStruct.mapStruct.api.DTOS.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import com.using.mapStruct.mapStruct.api.DTOS.request.BookRequest;
import com.using.mapStruct.mapStruct.api.DTOS.response.BookResponse;
import com.using.mapStruct.mapStruct.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    BookMapper mapper = Mappers.getMapper(BookMapper.class);
    @InheritInverseConfiguration
    @Mapping(source = "bookId", target = "id")
    BookResponse bookToBookResponse(Book book);

    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "loan", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Book requestToEntity(BookRequest request);
}
