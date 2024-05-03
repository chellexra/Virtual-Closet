package persistence;

import model.Bottoms;
import model.Tops;
import model.Shoes;
import model.Outfit;
import model.VirtualCloset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Testing JsonWriter class methods
class JsonWriterTest extends JsonTest {
    private Tops whiteBlouse;
    private Bottoms whiteJeans;
    private Shoes whiteSneaker;
    private Tops blackShirt;
    private Bottoms blackPants;
    private Shoes blackNikes;
    private String spring;
    private String summer;
    private Outfit outfit1;
    private Outfit outfit2;

    @BeforeEach
    void runBefore() {
        whiteBlouse = new Tops("white", "blouse");
        whiteJeans = new Bottoms("white", "jeans");
        whiteSneaker = new Shoes("white", "sneaker");
        spring = new String("spring");
        outfit1 = new Outfit(whiteBlouse, whiteJeans, whiteSneaker, spring);
        blackShirt = new Tops("black", "Sweater");
        blackPants = new Bottoms("black", "Pants");
        blackNikes = new Shoes("black", "Nikes");
        summer = new String("summer");
        outfit2 = new Outfit(blackShirt, blackPants, blackNikes, summer);
    }

    @Test
    void testWriterInvalidFile() {
        try {
            List<Outfit> outfits = new ArrayList<Outfit>();
            VirtualCloset vc = new VirtualCloset(outfits);
            JsonWriter writer = new JsonWriter("./data/my/illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            List<Outfit> outfits = new ArrayList<Outfit>();
            VirtualCloset vc = new VirtualCloset(outfits);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyVirtualCloset.json");
            writer.open();
            writer.write(vc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyVirtualCloset.json");
            vc = reader.read();
            assertEquals(0, vc.getAllOutfits().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {

            List<Outfit> outfits = new ArrayList<Outfit>();
            VirtualCloset vc = new VirtualCloset(outfits);
            vc.addOutfit(outfit1);
            vc.addOutfit(outfit2);
            JsonWriter writer = new JsonWriter("./data/testWriterVirtualCloset.json");
            writer.open();
            writer.write(vc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterVirtualCloset.json");
            Outfit outfit = vc.getAllOutfits().get(0);
            vc = reader.read();
            assertEquals("white", vc.getAllOutfits().get(0).getTop().getColor());
            assertEquals("blouse", vc.getAllOutfits().get(0).getTop().getType());
            List<Outfit> allOutfits = vc.getAllOutfits();
            assertEquals(2, vc.getAllOutfits().size());
            checkOutfit("white", "blouse", "white", "jeans", "white",
                    "sneaker", "spring", outfits.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}