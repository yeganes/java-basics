package Main.Library.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    public Connection connect (){
        String url = "jdbc:mysql://localhost:3306/library";
        String userName = "root" ;
        String password = "Ysa291182";
        try {
            Connection connection = DriverManager.getConnection(url , userName , password);

            if (connection != null){
                System.out.println("has connected successfully ");
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
