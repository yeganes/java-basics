package Main.Library;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateOperation extends Operation {
    public static int idMember;
    public static int j;
    private static ArrayList<Member> membersList = new ArrayList<>();
    public static ArrayList<Member> getMembersList() {
        return membersList;
    }
    public static void setMembersList(ArrayList<Member> membersList) {
        CreateOperation.membersList = membersList;
    }
    @Override
    public void execute() {

        super.inputInfo = new Scanner(System.in);
        System.out.println("How many people are going to sign-up: ");
        j = inputInfo.nextInt();
        String bufferClearer = inputInfo.nextLine();
        for (int i = 0 ; i< j ; i ++) {
            System.out.println(" please enter your name: ");
            String inputName = inputInfo.nextLine();
            System.out.println(" age: ");
            int inputAge = inputInfo.nextInt();
            inputInfo.nextLine();
            System.out.println(" phone number: ");
            long inputPhoneNumber = inputInfo.nextLong();
            String bufferClearer1 = inputInfo.nextLine();
            System.out.println("enter your gender: ");
            String inputGender = inputInfo.next();
            idMember = j;
            Member person = new Member(inputName, inputAge, inputPhoneNumber, inputGender ,idMember);
            membersList.add(person);

                System.out.println(person.getName() + "  " + person.getAge() + " " + person.getPhoneNumber() + " " + person.getGender() + " " + idMember);
            }

        }
    }



