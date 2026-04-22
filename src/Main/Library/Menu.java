package Main.Library;
import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        System.out.println("1.member \n2.librarian");
        int clarification = Integer.parseInt(input.nextLine());
        if (clarification == 1){
            MemberMenu.ask();
        }
        else if (clarification == 2){
            LibrarianMenu.ask();
        }
    }
}