package org.example.model;

public class Magazine extends Book {

    public Magazine(long id, String title, String isbn, Author author, String category) {
        super(id, title, isbn, author, category);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + getTitle() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", author=" + getAuthor().getFullName() +
                ", category='" + getCategory() + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}