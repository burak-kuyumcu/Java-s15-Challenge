package org.example.service;

import org.example.enums.BookStatus;
import org.example.model.Author;
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

    public Book findBookById(long id) {
        return library.findBookById(id);
    }

    public Book findBookByTitle(String title) {
        return library.findBookByTitle(title);
    }

    public Reader findReaderById(long id) {
        return library.findReaderById(id);
    }

    public void updateBookInfo(long bookId, String title, String isbn, Author author, String category) {
        library.updateBookInfo(bookId, title, isbn, author, category);
    }

    public void findBooksByAuthor(String authorName) {
        library.findBooksByAuthor(authorName);
    }

    public void showBooksByCategory(String category) {
        library.showBooksByCategory(category);
    }

    public void showCategories() {
        library.showCategories();
    }

    public void showBorrowedBooksByReaderId(long readerId) {
        library.showBorrowedBooksByReaderId(readerId);
    }

    public void removeBook(String title) {
        library.removeBook(title);
    }

    public void updateBookStatus(String title, BookStatus status) {
        library.updateBookStatus(title, status);
    }

    public void showBooks() {
        library.showBooks();
    }

    public void showReaders() {
        library.showReaders();
    }

    public void showAvailableBooks() {
        library.showAvailableBooks();
    }

    public void showBorrowedBooks() {
        library.showBorrowedBooks();
    }

    public void showLoans() {
        library.showLoans();
    }
}