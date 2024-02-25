package org.ruu.bootthymeleafjpa.board;

import lombok.extern.log4j.Log4j2;
import org.ruu.bootthymeleafjpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class boardRepositoryTest {

    @Autowired
    private BoardRepository repository;

    
}
