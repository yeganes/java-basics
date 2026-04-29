package Main.Library.UI;

import Main.Library.Service.LibraryService;
import Main.Library.Model.Member;
import Main.Library.Service.MemberService;

import java.util.Scanner;

import static Main.Library.Service.MemberService.listPerson;

public class MemberMenu {
    static Scanner input = new Scanner(System.in);
LibraryService libraryService  = new LibraryService();
    public  void ask()  {
        MemberService memberService = new MemberService();
        int chosenNumber = 0;
        do {
            System.out.println("please choose a number: \n 1 : Create \n 2 : Read \n 3 : Update\n 4 : Delete \n 5 : Borrow \n 6 : EXIT");
            if (input.hasNextInt()){
                //the output of hasnextint is always a boolean
                chosenNumber = Integer.parseInt(input.nextLine());
            }
            else{
                System.out.println("Invalid input!");
                input.nextLine();
                continue;
                //input.next == clears the buffer
            }
            switch (chosenNumber) {
                case 1:
                    System.out.println("you selected number 1 , let's create the member");
                    memberService.create();
                    break;
                case 2:
                    System.out.println("you selected number 2 , let's read the member");
                    memberService.read();
                    break;
                case 3:
                    System.out.println("you selected number 3 , let's update the member");
                    memberService.update();
                    break;
                case 4:
                    System.out.println("you selected number 4 , let's delete the member");
                    memberService.delete();
                    break;
                case 5:
                    System.out.println("you selected number 5 , let's borrow a book");
                    System.out.println("enter your id number to borrow a book");
                    String givenName = input.nextLine();
                    System.out.println("enter the book you wanna borrow");
                    String givenBook = input.nextLine();
                    libraryService.borrow(givenName , givenBook);
                    break;
                case 6:
                    System.out.println("you selected number 6 , Bye");
                    break;
            }
        } while (chosenNumber != 6);

    }
}
