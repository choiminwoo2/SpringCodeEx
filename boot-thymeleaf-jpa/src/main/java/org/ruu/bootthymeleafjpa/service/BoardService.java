package org.ruu.bootthymeleafjpa.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.dto.BoardDTO;
import org.ruu.bootthymeleafjpa.dto.BoardListReplyCountDTO;
import org.ruu.bootthymeleafjpa.dto.PageRequestDTO;
import org.ruu.bootthymeleafjpa.dto.PageResponseDTO;
import org.ruu.bootthymeleafjpa.exception.NotFoundPost;
import org.ruu.bootthymeleafjpa.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class BoardService {

    private final BoardRepository boardRepository;

    public Long register(BoardDTO boardDTO) {

        Board board = Board.builder()
            .writer(boardDTO.getWriter())
            .content(boardDTO.getContent())
            .title(boardDTO.getTitle())
            .build();
        return boardRepository.save(board).getBno();
    }

    public BoardDTO readOne(Long bno) throws NoSuchElementException {

        Board board = boardRepository.findById(bno)
            .orElseThrow(() -> new NotFoundPost(bno));

        return BoardDTO.builder()
            .bno(board.getBno())
            .writer(board.getWriter())
            .content(board.getContent())
            .title(board.getTitle())
            .modDate(board.getModDate())
            .regDate(board.getRegDate())
            .build();
    }

    public void modify(BoardDTO boardDTO){
        Board board = boardRepository.findById(boardDTO.getBno()).orElseThrow();
        board.change(boardDTO.getTitle(), boardDTO.getContent());
        boardRepository.save(board);
    }

    public void remove(Long bno){
        boardRepository.deleteById(bno);
    }

    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO){
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");

        Page<Board> result = boardRepository.searchAll(types,keyword,pageable);

        List<BoardDTO> dtoList = result.getContent().stream()
            .map(board -> BoardDTO.builder()
                .bno(board.getBno())
                .writer(board.getWriter())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .build())
            .toList();

        return PageResponseDTO.<BoardDTO>withAll()
            .pageRequestDTO(pageRequestDTO)
            .dtoList(dtoList)
            .total((int)result.getTotalElements())
            .build();
    }

    public PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO){
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types,keyword,pageable);

        return PageResponseDTO.<BoardListReplyCountDTO>withAll()
            .pageRequestDTO(pageRequestDTO)
            .dtoList(result.getContent())
            .total((int) result.getTotalElements())
            .build();
    }
}
