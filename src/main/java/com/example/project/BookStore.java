package com.example.project;

public class BookStore {

    // Requires at least 2 attributes
    private Book[] books = new Book[0];
    private User[] users = new User[10]; // Initialized to an empty array of 10 max users

    // Requires 1 empty constructor
    public BookStore() {}

    // Getter and Setter for users
    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    // Getter for books
    public Book[] getBooks() {
        return books;
    }

    // Adds a user to the users array
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) { // null means it found somewhere to insert a user
                users[i] = user; // insert user in said spot
                break; // break out, we don't need to add multiple of the same user
            }
        }
    }

    // Removes a user from the users array
    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            // if there is a user at this position and the user's id matches
            if (users[i] != null && users[i].getId().equals(user.getId())) {
                users[i] = null; // remove user by setting index to null
                break;
            }
        }
        consolidateUsers(); // remove gaps in user list
    }

    // Consolidates users array to remove null elements
    public void consolidateUsers() {
        User[] consolidatedUsers = new User[users.length];
        int index = 0;
        for (User user : users) {
            // only increase index when a user is found as to not create gaps with null in the new user list
            if (user != null) {
                consolidatedUsers[index++] = user;
            }
        }
        users = consolidatedUsers;
    }

    // Adds a book to the books array
    public void addBook(Book book) {
        // new array of books that is one larger than the current
        Book[] newBooks = new Book[books.length + 1];
        // copy array
        System.arraycopy(books, 0, newBooks, 0, books.length);
        // add the new book
        newBooks[books.length] = book;
        // write this new books array to the books attribute
        books = newBooks;
    }

    // Inserts a book at a specified index in the books array
    public void insertBook(Book book, int index) {
        if (index >= 0 && index <= books.length) {
            // new array of books that is one larger than the current
            Book[] newBooks = new Book[books.length + 1];
            // copy all books at and before the given index
            System.arraycopy(books, 0, newBooks, 0, index);
            // add book to given index
            newBooks[index] = book;
            // copy all books after the given index
            System.arraycopy(books, index, newBooks, index + 1, books.length - index);
            // set book list to new book list
            books = newBooks;
        }
    }

    // Removes a book from the books array
    public void removeBook(Book book) {
        // subtract 1 from book quantity
        book.setQuantity(book.getQuantity() - 1);
        // if there are no more books, remove this book entry
        if (book.getQuantity() == 0) {
            int index = -1;
            // iterate through books to find the index of the book
            for (int i = 0; i < books.length; i++) {
                if (books[i].equals(book)) {
                    index = i;
                    break;
                }
            }
            // book found
            if (index != -1) {
                // new list that is one less than the current list
                Book[] newBooks = new Book[books.length - 1];
                // copy all books to the left of the book
                System.arraycopy(books, 0, newBooks, 0, index);
                // copy all books to the right of the book
                System.arraycopy(books, index + 1, newBooks, index, books.length - index - 1);
                // write new books list to books attribute
                books = newBooks;
            }
        }
    }

    // For debugging purposes
    //public String bookStoreBookInfo() {

    //}

    // For debugging purposes
    //public String bookStoreUserInfo() {

    // }
}