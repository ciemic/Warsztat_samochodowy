package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Employees", urlPatterns = "/employees")
public class Employees extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee newEmployee = new Employee();

        try {
            newEmployee.setId(0);
            newEmployee.setName(request.getParameter("name"));
            newEmployee.setSurname(request.getParameter("surname"));
            newEmployee.setBirthDate(request.getParameter("birthDate"));
            newEmployee.setAddress(request.getParameter("address"));
            newEmployee.setPhone(request.getParameter("phone"));
            newEmployee.setEmail(request.getParameter("email"));
            newEmployee.setHourly(Double.parseDouble(request.getParameter("hourly")));
            newEmployee.setNote(request.getParameter("note"));


            EmployeeDao.addEmployee(newEmployee);
        } catch (Exception e) {
        }

        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> employees = EmployeeDao.loadAllEmployees();
        request.setAttribute("employees", employees);

        getServletContext().getRequestDispatcher("/WEB-INF/employees.jsp").forward(request, response);
    }
}
