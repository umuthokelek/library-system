public class Test {
    public static void main(String[] args) {
        User user1 = new User("Umut");
        User user2 = new User("Hökelek");
        Book book1 = new Book("İnsan Neyle Yaşar");
        Book book2 = new Book("Kendime Düşünceler");

        Library library = new Library();
        library.addUser(user1);
        library.addUser(user2);
        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook(user1, book1);
        library.borrowBook(user2, book2);
        library.returnBook(user2, book2);
        library.borrowBook(user1, book2);

    }
}
