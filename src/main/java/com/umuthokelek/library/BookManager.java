package com.umuthokelek.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
        System.out.println(b.getTitle() + " successfully added to the library.");
    }

    public Optional<Book> findByTitle(String title) {
        return books.stream().filter(b -> b.getTitle().equals(title)).findFirst();
    }
}
