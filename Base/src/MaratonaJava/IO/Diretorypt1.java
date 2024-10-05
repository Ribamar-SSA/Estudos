package MaratonaJava.IO;

import java.io.File;
import java.io.IOException;

public class Diretorypt1 {
    public static void main(String[] args) {
        File diretory = new File("pasta");
        boolean iscreateDirectory = diretory.mkdir();

        //"E:\\Neto\\Estudos\\ganhando_produtividade_com_Stream_API_Java\\pasta\\arquivo.txt"
        //posso usar o caminho absoluto ou o caminho relativo
        File arquivoDiretory = new File(diretory,"arquivo.txt");

        try {
            boolean isFileCreated = arquivoDiretory.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
