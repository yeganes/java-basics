package Main.Library.Service;
import Main.Library.Model.Member;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * سرویس کراد ممبر ها
 */


public class MemberService {

    Member person = null;
    static Scanner inputInfo = new Scanner(System.in);
    public static ArrayList<Member> listPerson = new ArrayList<>();
    static Integer idMember = 0 ;
    public static Integer borrowLimit = 2;
    public static Integer borrowedBooks = 0;


    public Member create(String inputName , int inputAge , String inputPhoneNumber , Member.Gender gender) {


        //validations
        if (inputName == null || inputName.isEmpty() ){
            throw new IllegalArgumentException(" The name can't be empty");
        }
        if (inputAge <= 0) {
            throw new IllegalArgumentException(" Age must be positive");
        }
        if (inputPhoneNumber.length() < 10 || inputPhoneNumber.length() > 11) {
            throw new IllegalArgumentException(" phoneNumber should be at least 10 digits ");
        }
        idMember++;
        person = new Member(inputName, inputAge, inputPhoneNumber, gender, idMember ,borrowLimit ,borrowedBooks);
        listPerson.add(person);
        return  person;
    }

    public  Member readByName(String member){
        Member result = null;
        for (Member m : listPerson){
            if (member.equalsIgnoreCase(m.getName())){
                result = m;
                break ;
            }
        }
        return result;
    }
    public Member readMemberById(Integer id) throws RuntimeException{
        Member result =  null;
        for (Member m : listPerson){
            if (id ==  m.getMemberId()){
                result = m ;
                break;
            }
        }
        return result;
    }


    public Member update(Integer id , String name , String phoneNumber , Integer age ) {
        Member m = readMemberById(id);

        if (m==null){
            return null;
        }

        if (name != null && !name.isEmpty()){
            m.setName(name);
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()){
            m.setPhoneNumber(phoneNumber);
        }

        if (age != null  ){
            m.setAge(age);
        }

        return m;
    }
    public Member delete(int enteredId , int number){
        Member m = readMemberById(enteredId);
        if (m == null){
            return null;
        }
        else {
            int i = listPerson.indexOf(m);
            if (number == 1 ){
                listPerson.remove(i);
            } else if (number == 2 ) {
                return m;
            }
        }
        return person;
    }


}