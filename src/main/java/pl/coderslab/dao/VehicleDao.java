package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleDao {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("mercedes");
        vehicle.setModel("model");
        vehicle.setCustomerId(1);
        try {
            List<Vehicle> vehicles= loadAllVehicles();
            System.out.println(vehicles);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String databaseName = "car_service";

    private static void addVehicle(Vehicle vehicle) {

        String query = "Insert into vehicle Values (?,?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(vehicle.getId()));
        queryParams.add(vehicle.getBrand());
        queryParams.add(vehicle.getModel());
        queryParams.add(vehicle.getProductionYear());
        queryParams.add(vehicle.getRegistrationNumber());
        queryParams.add(vehicle.getNextService());
        queryParams.add(String.valueOf(vehicle.getCustomerId()));
        DBService.executeUpdate(databaseName, query, queryParams);

    }

    private static void updateVehicle(Vehicle vehicle) {
        String query = "Update vehicle set brand = ?, model = ?, production_year = ?, registration_number = ?, next_service = ?" +
                ", customer_id = ? Where id = ?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(vehicle.getBrand());
        queryParams.add(vehicle.getModel());
        queryParams.add(vehicle.getProductionYear());
        queryParams.add(vehicle.getRegistrationNumber());
        queryParams.add(vehicle.getNextService());
        queryParams.add(String.valueOf(vehicle.getCustomerId()));
        queryParams.add(String.valueOf(vehicle.getId()));
        DBService.executeUpdate(databaseName, query, queryParams);
    }

    public static void delete(Vehicle vehicle) {
        String query = "DELETE FROM vehicle WHERE id=?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(vehicle.getId()));
        DBService.executeUpdate(databaseName, query, queryParams);

    }

    static public List<Vehicle> loadAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicle";

        PreparedStatement preparedStatement = DBService.connect(databaseName).prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Vehicle loadedVehicle = new Vehicle();
            loadedVehicle.setId(resultSet.getInt("id"));
            loadedVehicle.setBrand(resultSet.getString("brand"));
            loadedVehicle.setModel(resultSet.getString("model"));
            loadedVehicle.setProductionYear(resultSet.getString("production_year"));
            loadedVehicle.setRegistrationNumber(resultSet.getString("registration_number"));
            loadedVehicle.setNextService(resultSet.getString("next_service"));
            loadedVehicle.setCustomerId(resultSet.getInt("customer_id"));
            vehicles.add(loadedVehicle);
        }
        return vehicles;
    }

    static public Vehicle loadVehicleById(int id) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM customer WHERE id = ?";
        List<String> param = new ArrayList<>();
        param.add(String.valueOf(id));
        List<Map<String, String>> mapList = DBService.executeMultipleSelect(databaseName, query, param);

        for (Map<String, String> map : mapList) {
            vehicles.add(getVehicle(map));
        }
        Vehicle vehicle = vehicles.get(0);

        return vehicle;
    }

    protected static Vehicle getVehicle(Map<String, String> vehicleEntry) {
        Vehicle vehicle = new Vehicle();
        try {
            vehicle.setId(Integer.parseInt(vehicleEntry.get("id")));
            vehicle.setBrand(vehicleEntry.get("brand"));
            vehicle.setModel(vehicleEntry.get("model"));
            vehicle.setProductionYear(vehicleEntry.get("production_year"));
            vehicle.setRegistrationNumber(vehicleEntry.get("registration_number"));
            vehicle.setNextService(vehicleEntry.get("next_service"));
            vehicle.setCustomerId((Integer.parseInt(vehicleEntry.get("customer_id"))));
        } catch (Exception e) {

        }
        return vehicle;
    }

//    static public Vehicle loadVehicleById(int id) {
//        Vehicle vehicle = new Vehicle();
//        String query = "SELECT * FROM vehicle where id=?";
//        Map<String, String> vehicleEntry = new HashMap<>();
//        vehicleEntry = DBService.executeSingleSelect(databaseName, query, String.valueOf(id));
//
//        try {
//            vehicle.setId(Integer.parseInt(vehicleEntry.get("id")));
//            vehicle.setBrand(vehicleEntry.get("brand"));
//            vehicle.setModel(vehicleEntry.get("model"));
//            vehicle.setProductionYear(vehicleEntry.get("production_year"));
//            vehicle.setRegistrationNumber(vehicleEntry.get("registration_number"));
//            vehicle.setNextService(vehicleEntry.get("next_service"));
//            vehicle.setCustomerId((Integer.parseInt(vehicleEntry.get("customer_id"))));
//
//        } catch (Exception e) {
//
//        }
//        return vehicle;
//    }

}
