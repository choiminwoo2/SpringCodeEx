package com.example.bookrestserver;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book,Long> {

}
