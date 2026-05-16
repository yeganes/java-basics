package Main.Library.Service;
import Main.Library.Model.Book;
import Main.Library.Repository.BookRepo;

import java.util.ArrayList;
import java.util.List;


public class BookService {
    BookRepo bookRepo = new BookRepo();

    public static ArrayList<Book> listBook = new ArrayList<>();


    public int getMaxId(){
        int max = 0 ;
        for (Book book : listBook){
            if (book.getId() > max){
                max = book.getId();
            }
        }
        return max;
    }

    public Book add(String inputTitle, String inputAuthor, Integer inputPage) {

         boolean isAvailable = true;

        if (inputTitle==null || inputTitle.isEmpty()){
            throw new IllegalArgumentException("the title shouldn't be empty");

        }
        if (inputAuthor ==null || inputAuthor.isEmpty()){
            throw new IllegalArgumentException("the author shouldn't be empty");

        }
        if (inputPage==null || inputPage <= 0){
            throw new IllegalArgumentException("the page shouldn't be empty or smaller than zero");

        }
        int id = getMaxId() + 1 ;
        Book book = new Book(id, inputTitle, inputAuthor, inputPage,  isAvailable);
        listBook.add(book);
        bookRepo.insert(inputTitle, inputAuthor, inputPage,  isAvailable );
        return book;
    }
    public ArrayList<Book> findExactMatch (String title){
        ArrayList<Book> allBooks = bookRepo.select();
        ArrayList<Book> result = new ArrayList<>();

        for (Book b : allBooks) {

            if (b.getTitle().equalsIgnoreCase(title)) {
                result.add(b);
            }
        }

        return result ;
    }


    public List<Book> findPrefix(String preFix) {
        List<Book> allBooks = bookRepo.select();
        List<Book> result = new ArrayList<>(); // Separate list for results

        for (Book b : allBooks) {
            String[] words = b.getTitle().split(" ");
            for (String w : words) {
                if (w.toLowerCase().startsWith(preFix.toLowerCase())) {
                    result.add(b);
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<Book> search(String givenTitle) {
        ArrayList<Book> a = bookRepo.select();

        ArrayList<Book> b = null;

        b = findExactMatch(givenTitle);

            if (b == null) {
                throw new NullPointerException("the book's name doesn't match");
                //left empty by purpose
            }
        return b;
    }

    public Book update(String givenTitle, boolean chosen) {

        ArrayList<Book> book;
            b = search(givenTitle);
            for()
            if (chosen) {
                if (b.isAvailable() == true) {
                    b.setAvailable(false);
                    bookRepo.updateStatus(givenTitle , b.isAvailable());
                    b.isAvailable();
                } else {
                    b.setAvailable(true);
                    bookRepo.updateStatus(givenTitle ,  b.isAvailable());
                    b.isAvailable();

                }
            }


        return b;

    }

    public boolean delete(String givenTitle2)  {
        ArrayList<Book> a = bookRepo.select();

        Book b = search(givenTitle2);
        listBook.remove(b);
        bookRepo.delete(b.getTitle());
        a.remove(b);

        return true;
    }
}