package Main.Library.DataBase.Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/library";
        String userName = "root" ;
        String password = "Ysa291182";
        String sql = "DELETE FROM members WHERE id = ?";
        try{
            Connection connection = DriverManager.getConnection(url , userName , password);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1 , 1 );
            ps.executeUpdate();
            ps.close();
            connection.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
}
