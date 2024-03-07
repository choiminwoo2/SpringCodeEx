package com.example.bookrestserver;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    Logger logger = LoggerFactory.getLogger(BookService.class);
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findByBookList() {
        ArrayList<Book> bookList = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(bookList::add);
        return bookList;

    }
    public int save(Book book){
        bookRepository.save(book);
        return 1;

    }
}
