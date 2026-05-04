package Main.Library.Service;

import Main.Library.Model.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {
    public void writeFile(String address , Object obj) throws IOException {
        try {

            FileWriter fileWriter = new FileWriter(address , true) ;

            fileWriter.write(obj.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
