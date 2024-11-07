package MaratonaJava.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Resolve {
    public static void main(String[] args) {
    //caminhos absolutos começam com /
    // bastante cuidado com isso
    //não da de adicionar de um relativo para um absoluto

    //Resolve é juntar dois paths

        Path absoluto = Paths.get("/pasta/subpasta");
        Path relativo = Paths.get("subpasta/file3.txt");
        Path file = Paths.get("filekol.txt");

        System.out.println("1  "+absoluto.resolve(relativo));
        System.out.println("2  "+relativo.resolve(absoluto));
        System.out.println("3  "+relativo.resolve(file));

    }
}
