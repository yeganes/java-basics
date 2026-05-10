package Main.Library.DataBase.Crud;
import Main.Library.Model.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

    public static  void main(String[] args){
        Insert insert = new Insert();
        insert.insertMember();



    }
    public void insertMember(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter the info ");
        int id = Integer.parseInt(input.nextLine());
        String name = input.nextLine();
        String phoneNumber = input.nextLine();
        int age = Integer.parseInt(input.nextLine());
        Member person = new Member(id , name , age  , phoneNumber );
        String url = "jdbc:mysql://localhost:3306/library";
        String userName = "root" ;
        String password = "Ysa291182";
        String sql = "INSERT INTO members(id , name , age , phoneNumber) VALUES (?, ?, ?, ?)";
        //نگهدارند دستور اس کیو ال توی کد جاوا
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            if (connection != null){
                System.out.println("connection has connected successfully");
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, person.getMemberId());
            ps.setString(2 , person.getName());
            ps.setInt(3 , person.getAge());
            ps.setString(4 , person.getPhoneNumber());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
