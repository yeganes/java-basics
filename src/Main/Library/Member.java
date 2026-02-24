package Main.Library;
import java.util.Scanner;
public class Member {

    static Scanner input = new Scanner(System.in);

    private String name;
    private int age;
    private char gender;
    private long phone;
    private long idMembership;

    //یه ویژگی تعریف کردیم برای این کاربر که اسمش هست
    public void setName(String name) {
        this.name = name;
        // در ستر یک مقدار پارامتر ورودی به ان میدهیم تا انرا تغییر دهیم
    }

    public String getName() {
        return name;
        // در گتر هیچ پارامتری نداریم برای ورودی ولی این متود تایپ فیلد برمیگردونه به ما پس وید هم نمیتونه باشه
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        if (age > 100 || age < 5) {
            return 404;
        }
        return age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        if (gender == 'M' || gender == 'm' || gender == 'f' || gender == 'F') {
            return gender;
        }
        return 'u';
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getPhone() {
        return phone;
    }

    public void setIdMembership(long idMembership) {
        this.idMembership = idMembership;
    }

    public long getIdMembership() {
        return idMembership;
    }

    public Member(String name, int age, char gender, long phone, long idMembership) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.idMembership = idMembership;
    }
    //اماده سازی اولیه اشیا

    public static void main(String[] args) {
        Member person = null;
        //شیء پرسن از کلاس ممبر به صورت دیفالت نال یکبار تعریف میکنیم
            System.out.println("Welcome to the library ");
            System.out.println("Would you please enter your name please : ");
            String getUserName = input.nextLine();
            System.out.println("Now please enter your age please : ");
            int getUserAge = input.nextInt();
            input.nextLine();
            System.out.println("Please choose your gender M(male) , F(female) : ");
            char getUserGender = input.next().toUpperCase().charAt(0);
            System.out.println("Please enter your phone number :+98 ");
            long getUserphone = input.nextLong();
            input.nextLine();
            long setUserMembershipId = 404_000_000_000_000L + getUserphone;


            person = new Member(getUserName, getUserAge, getUserGender, getUserphone, setUserMembershipId);
            System.out.println("your name is : " + person.getName());
            System.out.println("your are  : " + person.getAge() + " years old");
            System.out.println(person.getGender());
            System.out.println("your phone number is : " + person.getPhone());
            System.out.println("your ID is : " + person.getIdMembership());
            String[] array = new String[4];
            array[1] = person.getName();
        }
    }





