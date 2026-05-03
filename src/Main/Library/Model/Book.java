package Main.Library.Model;

public class Book {
    private final String title;
    private final String author;
    private final Integer page;
    private boolean available;
    final private  Integer id;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Integer getPage() {
        return page;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book(String title , String author , Integer page , Integer id , boolean available) {
        this.title = title;
        this.author = author;
        this.page = page;
        this.id = id;
        this.available = available;

    }

}
