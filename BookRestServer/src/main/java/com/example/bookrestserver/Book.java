package com.example.bookrestserver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

    public long getBook_id() {
        return book_id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Id @GeneratedValue
    private long book_id;

    @Column
    private String name;

    @Column
    private String author;

    public Book(long book_id, String name, String author) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
    }

    public Book() {

    }

}
