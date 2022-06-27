package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;

import java.util.List;
import java.util.UUID;

public interface BookService {

    List<Book> getAllBooks() throws BSAuthException;

    Book getBookByIsbn(String isbn) throws BSResourceNotFoundException, BSAuthException;

    Book addBook(String isbn, UUID authorId, String title, String description, Short publishYear, String publisher, String lang, Double price) throws BSBadRequestException, BSAuthException;

    void updateBook(String isbn, Book book) throws BSBadRequestException, BSAuthException;

    void removeBook(String isbn) throws BSResourceNotFoundException, BSAuthException;
}
