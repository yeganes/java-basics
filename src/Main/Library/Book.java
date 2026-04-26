package Main.Library;

public class Book {
    private String title;
    private String author;
    private Integer page;
    private boolean available;
    final private  Integer id;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book(String title , String author , Integer page , Integer id){
        this.title = title;
        this.author = author;
        this.page = page;
        this.id = id;

    }

}
