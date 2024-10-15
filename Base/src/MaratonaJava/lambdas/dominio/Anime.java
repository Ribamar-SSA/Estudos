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

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int e) {
        this.episodes = episodes;
    }

    public Anime(String title, int quantity) {
        this.title = title;
        this.episodes = quantity;
    }
}
