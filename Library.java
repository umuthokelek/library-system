import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private BookManager bookManager;
    private UserManager userManager;
    private LoanManager loanManager;
    private NotificationService notificationService;

    public Library(BookManager bookManager, UserManager userManager, LoanManager loanManager,
            NotificationService notificationService) {
        this.bookManager = bookManager;
        this.userManager = userManager;
        this.loanManager = loanManager;
        this.notificationService = notificationService;
    }
}
