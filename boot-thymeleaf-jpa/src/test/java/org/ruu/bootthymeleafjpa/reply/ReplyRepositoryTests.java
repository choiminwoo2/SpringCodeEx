package org.ruu.bootthymeleafjpa.reply;


import jakarta.transaction.Transactional;
import java.sql.SQLException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.domain.Reply;
import org.ruu.bootthymeleafjpa.dto.BoardListReplyCountDTO;
import org.ruu.bootthymeleafjpa.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void testInsert(){

        Long bno = 705L;

        Board board = Board.builder()
            .bno(bno)
            .build();

        Reply reply = Reply.builder()
            .board(board)
            .replyText("댓글....")
            .replyer("replyer1")
            .build();

        replyRepository.save(reply);
    }

    @Test
    @Transactional(rollbackOn = {SQLException.class})
    void replyByBoard(){
        Long bno = 705L;

        Pageable pageable = PageRequest.of(0,10, Sort.by("rno").descending());

        Page<Reply> result = replyRepository.listOfBoard(bno,pageable);

        result.getContent().forEach(reply -> log.info(reply));

    }

    @Test
    void testSearchReplyCount(){
        String[] types = {"t","c","w"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());

        Page<BoardListReplyCountDTO> result = replyRepository.searchWithReplyCount(types,keyword,pageable);

        log.info(result.getTotalPages());

        log.info(result.getNumber());

        log.info(result.hasPrevious() + " : " + result.hasNext());

        result.getContent().forEach(log::info);
    }
}
