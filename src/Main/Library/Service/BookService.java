package Main.Library.Service;
import Main.Library.Model.Book;

import java.util.ArrayList;


public class BookService {
    public ArrayList<Book> listBook = new ArrayList<>();
    static Integer id = 0;
    static boolean isAvailable = true;


    public Book add(String inputTitle, String inputAuthor, Integer inputPage) {
        id++;
        Book book = new Book(inputTitle, inputAuthor, inputPage, id, isAvailable);
        listBook.add(book);
        return book;
    }

    public Book findBookByTitle(String title) throws NullPointerException{
        Book result = null;
        for (Book b : listBook) {
            if (title.equalsIgnoreCase(b.getTitle())) {
                result = b;
                break;
            }else{
                throw new NullPointerException();
        }

        }
        return result;
    }

    public Book search(String givenTitle) {
        Book b;
        while (true) {
            try {
                b = findBookByTitle(givenTitle);
                break;
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }
        if (b == null) {
            //left empty by purpose
        }
        return b;
    }

    public Book update(String givenTitle, boolean chosen) {
        Book b = search(givenTitle);
        if (b.getAvailable()) {
            if (chosen) {
                if (b.getAvailable() == true) {
                    b.setAvailable(false);
                    b.getAvailable();
                } else if (b.getAvailable() == false){
                    b.setAvailable(true);
                    b.getAvailable();
                }
            }
        }
        return b;

    }

    public boolean delete(String givenTitle2) throws NumberFormatException {
        Book b = findBookByTitle(givenTitle2);
        int i = listBook.indexOf(b);
        listBook.remove(i);
        return true;
    }
}