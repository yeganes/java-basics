package Main.Library.DataBase.Crud;

import java.sql.*;

public class Select {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/library";
        String userName = "root" ;
        String password = "Ysa291182";
        String sql = "SELECT * FROM members";

        try {
        Connection connection = DriverManager.getConnection(url , userName , password);
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                int age = rs.getInt("age");
                System.out.println(id + " " + name + " " + phoneNumber + " " + age);

            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}}
