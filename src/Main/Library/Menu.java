package Main.Library;
import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int clarification;
        do {
            System.out.println("1.member \n2.librarian");
            clarification = Integer.parseInt(input.nextLine());
            if (clarification == 1) {
                MemberMenu.ask();
            } else if (clarification == 2) {
                LibrarianMenu.ask();
            }
        } while (clarification == 1 || clarification == 2 );
    }
}