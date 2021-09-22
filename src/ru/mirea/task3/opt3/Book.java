package ru.mirea.task3.opt3;

public class Book {
    private int yearOfComposition;
    private int pages;
    private int currentPage;
    private int timesRead;
    private String authorName;
    private String bookName;

    public Book(int yearOfComposition, int pages, String authorName, String bookName) {
        this.yearOfComposition = yearOfComposition;
        this.pages = pages;
        this.authorName = authorName;
        this.bookName = bookName;
        this.currentPage = 1;
        this.timesRead = 0;
    }

    public Book(String authorName, String bookName) {
        this(1880, 500, authorName, bookName);
    }

    public int getYearOfComposition() {
        return yearOfComposition;
    }

    public void setYearOfComposition(int yearOfComposition) {
        this.yearOfComposition = yearOfComposition;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTimesRead() {
        return timesRead;
    }

    public void read(int pages)  {
        this.currentPage += pages - 1;
        while (this.currentPage > this.pages)   {
            this.currentPage -= this.pages;
            this.timesRead++;
        }
    }

    @Override
    public String toString() {
        return ("The name of the book: " + this.bookName +
                "\nThe name of the author of the book: " + this.authorName +
                "\nThe year of composition of the book: " + this.yearOfComposition +
                "\nThe amount of pages of the book: " + this.pages +
                "\nYou are on a page " + this.currentPage +
                "\nYou have read book " + this.timesRead + " times");
    }
}
