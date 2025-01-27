package com.example.project;

import java.util.Scanner;

public class LibraryInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final BookStore bookStore = new BookStore();

    // show the header once and never again, and then begin the prompt loop
    public LibraryInterface() {
        System.out.println("################ WELCOME TO THE LIBRARY #################");
        beginPrompts();
    }

    // show list of options to the user
    private void showOptions() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("---------------------------------------------------------");
    }

    private void beginPrompts() {
        while (true) {
            showOptions();
            // option selection
            int opt = Integer.parseInt(scanner.nextLine());
            // each case matches the options in showOptions()
            switch (opt) {
                case 0: {
                    // end to prompt loop
                    scanner.close();
                    return;
                }
                case 1: {
                    addBook();
                    break;
                }
                case 2: {
                    upgradeQuantity();
                    break;
                }
                case 3: {
                    search();
                    break;
                }
                case 4: {
                    showAllBooks();
                    break;
                }
                case 5: {
                    registerStudent();
                    break;
                }
                case 6: {
                    showAllStudents();
                    break;
                }
            }
        }
    }

    private void addBook() {
        // get book info from the user
        System.out.println("Enter Serial No of Book:");
        String serialNum = scanner.nextLine();
        System.out.println("Enter Book Name:");
        String title = scanner.nextLine();
        System.out.println("Enter Author Name:");
        String authorName = scanner.nextLine();
        System.out.println("Enter Year of Publication:");
        int yearPublished = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Quantity of Books:");
        int quantity = Integer.parseInt(scanner.nextLine());
        // finally create and add book to the book store
        bookStore.addBook(new Book(title, authorName, yearPublished, serialNum, quantity));
        System.out.println("Added Book."); // give feedback to the user to tell them that something happened
    }

    private void upgradeQuantity() {
        // query for the book in question
        System.out.println("Enter Serial No of Book:");
        String serialNum = scanner.nextLine();
        // attempt to update the book
        for (Book book: bookStore.getBooks()) {
            if (book == null) continue; // book is potentially null (?)
            if (book.getIsbn().equals(serialNum)) {
                // get new quantity from user
                System.out.println("Enter New Quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                // update quantity
                book.setQuantity(quantity);
                System.out.println("Set New Quantity."); // give feedback to the user
                return;
            }
        }
        System.out.println("Book does not exist."); // give feedback to the user
    }

    // book querying function for search()
    private boolean bookMatches(String criteria, Book book, String query) {
        // each case is a search criteria type
        switch (criteria) {
            case "title": return book.getTitle().equalsIgnoreCase(query);
            case "author": return book.getAuthor().equalsIgnoreCase(query);
            case "year": return book.getYearPublished() == Integer.parseInt(query);
            case "serial number": return book.getIsbn().equals(query);
            case "quantity": return book.getQuantity() == Integer.parseInt(query);
            default: return false;
        }
    }
    private void search() {
        // get query type
        System.out.println("Select Search Criteria: (title/author/year/serial number/quantity)");
        String method = scanner.nextLine().toLowerCase();
        if (!method.equals("title") && !method.equals("author") && !method.equals("year") && !method.equals("serial number") && !method.equals("quantity")) {
            System.out.println("Invalid Search Criteria"); // give feedback to the user
            return;
        }
        // get value to query for
        System.out.println("Input Search Value:");
        String requirement = scanner.nextLine();
        boolean hasMatches = false;
        // loop and print out info for books that match
        for (Book book: bookStore.getBooks()) {
            if (book == null) continue; // book is potentially null
            if (bookMatches(method, book, requirement)) {
                hasMatches = true;
                System.out.println(book.bookInfo());
            }
        }
        if (!hasMatches) {
            System.out.println("No Matches Found."); // give feedback to the user
        }
    }

    // show info of all books
    private void showAllBooks() {
        boolean hasBooks = false;
        for (Book book: bookStore.getBooks()) {
            if (book == null) continue;
            hasBooks = true;
            System.out.println(book.bookInfo());
        }
        if (!hasBooks) {
            System.out.println("No Books Found."); // give feedback to user
        }
    }

    // register student
    private void registerStudent() {
        // ask for name
        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();
        IdGenerate.generateID(); // increment id
        bookStore.addUser(new User(name, IdGenerate.getCurrentId())); // use new id to create User object
        System.out.println("Added Student."); // give feedback to user
    }

    // show info of all students
    private void showAllStudents() {
        boolean hasUsers = false;
        for (User user: bookStore.getUsers()) {
            if (user == null) continue; // user is potentially null
            hasUsers = true;
            System.out.println(user.userInfo());
        }
        if (!hasUsers) {
            System.out.println("No Users Found."); // give feedback to user
        }
    }
}