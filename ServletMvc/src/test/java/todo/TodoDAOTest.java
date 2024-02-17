package todo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.servletmvc.todo.dao.TodoDAO;

public class TodoDAOTest {
    private TodoDAO todoDAO;

    @BeforeEach
    public void setUp(){
        todoDAO = new TodoDAO();
    }

    @Test
    void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }


}
