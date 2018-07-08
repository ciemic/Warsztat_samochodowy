package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerControler", urlPatterns = "/customer")
public class CustomerControler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int customerId;
        Customer customer = new Customer();
        List<Vehicle> vehicleList = new ArrayList<>();
        try {
            customerId = Integer.parseInt(request.getParameter("id"));
            customer = CustomerDao.loadCustomerById(customerId);
            vehicleList = VehicleDao.loadAllCustomerVehicles(customerId);
        } catch (Exception e) {
        }
        request.setAttribute("customer", customer);
        request.setAttribute("vehicles", vehicleList);

        getServletContext().getRequestDispatcher("/WEB-INF/customer.jsp").forward(request, response);
    }
}
