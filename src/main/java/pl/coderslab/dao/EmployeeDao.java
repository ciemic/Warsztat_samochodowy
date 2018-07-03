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


}
