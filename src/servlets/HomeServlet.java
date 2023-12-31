package servlets;

import servlets.db.DBManager;
import servlets.model.Employee;
import servlets.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("taskList", DBManager.getAllTasks());
       resp.setCharacterEncoding("UTF-8");
       req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("task_title");
        String description = req.getParameter("task_description");
        LocalDate deadlineDate = LocalDate.parse(req.getParameter("task_deadline_date"));
        boolean isDone = Boolean.parseBoolean(req.getParameter("task_is_done"));

        Task task = new Task(null,title,description,deadlineDate,isDone);
        DBManager.addTask(task);
        resp.sendRedirect("/");
    }
}
