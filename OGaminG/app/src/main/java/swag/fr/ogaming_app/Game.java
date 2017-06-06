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
    private List<Consoles> consoles; // optional and used only to wrap whole res from JOIN in one videogame object
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

    public Game(int id,String title,String picture,Double price,List<Consoles> v,List<Gametype> g) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.picture=picture;
        this.consoles=v;
        this.gameTypes=g;
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

    public List<Consoles> getConsole() {
        return this.consoles;
    }

    public void setConsole(List<Consoles> console) {
        this.consoles = console;
    }

    public List<Gametype> getGametype() {
        return this.gameTypes;
    }

    public void setGametype(List<Gametype> gameType) {
        this.gameTypes = gameType;
    }
}
