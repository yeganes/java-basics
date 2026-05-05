//package Main.Library.Service;
//
//import Main.Library.Model.Book;
//
//import java.io.*;
//import java.util.ArrayList;
//
//public class FileService {
//
//    public  static ArrayList<Book> loadBooks(String address) throws IOException {
//        ArrayList<Book> books = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(address));
//
//        String line;
//        while (((line = reader.readLine()) != null)) {
//            books.add(Book.fromFileString(line));
//        }
//        reader.close();
//        return books;
//    }
//
//    public static void saveBooks(){
//
//    }

