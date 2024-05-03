package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.*;

//Outfit class represents a combination of clothing articles including tops,
// bottoms, and shoes with an associated season
public class Outfit implements Writable {
    private Tops top;
    private Bottoms bottoms;
    private Shoes shoes;
    private String seasons;

    //REQUIRES: season has to be Spring, Summer, Fall or Winter
    //MODIFIES: this
    //EFFECTS: construct outfit class
    public Outfit(Tops top, Bottoms bottom, Shoes shoe, String season) {
        this.top = top;
        this.bottoms = bottom;
        this.shoes = shoe;
        this.seasons = season;
    }

    //EFFECTS: returns tops
    public Tops getTop() {
        return top;
    }

    //EFFECTS: returns bottoms
    public Bottoms getBottom() {
        return bottoms;
    }

    //EFFECTS: returns shoes
    public Shoes getShoes() {
        return shoes;
    }

    //EFFECTS: returns season
    public String getSeason() {
        return seasons;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("top", top.toJson());
        json.put("bottom", bottoms.toJson());
        json.put("shoes", shoes.toJson());
        json.put("season", seasons);
        return json;
    }
}
