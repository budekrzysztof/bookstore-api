package com.kbudek.bookstoreapi.resources;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookstore/books")
public class BookResource {

    @Autowired
    BookService bookService;
    

    @GetMapping("")
    public String getAllBooks(HttpServletRequest request) {
        UUID user_id = (UUID) UUID.fromString((String) request.getAttribute("user_id"));
        return "Authenticated! User id: " + user_id; // this one returns correctly
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook(HttpServletRequest request,
                                        @RequestBody Map<String, Object> bookMap) {
        System.out.println(;request.getRemoteAddr().toString()

        UUID user_id = UUID.fromString((String) request.getAttribute("user_id"));
        UUID author_id = UUID.fromString((String) bookMap.get("author_id"));

        String isbn = (String) bookMap.get("isbn");
        String publisher = (String) bookMap.get("publisher");
        String lang = (String) bookMap.get("lang");
        String title = (String) bookMap.get("title");
        String description = (String) bookMap.get("description");

        Integer publish_year_i = (Integer) bookMap.get("publish_year"); // for later take a look at this cast again
        Short publish_year = publish_year_i.shortValue();
        Double price = (Double) bookMap.get("price");

        Book book = bookService.addBook(user_id, isbn, author_id, title, description, publish_year, publisher, lang, price);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }


}
