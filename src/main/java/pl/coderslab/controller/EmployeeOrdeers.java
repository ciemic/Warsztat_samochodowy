package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeOrdeers", urlPatterns = "/employeeorders")
public class EmployeeOrdeers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int employeeId;
        boolean actualOrders = false;

        List<Order> employeeOrderList = new ArrayList<>();
        try {
            employeeId = Integer.parseInt(request.getParameter("id"));
            actualOrders = Boolean.parseBoolean(request.getParameter("actual"));

            Employee employee = EmployeeDao.loadEmployeeById(employeeId);
            if (!actualOrders)
                employeeOrderList = EmployeeDao.loadEmployeeOrders(employee);
            else
                employeeOrderList = EmployeeDao.loadEmployeeOrdersInProgress(employee);
        } catch (Exception e) {
        }
        request.setAttribute("orders", employeeOrderList);

        getServletContext().getRequestDispatcher("/WEB-INF/orders.jsp").forward(request, response);

    }
}
