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
            System.out.println(" please enter your name: ");
            String inputName = inputInfo.nextLine();
            System.out.println(" age: ");
            int inputAge = inputInfo.nextInt();
            System.out.println(" phone number: ");
            long inputPhoneNumber = inputInfo.nextLong();
            String bufferClearer1 = inputInfo.nextLine();
            System.out.println("enter your gender: ");
            String inputGender = inputInfo.next();
            long idMember = i;
            Member person = new Member(inputName, inputAge, inputPhoneNumber, inputGender ,idMember);
            Member[] arrayPerson = new Member[i];
            for (int k = 0 ; k <= i ; k++){
                arrayPerson[k] = person;
            }
            System.out.println(person.getName() + "  " + person.getAge() + " " + person.getPhoneNumber() + " " + person.getGender() + " " + idMember);

        }
    }

    }

