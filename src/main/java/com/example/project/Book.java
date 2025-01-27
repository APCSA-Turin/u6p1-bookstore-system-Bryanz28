package com.example.project;

public class Book {
    // Requires 5 attributes
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    // Requires 1 constructor with 5 arguments that initialize the attributes of the class
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        // initialize attributes to those given through the constructor
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
    public String bookInfo() {
        return "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
    }
}