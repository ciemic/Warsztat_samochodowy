package pl.coderslab.model;

public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String productionDate;
    private String registrationNumber;
    private String nextService;
    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Vehicle(int id, String brand, String model, String productionDate, String registrationNumber, String nextService, int customerId) {
        setId(id);
        setBrand(brand);
        setModel(model);
        setProductionDate(productionDate);
        setRegistrationNumber(registrationNumber);
        setNextService(nextService);
        setCustomerId(customerId);
    }

    public Vehicle() {
    }
}
