package org.ruu.bootthymeleafjpa.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import java.util.List;
import java.util.Objects;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.domain.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        if(types != null && types.length > 0 && keyword != null){
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type : types){
                switch (type){
                    case "t" -> booleanBuilder.or(board.title.contains(keyword));
                    case "c" -> booleanBuilder.or(board.content.contains(keyword));
                    case "w" -> booleanBuilder.or(board.writer.contains(keyword));
                }
            }
            query.where(booleanBuilder);
        }

        query.where(board.bno.gt(0L));

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list,pageable,count);
    }
}
