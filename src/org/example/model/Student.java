package org.example.model;

public class Student extends Reader {

    private String studentNumber;

    public Student(long id, String name, String surname, String email, String studentNumber) {
        super(id, name, surname, email, 5);
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}