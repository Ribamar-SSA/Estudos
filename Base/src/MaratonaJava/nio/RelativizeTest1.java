package MaratonaJava.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest1 {
    public static void main(String[] args) {
        Path dir  = Paths.get("pasta/subpasta");
        Path clazz = Paths.get("pasta/subpasta/pastaSecreta/arquivo.txt");


        Path absoluto1  = Paths.get("/Neto/pasta/subpasta");
        Path absoluto2  = Paths.get("/usr/local");
        Path absoluto3  = Paths.get("/Neto/pasta/subpasta/pastaSecreta/arquivo.txt");
        Path relativo1  = Paths.get("NetoRelativo");
        Path relativo2  = Paths.get("NetoRelativo/pasta/subpasta");

        System.out.println("1 "+absoluto1.relativize(absoluto3));
        System.out.println("2 "+absoluto2.relativize(absoluto1));
        System.out.println("3 "+ relativo1.relativize(relativo2));

        //não tem como saber onde NetoRelativo está
        //System.out.println("4 "+absoluto1.relativize(relativo1));
    }




}
