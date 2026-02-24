package video_03;
import java.util.Arrays;
import java.util.Scanner;
public class SortingIntegers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int [] array = new int[3];
        int [] array_alternative = new int[3];
        System.out.println("enter the unsorted integer limit : 6 ");
        for (int i = 0 ; i < array.length ; i++){
            int j = i + 1;
            System.out.println("number " + j + ":");
            array[i] = input.nextInt();

        }
        for (int i = 0 ; i < 3 ; i++){
            if (array[i] < array[i+1]){
                array_alternative[i] = array[i];
            }
            else if (array[i] < array[i+2]) {
                array_alternative[i] = array[i];
            }else if (array[i+1] < array[i+2]);
            {
                array_alternative[i + 1] = array[i + 1];
            }



        System.out.print(Arrays.toString(array_alternative));

        }
        }
        





    }

