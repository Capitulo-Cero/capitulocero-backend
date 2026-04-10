package com.factoriaf5.library.service;

import com.factoriaf5.library.dto.BookRequest;
import com.factoriaf5.library.dto.BookResponse;
import com.factoriaf5.library.exception.ResourceNotFoundException;
import com.factoriaf5.library.model.Author;
import com.factoriaf5.library.model.Book;
import com.factoriaf5.library.repository.AuthorRepository;
import com.factoriaf5.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public BookResponse getBookById(Long id) {
        return toResponse(findBookOrThrow(id));
    }

    @Transactional
    public BookResponse createBook(BookRequest request) {
        Author author = findAuthorOrThrow(request.authorId());
        Book book = new Book();
        mapRequestToBook(request, book, author);
        return toResponse(bookRepository.save(book));
    }

    @Transactional
    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = findBookOrThrow(id);
        Author author = findAuthorOrThrow(request.authorId());
        mapRequestToBook(request, book, author);
        return toResponse(bookRepository.save(book));
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = findBookOrThrow(id);
        bookRepository.delete(book);
    }

    private Book findBookOrThrow(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    private Author findAuthorOrThrow(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    private void mapRequestToBook(BookRequest request, Book book, Author author) {
        book.setTitle(request.title());
        book.setIsbn(request.isbn());
        book.setPublicationYear(request.publicationYear());
        book.setImage(request.image());
        book.setAuthor(author);
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.getImage(),
                book.getAuthor().getName(),
                book.getAuthor().getLastName()
        );
    }
}
