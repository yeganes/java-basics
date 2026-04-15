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
    public static void ask(){
        Operations c = new CreateOperation();
        Scanner input = new Scanner(System.in);
        System.out.println("please choose a number: \n 1 : Create \n 2 : Read \n 3 : Update\n 4 : Delete");
         int chosenNumber = input.nextInt();
         switch (chosenNumber) {
             case 1:
                 System.out.println("you selected number 1 , let's create the members");
                 c.execute();
         }

    }

    public static void main(String[] args){
        ask();

    }
}


