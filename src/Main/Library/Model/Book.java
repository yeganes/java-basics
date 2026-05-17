package Main.Library.Model;


public class Book {
    private final String title;
    private final String author;
    private final Integer totalPages;
    private boolean available;
    final private Integer id;
    private int bookStock;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public Book(int id, String title, String author, int page, boolean available , int bookStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalPages = page;
        this.available = available;
        this.bookStock = bookStock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", page=" + totalPages +
                ", available=" + available +
                ", bookStock=" + bookStock+
                '}';
    }

}