

public class Book {
    private String title;
    private boolean isLent;

    public Book(String title) {
        this.title = title;
        this.isLent = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isLent() {
        return isLent;
    }

    protected void setLent(boolean lent) {
        this.isLent = lent;
    }
}
