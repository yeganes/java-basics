package Main.Library;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarianService {
    Scanner inputInfo = new Scanner(System.in);
    public static ArrayList<Book> listBook = new ArrayList<>();

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

            Book book = new Book(inputTitle , inputAuthor , inputPage);
            listBook.add(book);
            System.out.println(book.getTitle() + " written by " + book.getAuthor() + " with " + book.getPage() + " pages ");
            System.out.println("enter the book's name : ");
            String booksname = inputInfo.nextLine();
            boolean inputAvailable = book.getTitle().equalsIgnoreCase(booksname);
            if ( inputAvailable == true ) {
                book = new Book(inputAvailable);
                System.out.println(book.getTitle() + " written by " + book.getAuthor() + " with " + book.getPage() + " pages " + book.getAvailable());


            }


        }



    }

    public void search(){

    }
    public void update(){}
    public void delete(){}


}
