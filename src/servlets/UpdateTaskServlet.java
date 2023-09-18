package servlets;

import servlets.db.DBManager;
import servlets.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/update")
public class UpdateTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("task_id"));
        String title = req.getParameter("task_title");
        String description = req.getParameter("task_description");
        LocalDate deadlineDate = LocalDate.parse(req.getParameter("task_deadline_date"));
        boolean isDone = Boolean.parseBoolean(req.getParameter("task_is_done"));

        DBManager.updateTask(id,new Task(id,title,description,deadlineDate,isDone));
        resp.sendRedirect("/");
    }
}
