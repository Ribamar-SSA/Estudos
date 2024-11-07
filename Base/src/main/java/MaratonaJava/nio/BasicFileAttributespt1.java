package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributespt1 {
    public static void main(String[] args) {


        LocalDateTime date = LocalDateTime.now().minusDays(2);

//        File.txt file = new File.txt("pasta/arquivoatt.txt");
//        try {
//            boolean isCreatedFile = file.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        Path pathTeste1 = Paths.get("pasta/arquivoatt.txt");
        try {
            Files.createFile(pathTeste1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));

        try {
            Files.setLastModifiedTime(pathTeste1,fileTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
