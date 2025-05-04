package com.umuthokelek.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    private BookManager bookManager;
    private Book book;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        book = new Novel("Sefiller");
    }

    @Test
    public void testAddBook() {
        bookManager.addBook(book);
        Optional<Book> result = bookManager.findByTitle("Sefiller");
        assertTrue(result.isPresent(), "Kitap bulunamadi");
        assertEquals(book, result.get(), "Bulunan kitap ile beklenen kitap eslesmiyor");
    }

    @Test
    public void testFindByTitleSuccess() {
        bookManager.addBook(book);
        Optional<Book> result = bookManager.findByTitle("Sefiller");
        assertTrue(result.isPresent(), "Kitap bulunamadı.");
        assertEquals(book, result.get(), "findbyTitle dogru kitabi dondurmedi");
    }

    @Test
    public void testFindByTitleNotFound() {
        Optional<Book> result = bookManager.findByTitle("Sefiller");
        assertTrue(result.isEmpty(), "Kitap eklenmemesine ragmen bulundu");
    }
}
