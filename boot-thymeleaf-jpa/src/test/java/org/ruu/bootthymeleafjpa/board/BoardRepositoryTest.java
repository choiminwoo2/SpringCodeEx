package org.ruu.bootthymeleafjpa.board;

import java.util.Optional;
import java.util.stream.IntStream;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    void insertMany(){

        IntStream.rangeClosed(1,100).forEach(i ->{
            Board board = Board.builder()
                .title("title.." + i)
                .content("content.." + i)
                .writer("user" + (i % 10))
                .build();
            Board result = repository.save(board);
            log.info("bno: " + result.getBno());
        });
    }

    @Test
    void testSelect(){
        Long bno = 100L;

        Optional<Board> result = repository.findById(bno);

        Board board = result.orElseThrow();

        log.info(board);
    }

    @Test
    void updateBoard(){
    Long bno = 100L;

    Optional<Board> result = repository.findById(bno);

    Board board = result.orElseThrow();

    board.change("update...title 100", "update content 100");

    repository.save(board);
    }

    @Test
    void deleteBoard(){
        Long bno = 1L;
        repository.deleteById(bno);
    }

    @Test
    public void testPaging(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = repository.findAll(pageable);

    }

    @Test
    void selectAll(){
        String[] types = {"t","c","w"};

        String keword = "1";

        Pageable pageable = PageRequest.of(1,10,Sort.by("bno").descending());

        Page<Board> result = repository.searchAll(types, keword, pageable);
    }

    @Test
    void selectAll2(){
        String[] types = {"t","c","w"};

        String keword = "1";

        Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());

        Page<Board> result = repository.searchAll(types, keword, pageable);

        log.info(result.getTotalPages());

        log.info(result.getSize());

        log.info(result.getNumber());


        log.info(result.hasPrevious() +" :" + result.hasNext());

        result.getContent().forEach(board -> log.info(board));
    }
}
