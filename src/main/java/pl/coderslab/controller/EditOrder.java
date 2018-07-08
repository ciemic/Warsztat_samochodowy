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
import java.util.List;

@WebServlet(name = "EditOrder", urlPatterns = "/editOrder")
public class EditOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Order editOrder = new Order();

        editOrder.setId(Integer.parseInt(request.getParameter("orderId")));
        editOrder.setStatusId(Integer.parseInt(request.getParameter("statusId")));
        editOrder.setVehicleId(Integer.parseInt(request.getParameter("vehicleId")));
        editOrder.setProblemDescription(request.getParameter("problemDescription"));
        editOrder.setAcceptance(request.getParameter("acceptance"));
        if (!request.getParameter("plannedMaintenance").equalsIgnoreCase("")) {
            editOrder.setPlannedMaintenance(request.getParameter("plannedMaintenance"));
        }
        if (!request.getParameter("maintenanceStart").equalsIgnoreCase("")) {
            editOrder.setMaintenanceStart(request.getParameter("maintenanceStart"));
        }
        try {
            editOrder.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
        } catch (Exception e) {
        }
        editOrder.setMaintenaceDescription(request.getParameter("maintenanceDescription"));
        try {
            editOrder.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
        } catch (Exception e) {
        }
        try {
            editOrder.setPartsCost(Double.parseDouble(request.getParameter("partsCost")));
        } catch (Exception e) {
        }
        try {
            editOrder.setHoursAmount(Integer.parseInt(request.getParameter("hoursAmount")));
        } catch (Exception e) {
        }

        OrderDao.updateOrder(editOrder);

        response.sendRedirect(("/order?id=" + editOrder.getId()));
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

        List<Employee> employees = EmployeeDao.loadAllEmployees();
        request.setAttribute("employees", employees);

        getServletContext().getRequestDispatcher("/WEB-INF/editOrder.jsp").forward(request, response);
    }
}
