package org.example.model;

import org.example.enums.BookStatus;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private long id;
    private String name;
    private List<Book> books;
    private List<Reader> readers;
    private List<Loan> loans;

    public Library(long id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println("Reader added: " + reader.getFullName());
    }

    public void borrowBook(Book book, Reader reader) {
        if (!books.contains(book)) {
            System.out.println("This book does not belong to this library.");
            return;
        }

        if (!readers.contains(reader)) {
            System.out.println("This reader is not registered.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("This book is already borrowed: " + book.getTitle());
            return;
        }

        int activeLoanCount = 0;

        for (Loan loan : loans) {
            if (loan.getReader().equals(reader) && loan.isActive()) {
                activeLoanCount++;
            }
        }

        if (activeLoanCount >= reader.getMaxBorrowLimit()) {
            System.out.println("Borrow limit reached for: " + reader.getFullName());
            return;
        }

        book.borrow();

        Receipt receipt = new Receipt(reader, book, 50.0);
        Loan loan = new Loan(book, reader, receipt);
        loans.add(loan);

        System.out.println("Borrow success: " + book.getTitle() + " -> " + reader.getFullName());
        System.out.println("Receipt created: " + receipt);
    }

    public void returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && loan.isActive()) {
                loan.closeLoan();
                System.out.println("Return success: " + book.getTitle());
                System.out.println("Payment refunded for: " + book.getTitle());
                return;
            }
        }

        System.out.println("Active loan not found for: " + book.getTitle());
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public Reader findReaderById(long id) {
        for (Reader reader : readers) {
            if (reader.getId() == id) {
                return reader;
            }
        }

        return null;
    }

    public void findBooksByAuthor(String authorName) {
        System.out.println("\n--- Books By Author: " + authorName + " ---");

        boolean found = false;

        for (Book book : books) {
            if (book.getAuthor().getFullName().equalsIgnoreCase(authorName)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for author: " + authorName);
        }
    }

    public void showBooksByCategory(String category) {
        System.out.println("\n--- Books By Category: " + category + " ---");

        boolean found = false;

        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found in category: " + category);
        }
    }

    public void showBorrowedBooksByReaderId(long readerId) {
        Reader reader = findReaderById(readerId);

        if (reader == null) {
            System.out.println("Reader not found.");
            return;
        }

        System.out.println("\n--- Borrowed Books By " + reader.getFullName() + " ---");

        boolean found = false;

        for (Loan loan : loans) {
            if (loan.getReader().equals(reader) && loan.isActive()) {
                System.out.println(loan.getBook());
                found = true;
            }
        }

        if (!found) {
            System.out.println("This reader has no active borrowed books.");
        }
    }

    public void removeBook(String title) {
        Book bookToRemove = findBookByTitle(title);

        if (bookToRemove == null) {
            System.out.println("Book not found: " + title);
            return;
        }

        for (Loan loan : loans) {
            if (loan.getBook().equals(bookToRemove) && loan.isActive()) {
                System.out.println("This book is currently borrowed. It cannot be removed.");
                return;
            }
        }

        books.remove(bookToRemove);
        System.out.println("Book removed: " + bookToRemove.getTitle());
    }

    public void updateBookStatus(String title, BookStatus status) {
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found: " + title);
            return;
        }

        book.setStatus(status);
        System.out.println("Book status updated: " + book.getTitle() + " -> " + status);
    }

    public void showBooks() {
        System.out.println("\n--- Books ---");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showReaders() {
        System.out.println("\n--- Readers ---");

        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }

    public void showAvailableBooks() {
        System.out.println("\n--- Available Books ---");

        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void showBorrowedBooks() {
        System.out.println("\n--- Borrowed Books ---");

        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void showLoans() {
        System.out.println("\n--- Loans ---");

        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }
}