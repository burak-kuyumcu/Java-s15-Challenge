package org.example.model;

import java.time.LocalDate;

public class Loan {

    private Book book;
    private Reader reader;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Receipt receipt;

    public Loan(Book book, Reader reader, Receipt receipt) {
        this.book = book;
        this.reader = reader;
        this.receipt = receipt;
        this.borrowDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public boolean isActive() {
        return returnDate == null;
    }

    public void closeLoan() {
        this.returnDate = LocalDate.now();
        book.returnItem();
        receipt.refund();
    }

    @Override
    public String toString() {
        return "Loan{" +
                "book=" + book.getTitle() +
                ", reader=" + reader.getFullName() +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", receipt=" + receipt +
                '}';
    }
}