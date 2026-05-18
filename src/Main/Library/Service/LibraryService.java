package Main.Library.Service;

import Main.Library.Exceptions.LimitBorrowedException;
import Main.Library.Exceptions.MemberNotFoundException;
import Main.Library.Model.Book;
import Main.Library.Model.Borrow;
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

        ArrayList<Borrow> borrowlist = borrowRepo.selectMemberBook(member);
        Member name = memberService.readMemberById(member);
        Book book = bookService.findById(bookId);


            name.setBorrowLimit(name.getBorrowLimit() + 1 );
            book.setBookStock(book.getBookStock() + 1 );
            if (!book.isAvailable()){
                book.setAvailable(true);
            }

                for (Borrow borrow : borrowlist){
                    if (borrow.getBook_id() == 0 || borrow.getMember_id() == 0 ){
                        System.out.println("you didn't borrow any books");

                    }
                }




        memberRepo.updateLimit(member , name.getBorrowLimit());

        bookRepo.updateStock(bookId , book.getBookStock());

        borrowRepo.delete(member , bookId);





    }

}