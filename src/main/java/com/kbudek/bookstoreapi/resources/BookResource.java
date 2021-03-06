package com.kbudek.bookstoreapi.resources;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookstore/books")
public class BookResource {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(HttpServletRequest request) {
        UUID user_id = (UUID) UUID.fromString((String) request.getAttribute("user_id"));

        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(HttpServletRequest request,
                                              @PathVariable("isbn") String isbn) {
        UUID userId = (UUID) UUID.fromString((String) request.getAttribute("user_id"));
        Book book = bookService.getBookByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(HttpServletRequest request,
                                        @RequestBody Map<String, Object> bookMap) {

        // For printing caller's id but since I only run this locally then it doesn't really works out yet :(
        // System.out.println("Caller ip: " + request.getRemoteAddr().toString());

        // to retrieve caller's id - will be used in future
        UUID userId = UUID.fromString((String) request.getAttribute("user_id"));

        UUID authorId = UUID.fromString((String) bookMap.get("author_id"));
        String isbn = (String) bookMap.get("isbn");
        String publisher = (String) bookMap.get("publisher");
        String lang = (String) bookMap.get("lang");
        String title = (String) bookMap.get("title");
        String description = (String) bookMap.get("description");
        Short publishYear = ((Integer) bookMap.get("publish_year")).shortValue();
        Double price = (Double) bookMap.get("price");

        Book book = bookService.addBook(isbn, authorId, title, description, publishYear, publisher, lang, price);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Map<String, Boolean>> updateCategory(HttpServletRequest request,
                                                               @PathVariable("isbn") String isbn,
                                                               @RequestBody Book book) {
        UUID userId = UUID.fromString((String) request.getAttribute("user_id"));
        bookService.updateBook(isbn, book);
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }



}
