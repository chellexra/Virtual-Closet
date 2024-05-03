package persistence;

import model.Bottoms;
import model.Outfit;
import model.Tops;
import model.VirtualCloset;
import model.Shoes;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;



// Referenced from JsonSerializationDemo
public class JsonReader {
    private String source;

    //EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads virtualCloset from file and returns it;
    // throws IOException if an error occurs reading data from file
    public VirtualCloset read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseVirtualCloset(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses VirtualCloset from JSON object and returns it
    private VirtualCloset parseVirtualCloset(JSONObject jsonObject) {
        VirtualCloset vc = new VirtualCloset(new ArrayList<>());
        addOutfits(vc, jsonObject);
        return vc;
    }

    // MODIFIES: vc
    // EFFECTS: parses outfits from JSON object and adds them to virtualCloset
    private void addOutfits(VirtualCloset vc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("outfits");
        for (Object json : jsonArray) {
            JSONObject nextOutfit = (JSONObject) json;
            addOutfit(vc, nextOutfit);
        }
    }

    // MODIFIES: vc
    // EFFECTS: parses outfit from JSON object and adds it to virtualCloset
    private void addOutfit(VirtualCloset vc, JSONObject jsonObject) {
        JSONObject top = jsonObject.getJSONObject("top");
        String tcolor = top.getString("color");
        String ttype = top.getString("type");
        Tops tops = new Tops(tcolor, ttype);
        JSONObject bottom = jsonObject.getJSONObject("bottom");
        String bcolor = bottom.getString("color");
        String btype = bottom.getString("type");
        Bottoms bottoms = new Bottoms(bcolor, btype);
        JSONObject shoe = jsonObject.getJSONObject("shoes");
        String scolor = shoe.getString("color");
        String stype = shoe.getString("type");
        Shoes shoes = new Shoes(scolor, stype);
        String season = jsonObject.getString("season");

        Outfit outfit = new Outfit(tops, bottoms, shoes, season);
        vc.addOutfit(outfit);
    }
}

