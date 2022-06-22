package com.kbudek.bookstoreapi.domain;

import java.util.UUID;

public class Book {

    private String isbn;
    private UUID author_id;
    private String title;
    private String description;
    private Short publish_year;
    private String publisher;
    private String lang;
    private Double price;

    public Book(String isbn, UUID author_id, String title, String description, Short publish_year, String publisher, String lang, Double price) {
        this.isbn = isbn;
        this.author_id = author_id;
        this.title = title;
        this.description = description;
        this.publish_year = publish_year;
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

    public UUID getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(UUID author_id) {
        this.author_id = author_id;
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

    public Short getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(Short publish_year) {
        this.publish_year = publish_year;
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
