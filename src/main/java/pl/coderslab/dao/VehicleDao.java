package pl.coderslab.dao;

import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;

import java.util.ArrayList;
import java.util.List;

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
}
