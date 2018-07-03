package pl.coderslab.dao;

import pl.coderslab.model.Employee;
import pl.coderslab.services.DBService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static String databaseName = "car_service";

    private static void addEmployee(Employee employee) {

        String query = "Insert into employees Values (?,?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(employee.getId()));
        queryParams.add(employee.getName());
        queryParams.add(employee.getSurname());
        queryParams.add(employee.getPhone());
        queryParams.add(employee.getEmail());
        queryParams.add(employee.getBirthDate());

        DBService.executeUpdate(databaseName, query, queryParams);
    }

    private static void updateEmployee(Employee employee) {
        String query = "Update employee set name = ?, surname = ?, address = ?, phone = ?, email = ?" +
                ", birth_date = ? Where id = ?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(employee.getName());
        queryParams.add(employee.getSurname());
        queryParams.add(employee.getAddress());
        queryParams.add(employee.getPhone());
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


}
