package com.umuthokelek.library;

public class SmsNotificationService implements NotificationService {
    @Override
    public void notify(User user, String message) {
        System.out.println("SMS to " + user.getName() + ": " + message);
    }
}
