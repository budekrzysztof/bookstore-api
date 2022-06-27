package com.kbudek.bookstoreapi.domain;

import java.util.UUID;

public class Book {

    private String isbn;
    private UUID authorId;
    private String title;
    private String description;
    private Short publishYear;
    private String publisher;
    private String lang;
    private Double price;

    public Book(String isbn, UUID authorId, String title, String description, Short publishYear, String publisher, String lang, Double price) {
        this.isbn = isbn;
        this.authorId = authorId;
        this.title = title;
        this.description = description;
        this.publishYear = publishYear;
        this.publisher = publisher;
        this.lang = lang;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Short publishYear) {
        this.publishYear = publishYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
