package com.factoriaf5.library.service;

import com.factoriaf5.library.dto.AuthorRequest;
import com.factoriaf5.library.dto.AuthorResponse;
import com.factoriaf5.library.exception.ResourceNotFoundException;
import com.factoriaf5.library.model.Author;
import com.factoriaf5.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public AuthorResponse getAuthorById(Long id) {
        return toResponse(findAuthorOrThrow(id));
    }

    @Transactional
    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = new Author();
        mapRequestToAuthor(request, author);
        return toResponse(authorRepository.save(author));
    }

    @Transactional
    public AuthorResponse updateAuthor(Long id, AuthorRequest request) {
        Author author = findAuthorOrThrow(id);
        mapRequestToAuthor(request, author);
        return toResponse(authorRepository.save(author));
    }

    @Transactional
    public void deleteAuthor(Long id) {
        Author author = findAuthorOrThrow(id);
        authorRepository.delete(author);
    }

    private Author findAuthorOrThrow(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    private void mapRequestToAuthor(AuthorRequest request, Author author) {
        author.setName(request.name());
        author.setLastName(request.lastName());
        author.setNationality(request.nationality());
        author.setBirthYear(request.birthYear());
        author.setIsAlive(request.isAlive());
    }

    private AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getLastName(),
                author.getNationality(),
                author.getBirthYear(),
                author.getIsAlive()
        );
    }
}
