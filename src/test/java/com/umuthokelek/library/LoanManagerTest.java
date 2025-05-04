package com.umuthokelek.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoanManagerTest {

    private BookManager bookManager;
    private UserManager userManager;
    private NotificationService notificationService;
    private LoanManager loanManager;

    private User user;
    private Book book;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        userManager = new UserManager();
        notificationService = Mockito.mock(NotificationService.class);
        loanManager = new LoanManager(bookManager, userManager, notificationService);

        user = new User("Umut");
        book = new Novel("Sofie'nin Dünyası");

        bookManager.addBook(book);
        userManager.addUser(user);
    }

    @Test
    public void testBorrowBookSuccess() {
        loanManager.borrowBook("Umut", "Sofie'nin Dünyası");
        assertTrue(book.isBorrowed());
        verify(notificationService).notify(user, "You borrowed: Sofie'nin Dünyası");
    }

    @Test
    public void testBorrowBookAlreadyBorrowed() {
        book.setBorrowed(true);
        loanManager.borrowBook("Umut", "Sofie'nin Dünyası");
        verify(notificationService, never()).notify(any(), any());
    }

    @Test
    public void testReturnBookSuccess() {
        loanManager.borrowBook("Umut", "Sofie'nin Dünyası");
        loanManager.returnBook("Umut", "Sofie'nin Dünyası");
        assertFalse(book.isBorrowed());
        verify(notificationService).notify(user, "You returned: Sofie'nin Dünyası");
    }

    @Test
    public void testReturnBookWithoutBorrowing() {
        loanManager.returnBook("Umut", "Sofie'nin Dünyası");
        assertFalse(book.isBorrowed());
        verify(notificationService, never()).notify(any(), any());
    }

    @Test
    public void testBorrowNonexistentUser() {
        loanManager.borrowBook("Ahmet", "Sofie'nin Dünyası");
        verify(notificationService, never()).notify(any(), any());
    }

    @Test
    public void testBorrowNonexistentBook() {
        loanManager.borrowBook("Umut", "Bilinmeyen Kitap");
        verify(notificationService, never()).notify(any(), any());
    }
}
