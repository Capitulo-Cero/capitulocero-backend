package com.factoriaf5.library.dto;

public record BookRequest(
        String title,
        String isbn,
        Integer publicationYear,
        String image,
        Long authorId
) {
}
