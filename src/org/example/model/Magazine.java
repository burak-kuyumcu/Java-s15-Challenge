package org.example.model;

public class Magazine extends Book {

    private String category;

    public Magazine(long id, String title, String isbn, Author author, String category) {
        super(id, title, isbn, author);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + getTitle() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                ", author=" + getAuthor().getFullName() +
                ", category='" + category + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}