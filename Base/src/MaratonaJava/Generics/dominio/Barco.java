package MaratonaJava.Generics.dominio;

public class Barco {
    private String nome ;

    @Override
    public String toString() {
        return "Barco{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Barco(String nome) {
        this.nome = nome;
    }
}
