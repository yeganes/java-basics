package Main.Library.Service;

import Main.Library.Library;
import Main.Library.Model.Book;
import Main.Library.Model.Member;

import java.util.ArrayList;



public class LibraryService implements Library {
    MemberService memberService = new MemberService();
    BookService bookService = new BookService();

    @Override
    public void borrow(String member, String books) {
        Book book = bookService.findBookByTitle(books);
        Member name = memberService.findMemberByName(member);
        boolean b1 = name.getBorrowedBooksNum() <= name.getBorrowLimit();
        boolean b2 = book.getAvailable();
        if ( b1 & b2 == true) {
            Integer b = name.setBorrowLimit(name.getBorrowLimit() - 1);
            book.setAvailable(false);
            System.out.println("the book is borrowed ");
        }else{
            System.out.println("you can't borrow any books - you have achived the limit ");
        }
    }
}
