package org.example.model;

import org.example.enums.BookStatus;

public class Book implements Borrowable {

    private long id;
    private String title;
    private String isbn;
    private Author author;
    private String category;
    private BookStatus status;

    public Book(long id, String title, String isbn, Author author, String category) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
        this.status = BookStatus.AVAILABLE;
    }

    @Override
    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    @Override
    public void borrow() {
        this.status = BookStatus.BORROWED;
    }

    @Override
    public void returnItem() {
        this.status = BookStatus.AVAILABLE;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getIsbn() {

        return isbn;
    }

    public Author getAuthor() {

        return author;
    }

    public String getCategory() {

        return category;
    }

    public BookStatus getStatus() {

        return status;
    }

    public void setStatus(BookStatus status) {

        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author.getFullName() +
                ", category='" + category + '\'' +
                ", status=" + status +
                '}';
    }
}