package com.umuthokelek.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NovelTest {

    @Test
    public void testNovelCreationAndTitle() {
        Novel novel = new Novel("Sefiller");
        assertEquals("Sefiller", novel.getTitle());
        assertFalse(novel.isBorrowed());
    }

    @Test
    public void testBorrowedStateChange() {
        Novel novel = new Novel("Kürk Mantolu Madonna");
        novel.setBorrowed(true);
        assertTrue(novel.isBorrowed());
    }

    @Test
    public void testEqualsAndHashCode() {
        Novel n1 = new Novel("1984");
        Novel n2 = new Novel("1984");

        assertEquals(n1, n2);
        assertEquals(n1.hashCode(), n2.hashCode());
    }

    @Test
    public void testNotEqualsDifferentTitle() {
        Novel n1 = new Novel("Hayvan Çiftliği");
        Novel n2 = new Novel("Beyaz Diş");

        assertNotEquals(n1, n2);
    }
}
