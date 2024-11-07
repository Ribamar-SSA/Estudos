package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest2 {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("pasta");

        if(Files.notExists(path1)){
            Path pathDiretorio = Files.createDirectory(path1);

        }

        Path subPastaPath = Paths.get("pasta\\subpasta");
        //garante a criação de todos os diretórios pais
        Files.createDirectories(subPastaPath);
        Path pathFile = Paths.get(subPastaPath.toString(),"file3.txt");

        if(Files.notExists(pathFile)){
            Files.createFile(pathFile);

        }

        Path source = pathFile;

        Path target  = Paths.get(pathFile.getParent().toString(),"fileRenamed.txt");

        Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);



        //Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING );



    }
}
