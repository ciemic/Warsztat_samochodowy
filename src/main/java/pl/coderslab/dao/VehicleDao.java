package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleDao {

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
        List<Vehicle> exercises = new ArrayList<>();
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
            exercises.add(loadedVehicle);
        }
        return exercises;
    }

    static public Vehicle loadVehicleById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM vehicle where id=?";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Vehicle loadedVehicle = new Vehicle();
            loadedVehicle.setId(resultSet.getInt("id"));
            loadedVehicle.setBrand(resultSet.getString("brand"));
            loadedVehicle.setModel(resultSet.getString("model"));
            loadedVehicle.setProductionYear(resultSet.getString("production_year"));
            loadedVehicle.setRegistrationNumber(resultSet.getString("registration_number"));
            loadedVehicle.setNextService(resultSet.getString("next_service"));
            loadedVehicle.setCustomerId(resultSet.getInt("customer_id"));
            return loadedVehicle;
        }
        return null;
    }

}
