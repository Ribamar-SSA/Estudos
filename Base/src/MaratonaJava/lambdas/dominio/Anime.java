package MaratonaJava.lambdas.dominio;

public class Anime {
    private String title;
    private int episodes;

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", episodes=" + episodes +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return episodes;
    }

    public void setQuantity(int quantity) {
        this.episodes = quantity;
    }

    public Anime(String title, int quantity) {
        this.title = title;
        this.episodes = quantity;
    }
}
