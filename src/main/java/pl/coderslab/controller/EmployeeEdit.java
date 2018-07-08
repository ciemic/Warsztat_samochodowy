package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeEdit", urlPatterns = "/employeeedit")
public class EmployeeEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee editEmployee = new Employee();

        try {
            editEmployee.setId(Integer.parseInt(request.getParameter("id")));
            editEmployee.setName(request.getParameter("name"));
            editEmployee.setSurname(request.getParameter("surname"));
            editEmployee.setBirthDate(request.getParameter("birthDate"));
            editEmployee.setAddress(request.getParameter("address"));
            editEmployee.setPhone(request.getParameter("phone"));
            editEmployee.setEmail(request.getParameter("email"));
            editEmployee.setHourly(Double.parseDouble(request.getParameter("hourly")));
            editEmployee.setNote(request.getParameter("note"));


            EmployeeDao.updateEmployee(editEmployee);
        } catch (Exception e) {
        }

        getServletContext().getRequestDispatcher("/employee?id=" + editEmployee.getId()).forward(request, response);
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

        getServletContext().getRequestDispatcher("/WEB-INF/employeeEdit.jsp").forward(request, response);
    }
}
