package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;
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
    public List<Book> getAllBooks() throws BSAuthException {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookByIsbn(String isbn) throws BSResourceNotFoundException, BSAuthException {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Book addBook(String isbn, UUID authorId, String title,
                        String description, Short publishYear, String publisher,
                        String lang, Double price) throws BSBadRequestException, BSAuthException {
        return bookRepository.findByIsbn(bookRepository.create(isbn, authorId, title, description, publishYear, publisher, lang, price));
    }

    @Override
    public void updateBook(String isbn, Book book) throws BSBadRequestException, BSAuthException {
        bookRepository.update(isbn, book);
    }

    @Override
    public void removeBook(String isbn) throws BSResourceNotFoundException, BSAuthException {
        bookRepository.removeByIsbn(isbn);
    }
}
