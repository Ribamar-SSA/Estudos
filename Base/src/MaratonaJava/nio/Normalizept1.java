package MaratonaJava.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Normalizept1 {
    public static void main(String[] args) {

        String diretorioProjeto = "ribamar/dev/chegando";
        String arquivoTxt = "../../arquivo.txt";

        Path path1 = Paths.get(diretorioProjeto,arquivoTxt);

        //sem normalização
        System.out.println(path1.toString());

        //com normalização
        System.out.println(path1.normalize().toString());



    }
}
