package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddOrder", urlPatterns = "/addOrder")
public class AddOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order newOrder = new Order();

        newOrder.setStatusId(Integer.parseInt(request.getParameter("statusId")));
        newOrder.setVehicleId(Integer.parseInt(request.getParameter("vehicleId")));
        newOrder.setProblemDescription(request.getParameter("problemDescription"));
        if (!request.getParameter("plannedMaintenance").equalsIgnoreCase("")) {
            newOrder.setPlannedMaintenance(request.getParameter("plannedMaintenance"));
        }
        if (!request.getParameter("maintenanceStart").equalsIgnoreCase("")) {
            newOrder.setMaintenanceStart(request.getParameter("maintenanceStart"));
        }
        try {
            newOrder.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
        } catch (Exception e) {
        }
        newOrder.setMaintenaceDescription(request.getParameter("maintenanceDescription"));
        try {
            newOrder.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
        } catch (Exception e) {
        }
        try {
            newOrder.setPartsCost(Double.parseDouble(request.getParameter("partsCost")));
        } catch (Exception e) {
        }
        try {
            newOrder.setHoursAmount(Integer.parseInt(request.getParameter("hoursAmount")));
        } catch (Exception e) {
        }

        OrderDao.addOrder(newOrder);


        response.sendRedirect(("/orders"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicleList = new ArrayList<>();
        try {
            vehicleList = VehicleDao.loadAllVehicles();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Employee> employees = EmployeeDao.loadAllEmployees();

        request.setAttribute("employees", employees);
        request.setAttribute("vehicles", vehicleList);


        getServletContext().getRequestDispatcher("/WEB-INF/addOrder.jsp").forward(request, response);
    }
}
