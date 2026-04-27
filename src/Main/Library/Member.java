package Main.Library;


public class Member {


    public enum MembershipStatus{
        ACTIVE,
        SUSPENDED,
        EXPIRED;
    }
    public enum Gender{
        MALE,
        FEMALE;
    }

    // یک کلاس داریم که کارش نگه داشتن اطلاعات ممبر هاست
    // این کلاس ی سری فیلد یا همون پراپرتی داره که خصوصیات این مثل اسم سن و ...
    //این پراپرتی ها باید خصوصی تعریف بشه که از لحاظ امنیتی کد در حالت استیبلی قرار بگیره
    private String name;
    private int age ;
    private long phoneNumber;
    private final Integer memberId;
    private Integer borrowLimit;
    private MembershipStatus status;
    private Gender gender;
    private Integer borrowedBooksNum ;

    public void setBorrowedBooksNum(Integer borrowedBooksNum) {
        this.borrowedBooksNum = borrowedBooksNum;
    }

    public Integer getBorrowedBooksNum() {
        return borrowedBooksNum;
    }

    public Integer getBorrowLimit() {
        return borrowLimit;
    }

    public Integer setBorrowLimit(Integer borrowLimit) {
        this.borrowLimit = borrowLimit;
        return borrowLimit;
    }

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
    public long setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
        return phoneNumber;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public Gender getGender(){
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getMemberId(){
        return memberId;
    }

    // یک سازنده هم نام کلاسمان میسازیم
    public Member(String name , int age , long phoneNumber , Gender gender ,Integer memberId , Integer borrowLimit , Integer borrowedBooksNum){
        this.name = name ;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.borrowedBooksNum = borrowedBooksNum;
    }
    public Member(Integer memberId){
        this.memberId = memberId;

    }
    // یک شی به اسم پرسن از کلاس ممبر تعریف میکنیم و انرا اینیشیالایزد میکنیم و چون یک سازنده داشتیم الان اون از بدو تولدش دارای یک شی معتبر است پس میتوانیم با توجه به یک
    //پارامتری بودن سازندهمون به ان یک پارامتر برای استفاده بدهیم.
}