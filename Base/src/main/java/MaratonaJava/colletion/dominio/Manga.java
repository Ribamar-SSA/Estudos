package MaratonaJava.colletion.dominio;

import java.util.Comparator;
import java.util.Objects;



public class Manga implements Comparable<Manga>{
    private Integer id;
    private  String nome;
    private double preco;


    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private int quantidade;

    public Manga(Integer id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    //usado para verificar se é o mesmo objeto


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco);
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Manga(int id, String nome, double preco) {
        Objects.requireNonNull(nome);
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }



    //usado para ordenar
    @Override
    public int compareTo(Manga o) {
        //this < o => negativo
        //this == o => zero
        //this > o => positivo

//        if(this.id < o.getId()){
//            return -1;
//        }
//        else if(this.id == o.getId()){
//            return 0;
//        }
//        else
//            return 1;

        //usando o compareTo (wrapper)
        return this.id.compareTo(o.getId());

        //caso seja tipo primitivo:
        //Double.valueOf(atributo)
    }
}
