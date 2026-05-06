package Main.Library.Service;
import Main.Library.Model.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * سرویس کراد ممبر ها
 */


public class MemberService {

    Member person = null;
    static Scanner inputInfo = new Scanner(System.in);
    public static ArrayList<Member> listPerson = new ArrayList<>();
    public static Integer borrowLimit = 2;
    public static Integer borrowedBooks = 0;

    public int getMaxId() {
        int max = 0;
        //متغیر ماکسیمم داریم
        for (Member m : listPerson) {
            if (m.getMemberId() > max) {
                max = m.getMemberId();
            }
        }
        return max;
    }
    public void save(Member person){
        try{
            FileWriter writer = new FileWriter("Member.txt" , true);
            writer.write(
                    person.getMemberId() + "|" +
                            person.getName() + "|" +
                            person.getAge() + "|" +
                            person.getPhoneNumber() + "|" +
                            person.getGender() + "|" +
                            person.getBorrowLimit() + "|" +
                            person.getBorrowedBooksNum() + "\n"
            );            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void update (){
        try{
            FileWriter writer = new FileWriter("Member.txt");
            for (Member person : listPerson){
            writer.write(
                    person.getMemberId() + "|" +
                            person.getName() + "|" +
                            person.getAge() + "|" +
                            person.getPhoneNumber() + "|" +
                            person.getGender() + "|" +
                            person.getBorrowLimit() + "|" +
                            person.getBorrowedBooksNum() + "\n"
            );} writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> readFromFile(String path ) {
        listPerson.clear();
        //یکبار لیست پاک میکنیم
        Member m = null;
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                Integer idMember1 = Integer.valueOf(parts[0]);
                String name = parts[1];
                Integer age = Integer.valueOf(parts[2]);
                String phoneNumber = parts[3];
                Member.Gender gender = Member.Gender.valueOf(parts[4]);
                Integer borrowLimit = Integer.valueOf(parts[5]);
                Integer borrowedBooks = Integer.parseInt(parts[6]);
                m = new Member(idMember1 ,name, age, phoneNumber, gender, borrowLimit, borrowedBooks);

                listPerson.add(m);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listPerson;
    }
    public Member create(String inputName , int inputAge , String inputPhoneNumber , Member.Gender gender) throws IOException {

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
        int newId = getMaxId() + 1;

        person = new Member(newId , inputName, inputAge, inputPhoneNumber, gender,borrowLimit ,borrowedBooks);
        listPerson.add(person);
        save(person);


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
        update();
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
        update();
        return person;
    }


}