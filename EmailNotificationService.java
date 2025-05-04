public class EmailNotificationService implements NotificationService {
    @Override
    public void notify(User user, String message) {
        System.out.println("E-mail to: " + user.getName() + ": " + message);
    }
}