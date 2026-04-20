package Main.Library;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Service {

    static Scanner inputInfo = new Scanner(System.in);
    public static ArrayList<Member> listPerson = new ArrayList<>();
    static int idMember ;
    public void create(){
        System.out.println("How many people are going to sign-up: ");
        int j = Integer.parseInt(inputInfo.nextLine());

        for (int i = 0 ; i< j ; i ++) {

            System.out.println(" please enter your name: ");
            String inputName = inputInfo.nextLine();

            System.out.println(" age: ");
            int inputAge = Integer.parseInt(inputInfo.nextLine());

            System.out.println(" phone number: ");
            long inputPhoneNumber = Long.parseLong(inputInfo.nextLine());

            System.out.println("enter your gender: ");
            String inputGender = inputInfo.nextLine();

            Member person = new Member(inputName, inputAge, inputPhoneNumber, inputGender ,idMember);
            listPerson.add(person);
            idMember++;
            System.out.println(listPerson);
            System.out.println("Added! ID: " + idMember);
                }
                    }
    public void read(){
        Member person = new Member(idMember);
        System.out.println("enter the id number : ");
        int enteredId = inputInfo.nextInt();

        Member m = listPerson.get(enteredId-1);

            System.out.println(m.getName()  + " " + m.getAge() + " " + m.getGender() + " " + m.getPhoneNumber());


    }
        public void update(){}
        public void delete(){}
}


