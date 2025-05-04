public class Article extends Book {
    public Article(String title) {
        super(title);
    }

    @Override
    public int getLoanDurationInDays() {
        return 3;
    }
}
