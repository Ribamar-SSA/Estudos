package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesPt2 {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("pasta/path_novo.txt");

        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        //visualização dos dados
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println(lastModifiedTime);
        System.out.println(creationTime);
        System.out.println(lastAccessTime);
        System.out.println("-----------------");

        //alteração dos dados , por isso cria um BasicFileAttributeView
        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
        basicFileAttributeView.setTimes(lastModifiedTime,newCreationTime,creationTime);


        //visualização dos dados novamente / precisa fazer a leitura do arquivo novamente
         lastModifiedTime = basicFileAttributeView.readAttributes().lastModifiedTime();
         creationTime = basicFileAttributeView.readAttributes().creationTime();
         lastAccessTime = basicFileAttributeView.readAttributes().lastAccessTime();

        System.out.println(lastModifiedTime);
        System.out.println(creationTime);
        System.out.println(lastAccessTime);

    }
}
