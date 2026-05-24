package com.library.repository;



import com.library.dBConnection.DBConnection;
import com.library.model.Borrow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowRepo {
    DBConnection db = new DBConnection();

    public void insert(int memberId , int bookId){
        String sql = "INSERT INTO borrow(member_id , book_id) VALUES (? , ?)";
        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setInt(1 , memberId);
            ps.setInt(2 , bookId);
            ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Borrow> selectAll(){
        String sql = "SELECT * FROM borrow";
        ArrayList<Borrow> listBorrow = new ArrayList<>();

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int borrow_id = rs.getInt("borrow_id");
                int member_id = rs.getInt("member_id");
                int book_id = rs.getInt("book_id");
                Borrow borrow = new Borrow(borrow_id ,member_id , book_id);

                listBorrow.add(borrow);
            }
            return listBorrow;



        }catch(SQLException e){
            throw new RuntimeException(e);

        }

    }

    public ArrayList<Borrow> selectMemberBook(int memberId){
        String sql = "SELECT * FROM borrow WHERE member_id = ?";
        ArrayList<Borrow> listBorrow = new ArrayList<>();

        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setInt(1 , memberId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int borrowId = rs.getInt("borrow_id");
                int bookId = rs.getInt("book_id");
                Borrow borrow = new Borrow(borrowId ,memberId , bookId);

                listBorrow.add(borrow);
            }
            return listBorrow;



        }catch(SQLException e){
            throw new RuntimeException(e);

        }

    }

    public void delete(int memberId , int bookId){
        String sql = "DELETE FROM borrow WHERE member_id = ? AND book_id = ?";

        try(
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setInt(1 ,memberId );
            ps.setInt(2 , bookId);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
