package org.zerock.servletmvc.todo.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.todo.service.TodoService;

@WebServlet(name = "TodoReadController", urlPatterns = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

  private final TodoService todoService = TodoService.INSTANCE;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("[TodoReadController]");

    Long tno = Long.parseLong(req.getParameter("tno"));
    TodoDTO dto = null;
    try {
      dto = todoService.get(tno);
    } catch (SQLException e) {
      log.info(e.getMessage());
      throw new RuntimeException(e);
    }

    req.setAttribute("dto", dto);

    req.getRequestDispatcher("/WEB-INF/todo/read.jsp")
        .forward(req, resp);
  }
}
