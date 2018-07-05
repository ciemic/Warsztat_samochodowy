package pl.coderslab.dao;

import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;
import pl.coderslab.services.DBService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {

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

    static public List<Order> loadAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `car_service`.`order`";

        PreparedStatement preparedStatement = DBService.connect(databaseName).prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Order loadedOrder = new Order();
            loadedOrder.setId(resultSet.getInt("id"));
            loadedOrder.setStatusId(resultSet.getInt("status_id"));
            loadedOrder.setVehicleId(resultSet.getInt("vehicle_id"));
            loadedOrder.setProblemDescription(resultSet.getString("problem_description"));
            loadedOrder.setAcceptance(resultSet.getString("acceptance"));
            loadedOrder.setPlannedMaintenance(resultSet.getString("planned_maintenance"));
            loadedOrder.setMaintenanceStart(resultSet.getString("maintenance_start"));
            loadedOrder.setEmployeeId(resultSet.getInt("employee_id"));
            loadedOrder.setMaintenaceDescription(resultSet.getString("maintenance_description"));
            loadedOrder.setTotalPrice(resultSet.getDouble("total_price"));
            loadedOrder.setPartsCost(resultSet.getDouble("parts_cost"));
            loadedOrder.setHoursAmount(resultSet.getInt("hours_amount"));
            orders.add(loadedOrder);
        }
        return orders;
    }

    static public Order loadOrderById(int id) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `car_service`.`order` WHERE id = ?";
        List<String> param = new ArrayList<>();
        param.add(String.valueOf(id));
        List<Map<String, String>> mapList = DBService.executeMultipleSelect(databaseName, query, param);

        for (Map<String, String> map : mapList) {
            orders.add(getOrder(map));
        }
        Order order = orders.get(0);
        return order;
    }


    protected static Order getOrder(Map<String, String> orderEntry) {
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

    static public List<Order> loadVehicleHistory(Vehicle vehicle) {
        String query = "SELECT * FROM car_service.order where vehicle_id=?";
        List<Order> orders = new ArrayList<>();
        List<String> param = new ArrayList<>();
        param.add(String.valueOf(vehicle.getId()));

        List<Map<String, String>> mapList = DBService.executeMultipleSelect(databaseName, query, param);

        for (Map<String, String> map : mapList) {
            orders.add(OrderDao.getOrder(map));
        }
        return orders;
    }
}
