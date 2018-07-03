package pl.coderslab.model;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
    private String birthDate;

    public Person() {
    }

    public Person(int id, String name, String surname, String address, String phone, String email, String birthDate) {
        setId(id);
        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setBirthDate(birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
