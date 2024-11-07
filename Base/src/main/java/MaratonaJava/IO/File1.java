package MaratonaJava.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File1 {

    public static void main(String[] args) {
        File file1 = new File("file.txt");

    try(FileWriter fileWriter1 = new FileWriter(file1,true)){
        fileWriter1.write("ribamar dev java\n");
        fileWriter1.flush();
    }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
