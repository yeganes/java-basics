package Main.Library.UI;

import Main.Library.Exceptions.MemberNotFoundException;
import Main.Library.Repository.MemberRepo;
import Main.Library.Service.LibraryService;
import Main.Library.Model.Member;
import Main.Library.Exceptions.LimitBorrowedException;
import Main.Library.Service.MemberService;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberMenu {
    MemberService memberService = new MemberService();
    MemberRepo memberRepo = new MemberRepo();
    static Scanner input = new Scanner(System.in);
    LibraryService libraryService = new LibraryService();
    public MemberMenu() {
    }
    public void ask() throws LimitBorrowedException, MemberNotFoundException {


        int chosenNumber = 0;
        do {
            System.out.println("please choose a number: \n 1 : Create \n 2 : Read \n 3 : Update\n 4 : Delete \n 5 : Borrow \n 6 : EXIT");
            if (input.hasNextInt()) {
                //the output of hasnextint is always a boolean
                chosenNumber = Integer.parseInt(input.nextLine());
            } else {
                System.out.println("Invalid input!");
                input.nextLine();
                continue;
                //input.next == clears the buffer
            }
            switch (chosenNumber) {
                case 1:
                    System.out.println("you selected number 1 , let's create the member");
                    int j;
                    while (true) {
                        try {
                            System.out.println("How many people are going to sign-up: ");
                            j = Integer.parseInt(input.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                        }
                    }
                    for (int i = 0; i < j; i++) {
                        while (true){
                            try{
                                System.out.println(" please enter your name: ");
                                String inputName = input.nextLine();
                                if (inputName.trim().isEmpty()){
                                    return;
                                }


                                System.out.println(" age: ");
                                int inputAge = 0;
                                try {
                                    inputAge = Integer.parseInt(input.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input! please enter a number");
                                }


                                System.out.println(" phone number: ");
                                String inputPhoneNumber = input.nextLine();

                                Member.Gender gender = null;

                                while (gender == null) {

                                    System.out.println("Enter gender (male/female): ");
                                    String inputGender = input.nextLine().trim().toUpperCase();
                                    try {
                                        gender = Member.Gender.valueOf(inputGender);
                                        break;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid gender, try again!");
                                    }

                                }
                                Member person = memberService.create(inputName, inputAge, inputPhoneNumber, gender);
                                System.out.println("Added!  ");
                            }catch(IllegalArgumentException e){
                                System.out.println("error !" + e.getMessage());

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        }

                    }
                    break;
                case 2:
                    System.out.println("you selected number 2 , let's read the member");
                    System.out.println(" 1. search by name \n 2. search by id \n 3. read all the members");
                    int searchBy = Integer.parseInt(input.nextLine());
                    switch(searchBy){
                        case 1 :
                            while(true){
                                try{
                                    System.out.println("enter your name : ");
                                    String enteredName = input.nextLine();
                                    Member n = memberService.readByName(enteredName);
                                    String msg = MessageFormat.format("name : {0} \n age : {1} years old \n gender : {2} \n phone number : {3} \n you can borrrow  : {4} books ",
                                            n.getName(),
                                            n.getAge(),
                                            n.getGender(),
                                            n.getPhoneNumber(),
                                            n.getBorrowLimit());
                                    System.out.println(msg);
                                    break;
                                }catch(NullPointerException e){
                                    System.out.println("error ! " + e.getMessage());
                                }
                            }
                            break;
                        case 2 :
                            while (true){
                                try {
                                    System.out.println("enter the id number : ");
                                    Integer enteredId = Integer.valueOf(input.nextLine());
                                    Member m = memberService.readMemberById(enteredId);
                                    String msg = MessageFormat.format(" name : {0} \n age : {1} years old \n gender : {2} \n phone number : {3} \n you can borrrow  : {4} books ",
                                            m.getName(),
                                            m.getAge(),
                                            m.getGender(),
                                            m.getPhoneNumber(),
                                            m.getBorrowLimit());
                                    System.out.println(msg);
                                    break;
                                }catch(NullPointerException | NumberFormatException e){
                                    System.out.println("error !" + e.getMessage());
                                }
                            }
                            break;
                        case 3 :
                            ArrayList<Member> a =  memberRepo.select();
                            for (Member m  : a){
                            System.out.println(m);
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("you selected number 3 , let's update the member");

                    System.out.println("enter the id number : ");
                    int enteredId = Integer.parseInt(input.nextLine());
                    Member m = memberService.readMemberById(enteredId);

                    System.out.println(m.getName());
                    String name = input.nextLine();

                    System.out.println(m.getPhoneNumber());
                    String phoneNumber = input.nextLine();

                    System.out.println(m.getAge());
                    Integer age = Integer.parseInt(input.nextLine());


                    memberService.update(enteredId , name , phoneNumber , age);


                    break;
                case 4:
                    System.out.println("you selected number 4 , let's delete the member");
                    while(true){
                    try {
                        System.out.println("enter the id number : ");
                        int enteredId1 = Integer.parseInt(input.nextLine());

                        Member n = memberService.readMemberById(enteredId1);

                        String msg = MessageFormat.format(" name : {0} \n age : {1} years old  \n phone number : {2} ",
                                n.getName(),
                                n.getAge(),
                                n.getPhoneNumber());
                        System.out.println(msg);
                        System.out.println("Do you wanna delete the account : \n 1.Yes \n 2. No ");
                        int number = Integer.parseInt(input.nextLine());
                        memberService.delete(enteredId1 , number);
                        System.out.println("this member is deleted");
                        break;
                    }catch(NullPointerException | NumberFormatException e) {
                        System.out.println("error !" + e.getMessage());
                    } catch (MemberNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    }
                    break;
                case 5:
                    System.out.println("you selected number 5 , let's borrow a book");
                    System.out.println("enter your id number to borrow a book");
                    int givenId = Integer.parseInt(input.nextLine());
                    System.out.println("enter the book you wanna borrow");
                    String givenBook = input.nextLine();
                    try{
                        libraryService.borrow(givenId, givenBook);
                        System.out.println("the book is borrowed");

                    }catch (LimitBorrowedException l){
                        System.out.println("error" + l.getMessage());
                    }

                    break;
                case 6:
                    System.out.println("you selected number 6 , Bye");
                    break;
            }
        }while (chosenNumber != 6) ;
    }
}