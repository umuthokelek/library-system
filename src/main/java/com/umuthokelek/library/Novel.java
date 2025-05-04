package com.umuthokelek.library;

public class Novel extends Book {

    public Novel(String title) {
        super(title);
    }

    @Override
    public int getLoanDurationInDays() {
        return 14;
    }
}
