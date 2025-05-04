package com.umuthokelek.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LibraryTest {

    private Library library;
    private LoanManager loanManager;
    private BookManager bookManager;
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        bookManager = new BookManager();
        userManager = new UserManager();
        loanManager = mock(LoanManager.class);

        library = new Library(bookManager, userManager, loanManager);
    }

    @Test
    public void testBorrowBookDelegation() {
        library.borrowBook("Umut", "Sefiller");
        verify(loanManager).borrowBook("Umut", "Sefiller");
    }

    @Test
    public void testReturnBookDelegation() {
        library.returnBook("Umut", "Sefiller");
        verify(loanManager).returnBook("Umut", "Sefiller");
    }
}
