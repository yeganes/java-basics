package Main.Library.Service;

import java.io.File;
import java.io.IOException;

public class FileService {

    public void addFile(String path){
        File file = new File(path);
        if (!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
