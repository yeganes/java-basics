package com.library.service;



import com.library.exceptions.LimitBorrowedException;
import com.library.exceptions.MemberNotFoundException;
import com.library.model.Book;
import com.library.model.Borrow;
import com.library.model.Member;
import com.library.repository.BookRepo;
import com.library.repository.BorrowRepo;
import com.library.repository.MemberRepo;

import java.util.ArrayList;

public class LibraryService {
    MemberService memberService = new MemberService();
    BookService bookService = new BookService();
    BookRepo bookRepo = new BookRepo();
    BorrowRepo borrowRepo = new BorrowRepo();
    MemberRepo memberRepo = new MemberRepo();


    public void borrow(int member, int bookId ) throws LimitBorrowedException, MemberNotFoundException {

        Member name = memberService.readMemberById(member);
        Book book = bookService.findById(bookId);
        borrowRepo.selectAll();

        if (book.isAvailable() && name.getBorrowLimit() > 0 && book.getBookStock() > 0) {
            name.setBorrowLimit(name.getBorrowLimit() - 1);
            book.setBookStock(book.getBookStock()-1);
            if (book.getBookStock() < 0){
                book.setAvailable(false);
            }

            borrowRepo.insert(member , bookId);
            memberRepo.updateLimit(member , name.getBorrowLimit());
            bookRepo.updateStock(bookId , book.getBookStock());



        } else if (name.getBorrowLimit() == 0){
            throw new LimitBorrowedException("can't borrow more books");

        }
    }

    public void returnBook (int member , int bookId) throws MemberNotFoundException {

        ArrayList<Borrow> borrowList = borrowRepo.selectMemberBook(member);
        Member name = memberService.readMemberById(member);
        Book book = bookService.findById(bookId);


        name.setBorrowLimit(name.getBorrowLimit() + 1 );
        book.setBookStock(book.getBookStock() + 1 );
        if (!book.isAvailable()){
            book.setAvailable(true);
        }

        for (Borrow borrow : borrowList){
            if (borrow.getBook_id() == 0 || borrow.getMember_id() == 0 ){
                System.out.println("you didn't borrow any books");

            }
        }
        memberRepo.updateLimit(member , name.getBorrowLimit());

        bookRepo.updateStock(bookId , book.getBookStock());

        borrowRepo.delete(member , bookId);
    }

}