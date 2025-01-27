package com.example.project;

public class IdGenerate {

    // Requires 1 private attribute int currentId. You must initialize it to 99
    private static int currentID = 99;

    // Requires one empty constructor
    public IdGenerate() {}

    // Returns the currentId as a String
    public static String getCurrentId() {
        return Integer.toString(currentID);
    }

    // Resets the currentId back to 99
    public static void reset() {
        currentID = 99;
    }

    // Generates a new ID, increments the currentId by 1
    public static void generateID() {
        currentID++;
    }
}