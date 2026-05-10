package Main.Library.Service;
import Main.Library.Model.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BookService {


    public static ArrayList<Book> listBook = new ArrayList<>();

    static boolean isAvailable = true;

    public int getMaxId(){
        int max = 0 ;
        for (Book book : listBook){
            if (book.getId() > max){
                max = book.getId();
            }
        }
        return max;
    }




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
        int id = getMaxId() + 1 ;
        Book book = new Book(id, inputTitle, inputAuthor, inputPage,  isAvailable);
        listBook.add(book);
        return book;
    }
    public Book findExactMatch (String title){

        for (Book b : listBook) {

            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }

        return null ;
    }
    public List<Book> findPrefix(String preFix){
        List<Book> result = new ArrayList<>();
        for (Book b : listBook){
            String [] words = b.getTitle().split(" ");
            for(String w : words){
                if (w.toLowerCase().startsWith(preFix.toLowerCase())){
                    result.add(b);
                    break;
                }
            }
        }
        return result;
    }

    public Book search(String givenTitle) {

        Book b = null;

        b = findExactMatch(givenTitle);

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
        listBook.remove(b);
        return true;
    }
}
