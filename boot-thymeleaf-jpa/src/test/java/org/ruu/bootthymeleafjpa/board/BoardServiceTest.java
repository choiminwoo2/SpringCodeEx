package org.ruu.bootthymeleafjpa.board;

import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.dto.BoardDTO;
import org.ruu.bootthymeleafjpa.dto.PageRequestDTO;
import org.ruu.bootthymeleafjpa.dto.PageResponseDTO;
import org.ruu.bootthymeleafjpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void register(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
            .title("Sample Title..")
            .content("SampleContent")
            .writer("user00")
            .build();

        Long bno = boardService.register(boardDTO);

        log.info("Bno: " + bno);

        Assertions.assertThat(bno).isNotNull();
    }

    @Test
    void readOne(){
        log.info(boardService.getClass().getName());
        long bno = 50L;

        BoardDTO boardDTO = boardService.readOne(bno);

        Assertions.assertThat(boardDTO.getBno()).isEqualTo(bno);
    }

    @Test
    void modify(){
        BoardDTO boardDTO = BoardDTO.builder()
            .bno(101L)
            .title("Update...101")
            .content("Update content 101...")
            .build();

        boardService.modify(boardDTO);

        BoardDTO boardDTO1 = boardService.readOne(101L);

        Assertions.assertThat(boardDTO.getContent()).isEqualTo(boardDTO1.getContent());
    }

    @Test
    void getList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .type("tcw")
            .keyword("1")
            .page(1)
            .size(10)
            .build();

        PageResponseDTO<BoardDTO> reponseDTO = boardService.list(pageRequestDTO);

        log.info(reponseDTO);
    }
}
