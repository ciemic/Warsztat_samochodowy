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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Homepage", urlPatterns = "")
public class Homepage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> employees = EmployeeDao.loadAllEmployees();
        Map<Employee, List<Order>> employeeListMap = new HashMap<>();
        for (Employee employee : employees) {
            List<Order> employeeOrders = EmployeeDao.loadEmployeeOrdersInProgress(employee);
            employeeListMap.put(employee, employeeOrders);
        }
        request.setAttribute("ordersMap", employeeListMap);
        request.setAttribute("employeeList", employees);

        getServletContext().getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
    }
}
