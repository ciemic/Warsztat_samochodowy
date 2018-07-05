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

@WebServlet(name = "OrderController", urlPatterns = "/order")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = OrderDao.loadOrderById(id);
        request.setAttribute("order", order);

        int vehicleId = order.getVehicleId();
        Vehicle vehicle = VehicleDao.loadVehicleById(vehicleId);
        request.setAttribute("vehicle", vehicle);

        int employeeId = order.getEmployeeId();
        Employee employee = EmployeeDao.loadEmployeeById(employeeId);
        request.setAttribute("employee", employee);

        getServletContext().getRequestDispatcher("/WEB-INF/order.jsp").forward(request,response);
    }
}
