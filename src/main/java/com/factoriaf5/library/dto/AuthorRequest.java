package com.factoriaf5.library.dto;

public record AuthorRequest(
        String name,
        String lastName,
        String nationality,
        Integer birthYear,
        Boolean isAlive
) {
}
