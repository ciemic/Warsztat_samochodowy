package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.services.DBService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeDao {
    public static void main(String[] args) {
        List<Employee> employees = loadAllEmployees();
        System.out.println(employees);
        System.out.println();
        List<Order> employeeOrderList = new ArrayList<>();
        Employee employee = EmployeeDao.loadEmployeeById(1);
        employeeOrderList = EmployeeDao.loadEmployeeOrders(employee);
        System.out.println(employeeOrderList);
        System.out.println();

        List<Order> employeeInProgressOrderList = EmployeeDao.loadEmployeeOrdersInProgress(employee);
        System.out.println(employeeInProgressOrderList);

    }

    private static String databaseName = "car_service";

    public static void addEmployee(Employee employee) {

        String query = "Insert into employee Values (?,?,?,?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(employee.getId()));
        queryParams.add(employee.getName());
        queryParams.add(employee.getSurname());
        queryParams.add(employee.getAddress());
        queryParams.add(employee.getPhone());
        queryParams.add(employee.getNote());
        queryParams.add(String.valueOf(employee.getHourly()));
        queryParams.add(employee.getEmail());
        queryParams.add(employee.getBirthDate());

        DBService.executeUpdate(databaseName, query, queryParams);
    }

    public static void updateEmployee(Employee employee) {
        String query = "Update employee set name = ?, surname = ?, address = ?, phone = ?" +
                ", note = ?, hourly = ?, email = ?, birth_date = ? Where id = ?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(employee.getName());
        queryParams.add(employee.getSurname());
        queryParams.add(employee.getAddress());
        queryParams.add(employee.getPhone());
        queryParams.add(employee.getNote());
        queryParams.add(String.valueOf(employee.getHourly()));
        queryParams.add(employee.getEmail());
        queryParams.add(employee.getBirthDate());
        queryParams.add(String.valueOf(employee.getId()));

        DBService.executeUpdate(databaseName, query, queryParams);
    }

    public static void deleteEmployee(Employee employee) {
        String query = "DELETE FROM employee WHERE id=?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(employee.getId()));
        DBService.executeUpdate(databaseName, query, queryParams);
    }

    public static List<Employee> loadAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "Select * FROM employee";

        try {
            PreparedStatement preparedStatement = DBService.connect(databaseName).prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee loadedEmployee = new Employee();
                loadedEmployee.setId(resultSet.getInt("id"));
                loadedEmployee.setName(resultSet.getString("name"));
                loadedEmployee.setSurname(resultSet.getString("surname"));
                loadedEmployee.setAddress(resultSet.getString("address"));
                loadedEmployee.setPhone(resultSet.getString("phone"));
                loadedEmployee.setNote(resultSet.getString("note"));
                loadedEmployee.setHourly(resultSet.getDouble("hourly"));
                loadedEmployee.setEmail(resultSet.getString("email"));
                loadedEmployee.setBirthDate(resultSet.getString("birth_date"));

                employees.add(loadedEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    static public Employee loadEmployeeById(int id) {
        String query = "SELECT * FROM employee where id=?";
        Map<String, String> employeeEntry = DBService.executeSingleSelect(databaseName, query, String.valueOf(id));

        return getEmployee(employeeEntry);
    }

    static public List<Order> loadEmployeeOrders(Employee employee) {
        String query = "SELECT * FROM car_service.order where employee_id=?";
        List<Order> orders = new ArrayList<>();
        List<String> param = new ArrayList<>();
        param.add(String.valueOf(employee.getId()));

        List<Map<String, String>> mapList = DBService.executeMultipleSelect(databaseName, query, param);

        for (Map<String, String> map : mapList) {
            orders.add(OrderDao.getOrder(map));
        }
        return orders;
    }

    static public List<Order> loadEmployeeOrdersInProgress(Employee employee) {
        String query = "SELECT * FROM car_service.order where employee_id=? AND status_id<4";
        List<Order> orders = new ArrayList<>();
        List<String> param = new ArrayList<>();
        param.add(String.valueOf(employee.getId()));

        List<Map<String, String>> mapListOfOrders = DBService.executeMultipleSelect(databaseName, query, param);

        for (Map<String, String> map : mapListOfOrders) {
            orders.add(OrderDao.getOrder(map));
        }
        return orders;
    }

    private static Employee getEmployee(Map<String, String> employeeEntryMap) {
        Employee employee = new Employee();
        try {
            employee.setId(Integer.parseInt(employeeEntryMap.get("id")));
            employee.setName(employeeEntryMap.get("name"));
            employee.setSurname(employeeEntryMap.get("surname"));
            employee.setAddress(employeeEntryMap.get("address"));
            employee.setPhone(employeeEntryMap.get("phone"));
            employee.setNote(employeeEntryMap.get("note"));
            employee.setHourly(Double.parseDouble(employeeEntryMap.get("hourly")));
            employee.setEmail(employeeEntryMap.get("email"));
            employee.setBirthDate(employeeEntryMap.get("birth_date"));
        } catch (Exception e) {

        }
        return employee;
    }
}
