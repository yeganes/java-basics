package Main.Library.Service;
import Main.Library.Exceptions.MemberNotFoundException;
import Main.Library.Model.Member;
import Main.Library.Repository.MemberRepo;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * سرویس کراد ممبر ها
 */


public class MemberService {
    MemberRepo memberRepo = new MemberRepo();
    Member person = null;
    public static ArrayList<Member> listPerson = new ArrayList<>();
    public static Integer borrowLimit = 2;
    public static Integer borrowedBooks = 0;

    public Member create(String inputName , int inputAge , String inputPhoneNumber , Member.Gender gender) throws IOException {

        //validations
        if (inputName == null || inputName.isEmpty() ){
            throw new IllegalArgumentException(" The name can't be empty");
        }
        if (inputAge <= 0) {
            throw new IllegalArgumentException(" Age must be positive");
        }
        int id = 0 ;
        id ++;

        person = new Member(id , inputName, inputAge, inputPhoneNumber, gender,borrowLimit );

        listPerson.add(person);

        memberRepo.insert(inputName, inputAge, inputPhoneNumber, gender,borrowLimit ,borrowedBooks);

        return  person;
    }

    public  Member readByName(String member){
        ArrayList<Member> a = memberRepo.select();
        Member result = null;
        for (Member m : a){
            if (member.equalsIgnoreCase(m.getName())){
                result = m;
                break ;
            }
        }
        return result;
    }
    public Member readMemberById(Integer id) throws RuntimeException , MemberNotFoundException {

        ArrayList<Member> a = memberRepo.select();
        Member result = null;
        for (Member m : a) {
            if (id == m.getMemberId()) {
                result = m;
                break;
            }
        }
        return result;


    }


    public Member update(Integer id , String name , String phoneNumber , Integer age ) throws MemberNotFoundException {
        Member m = readMemberById(id);

        if (m==null){
            return null;
        }

        if (name != null && !name.isEmpty()){
            m.setName(name);
            memberRepo.updateName(id , name);
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()){
            m.setPhoneNumber(phoneNumber);
            memberRepo.updatePhoneNumber(id , phoneNumber);
        }

        if (age != null  ){
            m.setAge(age);
            memberRepo.updateAge(id , age);
        }
        return m;
    }
    public Member delete(int enteredId , int number) throws MemberNotFoundException {

        Member m = readMemberById(enteredId);
        if (m == null){
            return null;
        }
        else {
            if (number == 1 ){
                memberRepo.delete(enteredId);
            } else if (number == 2 ) {
                return m;
            }
        }
        return person;
    }


}