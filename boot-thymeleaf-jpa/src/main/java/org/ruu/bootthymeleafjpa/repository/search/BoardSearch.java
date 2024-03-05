package org.ruu.bootthymeleafjpa.repository.search;

import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.dto.BoardListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
    Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types,
        String keyword,
        Pageable pageable);
}

