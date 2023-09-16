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
        out.print(" <label>Name:</label> <input type=\"text\" name=\"name\" /><br/>");
        out.print(" <label>Surname:</label> <input type=\"text\" name=\"surname\"/><br/>");
        out.print(" <label>Food:</label>");
        out.print("<select name=\"food\"><option>Manty - 900KZT</option>");
        out.print(" <option>Plov - 1200KZT</option><option>Beshbarmak - 2500KZT</option>");
        out.print("<option>Kuirdak - 1500KZT</option></select><br/>");
        out.print("<input type=\"submit\" value=\"order\"></form>");

        out.flush();
    }


}
