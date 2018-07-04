package pl.coderslab.dao;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;
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
        String query = "SELECT * FROM customer where id=?";
        Map<String, String> customerEntry = DBService.executeSingleSelect(databaseName, query, String.valueOf(id));

        return getCustomer(customerEntry);
    }

    static public List<Customer> loadCustomerBySurname(String surname) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer WHERE surname = ?";
        List<String> param = new ArrayList<>();
        param.add(surname);
        List<Map<String, String>> mapList = DBService.executeMultipleSelect(databaseName, query, param);

        for (Map<String, String> map : mapList) {
            customers.add(getCustomer(map));
        }
        return customers;
    }

    static public List<Vehicle> loadCustomerVehicles(Customer customer) {
        String query = "SELECT * FROM car_service.vehicle where customer_id=?";
        List<Vehicle> vehicles = new ArrayList<>();
        List<String> param = new ArrayList<>();
        param.add(String.valueOf(customer.getId()));

        List<Map<String, String>> mapList = DBService.executeMultipleSelect(databaseName, query, param);

        for (Map<String, String> map : mapList) {
            vehicles.add(VehicleDao.getVehicle(map));
        }
        return vehicles;
    }

    private static Customer getCustomer(Map<String, String> customerEntryMap) {
        Customer customer = new Customer();
        try {
            customer.setId(Integer.parseInt(customerEntryMap.get("id")));
            customer.setName(customerEntryMap.get("name"));
            customer.setSurname(customerEntryMap.get("surname"));
            customer.setAddress(customerEntryMap.get("address"));
            customer.setPhone(customerEntryMap.get("phone"));
            customer.setEmail(customerEntryMap.get("email"));
            customer.setBirthDate(customerEntryMap.get("birth_date"));
        } catch (Exception e) {
        }
        return customer;
    }
}
