package MaratonaJava.StreamsCollector;

public class LightNovel {

    private String title;

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public LightNovel(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public LightNovel(String title) {
        this.title = title;
    }
}
