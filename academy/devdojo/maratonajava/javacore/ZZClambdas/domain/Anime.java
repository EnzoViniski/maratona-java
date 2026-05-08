package academy.devdojo.maratonajava.javacore.ZZClambdas.domain;

public class Anime {
    private String title;
    private int episodes;

    public Anime(String name, int quantity) {
        this.title = name;
        this.episodes = quantity;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + title + '\'' +
                ", episodes=" + episodes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }
}
