package swag.fr.ogaming_app;

import java.io.Console;
import java.util.List;

/**
 * Created by Hornet on 30/05/2017.
 */
public class Game {
    private int id;
    private String title;
    private String picture;
    private Double price;
    private List<Console> consoles; // optional and used only to wrap whole res from JOIN in one videogame object
    private List<Gametype> gameTypes;  // optional and used only to wrap whole res from JOIN in one videogame object

    public Game() {
    }

    public Game(int id) {
        this.id = id;
    }

    public Game(int id, String title, Double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Console> getConsole() {
        return this.consoles;
    }

    public void setConsole(List<Console> console) {
        this.consoles = console;
    }

    public List<Gametype> getGametype() {
        return this.gameTypes;
    }

    public void setGametype(List<Gametype> gameType) {
        this.gameTypes = gameType;
    }
}
