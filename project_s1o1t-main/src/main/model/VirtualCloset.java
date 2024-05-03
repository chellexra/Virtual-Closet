package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.*;

import java.util.List;

// VirtualCloset class represents a collection of outfits stored virtually.
// Users can add, remove, and retrieve outfits, as well as filter outfits by season.

public class VirtualCloset implements Writable {
    protected List<Outfit> outfits;

    //EFFECTS: constructs virtual closet class
    public VirtualCloset(List<Outfit> outfits) {
        this.outfits = outfits;
    }

    //EFFECTS: adds outfit to the VirtualCloset
    public void addOutfit(Outfit outfit) {
        this.outfits.add(outfit);
        EventLog.getInstance().logEvent(new Event("Added outfit" + outfit.toString() + " to Virtual Closet"));
    }

    //EFFECTS: removes outfit from VirtualCloset
    public void removeOutfit(int index) {
        this.outfits.remove(index);
    }

    //EFFECTS: gets all outfits
    public List<Outfit> getAllOutfits() {
        EventLog.getInstance().logEvent(new Event("Viewed outfits"));
        return this.outfits;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("outfits", outfitsToJson());
        return json;
    }

    // EFFECTS: returns outfits in this virtualCloset as a JSON array
    private JSONArray outfitsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Outfit o : outfits) {
            jsonArray.put(o.toJson());
        }

        return jsonArray;
    }

    //REQUIRES: s must be one of Spring, Summer, Winter, or Fall
    //MODIFIES: this
    //EFFECTS: produces list of outfits by inputted season, in the list, if outfit season = inputted string,
    //         add outfit to seasonal outfit closet otherwise return seasonal outfits.
    public List<Outfit> getOutfitsBySeason(String s) {
        ArrayList<Outfit> seasonalOutfits = new ArrayList<>();
        for (Outfit outfit: this.outfits) {
            if (outfit.getSeason().equals(s)) {
                seasonalOutfits.add(outfit);
            }
        }
        EventLog.getInstance().logEvent(new Event("Viewed " + s + " outfits"));
        return seasonalOutfits;
    }
}
