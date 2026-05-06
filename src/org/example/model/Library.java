package org.example.model;

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
        Loan loan = new Loan(book, reader);
        loans.add(loan);

        System.out.println("Borrow success: " + book.getTitle() + " -> " + reader.getFullName());
    }

    public void returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book) && loan.isActive()) {
                loan.closeLoan();
                System.out.println("Return success: " + book.getTitle());
                return;
            }
        }

        System.out.println("Active loan not found for: " + book.getTitle());
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
            System.out.println(reader.getFullName());
        }
    }

    public void showLoans() {
        System.out.println("\n--- Loans ---");
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }
}