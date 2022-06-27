package com.kbudek.bookstoreapi.repos;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;

import java.util.List;
import java.util.UUID;

public interface BookRepository {

    List<Book> findAll() throws BSResourceNotFoundException;

    Book findByIsbn(String isbn) throws BSResourceNotFoundException;

    String create(String isbn, UUID authorId, String title, String description, Short publishYear, String publisher, String lang, Double price) throws BSBadRequestException;

    void update(String isbn, Book book) throws BSBadRequestException;

    void removeByIsbn(String isbn);
}
