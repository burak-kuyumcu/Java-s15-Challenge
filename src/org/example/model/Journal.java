package org.example.model;

public class Journal extends Book {

    private int issueNumber;

    public Journal(long id, String title, String isbn, Author author, int issueNumber) {
        super(id, title, isbn, author);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + getTitle() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", author=" + getAuthor().getFullName() +
                ", issueNumber=" + issueNumber +
                ", status=" + getStatus() +
                '}';
    }
}