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

@WebServlet(name = "CustomerControler", urlPatterns = "/customer")
public class CustomerControler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int customerId;
        Customer customer = new Customer();
        try {
            customerId = Integer.parseInt(request.getParameter("id"));
            customer = CustomerDao.loadCustomerById(customerId);
        } catch (Exception e) {
        }
        request.setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/WEB-INF/customer.jsp").forward(request, response);
    }
}
