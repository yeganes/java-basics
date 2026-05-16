package Main.Library.Service;

import Main.Library.Exceptions.LimitBorrowedException;
import Main.Library.Exceptions.MemberNotFoundException;
import Main.Library.Model.Book;
import Main.Library.Model.Member;
import Main.Library.Repository.BookRepo;
import Main.Library.Repository.BorrowRepo;

import java.util.ArrayList;

public class LibraryService {
    MemberService memberService = new MemberService();
    BookService bookService = new BookService();
    BookRepo bookRepo = new BookRepo();
    BorrowRepo borrowRepo = new BorrowRepo();

    public void borrow(int member, String title) throws LimitBorrowedException, MemberNotFoundException {

        ArrayList<Book> book = bookService.findExactMatch(title);
        Member name = memberService.readMemberById(member);

        for (Book b : book) {
            if (b.isAvailable()) {
                name.setBorrowLimit(name.getBorrowLimit() - 1);
                b.setAvailable(false);

            } else {
                throw new LimitBorrowedException("can't borrow more books");
            }
        }
    }
}