package Main.Library.Repository;

import Main.Library.DBConnection.DBConnection;
import Main.Library.Model.Member;
import Main.Library.Service.MemberService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberRepo {
    DBConnection db = new DBConnection();


    public void insert(String name , int age , String phoneNumber, Member.Gender gender ,Integer borrowLimit ,Integer borrowedBooks){
        String sql = "INSERT INTO members(name , age , phone_number , gender , borrow_limit ) VALUES (?, ?, ? , ? , ?   )";
        try {
            Connection connection = db.connect();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2 , age);
            ps.setString(3 , phoneNumber);
            ps.setString(4 , String.valueOf(gender));
            ps.setInt(5, borrowLimit);


            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Member> select (){
        ArrayList<Member> listPerson = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (
            Connection connection = db.connect();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ){
            Member person = null;
            while (rs.next()) {
                int id = rs.getInt("member_id");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phone_number");
                int age = rs.getInt("age");
                String genderStr = rs.getString("gender");
                Member.Gender gender = Member.Gender.valueOf(genderStr);
                Integer borrowLimit = rs.getInt("borrow_limit");

                person = new Member(id, name, age, phoneNumber, gender, borrowLimit);
                listPerson.add(person);
            }



            return listPerson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateName(Integer id , String name ){
        String sql = "UPDATE members SET name = ? WHERE member_id = ?";
        try (
            Connection connection = db.connect();

            PreparedStatement ps = connection.prepareStatement(sql);
            ){ps.setString(1 ,  name );
            ps.setInt(2 , id);

            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updatePhoneNumber(Integer id , String phoneNumber  ){
        String sql = "UPDATE members SET phone_number = ? WHERE member_id = ?";
        try (
            Connection connection = db.connect();

            PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setString(1 ,  phoneNumber );
            ps.setInt(2 , id);

            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateAge(Integer id , int age  ){
        String sql = "UPDATE members SET age = ? WHERE member_id = ?";
        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setInt(1 ,  age );
            ps.setInt(2 , id);

            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateLimit(Integer id , int borrowLimit  ){
        String sql = "UPDATE members SET borrow_limit = ? WHERE member_id = ?";
        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setInt(1 ,  borrowLimit );
            ps.setInt(2 , id);

            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(int id) {

        String sql = "DELETE FROM members WHERE member_id = ?";

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
