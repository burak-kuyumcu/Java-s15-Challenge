package org.example.model;

public class Faculty extends Reader {

    private String department;

    public Faculty(long id, String name, String surname, String email, String department) {
        super(id, name, surname, email, 5);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}