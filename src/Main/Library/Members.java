package Main.Library;
public class Member {

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
}
    //اماده سازی اولیه اشیا







