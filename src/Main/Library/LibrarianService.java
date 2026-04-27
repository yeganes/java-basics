package Main.Library;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class LibrarianService {
    Scanner inputInfo = new Scanner(System.in);
    public static ArrayList<Book> listBook = new ArrayList<>();
    static Integer id = 0;
    boolean isAvailable = true;


    public void add(){

        System.out.println("How many books are you going to add? ");
        int j = Integer.parseInt(inputInfo.nextLine());
        for (int i = 0 ; i < j ; i++){
            System.out.println("Enter the book's title: ");
            String inputTitle = inputInfo.nextLine();

            System.out.println("Enter the book's author: ");
            String inputAuthor = inputInfo.nextLine();

            System.out.println("How many pages does it have? ");
            Integer inputPage = Integer.valueOf(inputInfo.nextLine());
            id++;
            Book book = new Book(inputTitle , inputAuthor , inputPage , id , isAvailable);
            book.getAvailable();
            listBook.add(book);
            System.out.println(book.getTitle() + " written by " + book.getAuthor() + " with " + book.getPage() + " pages " + "the book's id is : " + book.getId());
        }

    }
    public Book findBookByTitle(String title){
        Book result =  null;
        for (Book b : listBook){
            if (title.equalsIgnoreCase(b.getTitle())){
                result = b ;
                break;
            }
        }
        return result;
    }
    public void search(){
        System.out.println("enter the book you are searching for : ");
        String givenTitle = inputInfo.nextLine();
        Book b =  findBookByTitle(givenTitle);
        if (b == null){
            System.out.println("NOT FOUND");
        } else {
            System.out.println("this book is : " + b.getTitle() + " written by " + b.getAuthor() + " with " + b.getPage() + " pages the book availability is "+ b.getAvailable());
        }


    }
    public void update(){
        System.out.println("enter the book you are searching for : ");
        String givenTitle = inputInfo.nextLine();
        Book b =  findBookByTitle(givenTitle);
        if (b == null){
            System.out.println("NOT FOUND");
        } else {
            System.out.println("this book is : " + b.getTitle() + " written by " + b.getAuthor() + " with " + b.getPage() + " pages the book availability is "+ b.getAvailable());
        }

        if (b.getAvailable()){
            System.out.println("this book is available , make it unavailable , press enter");
            boolean chosen = inputInfo.nextLine().isEmpty();
            if (chosen){
                b.setAvailable(false);
                System.out.println("the book availability is "+ b.getAvailable());
            }
        }






    }
    public void delete(){
        System.out.println("enter the book you are searching for : ");
        String givenTitle = inputInfo.nextLine();
        Book b =  findBookByTitle(givenTitle);
        if (b == null){
            System.out.println("NOT FOUND");
        }
             else {
            System.out.println("this book is : " + b.getTitle() + " written by " + b.getAuthor() + " with " + b.getPage() + " pages ");
            System.out.println("Do you wanna delete this book from the archive? 1.yes 2.no");
            int bookDelete = 0;
            while (true){
            try {
                bookDelete = Integer.parseInt(inputInfo.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input , please enter a valid number  ");
            }
            }

            if (bookDelete == 1) {
                int i = listBook.indexOf(b);
                listBook.remove(i);
                System.out.println("this book is no longer available ");
            } else {
                return;
            }
        }
        }




}
