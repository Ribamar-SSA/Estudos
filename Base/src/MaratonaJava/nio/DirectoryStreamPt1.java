package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamPt1 {
    public static void main(String[] args) {

        Path path = Paths.get(".");

        try(DirectoryStream<Path> stremam1 = Files.newDirectoryStream(path)){
            for(Path path1 : stremam1){
                System.out.println(path1.getFileName());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
