package MaratonaJava.streams.dominio;

public class LightNovel {
    private String nome;
    private double price;

    public LightNovel(String nome, double price) {
        this.nome = nome;
        this.price = price;
    }

    public String getNome() {
        return nome;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "nome='" + nome + '\'' +
                ", price=" + price +
                '}'+"\n";
    }
}
