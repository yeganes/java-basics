package Main.Library.Repository;

import Main.Library.DBConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}


