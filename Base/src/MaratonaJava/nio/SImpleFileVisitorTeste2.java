package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
        if(file.getFileName().toString().endsWith(".java"))
            System.out.println(file.getFileName());

        return FileVisitResult.SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        //consegue visitar antes
        System.out.println(dir.getFileName()+"preVisit");
        //se escolher o retorno com continue , ele lê o que tem dentro do diretório
        return FileVisitResult.SKIP_SIBLINGS;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(dir.getFileName() + "postVIsitDirectory");
        return FileVisitResult.CONTINUE;
    }
}


public class SImpleFileVisitorTeste2 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("pasta");

        //file Visitor define o comportamento do que quer
        // fazer quando estiver navegando pelos diretórios
        Files.walkFileTree(root,new ListAllFiles());
    }
}
