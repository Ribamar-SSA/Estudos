package MaratonaJava.SerializationTest.test;

import MaratonaJava.SerializationTest.dominio.Aluno;
import MaratonaJava.SerializationTest.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationTest1 {
    public static void main(String[] args) {
        // serializar é persistir um objeto através de arrays de bytes

        //atributos estáticos não são serializados, pois pertencem à classe

        Aluno aluno = new Aluno(1L,"ribamar","sousa12");
        Turma turma = new Turma("vitoriosos  12 3 4");

        aluno.setTurma(turma);

        serializar(aluno);

        desserializar();

    }



    private static void serializar(Aluno aluno){
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(aluno);
            //System.out.println(aluno);
        }catch(IOException e){
            e.printStackTrace();

        }
    }
    private static void desserializar()  {
        Path path = Paths.get("pasta/aluno.ser");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }






}
