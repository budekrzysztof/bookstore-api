package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;

import java.util.List;
import java.util.UUID;

public interface BookService {

    List<Book> getAllBooks(UUID user_id);

    Book getBookByIsbn(UUID user_id, String isbn) throws BSResourceNotFoundException;

    Book addBook(UUID user_id, String isbn, UUID author_id, String title, String description, Short publish_year, String publisher, String lang, Double price) throws BSBadRequestException;

    void updateBook(UUID user_id, String isbn, Book book) throws BSBadRequestException;

    void removeBook(UUID user_id, String isbn) throws BSResourceNotFoundException;
}
