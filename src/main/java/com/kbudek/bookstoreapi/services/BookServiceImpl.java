package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;
import com.kbudek.bookstoreapi.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(UUID user_id) {
        return bookRepository.findAll(user_id);
    }

    @Override
    public Book getBookByIsbn(UUID user_id, String isbn) throws BSResourceNotFoundException {
        return bookRepository.findByIsbn(user_id, isbn);
    }

    @Override
    public Book addBook(UUID user_id, String isbn, UUID author_id, String title, String description, Short publish_year, String publisher, String lang, Double price) throws BSBadRequestException {
        return bookRepository.findByIsbn(user_id, bookRepository.create(user_id, isbn, author_id, title, description, publish_year, publisher, lang, price));
    }

    @Override
    public void updateBook(UUID user_id, String isbn, Book book) throws BSBadRequestException {
        bookRepository.update(user_id, isbn, book);
    }

    @Override
    public void removeBook(UUID user_id, String isbn) throws BSResourceNotFoundException {
        this.getBookByIsbn(user_id, isbn);
        bookRepository.removeByIsbn(user_id, isbn);
    }
}
