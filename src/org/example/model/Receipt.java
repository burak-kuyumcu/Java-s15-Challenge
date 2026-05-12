package org.example.model;

import java.time.LocalDate;

public class Receipt {

    private static long counter = 1;
    private long receiptId;
    private Reader reader;
    private Book book;
    private double amount;
    private LocalDate createdDate;
    private boolean refunded;

    public Receipt(Reader reader, Book book, double amount) {
        this.receiptId = counter++;
        this.reader = reader;
        this.book = book;
        this.amount = amount;
        this.createdDate = LocalDate.now();
        this.refunded = false;
    }

    public void refund() {
        this.refunded = true;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", reader=" + reader.getFullName() +
                ", book=" + book.getTitle() +
                ", amount=" + amount +
                ", createdDate=" + createdDate +
                ", refunded=" + refunded +
                '}';
    }
}