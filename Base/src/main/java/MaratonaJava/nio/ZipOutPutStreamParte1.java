package MaratonaJava.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutPutStreamParte1 {


    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subDirectory");

        zip(arquivoZip,arquivosParaZipar);

    }

    public static void zip(Path arquivoZip, Path arquivosParaZipar){

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)){
            for(Path path : directoryStream){
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(path,zipOutputStream);
                zipOutputStream.closeEntry();
            }


        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
