package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Customers", urlPatterns = "/customers")
public class Customers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer newCustomer = new Customer();

        try {
            newCustomer.setId(0);
            newCustomer.setName(request.getParameter("name"));
            newCustomer.setSurname(request.getParameter("surname"));
            newCustomer.setBirthDate(request.getParameter("birthDate"));
            newCustomer.setAddress(request.getParameter("address"));
            newCustomer.setPhone(request.getParameter("phone"));
            newCustomer.setEmail(request.getParameter("email"));


            CustomerDao.addCustomer(newCustomer);
        } catch (Exception e) {
        }

        this.doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = CustomerDao.loadAllCustomers();
        request.setAttribute("customers", customers);

        getServletContext().getRequestDispatcher("/WEB-INF/customers.jsp").forward(request, response);
    }
}
