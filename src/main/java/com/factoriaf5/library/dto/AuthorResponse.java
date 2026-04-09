package com.factoriaf5.library.dto;

public record AuthorResponse(
        Long id,
        String name,
        String lastName,
        String nationality,
        Integer birthYear,
        Boolean isAlive
) {
}
