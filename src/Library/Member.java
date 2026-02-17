package Library;

import java.util.Scanner;

public class Member {

    private String name;
    private int age;
    private char sex;
    private long membershipId;
    private boolean exist;

    //یک کلاس برای اعضا ایجاد کردیم که دارای یک سری ویژگی(فیلده)
    // با استفاده از متود الان میایم این ویژگی هارو ست میکنیم
    public void setName(String n) {
        name = n;
    }

    public String getName(String n) {
        return name;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getAge(int a) {
        return age;
    }

    public void setSex(char s) {
        sex = s;
    }

    public char getSex(char s) {
        return sex;
    }

    public void setMembershipId(long m) {
        membershipId = m;
    }

    public long getMembershipId(long m) {
        return membershipId;
    }

    public static void Name() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome , please enter your name and surname  : ");

        String nameInput = input.nextLine();
    }

    public static void Age() {
        Scanner input = new Scanner(System.in);

        System.out.println(" please enter your age  : ");

        int ageInput = input.nextInt();
    }
    public static void Sex() {
        Scanner input = new Scanner(System.in);

        System.out.println(" Female enter : F , Male enter : M ");

        char ageInput = (char)input.nextInt();

    }

}




