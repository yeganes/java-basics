package video_03;
import java.util.Arrays;
import java.util.Scanner;
public class DifferenceArray {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int [] array1 = new int[3];
        int [] array2 = new int[3];

        for(int i  = 0 ; i<3 ; i++ ){
            int j = i + 1;
           System.out.println("give your first array's number element  " +   j + " : ");
           array1[i] = input.nextInt();

        }
        for(int i  = 0 ; i<3 ; i++ ){
            int j = i + 1;
            System.out.println("give your second array's number : " +   j + " : ");
            array2[i] = input.nextInt();
        }

        System.out.println("your first array is : " + Arrays.toString(array1));
        System.out.println("your second array is : " + Arrays.toString(array2));
        for(int i = 0 ; i <3 ; i++ ){
            if (array1[i] == array2[i]) {
                int j = i + 1;
                System.out.println("the elements number " + j +"  are the same");
            }else{
                i++;
                }
        }
        }









    }

