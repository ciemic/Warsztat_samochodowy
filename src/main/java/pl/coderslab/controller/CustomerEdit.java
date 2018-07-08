package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerEdit", urlPatterns = "/customeredit")
public class CustomerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer editCustomer = new Customer();

        try {
            editCustomer.setId(Integer.parseInt(request.getParameter("id")));
            editCustomer.setName(request.getParameter("name"));
            editCustomer.setSurname(request.getParameter("surname"));
            editCustomer.setBirthDate(request.getParameter("birthDate"));
            editCustomer.setAddress(request.getParameter("address"));
            editCustomer.setPhone(request.getParameter("phone"));
            editCustomer.setEmail(request.getParameter("email"));


            CustomerDao.updateCustomer(editCustomer);
        } catch (Exception e) {
        }

        getServletContext().getRequestDispatcher("/customer?id=" + editCustomer.getId()).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employeeId;
        Customer customer = new Customer();
        try {
            employeeId = Integer.parseInt(request.getParameter("id"));
            customer = CustomerDao.loadCustomerById(employeeId);
        } catch (Exception e) {
        }
        request.setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/WEB-INF/customerEdit.jsp").forward(request, response);
    }
}
