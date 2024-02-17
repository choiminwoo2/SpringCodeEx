package todo;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.todo.service.TodoService;

public class sTodoServiceTest {

  private TodoService todoService;

  @BeforeEach
  public void setUp() {
    todoService = TodoService.INSTANCE;
  }

  @Test
  void insert() throws Exception {
    todoService.register(
        TodoDTO.builder()
            .title("JDBC Test Title")
            .dueDate(LocalDate.now())
            .build()
    );
  }

}
