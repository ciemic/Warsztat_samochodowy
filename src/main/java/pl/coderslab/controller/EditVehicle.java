package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "editVehicle", urlPatterns = "/editVehicle")
public class EditVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(Integer.parseInt(request.getParameter("id")));
        vehicle.setBrand(request.getParameter("brand"));
        vehicle.setModel(request.getParameter("model"));
        vehicle.setProductionYear(request.getParameter("productionYear"));
        vehicle.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
        vehicle.setNextService(request.getParameter("nextService"));
        vehicle.setRegistrationNumber(request.getParameter("registrationNumber"));

        VehicleDao.updateVehicle(vehicle);

        response.sendRedirect(("/vehicle?id=" + vehicle.getId()));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = VehicleDao.loadVehicleById(id);
        request.setAttribute("vehicle", vehicle);

        int customerId = vehicle.getCustomerId();
        Customer customer = CustomerDao.loadCustomerById(customerId);
        request.setAttribute("customer", customer);

        List<Customer> customers = CustomerDao.loadAllCustomers();
        request.setAttribute("customers", customers);

        getServletContext().getRequestDispatcher("/WEB-INF/editVehicle.jsp").forward(request,response);
    }
}
