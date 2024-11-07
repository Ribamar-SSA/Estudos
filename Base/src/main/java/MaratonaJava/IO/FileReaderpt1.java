package MaratonaJava.IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderpt1 {
    public static void main(String[] args) {
        char [] in = new char[200];
        File filereader1 = new File("file.txt");

        // usando o try ele fecha sozinho
        try(FileReader fileReader = new FileReader(filereader1)){
            fileReader.read(in);

            for(char c : in){
                System.out.print(c);
            }

            int i;
//            while((i = fileReader.read()) != -1){
//                System.out.print((char)i);
//            }

        }catch (IOException ex){
            ex.printStackTrace();
        }



    }
}
