package org.ruu.bootthymeleafjpa.repository;

import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

}
