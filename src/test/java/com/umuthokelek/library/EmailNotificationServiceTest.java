package com.umuthokelek.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class EmailNotificationServiceTest {

    private EmailNotificationService notificationService;
    private User user;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        notificationService = new EmailNotificationService();
        user = new User("Umut");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testNotifyPrintsCorrectMessage() {
        notificationService.notify(user, "You borrowed: Java Book");

        String expected = "E-mail to: Umut: You borrowed: Java Book" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}
