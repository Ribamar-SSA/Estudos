package MaratonaJava.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        Path p1 = Paths.get("E:\\Neto\\Estudos\\ganhando_produtividade_com_Stream_API_Java\\pasta\\arquivo.txt");

        System.out.println(p1.getFileName());
    }


}
