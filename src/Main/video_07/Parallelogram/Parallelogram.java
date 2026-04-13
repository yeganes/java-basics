package Main.video_07.Parallelogram;

import java.util.Scanner;

public class Parallelogram {
    static boolean flag = true;
    static private Integer breadth;
    static private Integer height;

    public static void setBreadth(Integer breadth) {
        Parallelogram.breadth = breadth;
    }

    public static int getBreadth() {
        return breadth;
    }

    public static void setHeight(Integer height) {
        Parallelogram.height = height;
    }
    public static int getHeight(){
        return height;
    }
    Parallelogram(Integer breadth, Integer height){
        Parallelogram.breadth = breadth;
        Parallelogram.height = height;

    }
    static{
     Scanner input = new Scanner(System.in);
     System.out.println("Hello please enter the Height ");
     Integer inputHeight = input.nextInt();
     System.out.println("enter the Breadth ");
     Integer inputBreadth = input.nextInt();
     breadth = inputBreadth;
     height = inputHeight;

     if (inputHeight <= 0 || inputBreadth <= 0){
         System.out.println("Invalid");
         flag = false;
            }
        else {
            System.out.println("Valid inputs");
     }
        input.close();

        }

    public static void main(String[] args) {
        if (flag) {
            Integer area = breadth * height;
            System.out.print(area);
        }
    }
}