package org.example.model;

public abstract class Person {
    private long id;
    private String name;
    private String surname;
    private String email;

    public Person(long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return name + " " + surname;
    }
}