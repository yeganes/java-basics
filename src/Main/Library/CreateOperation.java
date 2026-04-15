package Main.Library;
import java.util.Arrays;
import java.util.Scanner;

public class CreateOperation extends Operations {
    @Override
    public void execute() {
        super.execute();
        Scanner inputInfo = new Scanner(System.in);
        System.out.println("How many people are going to sign-up: ");
        int j = inputInfo.nextInt();
        String bufferClearer = inputInfo.nextLine();
        for (int i = 1 ; i<= j ; i ++) {
            System.out.println("Hello please enter your name: ");
            String inputName = inputInfo.nextLine();
            System.out.println("enter your age: ");
            int inputAge = inputInfo.nextInt();
            System.out.println("enter your phone number: ");
            long inputPhoneNumber = inputInfo.nextLong();
            String bufferClearer1 = inputInfo.nextLine();
            System.out.println("enter your gender: ");
            String inputGender = inputInfo.nextLine();
            long idMember = i;
            Members person = new Members(inputName, inputAge, inputPhoneNumber, inputGender ,idMember);
            String[] arrayPerson1 = new String[5];
            arrayPerson1[0] = person.getName();
            arrayPerson1[1] = String.valueOf(person.getAge());
            arrayPerson1[2] = String.valueOf(person.getPhoneNumber());
            arrayPerson1[3] = person.getGender();
            arrayPerson1[4] = String.valueOf(person.getMemberId());
            System.out.println(person.getName() + "  " + person.getAge() + " " + person.getPhoneNumber() + " " + person.getGender() + " " + idMember);
            System.out.println(Arrays.toString(arrayPerson1));


        }
    }

    }

