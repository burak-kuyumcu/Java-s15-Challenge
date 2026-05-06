package org.example.model;

public class Librarian extends Person {

    private String employeeNumber;

    public Librarian(long id, String name, String surname, String email, String employeeNumber) {
        super(id, name, surname, email);
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
}