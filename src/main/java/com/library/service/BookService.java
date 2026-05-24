package com.library.service;


import com.library.model.Book;
import com.library.dao.BookDAO;

import java.util.ArrayList;
import java.util.List;


public class BookService {
    BookDAO bookDAO = new BookDAO();

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

    public Book add(String inputTitle, String inputAuthor, Integer inputPage , int bookStock) {


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
        Book book = new Book(id, inputTitle, inputAuthor, inputPage,  isAvailable , bookStock);
        listBook.add(book);
        bookDAO.insert(inputTitle, inputAuthor, inputPage,  isAvailable  , bookStock);
        return book;
    }
    public ArrayList<Book> findExactMatch (String title){
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        ArrayList<Book> allBooks = bookDAO.selectTitle(title);
        ArrayList<Book> result = new ArrayList<>();

        for (Book b : allBooks) {

            if (b.getTitle().equalsIgnoreCase(title)) {
                result.add(b);
            }
        }

        return result ;
    }

    public Book findById( int id){
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid book ID");
        }
        ArrayList<Book> allBooks = bookDAO.selectId(id);
        ArrayList<Book> result = new ArrayList<>();
        Book book = null;
        for (Book b : allBooks){
            if (b.getId().equals(id)){
                result.add(b);
                book = b;
            }
        }
        return book;
    }


    public List<Book> findPrefix(String preFix) {
        if (preFix == null || preFix.isEmpty()) {
            throw new IllegalArgumentException("Prefix cannot be empty");
        }
        List<Book> allBooks = bookDAO.select();
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
        if (givenTitle == null || givenTitle.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        bookDAO.selectTitle(givenTitle);

        ArrayList<Book> b = null;

        b = findExactMatch(givenTitle);

        if (b.isEmpty()) {
            throw new NullPointerException("the book's name doesn't match");
            //left empty by purpose
        }
        return b;
    }

    public Book update(String givenTitle, boolean chosen) {
        if (givenTitle == null || givenTitle.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        ArrayList<Book> book;
        book = search(givenTitle);
        for(Book b : book){
            if (chosen) {
                if (b.isAvailable() == true) {
                    b.setAvailable(false);
                    bookDAO.updateStatus(givenTitle , b.isAvailable());
                    b.isAvailable();
                } else {
                    b.setAvailable(true);
                    bookDAO.updateStatus(givenTitle ,  b.isAvailable());
                    b.isAvailable();
                }
            }
            return b;

        }
        return null;
    }

    public boolean delete(String givenTitle2)  {

        if (givenTitle2 == null || givenTitle2.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        ArrayList<Book> allBooks = bookDAO.selectTitle(givenTitle2);


        ArrayList<Book> book = search(givenTitle2);
        for (Book b :  book){
            listBook.remove(b);
            bookDAO.delete(b.getTitle());
            allBooks.remove(b);
        }

        return true;
    }
}
