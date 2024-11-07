package MaratonaJava.streams.dominio;

import java.util.Objects;

public class LightNovel {
    public LightNovel(String nome, double price, Category category, Promotion promotion) {
        this.nome = nome;
        this.price = price;
        this.category = category;
        this.promotion = promotion;
    }

    private String nome;
    private double price;
    private Category category;
    public Promotion promotion;

    public LightNovel(String nome, double price, Category category) {
        this.nome = nome;
        this.price = price;
        this.category = category;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightNovel that = (LightNovel) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "nome='" + nome + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
