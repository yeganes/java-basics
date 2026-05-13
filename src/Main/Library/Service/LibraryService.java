package Main.Library.Service;

import Main.Library.Exceptions.LimitBorrowedException;
import Main.Library.Exceptions.MemberNotFoundException;
import Main.Library.Model.Book;
import Main.Library.Model.Member;
import Main.Library.Repository.BookRepo;

public class LibraryService  {
    MemberService memberService = new MemberService();
    BookService bookService = new BookService();
    BookRepo bookRepo = new BookRepo();

    public void borrow(int member, String title) throws LimitBorrowedException, MemberNotFoundException {

        Book book = bookService.findExactMatch(title);
        Member name = memberService.readMemberById(member);
        boolean b1 = name.getBorrowedBooksNum() <= name.getBorrowLimit();
        boolean b2 = book.isAvailable();
        if ( b1 & b2 ) {
            name.setBorrowLimit(name.getBorrowLimit() - 1);
            book.setAvailable(false);
            bookRepo.borrowBook(member , title);
        }else {
            throw new LimitBorrowedException("can't borrow more books");
        }
    }
}