package org.zerock.servletmvc.todo;

import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[ Controller ]/todo/list");
        List<TodoDTO> list = TodoService.INSTANCE.getList();

        req.setAttribute("list", list);

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp")
                .forward(req, resp);
    }
}
