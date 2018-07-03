package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.services.DBService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static String databaseName = "car_service";

    private static void addEmployee(Employee employee) {

        String query = "Insert into employees Values (?,?,?,?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(employee.getId()));
        queryParams.add(employee.getName());
        queryParams.add(employee.getSurname());
        queryParams.add(employee.getPhone());
        queryParams.add(employee.getNote());
        queryParams.add(String.valueOf(employee.getHourly()));
        queryParams.add(employee.getEmail());
        queryParams.add(employee.getBirthDate());


        DBService.executeUpdate(databaseName, query, queryParams);
    }

    private static void updateEmployee(Employee employee) {
        String query = "Update employee set name = ?, surname = ?, address = ?, phone = ?, email = ?" +
                ", note = ?, hourly = ?, birth_date = ? Where id = ?";

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

    public static List<Employee> loadAllEmployees(Employee employee) {
        List<Employee> employees = new ArrayList<>();
        String query = "Select * FROM employees";

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
                loadedEmployee.setHourly(resultSet.getBigDecimal("hourly"));
                loadedEmployee.setEmail(resultSet.getString("email"));
                loadedEmployee.setBirthDate(resultSet.getString("birth_date"));

                employees.add(loadedEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

}
