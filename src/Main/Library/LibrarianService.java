package Main.Library;
import java.util.ArrayList;
import java.util.Objects;
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
        }

    }
    public Book findBookByTitle(String title){
        Book result =  null;
        for (Book b : listBook){
            if (Objects.equals(title, b.getTitle())){
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
            System.out.println("this book is : " + b.getTitle() + " written by " + b.getAuthor() + " with " + b.getPage() + " pages ");
        }


    }
    public void update(){}
    public void delete(){}


}
