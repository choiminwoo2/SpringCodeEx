package org.ruu.springmvcxml.mapper;

import java.util.List;
import org.ruu.springmvcxml.domain.TodoEntity;

public interface TodoMapper {
    String getTime();

    void insert(TodoEntity todoEntity);

    List<TodoEntity> selectAll();

    TodoEntity selectOne(Long tno);
}
