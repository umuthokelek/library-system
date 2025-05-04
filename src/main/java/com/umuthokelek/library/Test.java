package com.umuthokelek.library;

public class Test {
    public static void main(String[] args) {
        Book b1 = new Article("Can machines think?");
        Book b2 = new Novel("Sofie'nin Dunyasi");
        Book b3 = new Textbook("Object-Oriented Thought Process");

        User u1 = new User("Umut");
        User u2 = new User("Ahmet");
        User u3 = new User("Mehmet");

        NotificationService notificationService = new EmailNotificationService();

        BookManager bookManager = new BookManager();
        UserManager userManager = new UserManager();
        LoanManager loanManager = new LoanManager(bookManager, userManager, notificationService);
        Library library = new Library(bookManager, userManager, loanManager);

        bookManager.addBook(b1);
        bookManager.addBook(b2);
        bookManager.addBook(b3);
        userManager.addUser(u1);
        userManager.addUser(u2);
        userManager.addUser(u3);
        library.borrowBook("Umut", "Can machines think?");
        library.returnBook("Umut", "Can machines think?");

    }
}
