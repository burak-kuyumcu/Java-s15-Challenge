package org.example;

import org.example.enums.BookStatus;
import org.example.model.*;
import org.example.service.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library(1, "Central Library");
        LibraryService service = new LibraryService(library);

        Author author1 = new Author(1, "George", "Orwell", "orwell@mail.com");
        Author author2 = new Author(2, "Isaac", "Asimov", "asimov@mail.com");
        Book book1 = new Book(1, "1984", "ISBN-001", author1, "Novel");
        Book book2 = new Book(2, "Animal Farm", "ISBN-002", author1, "Novel");
        Book book3 = new Book(3, "Foundation", "ISBN-003", author2, "Science Fiction");
        Book book4 = new Book(4, "I, Robot", "ISBN-004", author2, "Science Fiction");
        Journal journal1 = new Journal(5, "Science Journal", "ISBN-005", author2, "Science", 12);
        Magazine magazine1 = new Magazine(6, "Tech Monthly", "ISBN-006", author2, "Technology");
        Student student1 = new Student(1, "Burak", "Kuyumcu", "burak@mail.com", "2025001");
        Faculty faculty1 = new Faculty(2, "Ada", "Lovelace", "ada@mail.com", "Computer Engineering");

        service.addBook(book1);
        service.addBook(book2);
        service.addBook(book3);
        service.addBook(book4);
        service.addBook(journal1);
        service.addBook(magazine1);
        service.addReader(student1);
        service.addReader(faculty1);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== LIBRARY SYSTEM MENU =====");
            System.out.println("1. Show all books");
            System.out.println("2. Show available books");
            System.out.println("3. Show borrowed books");
            System.out.println("4. Search book by title");
            System.out.println("5. Search books by author");
            System.out.println("6. Borrow book");
            System.out.println("7. Return book");
            System.out.println("8. Remove book");
            System.out.println("9. Update book status");
            System.out.println("10. Show readers");
            System.out.println("11. Show loan history");
            System.out.println("12. Show borrowed books by reader");
            System.out.println("13. Show books by category");
            System.out.println("14. Show categories");
            System.out.println("15. Search book by id");
            System.out.println("16. Add new book");
            System.out.println("17. Update book information");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    service.showBooks();
                    break;

                case 2:
                    service.showAvailableBooks();
                    break;

                case 3:
                    service.showBorrowedBooks();
                    break;

                case 4:
                    System.out.print("Enter book title: ");
                    Book foundBook = service.findBookByTitle(scanner.nextLine());
                    System.out.println(foundBook != null ? "Found book: " + foundBook : "Book not found.");
                    break;

                case 5:
                    System.out.print("Enter author full name: ");
                    service.findBooksByAuthor(scanner.nextLine());
                    break;

                case 6:
                    System.out.print("Enter book title to borrow: ");
                    Book bookToBorrow = service.findBookByTitle(scanner.nextLine());

                    if (bookToBorrow == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    System.out.print("Enter reader id: ");
                    Reader borrowReader = service.findReaderById(scanner.nextLong());
                    scanner.nextLine();

                    if (borrowReader == null) {
                        System.out.println("Reader not found.");
                        break;
                    }

                    service.borrowBook(bookToBorrow, borrowReader);
                    break;

                case 7:
                    System.out.print("Enter book title to return: ");
                    Book bookToReturn = service.findBookByTitle(scanner.nextLine());

                    if (bookToReturn == null) {
                        System.out.println("Book not found.");
                        break;
                    }

                    service.returnBook(bookToReturn);
                    break;

                case 8:
                    System.out.print("Enter book title to remove: ");
                    service.removeBook(scanner.nextLine());
                    break;

                case 9:
                    System.out.print("Enter book title to update status: ");
                    String updateTitle = scanner.nextLine();

                    System.out.println("1. AVAILABLE");
                    System.out.println("2. BORROWED");
                    System.out.print("Choose status: ");

                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (statusChoice == 1) {
                        service.updateBookStatus(updateTitle, BookStatus.AVAILABLE);
                    } else if (statusChoice == 2) {
                        service.updateBookStatus(updateTitle, BookStatus.BORROWED);
                    } else {
                        System.out.println("Invalid status choice.");
                    }
                    break;

                case 10:
                    service.showReaders();
                    break;

                case 11:
                    service.showLoans();
                    break;

                case 12:
                    System.out.print("Enter reader id: ");
                    long readerId = scanner.nextLong();
                    scanner.nextLine();
                    service.showBorrowedBooksByReaderId(readerId);
                    break;

                case 13:
                    System.out.print("Enter category: ");
                    service.showBooksByCategory(scanner.nextLine());
                    break;

                case 14:
                    service.showCategories();
                    break;

                case 15:
                    System.out.print("Enter book id: ");
                    long searchBookId = scanner.nextLong();
                    scanner.nextLine();

                    Book foundById = service.findBookById(searchBookId);
                    System.out.println(foundById != null ? "Found book: " + foundById : "Book not found.");
                    break;

                case 16:
                    System.out.print("Enter book id: ");
                    long newBookId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter book title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter isbn: ");
                    String newIsbn = scanner.nextLine();

                    System.out.print("Enter author id: ");
                    long newAuthorId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter author name: ");
                    String newAuthorName = scanner.nextLine();

                    System.out.print("Enter author surname: ");
                    String newAuthorSurname = scanner.nextLine();

                    System.out.print("Enter author email: ");
                    String newAuthorEmail = scanner.nextLine();

                    System.out.print("Enter category: ");
                    String newCategory = scanner.nextLine();

                    Author newAuthor = new Author(newAuthorId, newAuthorName, newAuthorSurname, newAuthorEmail);
                    Book newBook = new Book(newBookId, newTitle, newIsbn, newAuthor, newCategory);

                    service.addBook(newBook);
                    break;

                case 17:
                    System.out.print("Enter book id to update: ");
                    long updateBookId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter new title: ");
                    String updatedTitle = scanner.nextLine();

                    System.out.print("Enter new isbn: ");
                    String updatedIsbn = scanner.nextLine();

                    System.out.print("Enter new author id: ");
                    long updatedAuthorId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter new author name: ");
                    String updatedAuthorName = scanner.nextLine();

                    System.out.print("Enter new author surname: ");
                    String updatedAuthorSurname = scanner.nextLine();

                    System.out.print("Enter new author email: ");
                    String updatedAuthorEmail = scanner.nextLine();

                    System.out.print("Enter new category: ");
                    String updatedCategory = scanner.nextLine();

                    Author updatedAuthor = new Author(
                            updatedAuthorId,
                            updatedAuthorName,
                            updatedAuthorSurname,
                            updatedAuthorEmail
                    );

                    service.updateBookInfo(
                            updateBookId,
                            updatedTitle,
                            updatedIsbn,
                            updatedAuthor,
                            updatedCategory
                    );
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting Library System...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}