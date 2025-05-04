import java.lang.foreign.Linker.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanManager {
    private List<LoanRecord> loans;
    private BookManager bookManager;
    private UserManager userManager;

    public LoanManager(BookManager bookManager, UserManager userManager) {
        this.bookManager = bookManager;
        this.userManager = userManager;
        loans = new ArrayList<>();
    }

    public void borrowBook(String userName, String bookTitle) {
        Optional<User> aUser = userManager.findByName(userName);
        Optional<Book> aBook = bookManager.findByTitle(bookTitle);

        if (aUser.isPresent() && aBook.isPresent()) {
            User user = aUser.get();
            Book book = aBook.get();

            if (!book.isBorrowed()) {
                loans.add(new LoanRecord(book, user));
                book.setBorrowed(true);
                System.out.println("Book borrowed successfully");
            } else {
                System.out.println("Book is already borrowed");
            }
        } else {
            System.out.println("User or book is not found");
        }

    }

    public void returnBook(String userName, String bookTitle) {
        Optional<User> aUser = userManager.findByName(userName);
        Optional<Book> aBook = bookManager.findByTitle(bookTitle);

        if (aUser.isPresent() && aBook.isPresent()) {
            User user = aUser.get();
            Book book = aBook.get();

            for (LoanRecord loanRecord : loans) {
                if (loanRecord.getUser().equals(user) && loanRecord.getBook().equals(book) & !loanRecord.isReturned()) {

                    loanRecord.setReturned(true);
                    loanRecord.setReturnDate(LocalDate.now());
                    book.setBorrowed(false);

                    LocalDate returnDate = LocalDate.now();
                    int allowedDays = book.getLoanDurationInDays();
                    LocalDate dueDate = loanRecord.getLoanDate().plusDays(allowedDays);
                    if (returnDate.isAfter(dueDate)) {
                        System.out.println("Book " + book.getTitle() + " was returned LATE by " + user.getName());
                    } else {
                        System.out.println("Book " + book.getTitle() + " was returned on time by " + user.getName());
                    }
                }
            }
            System.out.println("No active loan found for this user and book");
        } else {
            System.out.println("User or book not found");
        }
    }
}
