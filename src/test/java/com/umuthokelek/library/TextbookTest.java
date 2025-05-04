package com.umuthokelek.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextbookTest {

    @Test
    public void testTextbookTitleAndBorrow() {
        Textbook tb = new Textbook("Object-Oriented Thought Process");
        assertEquals("Object-Oriented Thought Process", tb.getTitle());
        assertFalse(tb.isBorrowed());

        tb.setBorrowed(true);
        assertTrue(tb.isBorrowed());
    }

    @Test
    public void testTextbookEquality() {
        Textbook t1 = new Textbook("Clean Code");
        Textbook t2 = new Textbook("Clean Code");

        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());
    }
}
