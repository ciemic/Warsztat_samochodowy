package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VehicleController", urlPatterns = "/vehicle")
public class VehicleController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = VehicleDao.loadVehicleById(id);
        request.setAttribute("vehicle", vehicle);

        int customerId = vehicle.getCustomerId();
        Customer customer = CustomerDao.loadCustomerById(customerId);
        request.setAttribute("customer", customer);

        getServletContext().getRequestDispatcher("/WEB-INF/vehicle.jsp").forward(request,response);
    }
}
