package Main.Library.Service;

import Main.Library.Exceptions.LimitBorrowedException;
import Main.Library.Exceptions.MemberNotFoundException;
import Main.Library.Model.Book;
import Main.Library.Model.Member;
import Main.Library.Repository.BookRepo;
import Main.Library.Repository.BorrowRepo;
import Main.Library.Repository.MemberRepo;

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

            if (book.isAvailable() && name.getBorrowLimit() > 0 && book.getBookStock() > 0) {
                name.setBorrowLimit(name.getBorrowLimit() - 1);
                book.setBookStock(book.getBookStock()-1);
                    if (book.getBookStock() < 0){
                        book.setAvailable(false);
                }
                borrowRepo.insert(member , bookId);
                memberRepo.updateLimit(member , name.getBorrowLimit());
                bookRepo.updateStock(bookId , book.getBookStock());



            } else {
                throw new LimitBorrowedException("can't borrow more books");

        }
    }

}