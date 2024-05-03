package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

// Shoes class represents the top clothing article in an outfit
// with attributes of color and type
public class Shoes implements Writable {
    private String color;
    private String type;

    public Shoes(String color, String type) {
        this.color = color;
        this.type = type;
    }

    // EFFECTS: returns string of shoe type
    public String getType() {
        return type;
    }

    // EFFECTS: returns string of shoe color
    public String getColor() {
        return color;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("color", color);
        json.put("type", type);
        return json;
    }
}