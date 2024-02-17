package org.zerock.servletmvc.todo.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.servletmvc.todo.dao.TodoDAO;
import org.zerock.servletmvc.todo.domain.TodoEntity;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.util.MapperUtil;

@Log4j2
public enum TodoService {
  INSTANCE;

  private TodoDAO dao;
  private ModelMapper modelMapper;

  TodoService() {
    dao = new TodoDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }

  public void register(TodoDTO todoDTO) throws SQLException {
    TodoEntity entity = modelMapper.map(todoDTO, TodoEntity.class);
    log.info(entity);
    dao.insert(entity);

  }

  public List<TodoDTO> getList() {

    return IntStream.range(0, 10).mapToObj(i -> {
      TodoDTO dto = TodoDTO.builder()
          .tno((long) i)
          .title("Todo.." + i)
          .dueDate(LocalDate.now())
          .build();

      return dto;
    }).collect(Collectors.toList());
  }

  public TodoDTO get(Long tno) {
    return TodoDTO.builder()
        .tno(tno)
        .title("Sample Todo")
        .dueDate(LocalDate.now())
        .finished(true)
        .build();
  }
}
