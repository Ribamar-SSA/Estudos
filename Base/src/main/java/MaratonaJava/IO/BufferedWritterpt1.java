package MaratonaJava.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWritterpt1 {
    public static void main(String[] args) {

        File file1 = new File("file.txt");

        try(FileWriter fileWriter = new FileWriter(file1)){
            BufferedWriter bufWrit = new BufferedWriter(fileWriter);
            bufWrit.write("hello world!");

            //sempre lembrar de dar o flush() antes de fechar
            bufWrit.flush();



        }catch(IOException e){
            e.printStackTrace();
        }




    }
}
