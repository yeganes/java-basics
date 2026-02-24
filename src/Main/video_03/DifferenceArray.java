package Main.video_03;
import java.util.Arrays;
import java.util.Scanner;
public class DifferenceArray {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("How many elements do you want your array1 have ? ");
        int a = input.nextInt();
        System.out.println("How many elements do you want your array2 have ? ");
        int b = input.nextInt();

        int [] array1 = new int[a];
        int [] array2 = new int[b];

        for(int i  = 0 ; i<a ; i++ ){
            int j = i + 1;
           System.out.println("Give your first array's number element  " +   j + " : ");
           array1[i] = input.nextInt();

        }
        for(int i  = 0 ; i<b ; i++ ){
            int j = i + 1;
            System.out.println("Give your second array's number element  " +   j + " : ");
            array2[i] = input.nextInt();
        }

        System.out.println("your first array is : " + Arrays.toString(array1));
        System.out.println("your second array is : " + Arrays.toString(array2));
        int max = Math.max(a, b);
        for(int i = 0 ; i <= max ; i++ ){

            if (array1[i] == array2[i]) {
                int j = i + 1;
                System.out.println("The elements number " + j +"  are the same");
            }if (array1[i] == array2[i+1]){
                int j = i + 1;

                System.out.println("The element  " + array1[i] + "  index " +  j  +" from array1 is the same with array2 element  " + array2[i+1]+ " index " + (j+1) );



            }if (array2[i] == array1[i+1]) {
                int j = i + 1;
                System.out.println("The element  " + array1[i+1] + "  index  "+  (j+1)  +" from array1 is the same with array2 element " + array2[i] +" index " + j) ;



            }
        }
        }









    }

