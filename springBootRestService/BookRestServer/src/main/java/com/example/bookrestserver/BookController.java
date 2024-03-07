package com.example.bookrestserver;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    private RestTemplate restTemplate;

    @Autowired
    public BookController(BookService bookService, RestTemplate restTemplate) {
        this.bookService = bookService;
        this.restTemplate = restTemplate;
    }


    @GetMapping("/list")
    public ResponseEntity<List<Book>> clientBookList(){
        ResponseEntity<List<Book>> response = restTemplate.exchange("http://localhost:8080/api/list", HttpMethod.GET,  null,
                new ParameterizedTypeReference<List<Book>>() {});
        logger.info("[BookController] MethodName: clientBookList() body: {}", response.getBody());
        return response;
    }

    @GetMapping("/api/list")
    public ResponseEntity<List<Book>> bookList()
    {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Baeldung-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");
        ResponseEntity<List<Book>> response = ResponseEntity.ok()
                .headers(responseHeaders)
                .body(bookService.findByBookList());
        return response;
    }

    @PostMapping("/save")
    public int save() {
        Book book = new Book(4, "spring", "jpas");

        return bookService.save(book);
    }

}
