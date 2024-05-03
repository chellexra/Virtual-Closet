package persistence;

import model.Bottoms;
import model.Tops;
import model.Shoes;
import model.Outfit;
import model.VirtualCloset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Tests JsonReader Class methods
class JsonReaderTest extends JsonTest {
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
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            VirtualCloset vc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyVirtualCloset() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyVirtualCloset.json");
        try {
            VirtualCloset vc = reader.read();
            assertEquals(0, vc.getAllOutfits().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderVirtualCloset.json");
        try {
            VirtualCloset vc = reader.read();
            List<Outfit> outfits = vc.getAllOutfits();
            assertEquals(1, outfits.size());
            checkOutfit("white", "blouse","white", "jeans", "white", "sneaker",
                    "spring", outfits.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

