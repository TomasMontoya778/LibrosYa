package com.using.mapStruct.mapStruct.domain.entities;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookId;

    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private String author;
    @Column(nullable = false)
    private int publicationYear;
    @Column(nullable = false, length = 50)
    private String genre;
    @Column(nullable = false, length = 20)
    private String isbn;

    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Reservation> reservations;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Loan> loan;
}