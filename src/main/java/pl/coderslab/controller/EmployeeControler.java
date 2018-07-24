package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeControler", urlPatterns = "/employee")
public class EmployeeControler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employeeId;
        Employee employee = new Employee();
        try {
            employeeId = Integer.parseInt(request.getParameter("id"));
            employee = EmployeeDao.loadEmployeeById(employeeId);
        } catch (Exception e) {
        }
        request.setAttribute("employee", employee);

        getServletContext().getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);
    }
}
