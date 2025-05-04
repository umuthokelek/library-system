package com.umuthokelek.library;

import java.time.LocalDate;
import java.util.Objects;

public class LoanRecord {
    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean isReturned;

    public LoanRecord(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.returnDate = null;
        this.isReturned = false;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        this.isReturned = returned;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LoanRecord))
            return false;
        LoanRecord that = (LoanRecord) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(book, that.book) &&
                Objects.equals(loanDate, that.loanDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book, loanDate);
    }
}
