package Main.Library;
import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int clarification = 0;
        do {
            System.out.println("1.member \n2.librarian");
            if (input.hasNextInt()){
                clarification = Integer.parseInt(input.nextLine());
            }
            else{
                System.out.println("invalid input ! please enter a number");
                input.next();
            }
            switch (clarification) {
                case 1 :
                MemberMenu.ask();
                case 2  :
                LibrarianMenu.ask();
            }
        } while (true);
    }
}