package com.umuthokelek.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class SmsNotificationServiceTest {

    private SmsNotificationService notificationService;
    private User user;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        notificationService = new SmsNotificationService();
        user = new User("Mehmet");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testNotifyPrintsCorrectMessage() {
        notificationService.notify(user, "You returned: Clean Code");

        String expected = "SMS to Mehmet: You returned: Clean Code" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}
