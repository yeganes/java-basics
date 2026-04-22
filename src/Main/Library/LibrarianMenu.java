package Main.Library;
import java.util.Scanner;
public class LibrarianMenu {

    public static void ask() {
        LibrarianService librarianService = new LibrarianService();
        Scanner input = new Scanner(System.in);
        int chosenNumber;
        do {
            System.out.println("please choose a number: \n 1 : Add book \n 2 : Search \n 3 : Update the price \n 4 : Delete \n 5 : EXIT");
            chosenNumber = input.nextInt();
            switch (chosenNumber) {
                case 1:
                    System.out.println("you selected number 1 , let's add the book");
                    librarianService.add();
                    break;
                case 2:
                    System.out.println("you selected number 2 , let's Search through the books");
                    librarianService.search();
                    break;
                case 3:
                    System.out.println("you selected number 3 , let's update the book's price");
                    librarianService.update();
                    break;
                case 4:
                    System.out.println("you selected number 4 , deleting a book ! ");
                    librarianService.delete();
                    break;
                case 5:
                    System.out.println("you selected number 5 , Bye");
                    break;
            }
        } while (chosenNumber == 1 || chosenNumber == 2 || chosenNumber == 3 || chosenNumber == 4);
    }
}
