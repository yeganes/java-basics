package Main.Library.Repository;

import Main.Library.DBConnection.DBConnection;
import Main.Library.Model.Book;
import Main.Library.Model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepo {

    DBConnection db = new DBConnection();
    public void insert(String title , String author , Integer page ,  boolean isAvailable , int NumbersOfBook){
        String sql = "INSERT INTO books(title , author , page, isAvailable , NumbersOfBook) VALUES( ? , ? , ? , ? ,? )";
        try(
        Connection connection = db.connect();
        PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setString(1 , title);
            ps.setString(2, author);
            ps.setInt(3 , page);
            ps.setBoolean(4 , isAvailable);
            ps.setInt(5 , NumbersOfBook);
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Book> select(){
        ArrayList<Book> listBook = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            Book book = null;
            while (rs.next())
            {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                Integer page = rs.getInt("page");
                boolean isAvailable = rs.getBoolean("isAvailable");
                int NumbersOfBook = rs.getInt("NumbersOfBook");
                book = new Book(id , title , author , page , isAvailable ,NumbersOfBook);
                listBook.add(book);
            }
            return listBook;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(String title , boolean isAvailable){
        String sql = "UPDATE books SET isAvailable = ? WHERE title = ? ";
        try(
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
                ){
            ps.setBoolean(1 , isAvailable);
            ps.setString(2 , title);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }
    public void delete(String title){
        String sql = "DELETE FROM books WHERE title = ? ";
        try(
            Connection connection = db.connect();
            PreparedStatement ps = connection.prepareStatement(sql);
                ){
            ps.setString(1 , title);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrowBook(int id , String title){
        String sql = "UPDATE books set member_id = ?  WHERE title = ?  ";
        try(
                Connection connection = db.connect();
                PreparedStatement ps = connection.prepareStatement(sql);
                ){
            ps.setInt(1 , id);
            ps.setString(2 , title);

            ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }




}
