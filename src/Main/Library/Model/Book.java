package Main.Library.Model;

public class Book {
    private final String title;
    private final String author;
    private final Integer page;
    private boolean available;
    final private Integer id;

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

    public Book(int id, String title, String author, int page, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.page = page;
        this.available = available;
    }

// یک متود برای اینکه اگر از فایل رشته ای خواندیم بتوانیم انرا به یک شی از کلاس کتاب تبدیل کنیم
    public static Book fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Book(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                Integer.parseInt(parts[3]),
                Boolean.parseBoolean(parts[4])
        );

    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", page=" + page +
                ", available=" + available +
                '}';
    }

}