package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributespt3 {
    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("pasta/teste.txt");
        if(Files.notExists(path1)) Files.createFile(path1);

        Files.setAttribute(path1,"dos:hidden",true);
        Files.setAttribute(path1,"dos:readonly",true);
        //Files.setAttribute(path1,"dos:hidden",false);
        //Files.setAttribute(path1,"dos:readonly",false);

        //usando as classes DosFileAttributes e DosFileAttributesView
            //para visualizar
        DosFileAttributes dosFileAttributes = Files.readAttributes(path1, DosFileAttributes.class);

        System.out.println(dosFileAttributes.isHidden());;
        System.out.println(dosFileAttributes.isReadOnly());;

            //para alterar algo
        DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path1, DosFileAttributeView.class);
        dosFileAttributeView.setHidden(true);
        dosFileAttributeView.setHidden(true);
            //para mostrar agora
        System.out.println(dosFileAttributeView.readAttributes().isReadOnly());
        System.out.println(dosFileAttributeView.readAttributes().isHidden());

    }
}
