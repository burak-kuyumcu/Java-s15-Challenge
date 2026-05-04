package org.example;

import org.example.model.Author;
import org.example.model.Student;

public class Main {
    public static void main(String[] args) {
        Author author = new Author(1, "George", "Orwell", "orwell@mail.com");
        Student student = new Student(2, "Burak", "Kuyumcu", "burak@mail.com");

        System.out.println(author.getFullName());
        System.out.println(student.getFullName());
    }
}