package Main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Test {
    String dName;

    public String getdName() {
        return dName;
    }
    public Test(String dName){
        this.dName = dName;
    }
    public static void main(String[] args) {
        System.out.println("enter the name class");
        Scanner input = new Scanner(System.in);
        String namem = input.nextLine();
        System.out.println("enter the name");
        String name = input.nextLine();
        Test test = new Test( namem);
        int length = name.length();
        int length1 = test.getdName().length();
        String[] nameArray = new String[length];
        String[] nameArrayd = new String[length1];
        for (int i = 0; i <= length - 1; i++) {
            System.out.println(name.charAt(i));
            nameArray[i] = String.valueOf(name.charAt(i));
        }
        for (int i = 0; i <= length1 - 1; i++) {
            System.out.println(test.getdName().charAt(i));
            nameArrayd[i] = String.valueOf(test.getdName().charAt(i));
        }


        System.out.println(Arrays.toString(nameArray));
        System.out.println(Arrays.toString(nameArrayd));
        if (Objects.equals(nameArray[0], nameArrayd[0] )){
            System.out.println(test.getdName() + "\n" + name);

            if (Objects.equals(nameArray[1], nameArrayd[1] )){
                System.out.println(test.getdName() + "\n" + name);

                if (Objects.equals(nameArray[2], nameArrayd[2] ))
                        System.out.println(test.getdName() + "\n" + name);
        }

        }


    }
}

