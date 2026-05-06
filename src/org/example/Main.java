package org.example;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Faculty;
import org.example.model.Journal;
import org.example.model.Library;
import org.example.model.Magazine;
import org.example.model.Student;
import org.example.service.LibraryService;

public class Main {
    public static void main(String[] args) {

        Library library = new Library(1, "Central Library");
        LibraryService service = new LibraryService(library);

        Author author1 = new Author(1, "George", "Orwell", "orwell@mail.com");
        Author author2 = new Author(2, "Isaac", "Asimov", "asimov@mail.com");

        Book book1 = new Book(1, "1984", "ISBN-001", author1);
        Book book2 = new Book(2, "Animal Farm", "ISBN-002", author1);
        Book book3 = new Book(3, "Foundation", "ISBN-003", author2);
        Book book4 = new Book(4, "I, Robot", "ISBN-004", author2);

        Journal journal1 = new Journal(5, "Science Journal", "ISBN-005", author2, 12);
        Magazine magazine1 = new Magazine(6, "Tech Monthly", "ISBN-006", author2, "Technology");

        Student student1 = new Student(1, "Burak", "Kuyumcu", "burak@mail.com", "2025001");
        Faculty faculty1 = new Faculty(2, "Ada", "Lovelace", "ada@mail.com", "Computer Engineering");

        service.addBook(book1);
        service.addBook(book2);
        service.addBook(book3);
        service.addBook(book4);
        service.addBook(journal1);
        service.addBook(magazine1);

        service.addReader(student1);
        service.addReader(faculty1);

        service.showBooks();
        service.showReaders();

        service.borrowBook(book1, student1);
        service.borrowBook(book2, student1);
        service.borrowBook(book3, student1);
        service.borrowBook(book4, student1);

        service.returnBook(book1);
        service.borrowBook(book4, student1);

        service.borrowBook(journal1, faculty1);
        service.borrowBook(magazine1, faculty1);

        service.showLoans();
        service.showBooks();
    }
}