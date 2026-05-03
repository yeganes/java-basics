package Main.Library.Model;

public class Book {
    private final String title;
    private final String author;
    private Integer page;
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
        if (title==null){
            throw new IllegalArgumentException("the title shouldn't be empty");

        }
        if (author ==null){
            throw new IllegalArgumentException("the author shouldn't be empty");

        }
        if (page==null || page <= 0){
            throw new IllegalArgumentException("the page shouldn't be empty or smaller than zero");

        }
        this.title = title;
        this.author = author;
        this.page = page;
        this.id = id;
        this.available = available;

    }

}
