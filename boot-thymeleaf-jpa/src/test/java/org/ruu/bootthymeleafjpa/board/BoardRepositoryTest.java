package org.ruu.bootthymeleafjpa.board;

import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository repository;


    @Test
    void BoardTest(){

        Board board = Board.builder()
            .title("title")
            .content("content")
            .writer("ㅇㅇ")
            .build();
        repository.saveAndFlush(board);

        Assertions.assertThat(board).isNotNull();

    }


    
}
