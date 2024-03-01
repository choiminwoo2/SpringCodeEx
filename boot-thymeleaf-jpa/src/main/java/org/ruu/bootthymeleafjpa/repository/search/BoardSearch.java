package org.ruu.bootthymeleafjpa.repository.search;

import org.ruu.bootthymeleafjpa.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {

    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}

