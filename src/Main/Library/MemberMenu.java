package Main.Library;

import java.util.Scanner;

public class MemberMenu {
    static Scanner input = new Scanner(System.in);
    public static void ask() {
        Service service = new Service();

        int chosenNumber;
        do {
            System.out.println("please choose a number: \n 1 : Create \n 2 : Read \n 3 : Update\n 4 : Delete \n 5 : EXIT");
            chosenNumber = input.nextInt();
            switch (chosenNumber) {
                case 1:
                    System.out.println("you selected number 1 , let's create the member");
                    service.create();
                    break;
                case 2:
                    System.out.println("you selected number 2 , let's read the member");
                    service.read();
                    break;
                case 3:
                    System.out.println("you selected number 3 , let's update the member");
                    service.update();
                    break;
                case 4:
                    System.out.println("you selected number 4 , let's delete the member");
                    service.delete();
                    break;
                case 5:
                    System.out.println("you selected number 5 , Bye");
                    break;
            }
        } while (chosenNumber == 1 ||chosenNumber == 2 || chosenNumber == 3 || chosenNumber == 4);
    }
}
