package com.using.mapStruct.mapStruct.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.using.mapStruct.mapStruct.domain.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
