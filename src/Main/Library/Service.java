package Main.Library;
import java.util.ArrayList;
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
            System.out.println("Added! ID: " + idMember);
                }
                    }
    public void read(){
        System.out.println("enter the id number : ");
        int enteredId = Integer.parseInt(inputInfo.nextLine());
        enteredId = enteredId - 1 ;
        Member m = listPerson.get(enteredId);
        System.out.println("here is your information : ");
            System.out.println(m.getName()  + " " + m.getAge() + " " + m.getGender() + " " + m.getPhoneNumber());


    }
        public void update(){
        System.out.println("enter the id number : ");
        int enteredId = Integer.parseInt(inputInfo.nextLine());
        enteredId = enteredId - 1 ;
        Member m = listPerson.get(enteredId);
        System.out.println("here is your information : ");
        System.out.println(m.getName()  + " " + m.getAge() + " " + m.getPhoneNumber());
        System.out.println("which one does need changing ? \n 1. Name \n 2. age \n 3. phone number ");
        int inputChanged = Integer.parseInt(inputInfo.nextLine());
            switch (inputChanged) {
                case 1 :
                    System.out.println("you selected number 1 , enter the alternative name : ");
                    String alternativeName  = inputInfo.nextLine();
                    System.out.println(m.setName(alternativeName));
                    break;
                case 2 :
                    System.out.println("you selected number 2 , enter the alternative age : ");
                    int alternativeAge  = Integer.parseInt(inputInfo.nextLine());
                    System.out.println(m.setAge(alternativeAge));
                    break;
                case 3 :
                    System.out.println("you selected number 3 , enter the alternative phone number : ");
                    long alternativePhoneNumber  = Long.parseLong(inputInfo.nextLine());
                    System.out.println(m.setPhoneNumber(alternativePhoneNumber));
                    break;

            }

        }
        public void delete(){
            System.out.println("enter the id number : ");
            int enteredId = Integer.parseInt(inputInfo.nextLine());
            enteredId = enteredId - 1 ;
            Member m = listPerson.get(enteredId);
            System.out.println("here is your information : ");
            System.out.println(m.getName()  + " " + m.getAge() + " " + m.getPhoneNumber());
            System.out.println("Do you wanna delete the account : \n 1.Yes \n 2. No ");
            int answer = Integer.parseInt(inputInfo.nextLine());
            if (answer == 1 ){
                listPerson.remove(enteredId);
                System.out.println("the member is no longer available ");
            } else if (answer == 2 ) {
                System.out.println("Ok , the member is still available ");
            }
        }

        }



