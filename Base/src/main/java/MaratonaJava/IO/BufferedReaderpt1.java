package MaratonaJava.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderpt1 {
    public static void main(String[] args) {

        File file1 = new File("file.txt");

        try(FileReader fr = new FileReader(file1)){
            BufferedReader br = new BufferedReader(fr);

            String linha;
            while((linha= br.readLine()) != null)
                System.out.println(br.readLine());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
