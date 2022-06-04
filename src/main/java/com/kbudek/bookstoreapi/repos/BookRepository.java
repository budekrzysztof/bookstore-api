package com.kbudek.bookstoreapi.repos;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;

import java.util.List;
import java.util.UUID;

public interface BookRepository {

    List<Book> findAll(UUID user_id) throws BSResourceNotFoundException;

    Book findByIsbn(UUID user_id, String isbn) throws BSResourceNotFoundException;

    String create(UUID user_id, String isbn, UUID author_id, String title, String description, Short publish_year, String publisher, String lang, Double price) throws BSBadRequestException;

    void update(UUID user_id, String isbn, Book book) throws BSBadRequestException;

    void removeByIsbn(UUID user_id, String isbn);
}
