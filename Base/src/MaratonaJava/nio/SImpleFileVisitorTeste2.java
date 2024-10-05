package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
        if(file.getFileName().toString().endsWith(".java"))
            System.out.println(file.getFileName());

        return FileVisitResult.CONTINUE;
    }
}


public class SImpleFileVisitorTeste2 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get(".");

        //file Visitor define o comportamento do que quer
        // fazer quando estiver navegando pelos diretórios
        Files.walkFileTree(root,new ListAllFiles());
    }
}
