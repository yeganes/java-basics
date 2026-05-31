package com.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "borrows")
public class Borrow {

    private Integer borrowId;
    private Book book;
    private Member member;

    public Borrow() {
    }

    public Borrow(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId=" + borrowId +
                ", book=" + book +
                ", member=" + member +
                '}';
    }
}