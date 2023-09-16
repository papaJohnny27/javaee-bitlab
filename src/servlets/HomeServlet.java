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
        out.print("<table><thead>");
        out.print(" <tr><th>NAME</th><th>SURNAME</th><th>DEPARTMENT</th><th>SALARY</th></tr></thead>");
        out.print("<tbody>");

        List<Employee> employees = getEmployees();

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            out.print("<tr><td>" + employee.getName() + "</td><td>" + employee.getSurname()
                    + "</td><td>" + employee.getDepartment() + "</td><td>" + employee.getSalary() + "</td></tr>");
        }

        out.print(" </tbody></table></body>");

        out.flush();
    }

    private static List<Employee> getEmployees() {
        Employee employee = new Employee("Ilyas", "Zzhuanyshev", "IT", 550000);
        Employee employee1 = new Employee("Aibek", "Bagit", "HR", 650000);
        Employee employee2 = new Employee("Alibek", "Serikov", "Management", 400000);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);

        return employees;
    }
}
