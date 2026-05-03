package Main.Library.UI;
import Main.Library.Model.Book;
import Main.Library.Service.BookService;


import java.util.Scanner;

public class BookMenu {
    static Scanner inputInfo = new Scanner(System.in);

    public void ask() {
        BookService bookService = new BookService();

        int chosenNumber = 0;
        do {
            System.out.println("please choose a number: \n 1 : Add book \n 2 : Search \n 3 : Update the status\n 4 : Delete \n 5 : EXIT");
            if (inputInfo.hasNextInt()){
                //the output of hasnextint is always a boolean
                chosenNumber = Integer.parseInt(inputInfo.nextLine());
            }
            else{
                System.out.println("Invalid input!");
                inputInfo.nextLine();
                continue;
            }
                //input.next == clears the buffer
            switch (chosenNumber) {
                case 1:
                    System.out.println("you selected number 1 , let's add the book");
                    System.out.println("How many books are you going to add? ");
                    int j;
                    while (true) {
                        try {
                            j = Integer.parseInt(inputInfo.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("invalid input , please add a number");


                        }
                    }
                    for (int i = 0; i < j; i++) {
                        while(true) {
                            try {
                                System.out.println("Enter the book's title: ");
                                String inputTitle = inputInfo.nextLine();
                                System.out.println("Enter the book's author: ");
                                String inputAuthor = inputInfo.nextLine();
                                System.out.println("How many pages does it have? ");
                                Integer inputPage = Integer.valueOf(inputInfo.nextLine());
                                Book book = bookService.add(inputTitle, inputAuthor, inputPage);
                                System.out.println("this book is added with ID number : " + book.getId());
                                break;

                            } catch (IllegalArgumentException e) {
                                System.out.println("error!" + e.getMessage());
                            }

                        }
                    }
                    break;
                case 2:
                    System.out.println("you selected number 2 , let's Search through the books");

                    while(true){
                    try{
                        System.out.println("enter the book you are searching for : ");
                        String givenTitle = inputInfo.nextLine();
                        Book book = bookService.search(givenTitle);
                        System.out.println("this book is : " + book.getTitle() + " written by " + book.getAuthor() + " with " + book.getPage() + " pages the book availability is " + book.isAvailable());
                        break;
                    }catch(NullPointerException e ){
                        System.out.println("error!" + e.getMessage());
                    }
                    }
                    break;

                case 3:
                    System.out.println("you selected number 3 , let's update the book's status");
                    while (true) {
                        Book book1 = null;

                        try {
                            System.out.println("enter the book you're going to update : ");
                            String givenTitle1 = inputInfo.nextLine();
                            book1 = bookService.search(givenTitle1);
                            System.out.println("the book availability is  " + book1.isAvailable() + "if you wanna change it press enter");
                            boolean chosen = inputInfo.nextLine().isEmpty();
                            Book b = bookService.update(givenTitle1, chosen);
                            System.out.println("the book availability is  " + b.isAvailable());
                            break;
                        } catch (NullPointerException e) {
                            System.out.println("error!" + e.getMessage());
                        }
                    }


                    break;
                case 4:
                    System.out.println("you selected number 4, deleting a book!");
                    System.out.println("enter the book's title:");
                    String givenTitle2 = inputInfo.nextLine();
                    System.out.println("Do you want to delete this book? 1.yes 2.no");
                    try {
                        int choice = Integer.parseInt(inputInfo.nextLine());
                        if (choice == 1) {
                            boolean deleted = bookService.delete(givenTitle2);
                            if (deleted) {
                                System.out.println("Book successfully deleted.");
                            } else {
                                System.out.println("Book not found.");
                            }
                        } else {
                            System.out.println("Deletion cancelled.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please enter a valid number.");
                    }

                    break;
                case 5:
                    System.out.println("you selected number 5 , Bye");
                    break;
            }
        } while (chosenNumber != 5);
    }
}
