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
        Operations r = new ReadOperation();
        Operations u = new UpdateOperation();
        Operations d = new DeleteOperation();

        Scanner input = new Scanner(System.in);

            System.out.println("please choose a number: \n 1 : Create \n 2 : Read \n 3 : Update\n 4 : Delete");
            int chosenNumber = input.nextInt();
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
                case 4 :
                    System.out.println("you selected number 4 , let's delete the members");
                    d.execute();
                    break;



            }




    }

    public static void main(String[] args){
        ask();

    }
}


