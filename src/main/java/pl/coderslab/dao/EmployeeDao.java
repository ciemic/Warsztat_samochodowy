package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeDao {
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

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBService.connect(databaseName).prepareStatement(query);
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
        Employee employee = new Employee();
        String query = "SELECT * FROM employee where id=?";
        Map<String, String> employeeEntry = DBService.executeSingleSelect(databaseName, query, String.valueOf(id));

        try {
            employee.setId(Integer.parseInt(employeeEntry.get("id")));
            employee.setName(employeeEntry.get("name"));
            employee.setSurname(employeeEntry.get("surname"));
            employee.setAddress(employeeEntry.get("address"));
            employee.setPhone(employeeEntry.get("phone"));
            employee.setNote(employeeEntry.get("note"));
            employee.setHourly(Double.parseDouble(employeeEntry.get("hourly")));
            employee.setEmail(employeeEntry.get("email"));
            employee.setBirthDate(employeeEntry.get("birth_date"));
        } catch (Exception e) {

        }
        return employee;
    }



}