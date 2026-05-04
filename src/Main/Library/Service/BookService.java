package Main.Library.Service;
import Main.Library.Model.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class BookService {
    public static ArrayList<Book> listBook = new ArrayList<>();
    static Integer id = 0;
    static boolean isAvailable = true;


    public Book add(String inputTitle, String inputAuthor, Integer inputPage) throws IOException {
        if (inputTitle==null || inputTitle.isEmpty()){
            throw new IllegalArgumentException("the title shouldn't be empty");

        }
        if (inputAuthor ==null || inputAuthor.isEmpty()){
            throw new IllegalArgumentException("the author shouldn't be empty");

        }
        if (inputPage==null || inputPage <= 0){
            throw new IllegalArgumentException("the page shouldn't be empty or smaller than zero");

        }
        id++;
        Book book = new Book(inputTitle, inputAuthor, inputPage, id, isAvailable);
        listBook.add(book);
        return book;
    }

    public Book findBookByTitle(String title) {
        for (Book b : listBook) {
            if (title.equalsIgnoreCase(b.getTitle())) {
                return b;
            }
        }
        return null;
    }

    public Book search(String givenTitle) {
        Book b;
        b = findBookByTitle(givenTitle);

            if (b == null) {
                throw new NullPointerException("the book's name doesn't match");
                //left empty by purpose
            }
        return b;
    }

    public Book update(String givenTitle, boolean chosen) {
        Book b;
            b = search(givenTitle);
        if (b.isAvailable()) {
            if (chosen) {
                if (b.isAvailable() == true) {
                    b.setAvailable(false);
                    b.isAvailable();
                } else if (b.isAvailable() == false) {
                    b.setAvailable(true);
                    b.isAvailable();
                }
            }
        }
        return b;

    }

    public boolean delete(String givenTitle2)  {
        Book b = search(givenTitle2);
        int i = listBook.indexOf(b);
        listBook.remove(i);
        return true;
    }
}