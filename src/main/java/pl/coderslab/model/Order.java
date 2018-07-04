package pl.coderslab.model;

import java.math.BigDecimal;

public class Order {
    private int id;
    private int statusId;
    private int vehicleId;
    private String problemDescription;
    private String acceptance;
    private String plannedMaintenance;
    private String maintenanceStart;
    private int employeeId;
    private String maintenaceDescription;
    private Double totalPrice;
    private Double partsCost;
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

    public String getMaintenanceStart() {
        return maintenanceStart;
    }

    public void setMaintenanceStart(String maintenanceStart) {
        this.maintenanceStart = maintenanceStart;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(Double partsCost) {
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", statusId=" + statusId +
                ", vehicleId=" + vehicleId +
                ", problemDescription='" + problemDescription + '\'' +
                ", acceptance='" + acceptance + '\'' +
                ", plannedMaintenance='" + plannedMaintenance + '\'' +
                ", maintenanceStart='" + maintenanceStart + '\'' +
                ", employeeId=" + employeeId +
                ", maintenaceDescription='" + maintenaceDescription + '\'' +
                ", totalPrice=" + totalPrice +
                ", partsCost=" + partsCost +
                ", hoursAmount=" + hoursAmount +
                '}';
    }
}
