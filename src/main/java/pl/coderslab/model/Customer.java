package pl.coderslab.model;

public class Customer extends Person{

    public Customer() {
    }

    public Customer(String name, String surname, String address, String phone, String email, String birthDate) {
        super(name, surname, address, phone, email, birthDate);
    }
}
