package Main.Library;
import java.util.Scanner;

public class Menu {
    private int number;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Menu(int number ){
        this.number = number;
    }
    public static void ask() {
        Operation c = new CreateOperation();
        Operation r = new ReadOperation();
        Operation u = new UpdateOperation();
        Operation d = new DeleteOperation();

        Scanner input = new Scanner(System.in);
        int chosenNumber;
        do {
            System.out.println("please choose a number: \n 1 : Create \n 2 : Read \n 3 : Update\n 4 : Delete \n 5 : EXIT");
            chosenNumber = input.nextInt();
            switch (chosenNumber) {
                case 1:
                    System.out.println("you selected number 1 , let's create the members");
                    c.execute();
                    break;
                case 2:
                    System.out.println("you selected number 2 , let's read the members");
                    r.execute();
                    break;
                case 3:
                    System.out.println("you selected number 3 , let's update the members");
                    u.execute();
                    break;
                case 4:
                    System.out.println("you selected number 4 , let's delete the members");
                    d.execute();
                    break;
                case 5:
                    System.out.println("you selected number 5 , Bye");
                    break;
            }
        } while (chosenNumber == 1 ||chosenNumber == 2 || chosenNumber == 3 || chosenNumber == 4);
        //اگر همون اول بخواد خارج شه از برنامه نمیتونه
    }

    public static void main(String[] args){
        ask();

    }
}


