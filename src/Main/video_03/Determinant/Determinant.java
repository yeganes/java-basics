package Main.video_03.Determinant;
import java.util.Arrays;
import java.util.Scanner;
public class Determinant {

        public static void Loop(){
            int [][] matrix = new int[2][2];
            Scanner inputMatrix = new Scanner(System.in);
            for (int i = 0 ; i < matrix.length ; i++ ){
                int a = i +1 ;
                for (int j = 0 ; j < matrix.length ; j++) {
                    int b = j + 1;
                    System.out.println("write the array's  element number " + a + " " + b);
                    matrix[i][j] = inputMatrix.nextInt();
                }
            }
            System.out.println(Arrays.deepToString(matrix));
               int i =  matrix[0][0] * matrix[1][1];
                int j = matrix[1][0] * matrix[0][1];
                int sum = i - j;
            System.out.println("the determinant of this matrix is " + sum);





        }






    }

