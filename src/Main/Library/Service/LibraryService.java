package Main.Library.Service;

import Main.Library.Library;
import Main.Library.Model.Book;
import Main.Library.Model.Member;

public class LibraryService implements Library {

    @Override
    public void borrow(Member member, Book book) {
        boolean b1 = member.getBorrowedBooksNum() <= member.getBorrowLimit();
        if ( b1 ) {
            Integer b = member.setBorrowLimit(member.getBorrowLimit() - 1);
        }else{
            System.out.println("you can't borrow any books - you have achived the limit ");
        }
    }
}
