package com.library.model;


public class Borrow {
    private int borrowId;
    private int member_id;
    private int book_id;
    private Book book;
    private Member member;

    public void setId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getId() {
        return borrowId;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Borrow (int borrowId , int member_id , int book_id ){
        this.borrowId = borrowId;
        this.member_id = member_id;
        this.book_id = book_id;
    }


}


