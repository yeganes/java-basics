package Main.Library.Service;
import Main.Library.Model.Member;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * سرویس کراد ممبر ها
 */


public class MemberService {


    /**
     * سرچ کردن با ورودی ایدی
      * @param id ایدی وارد شده
     * @return اطلاعات کاربر
     */
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

    /**
     * سرچ کردن با ورودی اسم
     * @param member اسم کاربر
     * @return اطلاعات کاربر
     */
    public  Member findMemberByName(String member){
        Member result = null;
        for (Member m : listPerson){
            if (member.equalsIgnoreCase(m.getName())){
                result = m;
                break ;
            }
        }
        return result;
    }
    Member person = null;
    static Scanner inputInfo = new Scanner(System.in);
    public static ArrayList<Member> listPerson = new ArrayList<>();
    static Integer idMember = 0 ;
    public static Integer borrowLimit = 2;
    public static Integer borrowedBooks = 0;
    public ArrayList<Member> create() {
        int j = 0;
        while (true) {
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
            int inputAge;
            try {
                inputAge = Integer.parseInt(inputInfo.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! please enter a number");
                return null;
            }

            System.out.println(" phone number: ");
            long inputPhoneNumber = Long.parseLong(inputInfo.nextLine());

            Member.Gender gender = null;
            while (gender == null) {
                System.out.println("Enter gender (male/female): ");
                String inputGender = inputInfo.nextLine().trim().toUpperCase();
                try {
                    gender = Member.Gender.valueOf(inputGender);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid gender, try again!");
                }
            }
            idMember++;
            person = new Member(inputName, inputAge, inputPhoneNumber, gender, idMember ,borrowLimit ,borrowedBooks);

            listPerson.add(person);

            System.out.println("Added! ID: " + person.getMemberId() );
        }
        return listPerson;
    }


    public Member read(){
        System.out.println(" 1. search by name \n 2. search by id");
        int searchBy = Integer.parseInt(inputInfo.nextLine());
        switch(searchBy){
            case 1 :
                System.out.println("enter your name : ");
                String enteredName = inputInfo.nextLine();
                Member n = findMemberByName(enteredName);
                if (n == null){
                    System.out.println("NOT FOUND");
                }else{
                System.out.println(n.getName() + " " + n.getAge() + " " +n.getGender()+ " " + n.getPhoneNumber() + "\n"+ "you can borrow  " + n.getBorrowLimit() + " books" );
                }
                break;
            case 2 :
                Integer enteredId ;
                while(true){
                try {
                    System.out.println("enter the id number : ");
                    enteredId = Integer.parseInt(inputInfo.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                }
                }
                Member m = findMemberById(enteredId);
                if (m == null){
                    System.out.println("NOT FOUND");
                } else {
                    System.out.println(m.getName() + " " + m.getAge() + " " +m.getGender()+ " " + m.getPhoneNumber()+ "\n"+ "you can borrow  " + m.getBorrowLimit() + " books" );
                    }
        }
        return person;
    }
        public Member update(){
        System.out.println("enter the id number : ");
        int enteredId = Integer.parseInt(inputInfo.nextLine());
            Member m = findMemberById(enteredId);
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
            return person;
        }
        public Member delete(){
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
                System.out.println("this member is no longer available ");
            } else if (answer == 2 ) {
                System.out.println("Ok , the member is still available ");
            }
        }
            return person;
    }


}



