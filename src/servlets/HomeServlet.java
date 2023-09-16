package servlets;

import servlets.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<form action=\"form\" method=\"get\">");
        out.print(" <label>Name:</label> <input type=\"text\" name=\"name\" />");
        out.print("<label>Surname:</label> <input type=\"text\" name=\"surname\"/>");
        out.print("<input type=\"submit\" value=\"send\">");

        out.flush();
    }


}
