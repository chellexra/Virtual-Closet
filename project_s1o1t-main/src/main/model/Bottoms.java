package model;

import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;
import java.util.Objects;

// Bottoms class represents the top clothing article in an outfit
// with attributes of color and type
public class Bottoms implements Writable {
    private String color;
    private String type;

    //EFFECTS: Bottoms constructor
    public Bottoms(String color, String type) {
        this.color = color;
        this.type = type;
    }

    // EFFECTS: returns string of bottoms type
    public String getType() {
        return type;
    }

    // EFFECTS: returns string of bottoms type
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
