import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<LoanRecord> loans;
    private NotificationService notificationService;

    public Library(NotificationService notificationService) {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();
        this.notificationService = notificationService;
    }

    public void addBook(Book b) {
        books.add(b);
        System.out.println(b.getTitle() + " successfully added to the library.");
    }

    public void addUser(User u) {
        users.add(u);
        System.out.println(u.getName() + " successfully registered to the library.");
    }

    public void borrowBook(User u, Book b) {
        for (Book libBook : books) {
            if (libBook.equals(b)) {
                if (!libBook.isBorrowed() && users.contains(u)) {
                    LoanRecord loan = new LoanRecord(libBook, u);
                    loans.add(loan);
                    libBook.setBorrowed(true);
                    System.out.println(libBook.getTitle() + " borrowed successfully by " + u.getName());
                } else {
                    System.out.println("Book already borrowed or user not found.");
                }
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    public void returnBook(User u, Book b) {
        for (LoanRecord record : loans) {
            if (record.getUser().equals(u) &&
                    record.getBook().equals(b) &&
                    !record.isReturned()) {

                record.setReturned(true);
                record.setReturnDate(LocalDate.now());

                for (Book libBook : books) {
                    if (libBook.equals(b)) {
                        libBook.setBorrowed(false);
                        break;
                    }
                }

                System.out.println("Book " + b.getTitle() + " successfully returned by " + u.getName());
                return;
            }
        }
        System.out.println("Loan record not found.");
    }
}
