package Main.Library;

import java.util.Arrays;
import java.util.Scanner;

import static Main.Library.CreateOperation.j;


public class ReadOperation extends Operations{

    @Override
    public void execute(){
        super.execute();
        super.inputInfo =  new Scanner(System.in);
        System.out.println("enter the id number : ");
        long id = inputInfo.nextLong();
        if (id == j) {
            System.out.println("here is your info : ");
            Member[] arrayPerson = new Member[j];
            System.out.println(Arrays.toString(arrayPerson));
        }

    }

}
