package org.zerock.servletmvc.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString
public class TodoEntity {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
