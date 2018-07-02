package pl.coderslab.model;

import java.math.BigDecimal;

public class Order {
    private int id;
    private int statusId;
    private int customerId;
    private int vehicleId;
    private String problemDescription;
    private String acceptance;
    private String plannedMaintenance;
    private String maintenanceString;
    private int employeeId;
    private String maintenaceDescription;
    private BigDecimal totalPrice;
    private BigDecimal partsCost;
    private int hoursAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getPlannedMaintenance() {
        return plannedMaintenance;
    }

    public void setPlannedMaintenance(String plannedMaintenance) {
        this.plannedMaintenance = plannedMaintenance;
    }

    public String getMaintenanceString() {
        return maintenanceString;
    }

    public void setMaintenanceString(String maintenanceString) {
        this.maintenanceString = maintenanceString;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getMaintenaceDescription() {
        return maintenaceDescription;
    }

    public void setMaintenaceDescription(String maintenaceDescription) {
        this.maintenaceDescription = maintenaceDescription;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(BigDecimal partsCost) {
        this.partsCost = partsCost;
    }

    public int getHoursAmount() {
        return hoursAmount;
    }

    public void setHoursAmount(int hoursAmount) {
        this.hoursAmount = hoursAmount;
    }

    public Order() {
    }
}
