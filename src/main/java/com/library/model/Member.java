package com.library.model;

import com.sun.istack.internal.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Integer memberId;
    public enum Gender {
        MALE,
        FEMALE
    }

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "member_name")
    @NotNull
    private String name;
    @NotNull
    private int age ;
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "borrow_limit_number")
    private Integer borrowLimit;
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

    public void setBorrowLimit(Integer borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    //از متود ستر استفاده میکنیم که بتوانیم متغیرمان را تغییر دهیم و انرا تعیین کنیم و یک اشاره گر برای ان بسازیم
    public void setName(String name){
        this.name = name;
    }
    // از متود گتر تعریف استفاده میکنیم که بتوانیم مقدار این ویژگی را دریافت کنیم
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
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

    public Member(){

    }

    // یک سازنده هم نام کلاسمان میسازیم
    public Member(Integer memberId , String name , int age , String phoneNumber , Gender gender , Integer borrowLimit ) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;

    }





}
