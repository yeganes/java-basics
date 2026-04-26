package Main.Library;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class MemberService {

    static Scanner inputInfo = new Scanner(System.in);
    public static ArrayList<Member> listPerson = new ArrayList<>();
    static int idMember ;
    public void create()  {

        int j = 0;
        while(true) {
            System.out.println("How many people are going to sign-up: ");
            String input = inputInfo.nextLine();
            try {
                j = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        for (int i = 0; i < j; i++) {

            System.out.println(" please enter your name: ");
            String inputName = inputInfo.nextLine();

            System.out.println(" age: ");
            int inputAge = Integer.parseInt(inputInfo.nextLine());

            System.out.println(" phone number: ");
            long inputPhoneNumber = Long.parseLong(inputInfo.nextLine());

            System.out.println("enter your gender: ");
            String inputGender = inputInfo.nextLine();
            idMember++;
            Member person = new Member(inputName, inputAge, inputPhoneNumber, inputGender, idMember);
            listPerson.add(person);
            System.out.println("Added! ID: " + idMember);
        }
    }


    public void read(){
        System.out.println(" 1. search by name \n 2. search by id");
        int searchBy = Integer.parseInt(inputInfo.nextLine());
        switch(searchBy){
            case 1 :
                System.out.println("enter your name : ");
                String enteredName = inputInfo.nextLine();
                Member n = Search.findMemberByName(enteredName);
                if (n == null){
                    System.out.println("NOT FOUND");
                }else{
                System.out.println(n.getName() + " " + n.getAge() + " " +n.getGender()+ " " + n.getPhoneNumber());
                }
                break;
            case 2 :
                System.out.println("enter the id number : ");
                int enteredId = Integer.parseInt(inputInfo.nextLine());
                Member m = Search.findMemberById(enteredId);
                if (m == null){
                    System.out.println("NOT FOUND");
                } else {
                    System.out.println(m.getName() + " " + m.getAge() + " " +m.getGender()+ " " + m.getPhoneNumber());
                    }
        }
    }
        public void update(){
        System.out.println("enter the id number : ");
        int enteredId = Integer.parseInt(inputInfo.nextLine());
            Member m = Search.findMemberById(enteredId);
            if (m == null){
                System.out.println("NOT FOUND");
            } else {
                System.out.println("here is your information : ");
                System.out.println(m.getName());
                System.out.println(":");
                String alternativeName = inputInfo.nextLine();
                boolean spaceEnter = alternativeName.isEmpty();
                if (spaceEnter){
                    // intentionally left blank
                }
                else{
                    System.out.println(m.setName(alternativeName));
                }
                System.out.println(m.getPhoneNumber());
                System.out.println(": ");
                String alternativePhoneNumber  = inputInfo.nextLine();
                boolean spaceEnter1 = alternativePhoneNumber.isEmpty();

                if (spaceEnter1){
                    // intentionally left blank
                }
                else{
                    System.out.println(m.setPhoneNumber(Long.parseLong(alternativePhoneNumber)));
                }
                System.out.println(m.getAge());
                System.out.println(": ");
                String alternativeAge  = inputInfo.nextLine();
                boolean spaceEnter2 = alternativeAge.isEmpty();
                if (spaceEnter2){
                    // intentionally left blank
                }
                else{
                    System.out.println(m.setAge(Integer.parseInt(alternativeAge)));
                }
            }
        }
        public void delete(){
            System.out.println("enter the id number : ");
            int enteredId = Integer.parseInt(inputInfo.nextLine());
            Member m = Search.findMemberById(enteredId);
            if (m == null){
                System.out.println("NOT FOUND");
            } else {
            System.out.println("here is your information : ");
            System.out.println(m.getName()  + " " + m.getAge() + " " + m.getPhoneNumber());
            System.out.println("Do you wanna delete the account : \n 1.Yes \n 2. No ");
            int answer = Integer.parseInt(inputInfo.nextLine());
                int i = listPerson.indexOf(m);
                if (answer == 1 ){
                listPerson.remove(i);
                System.out.println("this member with is no longer available ");
            } else if (answer == 2 ) {
                System.out.println("Ok , the member is still available ");
            }
        }
    }

        }



