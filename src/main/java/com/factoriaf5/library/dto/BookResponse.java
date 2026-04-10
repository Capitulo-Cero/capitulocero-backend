package com.factoriaf5.library.dto;

public record BookResponse(
        Long id,
        String title,
        String isbn,
        Integer publicationYear,
        String image,
        String authorName,
        String authorLastName
) {
}
