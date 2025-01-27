package com.example.project;

public class User {
    // Requires 3 private attributes
    private String name;
    private String id;
    private Book[] books; // This should be initialized to empty

    // Requires 1 constructor with two parameters that will initialize the name and id
    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.books = new Book[5]; // Initialize the book to null (empty)
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book[] getBooks() {
        return books.clone();
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    // Returns a book list for the user, if empty, outputs "empty"
    public String bookListInfo() {
        // create string list for list of book information
        String[] booksInfo = new String[5];
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) { // null space
                booksInfo[i] = "empty";
            } else { // this book exists
                // add the book's info the the array
                booksInfo[i] = books[i].bookInfo();
            }
        }
        // join the book information together with newlines
        return String.join("\n", booksInfo);
    }

    // Returns "Name: []\nID: []\nBooks:\n[]"
    public String userInfo() {
        String booksInfo = bookListInfo();
        return "Name: " + name + "\nId: " + id + "\nBooks: \n" + booksInfo + "\n";
    }
}