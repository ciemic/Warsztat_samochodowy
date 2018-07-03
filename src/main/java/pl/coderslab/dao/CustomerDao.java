package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.services.DBService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerDao {
    private static String databaseName = "car_service";

    public static void addCustomer(Customer customer) {

        String query = "Insert into customer Values (?,?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(customer.getId()));
        queryParams.add(customer.getName());
        queryParams.add(customer.getSurname());
        queryParams.add(customer.getAddress());
        queryParams.add(customer.getPhone());
        queryParams.add(customer.getEmail());
        queryParams.add(customer.getBirthDate());


        DBService.executeUpdate(databaseName, query, queryParams);
    }

    public static void updateEmployee(Customer customer) {
        String query = "Update customer set name = ?, surname = ?, address = ?, phone = ?" +
                ", email = ?, birth_date = ? Where id = ?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(customer.getName());
        queryParams.add(customer.getSurname());
        queryParams.add(customer.getAddress());
        queryParams.add(customer.getPhone());
        queryParams.add(customer.getEmail());
        queryParams.add(customer.getBirthDate());

        DBService.executeUpdate(databaseName, query, queryParams);
    }

    public static void deleteCustomer(Customer customer) {
        String query = "DELETE FROM customer WHERE id=?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(customer.getId()));
        DBService.executeUpdate(databaseName, query, queryParams);

    }

    public static List<Customer> loadAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "Select * FROM customer";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBService.connect(databaseName).prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer loadedCustomer = new Customer();
                loadedCustomer.setId(resultSet.getInt("id"));
                loadedCustomer.setName(resultSet.getString("name"));
                loadedCustomer.setSurname(resultSet.getString("surname"));
                loadedCustomer.setAddress(resultSet.getString("address"));
                loadedCustomer.setPhone(resultSet.getString("phone"));
                loadedCustomer.setEmail(resultSet.getString("email"));
                loadedCustomer.setBirthDate(resultSet.getString("birth_date"));

                customers.add(loadedCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    static public Customer loadCustomerById(int id) {
        Customer customer = new Customer();
        String query = "SELECT * FROM customer where id=?";
        Map<String, String> employeeEntry = DBService.executeSingleSelect(databaseName, query, String.valueOf(id));

        try {
            customer.setId(Integer.parseInt(employeeEntry.get("id")));
            customer.setName(employeeEntry.get("name"));
            customer.setSurname(employeeEntry.get("surname"));
            customer.setAddress(employeeEntry.get("address"));
            customer.setPhone(employeeEntry.get("phone"));
            customer.setEmail(employeeEntry.get("email"));
            customer.setBirthDate(employeeEntry.get("birth_date"));
        } catch (Exception e) {

        }
        return customer;
    }
}
