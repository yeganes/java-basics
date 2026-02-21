package video_03;
// برای رشته های 3 عددی و یا 5 عددی چک میکند کهمیتوانند ریورس باشند یا نه
import java.util.Scanner;
public class StringReverse {



    public static void main(String[] args){
        System.out.println("please write down string to check if it could be reversed or not: ");
        Scanner input = new Scanner(System.in);
        String f = input.nextLine();
        if (f.length() == 5){
            reverse5(f);}
        else{
            reverse3(f);
        }




    }
    static void reverse3(String string){
        int first = string.charAt(0);
        int second = string.charAt(1);
        int last = string.charAt(2);
        if (first == last){
            System.out.println(string);
        }
        else {
            System.out.println("this is not reversed");
        }
    }
    static void reverse5(String string){
        int first = string.charAt(0);
        int second = string.charAt(1);
        int third = string.charAt(2);
        int fourth = string.charAt(3);
        int last = string.charAt(4);
        if (first == last && second == fourth) {
            System.out.println(string);
        }
        else {
            System.out.println("this is not reversed");
        }

    }





    }

