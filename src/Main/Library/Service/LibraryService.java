package Main.Library.Service;

import Main.Library.Model.Book;
import Main.Library.Model.Member;

public class LibraryService  {
    MemberService memberService = new MemberService();
    BookService bookService = new BookService();

    public void borrow(int member, String books) throws LimitBorrowedException {
        Book book = bookService.findBookByTitle(books);
        Member name = memberService.readMemberById(member);
        boolean b1 = name.getBorrowedBooksNum() <= name.getBorrowLimit();
        boolean b2 = book.isAvailable();
        if ( b1 & b2 ) {
            Integer b = name.setBorrowLimit(name.getBorrowLimit() - 1);
            book.setAvailable(false);
        }else {
            throw new LimitBorrowedException("can't borrow more books");
        }
    }
}