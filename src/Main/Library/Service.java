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
        System.out.println("here is your information : ");
            System.out.println(m.getName()  + " " + m.getAge() + " " + m.getGender() + " " + m.getPhoneNumber());


    }
        public void update(){
        System.out.println("enter the id number : ");
        int enteredId = Integer.parseInt(inputInfo.nextLine());
        Member m = listPerson.get(enteredId-1);
        System.out.println("here is your information : ");
        System.out.println(m.getName()  + " " + m.getAge() + " " + m.getPhoneNumber());
        System.out.println("which one does need changing ? \n 1. Name \n 2. age \n 3. phone number ");
        int inputChanged = Integer.parseInt(inputInfo.nextLine());
            switch (inputChanged) {
                case 1 :
                    System.out.println("you selected number 1 , enter the alternative one : ");
                    String alternativeName  = inputInfo.nextLine();
                    System.out.println(m.setName(alternativeName));
                case 2 :
                    System.out.println("you selected number 2 , enter the alternative one : ");
                    int alternativeAge  = Integer.parseInt(inputInfo.nextLine());
                    System.out.println(m.setAge(alternativeAge));
                case 3 :
                    System.out.println("you selected number 3 , enter the alternative one : ");
                    int alternativePhonenumber  = Integer.parseInt(inputInfo.nextLine());
                    System.out.println(m.setAge(alternativePhonenumber));
            }

        }
        public void delete(){
            System.out.println("enter the id number : ");
            int enteredId = Integer.parseInt(inputInfo.nextLine());
            Member m = listPerson.get(enteredId-1);
            System.out.println("here is your information : ");
            System.out.println(m.getName()  + " " + m.getAge() + " " + m.getPhoneNumber());
            System.out.println("Do you wanna delete the account : \n 1.Yes \n 2. No ");
            int answer = Integer.parseInt(inputInfo.nextLine());
            if (answer == 1 ){
                Member d = listPerson.remove(enteredId-1);
                System.out.println("the member is no longer available ");
            } else if (answer == 2 ) {
                System.out.println("Ok , the member is still available ");
            }
        }

        }



