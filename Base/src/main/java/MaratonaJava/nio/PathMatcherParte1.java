package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PathMatcherParte1 {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");

        //não importa do o arquivo existe ou não para fazer o teste do match
        matches(path1,"glob:**.bkp");
        matches(path2,"glob:**.txt");
        matches(path3,"glob:**.java");
        matches(path3,"glob:**.{java,txt,bkp}");
        matches(path3,"glob:**.????");

        Path pathExe = Paths.get(".");
        Files.walkFileTree(pathExe,new ListAllJavaClasses1());


    }
    public static class ListAllJavaClasses1 extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            if(matches(file,"glob:**/*{Test}*.{java,class}"))
                System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }

    private static boolean matches(Path path, String glob ){
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
        //System.out.println(glob +":  "+ pathMatcher.matches(path));
        return pathMatcher.matches(path);
    }
}
