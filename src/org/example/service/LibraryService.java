package org.example.service;

import org.example.model.Book;
import org.example.model.Library;
import org.example.model.Reader;

public class LibraryService {

    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public void addReader(Reader reader) {
        library.addReader(reader);
    }

    public void borrowBook(Book book, Reader reader) {
        library.borrowBook(book, reader);
    }

    public void returnBook(Book book) {
        library.returnBook(book);
    }

    public void showBooks() {
        library.showBooks();
    }

    public void showReaders() {
        library.showReaders();
    }

    public void showLoans() {
        library.showLoans();
    }
}