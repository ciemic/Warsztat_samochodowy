package pl.coderslab.model;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal hourly;
    private String note;

    public Employee() {
    }

    public Employee(String name, String surname, String address, String phone, String email, String birthDate, BigDecimal hourly, String note) {
        super(name, surname, address, phone, email, birthDate);
        this.hourly = hourly;
        this.note = note;
    }


    public BigDecimal getHourly() {
        return hourly;
    }

    public void setHourly(BigDecimal hourly) {
        this.hourly = hourly;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
