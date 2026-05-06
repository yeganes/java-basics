package Main.Library.Service;
import Main.Library.Model.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
    public ArrayList<Book> readFromFile(String path){
        listBook.clear();
        Book b= null;
            try (Scanner scanner = new Scanner(new File(path))) {
                while(scanner.hasNextLine()){

                    String line = scanner.nextLine();
                    String[] parts = line.split("\\|");
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    Integer page = Integer.valueOf(parts[3]);
                    boolean status = parts[4].isEmpty();
                    b = new Book(id , title , author , page , status);

                    listBook.add(b);
                }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listBook;
    }

    public void save(Book book){
        try {
            FileWriter writer = new FileWriter("book.txt", true);
            writer.write(book.getId() + "|"
            +book.getTitle() + "|"
            + book.getAuthor() + "|"
            + book.getPage() +"|"
            +book.isAvailable()
                    +  "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void update(){
        try {
            FileWriter writer = new FileWriter("book.txt");
            for (Book book : listBook){
            writer.write(book.getId() + "|"
                    +book.getTitle() + "|"
                    + book.getAuthor() + "|"
                    + book.getPage() +"|"
                    +book.isAvailable()
                    +  "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        save(book);
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

        Book b = null;

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
        update();
        return b;

    }

    public boolean delete(String givenTitle2)  {
        Book b = search(givenTitle2);
        listBook.remove(b);
        update();
        return true;
    }
}