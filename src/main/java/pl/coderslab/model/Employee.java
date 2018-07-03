package pl.coderslab.model;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal hourly;
    private String note;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String address, String phone, String email, String birthDate, BigDecimal hourly, String note) {
        super(id, name, surname, address, phone, email, birthDate);
        setHourly(hourly);
        setNote(note);
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

    @Override
    public String toString() {
        return "Employee{" +
                "hourly=" + hourly +
                ", note='" + note + '\'' +
                '}';
    }
}
