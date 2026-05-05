package org.example.model;

import java.time.LocalDate;

public class Loan {

    private Book book;
    private Reader reader;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(Book book, Reader reader) {
        this.book = book;
        this.reader = reader;
        this.borrowDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return returnDate == null;
    }

    public void closeLoan() {
        this.returnDate = LocalDate.now();
        book.returnItem();
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book.getTitle() +
                ", reader=" + reader.getFullName() +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}