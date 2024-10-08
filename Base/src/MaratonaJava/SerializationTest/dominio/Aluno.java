package MaratonaJava.SerializationTest.dominio;

import javax.swing.table.TableRowSorter;
import java.io.*;

public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 7139696538148843195L;
    private long id ;
    private  String nome;
    private   transient Turma turma;

    //toda vez que serializo, o java precisa manter um ID para saber se posso deserializar
    //como se fosse um hash e garante que nada foi alterado
    private transient String senha;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno(long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }


    //tem que seguir exatamente a escrita do método
    //é como se fosse uma sobrescrita
    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        //já que não dá de serializar o objeto
        //supondo que ele não seja serializable
        //.Precisamos escrever atributo por atributo
        oos.defaultWriteObject();
        oos.writeUTF(turma.getNome());

    }
    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        String nome = ois.readUTF();
        turma = new Turma(nome);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", turma=" + turma +
                ", senha='" + senha + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
