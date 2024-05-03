package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

//Tops class represents the top clothing article in an outfit
// with attributes of color and type
public class Tops implements Writable {
    private String color;
    private String type;

    public Tops(String color, String type) {
        this.color = color;
        this.type = type;
    }

    // EFFECTS: returns string of top type
    public String getType() {
        return type;
    }

    //EFFECTS: returns string of top color
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
