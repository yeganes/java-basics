package Main.video_07.BirdsCage;

import java.util.Arrays;
import java.util.Scanner;

public class CageCopier {
    public static void copy(Cage c  , Cage c2){
        c.setName(c2.getName());
        c.setId(c2.getId());
        c.setBirds(c2.getBirds());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            for (int i = 0 ; i < 2 ; i ++) {
                System.out.println("enter the birds name");
                String inputBirdName1 = input.nextLine();
                String[] arrBird = new String[2];
                Bird birds = new Bird(inputBirdName1);
                arrBird[i] = birds.getName();




                Cage cage1 = new Cage(123, "Cage C1", arrBird);
                Cage cage2 = new Cage(321, "Cage C2", arrBird);
                CageCopier.copy(cage1 , cage2);
                //cage2 = cage1 ;
                //here it is copying it , but it's shallow copying
                System.out.println(cage1.getId());
                System.out.println(cage1.getName());
                System.out.println(Arrays.toString((arrBird)));
                System.out.println(cage2.getId());
                System.out.println(cage2.getName());
                System.out.println(Arrays.toString(arrBird));
            }

        }
    }
