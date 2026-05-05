package org.example;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Journal;
import org.example.model.Library;
import org.example.model.Magazine;
import org.example.model.Student;

public class Main {
    public static void main(String[] args) {

        Library library = new Library(1, "Central Library");

        Author author1 = new Author(1, "George", "Orwell", "orwell@mail.com");
        Author author2 = new Author(2, "Isaac", "Asimov", "asimov@mail.com");

        Book book1 = new Book(1, "1984", "ISBN-001", author1);
        Book book2 = new Book(2, "Animal Farm", "ISBN-002", author1);

        Journal journal1 = new Journal(3, "Science Journal", "ISBN-003", author2, 12);
        Magazine magazine1 = new Magazine(4, "Tech Monthly", "ISBN-004", author2, "Technology");

        Student student1 = new Student(1, "Burak", "Kuyumcu", "burak@mail.com");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(journal1);
        library.addBook(magazine1);

        library.addReader(student1);

        library.showBooks();

        library.borrowBook(book1, student1);
        library.borrowBook(book1, student1);

        library.returnBook(book1);
        library.borrowBook(book1, student1);

        library.showLoans();
        library.showBooks();
    }
}