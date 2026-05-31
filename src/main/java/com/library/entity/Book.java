package com.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    private Integer id;
    private String title;
    private String author;
    private int totalPages;
    private boolean available;
    private int bookStock;

    public Book() {
    }

    public Book(String title,
                String author,
                int totalPages,
                boolean available,
                int bookStock) {

        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.available = available;
        this.bookStock = bookStock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "book_title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author_name")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalPages=" + totalPages +
                ", available=" + available +
                ", bookStock=" + bookStock +
                '}';
    }
}