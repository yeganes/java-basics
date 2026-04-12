package Main.video_07.MiceSchool;
import java.util.Arrays;
import java.util.Scanner;
public class Course{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] arrayStudent = new String[5];
        for (int i = 0; i <= 4; i++) {
            System.out.println("Hello please enter your name: ");
            String inputName = input.nextLine();
            Student student = new Student(inputName);
            arrayStudent[i] = student.getFirstName();

            String[] filledStudents = Arrays.copyOf(arrayStudent, i+1);
            System.out.println("Students so far: " + Arrays.toString(filledStudents));
        }
        input.close();
    }
}