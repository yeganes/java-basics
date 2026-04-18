package Main.Library;

import java.util.Arrays;
import java.util.Scanner;

import static Main.Library.CreateOperation.idMember;
import static Main.Library.CreateOperation.j;


public class ReadOperation extends Operation{

    @Override
    public void execute(){
        super.inputInfo =  new Scanner(System.in);
        System.out.println("enter the id number : ");
        long id = inputInfo.nextLong();
        if (id == idMember) {
            System.out.println("here is your info : ");
            System.out.println(Arrays.toString(arrayPerson));
        }

    }

}
