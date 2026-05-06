package org.example.model;

public class Reader extends Person {

    private int maxBorrowLimit;

    public Reader(long id, String name, String surname, String email, int maxBorrowLimit) {
        super(id, name, surname, email);
        this.maxBorrowLimit = maxBorrowLimit;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }
}