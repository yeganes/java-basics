package Main.Library;


public class Member {
    // یک کلاس داریم که کارش نگه داشتن اطلاعات ممبر هاست
    // این کلاس ی سری فیلد یا همون پراپرتی داره که خصوصیات این مثل اسم سن و ...
    //این پراپرتی ها باید خصوصی تعریف بشه که از لحاظ امنیتی کد در حالت استیبلی قرار بگیره
    private String name;
    private int age ;
    private long phoneNumber;
    private String gender;
    private int memberId;



    //از متود ستر استفاده میکنیم که بتوانیم متغیرمان را تغییر دهیم و انرا تعیین کنیم و یک اشاره گر برای ان بسازیم
    public String setName(String name){
        this.name = name;
        return name;
    }
    // از متود گتر تعریف استفاده میکنیم که بتوانیم مقدار این ویژگی را دریافت کنیم
    public String getName(){
        return name;
    }
    public int setAge(int age){
        this.age = age;
        return age;
    }
    public int getAge(){
        return age;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public String getGender(){
        return gender;
    }
    public int getMemberId(){
        return memberId;
    }

    // یک سازنده هم نام کلاسمان میسازیم
    public Member(String name , int age , long phoneNumber , String gender ,int memberId){
        this.name = name ;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.memberId = memberId;
    }
    public Member(int memberId){
        this.memberId = memberId;

    }
    // یک شی به اسم پرسن از کلاس ممبر تعریف میکنیم و انرا اینیشیالایزد میکنیم و چون یک سازنده داشتیم الان اون از بدو تولدش دارای یک شی معتبر است پس میتوانیم با توجه به یک
    //پارامتری بودن سازندهمون به ان یک پارامتر برای استفاده بدهیم.
}