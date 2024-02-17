package org.zerock.servletmvc.todo.service;

import org.zerock.servletmvc.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDTO) {
        System.out.println("Debug" + todoDTO);
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
