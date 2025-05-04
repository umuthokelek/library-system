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

    }

    public void returnBook(User u, Book b) {

    }
}
