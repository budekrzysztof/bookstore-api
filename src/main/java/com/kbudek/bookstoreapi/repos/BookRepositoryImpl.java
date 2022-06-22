package com.kbudek.bookstoreapi.repos;

import com.kbudek.bookstoreapi.domain.Book;
import com.kbudek.bookstoreapi.exceptions.BSBadRequestException;
import com.kbudek.bookstoreapi.exceptions.BSResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static final String SQL_CREATE = "INSERT INTO bs_books (isbn, author_id, title, description, publish_year, publisher, lang, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_ISBN = "SELECT * FROM bs_books WHERE isbn=?";
    private static final String SQL_FIND_ALL = "SELECT * FROM bs_books";
    //private static final String SQL_UPDATE = "UPDATE bs_books SET author_id = ?, title = ?, description = ?, publish_year = ?, publisher = ?, lang = ?, price = ? WHERE isbn = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll() throws BSResourceNotFoundException {
        return jdbcTemplate.query(SQL_FIND_ALL, bookRowMapper);
    }

    @Override
    public Book findByIsbn(String isbn) throws BSResourceNotFoundException {
        try {
            return (Book) jdbcTemplate.queryForObject(SQL_FIND_BY_ISBN, bookRowMapper, isbn);
        } catch (Exception e){
            throw new BSResourceNotFoundException("Book not found");
        }
    }

    @Override
    public String create(String isbn, UUID author_id, String title, String description, Short publish_year, String publisher, String lang, Double price) throws BSBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, isbn);
                ps.setObject(2, author_id);
                ps.setString(3, title);
                ps.setString(4, description);
                ps.setShort(5, publish_year);
                ps.setString(6, publisher);
                ps.setString(7, lang);
                ps.setDouble(8, price);
                return ps;
            }, keyHolder);
            return (String) keyHolder.getKeys().get("isbn");
        } catch (Exception e){
            throw new BSBadRequestException("Book already exists.");
        }
    }

    @Override
    public void update(String isbn, Book book) throws BSBadRequestException {

    }

    @Override
    public void removeByIsbn(String isbn) {

    }

    private RowMapper<Book> bookRowMapper = ((rs, rowNum) -> {
        return new Book(rs.getString("isbn"),
                (UUID) rs.getObject("author_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getShort("publish_year"),
                rs.getString("publisher"),
                rs.getString("lang"),
                rs.getDouble("price"));
    });
}