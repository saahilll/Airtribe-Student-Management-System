package com.airtribe.studentmanagement.interfaces;

public interface Searchable<T> {
    T search(String query);

    default void printSearchResults(T result) {
        if (result != null) {
            System.out.println("Search Result: " + result.toString());
        } else {
            System.out.println("No records found.");
        }
    }
}