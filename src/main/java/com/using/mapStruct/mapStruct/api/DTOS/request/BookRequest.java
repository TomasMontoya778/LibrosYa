package com.using.mapStruct.mapStruct.api.DTOS.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @Size(min = 0, max = 100, message = "The title exceeds the numbers of characters")
    @NotBlank(message = "Title is required")
    private String title;

    @Size(min = 0, max = 100, message = "The Author exceeds the numbers of characters")
    @NotBlank(message = "Author is required")
    private String author;

    @NotNull(message = "The publication year is required")
    private int publicationYear;

    @Size(min = 0, max = 50, message = "The gener exceeds the numbers of characters")
    @NotBlank(message = "Gener is required")
    private String gener;

    @Size(min = 0, max = 20, message = "The isbn exceeds the numbers of characters")
    @NotBlank(message = "Isbn is required")
    private String isbn;
}
