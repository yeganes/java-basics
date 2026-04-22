package Main.Library;
import java.util.ArrayList;
import java.util.Scanner;


public class MemberService {

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
            idMember++;
            Member person = new Member(inputName, inputAge, inputPhoneNumber, inputGender ,idMember);
            listPerson.add(person);
            System.out.println("Added! ID: " + idMember);
                }
                    }
    public Member findMemberById(int id){
        Member result =  null;
        for (Member m : listPerson){
            if (id ==  m.getMemberId()){
                result = m ;
                break;
            }
        }
        return result;
    }
    public void read(){
        if (listPerson.isEmpty()) {
            System.out.println("list is empty");
        }
        System.out.println("enter the id number : ");
        int enteredId = Integer.parseInt(inputInfo.nextLine());
        Member m = findMemberById(enteredId);
        if (m == null){
            System.out.println("NOT FOUND");
        } else {
            System.out.println(m.getName());
        }
    }
        public void update(){
        System.out.println("enter the id number : ");
        int enteredId = Integer.parseInt(inputInfo.nextLine());
            Member m = findMemberById(enteredId);
            if (m == null){
                System.out.println("NOT FOUND");
            } else {
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
        }
        public void delete(){
            System.out.println("enter the id number : ");
            int enteredId = Integer.parseInt(inputInfo.nextLine());
            Member m = findMemberById(enteredId);
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
                System.out.println("the member with " + enteredId+1 + "is no longer available ");
            } else if (answer == 2 ) {
                System.out.println("Ok , the member is still available ");
            }
        }
    }

        }



