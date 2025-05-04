public class Textbook extends Book {
    public Textbook(String title) {
        super(title);
    }

    @Override
    public int getLoanDurationInDays() {
        return 30;
    }
}
