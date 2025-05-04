package com.umuthokelek.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {

    @Test
    public void testArticleCreationAndGetTitle() {
        Article article = new Article("Can Machines Think?");
        assertEquals("Can Machines Think?", article.getTitle());
        assertFalse(article.isBorrowed());
    }

    @Test
    public void testBorrowedFlag() {
        Article article = new Article("AI Ethics");
        article.setBorrowed(true);
        assertTrue(article.isBorrowed());
    }

    @Test
    public void testEqualsAndHashCode() {
        Article a1 = new Article("Deep Learning");
        Article a2 = new Article("Deep Learning");

        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }
}
