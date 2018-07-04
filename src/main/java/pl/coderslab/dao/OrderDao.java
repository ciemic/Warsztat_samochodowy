package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {

    public static void main(String[] args) {
        Order order = new Order();
        order.setVehicleId(1);
        order.setProblemDescription("popsuty");
        order.setEmployeeId(1);
        order.setStatusId(1);
        order.setTotalPrice(500.00);
        order.setPartsCost(100.00);
        order.setId(9);

        updateOrder(order);

    }

    private static String databaseName = "car_service";

    private static void addOrder(Order order) {

        String query = "INSERT INTO `car_service`.`order` (`status_id`, `vehicle_id`, `problem_description`, `acceptance`," +
                " `planned_maintenance`, `maintenance_start`, `employee_id`, `maintenance_description`, `total_price`," +
                " `parts_cost`, `hours_amount`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(order.getStatusId()));
        queryParams.add(String.valueOf(order.getVehicleId()));
        queryParams.add(order.getProblemDescription());
        queryParams.add(order.getAcceptance());
        queryParams.add(order.getPlannedMaintenance());
        queryParams.add(order.getMaintenanceStart());
        queryParams.add(String.valueOf(order.getEmployeeId()));
        queryParams.add(order.getMaintenaceDescription());
        queryParams.add(String.valueOf(order.getTotalPrice()));
        queryParams.add(String.valueOf(order.getPartsCost()));
        queryParams.add(String.valueOf(order.getHoursAmount()));
        DBService.executeUpdate(databaseName, query, queryParams);

    }

    private static void updateOrder(Order order) {
        String query = "Update `car_service`.`order` SET `status_id`=?, `vehicle_id`=?, `problem_description`=?, `acceptance`=?," +
                "`planned_maintenance`=?, `maintenance_start`=?, `employee_id`=?, `maintenance_description`=?, `total_price`=?," +
                "`parts_cost`=?, `hours_amount`=? Where id = ?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(order.getStatusId()));
        queryParams.add(String.valueOf(order.getVehicleId()));
        queryParams.add(order.getProblemDescription());
        queryParams.add(order.getAcceptance());
        queryParams.add(order.getPlannedMaintenance());
        queryParams.add(order.getMaintenanceStart());
        queryParams.add(String.valueOf(order.getEmployeeId()));
        queryParams.add(order.getMaintenaceDescription());
        queryParams.add(String.valueOf(order.getTotalPrice()));
        queryParams.add(String.valueOf(order.getPartsCost()));
        queryParams.add(String.valueOf(order.getHoursAmount()));
        queryParams.add(String.valueOf(order.getId()));
        DBService.executeUpdate(databaseName, query, queryParams);

    }

    public static void delete(Order order) {
        String query = "DELETE FROM `car_service`.`order` WHERE `id`=?";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(order.getId()));
        DBService.executeUpdate(databaseName, query, queryParams);

    }

    protected static Order getOrder(Map<String, String> orderEntry) {

        String query = "Update `car_service`.`order` SET `status_id`=?, `vehicle_id`=?, `problem_description`=?, `acceptance`=?," +
                "`planned_maintenance`=?, `maintenance_start`=?, `employee_id`=?, `maintenance_description`=?, `total_price`=?," +
                "`parts_cost`=?, `hours_amount`=? Where id = ?";

        Order order = new Order();
        try {
            order.setId(Integer.parseInt(orderEntry.get("id")));
            order.setStatusId(Integer.parseInt(orderEntry.get("status_id")));
            order.setVehicleId(Integer.parseInt(orderEntry.get("vehicle_id")));
            order.setProblemDescription(orderEntry.get("problem_description"));
            order.setAcceptance(orderEntry.get("acceptance"));
            order.setPlannedMaintenance(orderEntry.get("planned_maintenance"));
            order.setMaintenanceStart(orderEntry.get("maintenance_start"));
            order.setEmployeeId(Integer.parseInt(orderEntry.get("employee_id")));
            order.setMaintenaceDescription(orderEntry.get("maintenance_description"));
            order.setTotalPrice(Double.parseDouble(orderEntry.get("total_price")));
            order.setPartsCost(Double.parseDouble(orderEntry.get("parts_cost")));
            order.setHoursAmount(Integer.parseInt(orderEntry.get("hours_amount")));

        } catch (Exception e) {

        }
        return order;
    }

}
